package com.bupt.pm25.schedule;

import com.bupt.pm25.model.Pm25Entity;
import com.bupt.pm25.service.AirStatusService;
import com.bupt.pm25.service.Pm25Service;
import com.bupt.pm25.util.FetchPm25DataUtils;
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
public class FetchPm25DataJob{
    private Logger logger = LoggerFactory.getLogger(FetchPm25DataJob.class);
    @Autowired
    private Pm25Service pm25Service;
    public void work() {
        try {
            List<Pm25Entity> pm25Entities = FetchPm25DataUtils.getPm25();
            pm25Service.insertBatch(pm25Entities);
        } catch (IOException e) {
            logger.error("抓取pm25数据异常:",e);
        }
    }
}
