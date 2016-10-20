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

/**
 *
 */
public class WeatherService {

    private WeatherDataDao weatherDataDao = new WeatherDataDao();


    /**
     * 抓取天气数据，并存到数据库里
     * @throws IOException
     */
    public void fetchWeatherData() throws IOException{
        //mybatis的配置文件
        String resource = "mybatis.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = WeatherService.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.bupt.pm25.dao.WeatherDataDao.insert";//映射sql的标识字符串
        for (Map.Entry<String,String> entry : DataConstant.CITY_CODE_MAP.entrySet()) {
            WeatherDataEntity weatherDataEntity = FetchWeatherDataUtils.getWeatherData(entry.getKey());
            session.insert(statement,weatherDataEntity);
        }
        session.commit();
    }
}
