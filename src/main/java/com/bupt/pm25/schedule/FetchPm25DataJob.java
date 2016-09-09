package com.bupt.pm25.schedule;

import com.bupt.pm25.service.AirStatusService;
import com.bupt.pm25.service.WeatherService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;

/**
 * 收集PM25数据Job
 * Created by miguangshu on 2016/9/7.
 */
public class FetchPm25DataJob implements org.quartz.Job{

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
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
}
