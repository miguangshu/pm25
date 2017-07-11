package com.bupt.pm25.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtil {

	private static final Logger logger = LoggerFactory.getLogger(ConfigUtil.class);


	public static String getUploadImageDir(){
		String headImageDir = PropertiesUtil.getInstance("config.properties").getText("upload.pic.dir");
		if (StringUtils.isNoneBlank(headImageDir)) {
			return headImageDir;
		}
		logger.info("上传照片文件夹配置为空");
		return null;
	}
	public static String getUploadAddress(){
		String address = PropertiesUtil.getInstance("config.properties").getText("upload.address");
		if (StringUtils.isNoneBlank(address)) {
			return address;
		}else{
			throw new RuntimeException("上传图片地址配置为空");
		}
	}
	public static int getUploadPort(){
		String port = PropertiesUtil.getInstance("config.properties").getText("upload.port");
		if (StringUtils.isNoneBlank(port)) {
			int iport = Integer.parseInt(port);
			return iport;
		}else{
			throw new RuntimeException("上传图片端口号配置为空");
		}
	}
	public static void main(String[] args) {
		System.out.println(getUploadImageDir());
	}
}
