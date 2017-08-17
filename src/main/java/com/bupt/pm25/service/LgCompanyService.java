package com.bupt.pm25.service;

import com.bupt.pm25.dao.LgCompanyDao;
import com.bupt.pm25.dao.Pm25Dao;
import com.bupt.pm25.model.LgCompanyEntity;
import com.bupt.pm25.model.Pm25Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by miguangshu on 2016/6/21.
 */
@Service
public class LgCompanyService {
    @Autowired
    private LgCompanyDao lgCompanyDao;
    public void insertBatch(List<LgCompanyEntity> companyEntities) throws IOException{
        lgCompanyDao.insertBatch(companyEntities);
    }
}
