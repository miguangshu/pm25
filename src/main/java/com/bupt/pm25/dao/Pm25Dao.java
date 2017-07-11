package com.bupt.pm25.dao;

import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.model.Pm25Entity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by miguangshu on 2016/6/21.
 */
@Repository
public interface Pm25Dao {
    /**
     * 批量插入
     * @param list
     */
    public void insertBatch(List<Pm25Entity> list);
}
