package com.bupt.pm25.schedule;

import com.bupt.pm25.service.AirStatusService;
import com.bupt.pm25.service.WeatherService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 收集天气数据Job
 * Created by miguangshu on 2016/9/7.
 */
public class FetchWeatherDataJob implements org.quartz.Job{
    private static Logger _log = LoggerFactory.getLogger(FetchWeatherDataJob.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            _log.info(">>>>>>>>>>>>>>>开始采集天气数据......");
            WeatherService weatherService = new WeatherService();
            weatherService.fetchWeatherData();
            _log.info(">>>>>>>>>>>>>>>采集天气数据成功......");
        } catch (IOException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
