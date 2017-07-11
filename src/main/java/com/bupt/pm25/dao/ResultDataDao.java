package com.bupt.pm25.dao;

import com.bupt.pm25.model.ResultDataEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by miguangshu on 2016/6/21.
 */
@Repository
public interface ResultDataDao {
    public void insert(ResultDataEntity resultDataEntity);
}
