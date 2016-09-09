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
        String resource = "mybatis-config.xml";
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
    /*public static void processWeatherData() throws IOException {
        //北京市
        WeatherDataEntity weatherDataEntity1 =
                getWeatherDataByGet("54511");
        if (weatherDataEntity1 != null) {
            weatherDataEntity1.setCityId("001");
            new WeatherDataDao().insertWeatherData(weatherDataEntity1);
            weatherDataEntity1.setCityId("00106");
            weatherDataEntity1.setCityName("西城区");
            new WeatherDataDao().insertWeatherData(weatherDataEntity1);
            weatherDataEntity1.setCityId("00107");
            weatherDataEntity1.setCityName("东城区");
            new WeatherDataDao().insertWeatherData(weatherDataEntity1);
        }
        //海淀区
        WeatherDataEntity weatherDataEntity2 =
                getWeatherDataByGet("101010200");
        if (weatherDataEntity2 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity2);
        }
        //石景山区
        WeatherDataEntity weatherDataEntity3 =
                getWeatherDataByGet("101011000");
        if (weatherDataEntity3 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity3);
        }
        //丰台区
        WeatherDataEntity weatherDataEntity4 =
                getWeatherDataByGet("101010900");
        if (weatherDataEntity4 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity4);
        }
        //房山区
        WeatherDataEntity weatherDataEntity5 =
                getWeatherDataByGet("101011200");
        if (weatherDataEntity5 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity5);
        }
        //朝阳区
        WeatherDataEntity weatherDataEntity6 =
                getWeatherDataByGet("101010300");
        if (weatherDataEntity6 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity6);
        }
        //大兴区
        WeatherDataEntity weatherDataEntity8 =
                getWeatherDataByGet("101011100");
        if (weatherDataEntity8 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity8);
        }
        //通州
        WeatherDataEntity weatherDataEntity9 =
                getWeatherDataByGet("101010600");
        if (weatherDataEntity9 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity9);
        }
        //顺义
        WeatherDataEntity weatherDataEntity10 = getWeatherDataByGet("101010400");
        if (weatherDataEntity10 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity10);
        }
        //昌平
        WeatherDataEntity weatherDataEntity11 = getWeatherDataByGet("101010700");
        if (weatherDataEntity11 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity11);
        }
        //门头沟
        WeatherDataEntity weatherDataEntity12 = getWeatherDataByGet("101011400");
        if (weatherDataEntity12 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity12);
        }
        //平谷
        WeatherDataEntity weatherDataEntity13 = getWeatherDataByGet("101011500");
        if (weatherDataEntity13 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity13);
        }
        //怀柔
        WeatherDataEntity weatherDataEntity14 = getWeatherDataByGet("101010500");
        if (weatherDataEntity14 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity14);
        }
        //密云
        WeatherDataEntity weatherDataEntity15 = getWeatherDataByGet("101011300");
        if (weatherDataEntity15 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity15);
        }
        //延庆
        WeatherDataEntity weatherDataEntity16 = getWeatherDataByGet("101010800");
        if (weatherDataEntity16 != null) {
            new WeatherDataDao().insertWeatherData(weatherDataEntity16);
        }
    }*/





    public static void main(String[] args) throws Exception {
//        getWeatherDataByGet("54511");
        WeatherService weatherService = new WeatherService();
        weatherService.fetchWeatherData();
    }
}
