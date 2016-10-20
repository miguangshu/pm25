package com.bupt.pm25.schedule;

import com.bupt.pm25.service.AirStatusService;
import com.bupt.pm25.service.WeatherService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 * 定时启动任务去进行任务处理
 * */
public class ScheduleTask {
	private static Logger logger = Logger.getLogger(ScheduleTask.class);
	public static void timerTask() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					logger.info(">>>>>>>>>>>>>>>begin fetch weather data>>>>>>>>>>>>>>");
					WeatherService weatherService = new WeatherService();
					weatherService.fetchWeatherData();
					logger.info(">>>>>>>>>>>>>>>fetch weather data succeed>>>>>>>>>>>>>>>");
					logger.info(">>>>>>>>>>>>>>>begin fetch air condition data>>>>>>>>>>>>>>");
					AirStatusService airStatusService = new AirStatusService();
					airStatusService.insert();
					logger.info(">>>>>>>>>>>>>>>fetch air condition data succeed>>>>>>>>>>>>>");
				} catch (IOException e) {
					logger.error("fetch weather or air data error:",e);
					e.printStackTrace();
				} catch(Exception e){
					logger.error("fetch weather or air data error:",e);
					e.printStackTrace();
				}
			}
		};
		Timer timer = new Timer();
		long delay = 0;
		long intevalPeriod = 60 * 60 * 1000;// 这块是代码执行间隔,现在是10s执行一次
		// schedules the task to be run in an interval
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
	}

	public static void main(String[] a) {
		timerTask();
	}
}
