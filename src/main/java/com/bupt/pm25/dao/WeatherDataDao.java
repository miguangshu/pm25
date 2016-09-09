package com.bupt.pm25.dao;

import com.bupt.pm25.model.WeatherDataEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;


public class WeatherDataDao {
//	public static final String url = "jdbc:mysql://127.0.0.1:3306/pm25?useUnicode=true&characterEncoding=utf8";

	/*public static final String url = "jdbc:mysql://222.128.13.159:64000/pm25?useUnicode=true&characterEncoding=utf8";
//	public static final String url = "jdbc:mysql://182.92.83.221:3306/xinhao?useUnicode=true&characterEncoding=utf8";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "pm25";
	public static final String password = "123456";
	public Connection conn = null;
	public Statement st = null;

	static {
		try {
			Class.forName(name);// 指定连接类型
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.st.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 插入数据
	public void insertWeatherData(WeatherDataEntity weatherDataEntity) {
		try {
			java.util.Date date=new java.util.Date();
			Timestamp tt=new Timestamp(date.getTime());
			String sql = "insert into t_weather_data (id, city_id,city_name,temperature, pressure, humidity,"
					+ "wind_speed,wind_direction_name, wind_direction,weather_name, weather, collect_time,create_date, extend)"
					+ "VALUES("
					+ weatherDataEntity.getId()
					+ ", ' "
					+ weatherDataEntity.getCityId()
					+ " ',' "
					+ weatherDataEntity.getCityName()
					+ " ',' "
					+ weatherDataEntity.getTemperature()
					+ " ',' "
					+ weatherDataEntity.getPressure()
					+ " ',' "
					+ weatherDataEntity.getHumidity()
					+ " ',' "
					+ weatherDataEntity.getWindSpeed()
					+ " ',' "
					+ weatherDataEntity.getWindDirection()
					+ " ',' "
					+ weatherDataEntity.getWindDirectionName()
					+ " ',' "
					+ weatherDataEntity.getWeatherName()
					+ " ',' "
					+ weatherDataEntity.getWeather()
					+ " ',' "
					+ weatherDataEntity.getCollectTime()
					+ " ',' "
					+tt
					+ " ',' "
					+ weatherDataEntity.getExtend() + "')";
//			System.out.println("sql=" + sql);
			conn = DriverManager.getConnection(url, user, password);
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close();
		}
	}

	public static void main(String[] a) {
		WeatherDataEntity weatherDataEntity = new WeatherDataEntity();
		weatherDataEntity.setId(002l);
		weatherDataEntity.setCityId("0001");
		new WeatherDataDao().insertWeatherData(weatherDataEntity);
	}*/
}
