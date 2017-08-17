package com.bupt.pm25.dao;

import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.model.LgCompanyEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by miguangshu on 2016/6/21.
 */
@Repository
public interface LgCompanyDao {
    /**
     * 批量插入
     * @param lgCompanyEntities
     */
    public void insertBatch(List<LgCompanyEntity> lgCompanyEntities);
}
