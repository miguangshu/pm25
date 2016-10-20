package com.bupt.pm25.model;

import java.util.Date;

public class WeatherDataEntity {

	private Long id;
	// 城市id
	private String cityId;
	//城市名称
	private String cityName;
	// 采集时间
	private String collectTime;
	// 温度
	private String temperature;
	// 压力
	private String pressure;
	// 湿度
	private String humidity;
	// 风速
	private String windSpeed;
	private String windDirectionName;
	// 风向
	private String windDirection;
	// 天气原始名称
	private String weatherName;
	// 天气
	private String weather;
	// 扩展字段
	private String extend;
	private String createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getWeatherName() {
		return weatherName;
	}

	public void setWeatherName(String weatherName) {
		this.weatherName = weatherName;
	}

	public String getWindDirectionName() {
		return windDirectionName;
	}

	public void setWindDirectionName(String windDirectionName) {
		this.windDirectionName = windDirectionName;
	}

	@Override
	public String toString() {
		return "WeatherDataEntity{" +
				"id=" + id +
				", cityId='" + cityId + '\'' +
				", cityName='" + cityName + '\'' +
				", collectTime='" + collectTime + '\'' +
				", temperature='" + temperature + '\'' +
				", pressure='" + pressure + '\'' +
				", humidity='" + humidity + '\'' +
				", windSpeed='" + windSpeed + '\'' +
				", windDirectionName='" + windDirectionName + '\'' +
				", windDirection='" + windDirection + '\'' +
				", weatherName='" + weatherName + '\'' +
				", weather='" + weather + '\'' +
				", extend='" + extend + '\'' +
				", createDate='" + createDate + '\'' +
				'}';
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
