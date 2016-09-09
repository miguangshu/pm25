package com.bupt.pm25.service;

import com.bupt.pm25.util.FetchAirStatusClient;
import com.bupt.pm25.model.AirStatus;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by miguangshu on 2016/6/21.
 */
public class AirStatusService {
    public void insert() throws IOException{
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = AirStatusService.class.getClassLoader().getResourceAsStream(resource);
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
        String statement = "com.bupt.pm25.dao.AirStatusDao.insert";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
//        AirStatus airStatus = session.selectOne(statement, 1);
//        System.out.println(airStatus);
        List<AirStatus> airStatusList = new FetchAirStatusClient().fetchAirStatus();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",airStatusList);
        session.insert(statement,map);
        session.commit();
    }
}
