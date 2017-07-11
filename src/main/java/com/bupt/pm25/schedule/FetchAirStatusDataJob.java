package com.bupt.pm25.schedule;

import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.service.AirStatusService;
import com.bupt.pm25.util.FetchAirStatusClient;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * 收集PM25数据Job
 * Created by miguangshu on 2016/9/7.
 */
public class FetchAirStatusDataJob {
    private Logger logger = LoggerFactory.getLogger(FetchAirStatusDataJob.class);
    @Autowired
    private AirStatusService airStatusService;
    public void work()  {
        try {
            List<AirStatus> airStatusList = FetchAirStatusClient.fetchAirStatus();
            airStatusService.insertBatch(airStatusList);
        } catch (IOException e) {
            logger.error("抓取空气质量数据异常:",e);
        }
    }
}
