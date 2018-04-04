package com.bupt.pm25.controller;

import com.bupt.pm25.dto.HttpMessage;
import com.bupt.pm25.model.ResultDataEntity;
import com.bupt.pm25.service.ResultDataService;
import com.bupt.pm25.util.ConfigUtil;
import com.bupt.pm25.util.DateUtil;
import com.bupt.pm25.util.FileUtils;
import com.bupt.pm25.util.SocketUploadUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/pm25")
@Controller
public class DataController implements SocketUploadUtil.OnUploadProcessListener{

	private static final Logger logger = LoggerFactory.getLogger(DataController.class);
	@Autowired
	private ResultDataService resultDataService;
	/**
	 * @param request
     * @return
     */
	@RequestMapping(value = "upload2")
	@ResponseBody
	public HttpMessage upload(HttpServletRequest request) {
		HttpMessage httpMessage = new HttpMessage();
		try {
			String phoneType = null;//手机型号
			String lat = null;//纬度
			String lon = null;//经度
			String areaCode = null;//区号
			String cityCode = null;//城市编码
			String fileName = null;
			String loadpath = ConfigUtil.getUploadImageDir();
			if (loadpath == null) {
				loadpath = request.getSession().getServletContext().getRealPath("/") + "/image"; //上传文件存放目录
			}
			logger.info("loadpath=" + loadpath);
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1 * 1024 * 1024);
			//开始读取上传信息
			List fileItems = upload.parseRequest(request);
			Iterator iter = fileItems.iterator(); // 依次处理每个上传的文件
			FileItem picItem = null;
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();// 忽略其他不是文件域的所有表单信息
				if (!item.isFormField()) {
					String name = item.getName();//获取上传文件名,包括路径
					fileName = name.substring(name.lastIndexOf("\\") + 1);//从全路径中提取文件名
					long size = item.getSize();
					if ((fileName == null || fileName.equals("")) && size == 0)
						continue;
					picItem = item;
					//取出不是文件域的所有表单信息
				} else {
					String fieldvalue = item.getString();
					String fieldName = item.getFieldName();
					if("lon".equals(fieldName)){
						lon = fieldvalue;
					}else if("lat".equals(fieldName)){
						lat = fieldvalue;
					}else if("phoneType".equals(fieldName)){
						phoneType = fieldvalue;
					}else if("areaCode".equals(fieldName)){
						areaCode = fieldvalue;
					}else if("cityCode".equals(fieldName)){
						cityCode = fieldvalue;
					}
				}
			}
			if(fileName == null || "".equals(fileName)){
				httpMessage.setCode(1);
				httpMessage.setContent("上传照片不能为空");
				return httpMessage;
			}
			if(lon == null || "".equals(lon)){
				httpMessage.setCode(1);
				httpMessage.setContent("经度lon不能为空");
				return httpMessage;
			}
			if(lat == null || "".equals(lat)){
				httpMessage.setCode(1);
				httpMessage.setContent("纬度lat不能为空");
				return httpMessage;
			}
			if(phoneType == null || "".equals(phoneType)){
				phoneType = "xxxxx";
			}
			if(areaCode == null || "".equals(areaCode)){
				areaCode = "00101";
			}
			if(cityCode == null || "".equals(cityCode)){
				cityCode = "131";
			}
			String picName = DateUtil.date2str("yyyyMMddHHmmss")+"_"+lon+"_"+lat+"_"+areaCode+"_"+cityCode+"_"+phoneType+".jpeg";
//			int point = fileName.indexOf(".");
			FileUtils.createParentDir(new File(loadpath));
			File fNew = new File(loadpath, picName);
			fNew.createNewFile();
			picItem.write(fNew);
			ResultDataEntity resultDataEntity = new ResultDataEntity();
			resultDataEntity.setLatitude(lat);
			resultDataEntity.setLongitude(lon);
			resultDataEntity.setCityCode(areaCode);
			resultDataEntity.setPhoneType(phoneType);
			resultDataEntity.setPicName(fileName);
			resultDataService.addResultData(resultDataEntity);
			SocketUploadUtil socketUploadUtil = SocketUploadUtil.getInstance();
			String result = socketUploadUtil.synUploadFile(loadpath+picName,ConfigUtil.getUploadAddress(),ConfigUtil.getUploadPort());
			httpMessage.setCode(0);
			httpMessage.setContent(result);
		}catch(Exception e){
			logger.error("上传图片异常，异常原因:",e);
			httpMessage.setCode(1);
			httpMessage.setContent(e.getMessage());
		}
		logger.info(httpMessage.toString());
		return httpMessage;
	}

	public void onUploadDone(int responseCode, String message) {
		logger.info("上传完成，返回码{}，消息内容{}",responseCode,message);
	}

	public void onUploadProcess(int uploadSize) {
		logger.info("已经上传文件大小：{}B",uploadSize);
	}

	public void initUpload(int fileSize) {
		logger.info("上传文件总大小：{}B",fileSize);
	}
}
