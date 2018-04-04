package com.bupt.pm25.controller;

import com.bupt.pm25.dto.HttpMessage;
import com.bupt.pm25.model.Question;
import com.bupt.pm25.model.ResultDataEntity;
import com.bupt.pm25.service.ResultDataService;
import com.bupt.pm25.util.*;
import com.google.inject.servlet.RequestParameters;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RequestMapping("/question")
@Controller
public class QuestionController {

	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	/**
	 * @param question
	 * @param answers
     * @return
     */
	@RequestMapping(value = "getAnswer")
	@ResponseBody
	public HttpMessage getAnswer(String question, List<String> answers) {
		HttpMessage httpMessage = new HttpMessage();
		try {
			String result = SelenuimUtils.baiduSearch(question);
			int count = Integer.MIN_VALUE;
			String myAnswer = null;
			for(String answer:answers){
				int times = StringUtils.getCounts(result,answer);
				if(times > count){
					count = times;
					myAnswer = answer;
				}
			}
			httpMessage.setCode(0);
			httpMessage.setContent(myAnswer);
		}catch(Exception e){
			logger.error("后台发生异常，异常原因:",e);
			httpMessage.setCode(1);
			httpMessage.setContent(e.getMessage());
		}
		logger.info(httpMessage.toString());
		return httpMessage;
	}
	/**
	 * @param question
	 * @param question
	 * @return
	 */
	@RequestMapping(value = "getQAnswer")
	@ResponseBody
	public HttpMessage getAnswer(@RequestBody Question question) {
		HttpMessage httpMessage = new HttpMessage();
		try {
			String q = question.getQuestion();
			List<String> answers = question.getAnswers();
			String result = SelenuimUtils.baiduSearch(q);
			int count = Integer.MIN_VALUE;
			String myAnswer = null;
			for(String answer:answers){
				int times = StringUtils.getCounts(result,answer);
				if(times > count){
					count = times;
					myAnswer = answer;
				}
			}
			httpMessage.setCode(0);
			httpMessage.setContent(myAnswer);
		}catch(Exception e){
			logger.error("后台发生异常，异常原因:",e);
			httpMessage.setCode(1);
			httpMessage.setContent(e.getMessage());
		}
		logger.info(httpMessage.toString());
		return httpMessage;
	}
}
