package com.bupt.pm25.dao;

import com.bupt.pm25.model.WeatherDataEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public interface WeatherDataDao {
    /**
     *插入一条数据
     * @param weatherDataEntity
     */
    public void insert(WeatherDataEntity weatherDataEntity);
}
