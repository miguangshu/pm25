package com.bupt.pm25.model;

/**
 * Created by miguangshu on 2016/6/21.
 */
public class StationEntity {
    private String id;
    private String stationName;
    private String lon;
    private String lat;
    private String stationDic;
    private String cityId;
    public StationEntity(){}

    public StationEntity(String id, String stationName, String lon, String lat, String stationDic, String cityId) {
        this.id = id;
        this.stationName = stationName;
        this.lon = lon;
        this.lat = lat;
        this.stationDic = stationDic;
        this.cityId = cityId;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getStationDic() {
        return stationDic;
    }

    public void setStationDic(String stationDic) {
        this.stationDic = stationDic;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
