package com.bupt.pm25.schedule;

import com.bupt.pm25.service.AirStatusService;
import com.bupt.pm25.service.WeatherService;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 * 定时启动任务去进行任务处理
 * */
public class ScheduleTask {

	public static void timerTask() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				try {
					System.out.println(">>>>>>>>>>>>>>>开始采集天气数据......");
					WeatherService weatherService = new WeatherService();
					weatherService.fetchWeatherData();
					System.out.println(">>>>>>>>>>>>>>>采集天气数据成功......");
					System.out.println(">>>>>>>>>>>>>>>开始采集pm25数据......");
					AirStatusService airStatusService = new AirStatusService();
					airStatusService.insert();
					System.out.println(">>>>>>>>>>>>>>>采集pm25成功......");
				} catch (IOException e) {
					e.printStackTrace();
				} catch(Exception e){
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
