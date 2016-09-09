package com.bupt.pm25.util;

import com.bupt.pm25.model.WeatherDataEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class FetchWeatherDataUtils {
	// Url
//	public final static String URL = "http://api.k780.com:88/";
//    public static String URL = "http://www.nmc.cn/service/data/real/$cityid$.json?_=$timestamp$";
	public static String URL = "http://www.nmc.cn/f/rest/real/cityCode?_=timestamp";
	public static 	ObjectMapper mapper = new ObjectMapper(); // create once, reuse

	/**
	 * 根据城市编码获取天气数据
	 * @param cityCode
	 * @return
	 * @throws IOException
     */
	public static WeatherDataEntity getWeatherData(String cityCode) throws IOException {
		String jsonResult = HttpClientUtils.sendGet(URL.replace("cityCode",ConvertDataUtils.convetorCityId(cityCode)).replace("timestamp",System.currentTimeMillis()+""));
		JsonNode root = mapper.readTree(jsonResult);
		String publishTime = root.get("publish_time").asText();
		JsonNode station = root.get("station");
		JsonNode weather = root.get("weather");
		JsonNode wind = root.get("wind");
		WeatherDataEntity weatherDataEntity = new WeatherDataEntity();
		weatherDataEntity.setCityId(cityCode);
		weatherDataEntity.setCityName(station.get("city").asText());
		weatherDataEntity.setHumidity(ConvertDataUtils.convetorhumidity(weather.get("humidity").asText()));
		weatherDataEntity.setCollectTime(publishTime);
		weatherDataEntity.setPressure(weather.get("airpressure").asText());
		weatherDataEntity.setTemperature(weather.get("temperature").asText());
		weatherDataEntity.setWeatherName(weather.get("info").asText());
		weatherDataEntity.setWeather(ConvertDataUtils.convetorWeather(weather.get("info").asText()));
		weatherDataEntity.setWindDirectionName(wind.get("direct").asText());
		weatherDataEntity.setWindDirection(ConvertDataUtils.convetorWinDirection(wind.get("direct").asText()));
		weatherDataEntity.setWindSpeed(wind.get("speed").asText());
		return weatherDataEntity;
	}

	public static void main(String[] args) throws Exception{
		System.out.println(getWeatherData("001"));
	}
}
