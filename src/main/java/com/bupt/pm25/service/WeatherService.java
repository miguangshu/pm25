package com.bupt.pm25.service;


import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.bupt.pm25.constant.DataConstant;
import com.bupt.pm25.dao.WeatherDataDao;
import com.bupt.pm25.model.WeatherDataEntity;
import com.bupt.pm25.util.FetchWeatherDataUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class WeatherService {
    @Autowired
    private WeatherDataDao weatherDataDao;
    /**
     * 抓取天气数据，并存到数据库里
     * @throws IOException
     */
    public void fetchWeatherData() throws IOException{
        for (Map.Entry<String,String> entry : DataConstant.CITY_CODE_MAP.entrySet()) {
            WeatherDataEntity weatherDataEntity = FetchWeatherDataUtils.getWeatherData(entry.getKey());
            weatherDataDao.insert(weatherDataEntity);
        }
    }
}
