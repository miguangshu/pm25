package com.bupt.pm25.model;

public class ResultDataEntity {
	//id
	private Long id;
	//经度
	private String longitude;
	//纬度
	private String latitude;
	//手机型号
	private String phoneType;
	//图片名称
	private String picName;
	//预测值
	private String predictValue;
	//创建时间
	private String createDate;
	//区域名称
	private String districtName;
	//区域编号
	private String districtCode;
	//城市编号
	private String cityCode;
	//图片预测值
	private String imageValue;
	//天气预测值
	private String weatherValue;
	private String distance;
	@Override
	public String toString() {
		return "ResultDataEntity{" +
				"id=" + id +
				", longitude='" + longitude + '\'' +
				", phoneType='" + phoneType + '\'' +
				", picName='" + picName + '\'' +
				", predictValue='" + predictValue + '\'' +
				", createDate='" + createDate + '\'' +
				", districtCode='" + districtCode + '\'' +
				", cityCode='" + cityCode + '\'' +
				", imageValue='" + imageValue + '\'' +
				", weatherValue='" + weatherValue + '\'' +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getPredictValue() {
		return predictValue;
	}

	public void setPredictValue(String predictValue) {
		this.predictValue = predictValue;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getImageValue() {
		return imageValue;
	}

	public void setImageValue(String imageValue) {
		this.imageValue = imageValue;
	}

	public String getWeatherValue() {
		return weatherValue;
	}

	public void setWeatherValue(String weatherValue) {
		this.weatherValue = weatherValue;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
}
