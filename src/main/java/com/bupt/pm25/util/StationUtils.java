package com.bupt.pm25.util;

import com.bupt.pm25.model.StationEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by miguangshu on 2016/6/21.
 */
public class StationUtils {
    private static Map<String,StationEntity> stations = new HashMap<String,StationEntity>();
    static {
        stations.put("海淀区万柳",   new StationEntity("1",  "海淀区万柳",   "39.970097","116.300176","00101","1"));
        stations.put("万寿西宫", new StationEntity("2",  "西城万寿西宫", "39.885719","116.374807","00106","1"));
        stations.put("定陵",     new StationEntity("3",  "昌平定陵",     "40.294875","116.246293","00111","1"));
        stations.put("东四",     new StationEntity("4",  "东城东四",     "39.932395","116.425074","00107","1"));
        stations.put("天坛",     new StationEntity("5",  "东城天坛",     "39.885013","116.429354","00107","1"));
        stations.put("农展馆",   new StationEntity("6",  "朝阳农展馆",   "39.947009","116.470307","00105","1"));
        stations.put("官园",     new StationEntity("7",  "西城官园",     "39.936995","116.359667","00106","1"));
        stations.put("顺义新城",     new StationEntity("8",  "顺义新城",     "40.122472","116.643946","00110","1"));
        stations.put("怀柔镇",         new StationEntity("9",  "怀柔",         "40.318906","116.658565","00114","1"));
        stations.put("昌平镇",       new StationEntity("10", "昌平镇",       "40.227109","116.233051","00111","1"));
        stations.put("奥体中心", new StationEntity("11", "朝阳奥体中心", "39.992034","116.402256","00105","1"));
        stations.put("古城",   new StationEntity("12", "石景山古城",   "39.913397","116.196743","00102","1"));
    }
    public static StationEntity getStationEntity(String stationName){
        return stations.get(stationName);
    }
}
