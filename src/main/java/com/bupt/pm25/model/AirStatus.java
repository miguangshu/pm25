package com.bupt.pm25.model;

public class AirStatus {
	private int id;
	private String stationId;//站点ID
	private String stationName;//站点名称
	private String dic;//检测站点所在区域
	private String cityId;
	private String lon;
	private String lat;
	private String aqi;//空气质量指数
	private String pm25;//pm25含量
	private String pm10;//pm10含量
	private String co;//一氧化碳含量
	private String no2;//二氧化氮含量
	private String o3;//臭氧含量
	private String so2;//二氧化硫含量
	public void setStation(StationEntity stationEntity){
		this.stationId = stationEntity.getId();
		this.stationName = stationEntity.getStationName();
		this.dic = stationEntity.getStationDic();
		this.cityId = stationEntity.getCityId();
		this.lat = stationEntity.getLat();
		this.lon = stationEntity.getLon();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getDic() {
		return dic;
	}

	public void setDic(String dic) {
		this.dic = dic;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getAqi() {
		return aqi;
	}

	@Override
	public String toString() {
		return "AirStatus{" +
				"id=" + id +
				", stationId='" + stationId + '\'' +
				", stationName='" + stationName + '\'' +
				", dic='" + dic + '\'' +
				", cityId='" + cityId + '\'' +
				", aqi='" + aqi + '\'' +
				", pm25='" + pm25 + '\'' +
				", pm10='" + pm10 + '\'' +
				", co='" + co + '\'' +
				", no2='" + no2 + '\'' +
				", o3='" + o3 + '\'' +
				", so2='" + so2 + '\'' +
				'}';
	}

	public void setAqi(String aqi) {

		this.aqi = aqi;
	}

	public String getPm25() {
		return pm25;
	}

	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}

	public String getPm10() {
		return pm10;
	}

	public void setPm10(String pm10) {
		this.pm10 = pm10;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getNo2() {
		return no2;
	}

	public void setNo2(String no2) {
		this.no2 = no2;
	}

	public String getO3() {
		return o3;
	}

	public void setO3(String o3) {
		this.o3 = o3;
	}

	public String getSo2() {
		return so2;
	}

	public void setSo2(String so2) {
		this.so2 = so2;
	}
}
