package com.bupt.pm25.controller;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/pm25")
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	/*@Autowired
	private NoticeService noticeService;

	*//**
	 * 获取公告，返回页面
	 *//*
	@RequestMapping(value = "/getNotice")
	public String getNotice(HttpServletRequest request, Model model) {
		List<Notice> noticelList = noticeService.queryAllNotices();
		model.addAttribute("noticelList", noticelList);
		return "notice_list";
	}*/

	/**
	 *
	 * @param lng 经度
	 * @param lat 维度
	 * @param areaCode 区号
	 * @param phoneModel 手机型号
	 * @param request
     * @return
     */
	@RequestMapping(value = "upload")
	@ResponseBody
	public String upload(String lng,String lat,String areaCode,String phoneModel,HttpServletRequest request){
		String temp=request.getSession().getServletContext().getRealPath("/")+"temp";   //临时目录
		System.out.println("temp="+temp);
		String loadpath=request.getSession().getServletContext().getRealPath("/")+"Image"; //上传文件存放目录
		System.out.println("loadpath="+loadpath);
		DiskFileUpload fu =new DiskFileUpload();
		fu.setSizeMax(1*1024*1024);   // 设置允许用户上传文件大小,单位:字节
		fu.setSizeThreshold(4096);   // 设置最多只允许在内存中存储的数据,单位:字节
		fu.setRepositoryPath(temp); // 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
		//开始读取上传信息
		int index=0;
		List fileItems =null;
		try {
			fileItems = fu.parseRequest(request);
			System.out.println("fileItems="+fileItems);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator iter = fileItems.iterator(); // 依次处理每个上传的文件
		while (iter.hasNext())
		{
			FileItem item = (FileItem)iter.next();// 忽略其他不是文件域的所有表单信息
			if (!item.isFormField())
			{
				String name = item.getName();//获取上传文件名,包括路径
				name=name.substring(name.lastIndexOf("\\")+1);//从全路径中提取文件名
				long size = item.getSize();
				if((name==null||name.equals("")) && size==0)
					continue;
				int point = name.indexOf(".");
				name=(new Date()).getTime()+name.substring(point,name.length())+index;
				index++;
				File fNew=new File(loadpath, name);
				try {
					item.write(fNew);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			//取出不是文件域的所有表单信息
			}else{
				String fieldvalue = item.getString();
				//如果包含中文应写为：(转为UTF-8编码)
				//String fieldvalue = new String(item.getString().getBytes(),"UTF-8");
			}
		}
		String text1="11";
		return "11";
	}
}
