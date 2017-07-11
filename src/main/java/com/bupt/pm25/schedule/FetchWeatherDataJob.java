package com.bupt.pm25.schedule;

import com.bupt.pm25.service.AirStatusService;
import com.bupt.pm25.service.WeatherService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * 收集天气数据Job
 * Created by miguangshu on 2016/9/7.
 */
public class FetchWeatherDataJob {
    private static Logger log = LoggerFactory.getLogger(FetchWeatherDataJob.class);
    @Autowired
    private WeatherService weatherService;
    public void work() throws JobExecutionException {
        try {
            weatherService.fetchWeatherData();
        } catch (IOException e) {
            log.error("抓取天气数据异常:",e);
        }
    }
}
