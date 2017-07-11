package com.bupt.pm25.service;


import com.bupt.pm25.constant.DataConstant;
import com.bupt.pm25.dao.ResultDataDao;
import com.bupt.pm25.dao.WeatherDataDao;
import com.bupt.pm25.model.ResultDataEntity;
import com.bupt.pm25.model.WeatherDataEntity;
import com.bupt.pm25.util.FetchWeatherDataUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 *
 */
@Service
public class ResultDataService {
    @Autowired
    private ResultDataDao resultDataDao;

    /**
     * 添加访问记录
     * @param resultDataEntity
     */
    public void  addResultData(ResultDataEntity resultDataEntity){
        resultDataDao.insert(resultDataEntity);
    }
}
