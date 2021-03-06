package com.bupt.pm25.dao;

import com.bupt.pm25.model.AirStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by miguangshu on 2016/6/21.
 */
@Repository
public interface AirStatusDao {
    /**
     * 批量插入
     * @param airStatuses
     */
    public void insertBatch(List<AirStatus> airStatuses);
}
