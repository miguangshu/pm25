package com.bupt.pm25.schedule;

import com.bupt.pm25.model.AirStatus;
import com.bupt.pm25.util.excel.ExportExcel;
import com.google.common.collect.Lists;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by katiemi on 2017/1/12.
 */
public class HadoopTest {
    private static Logger LOGGER = LoggerFactory.getLogger(HadoopTest.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    public static void main(String[] args) throws Exception {

    }

}
