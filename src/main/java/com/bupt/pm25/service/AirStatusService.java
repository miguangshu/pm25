package com.bupt.pm25.service;

import com.bupt.pm25.dao.AirStatusDao;
import com.bupt.pm25.util.FetchAirStatusClient;
import com.bupt.pm25.model.AirStatus;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by miguangshu on 2016/6/21.
 */
@Service
public class AirStatusService {
    @Autowired
    private AirStatusDao airStatusDao;
    public void insertBatch(List<AirStatus> airStatuses) throws IOException{
        airStatusDao.insertBatch(airStatuses);
    }
}
