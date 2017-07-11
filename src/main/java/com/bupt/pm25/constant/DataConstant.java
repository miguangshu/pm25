package com.bupt.pm25.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by miguangshu on 2016/9/7.
 */
public class DataConstant {
    public static Map<String, String> CITY_CODE_MAP = new HashMap<String,String>(); // 转换城市id, <src,desc>
    static {
        CITY_CODE_MAP.put("001","54511");// 北京市
        CITY_CODE_MAP.put("00101","54511");// 海淀
        CITY_CODE_MAP.put("00102","54511");// 石景山
        CITY_CODE_MAP.put("00103","54511");// 丰台区
        CITY_CODE_MAP.put("00105","54511");// 朝阳区
        CITY_CODE_MAP.put("00106","54511");// 西城区
        CITY_CODE_MAP.put("00107","54511");// 东城区
        CITY_CODE_MAP.put("00108","54594");// 大兴区
        CITY_CODE_MAP.put("00109","54431");// 通州区
        CITY_CODE_MAP.put("00110","54398");// 顺义区
        CITY_CODE_MAP.put("00111","54499");// 昌平区
        CITY_CODE_MAP.put("00112","54505");// 门头沟区
        CITY_CODE_MAP.put("00113","54424");// 平谷区
        CITY_CODE_MAP.put("00114","54419");// 怀柔区
        CITY_CODE_MAP.put("00115","54416");// 密云县
        CITY_CODE_MAP.put("00116","54406");// 延庆县
        CITY_CODE_MAP.put("00104","54596");// 房山区
    }
    public static Map<String, String> CITY_CODE_NAME_MAP = new HashMap<String,String>(); // 转换城市id, <src,desc>
    static {
        CITY_CODE_NAME_MAP.put("001","北京市");// 北京市
        CITY_CODE_NAME_MAP.put("00101","海淀区");// 海淀
        CITY_CODE_NAME_MAP.put("00102","石景山区");// 石景山
        CITY_CODE_NAME_MAP.put("00103","丰台区");// 丰台区
        CITY_CODE_NAME_MAP.put("00105","朝阳区");// 朝阳区
        CITY_CODE_NAME_MAP.put("00106","西城区");// 西城区
        CITY_CODE_NAME_MAP.put("00107","东城区");// 东城区
        CITY_CODE_NAME_MAP.put("00108","大兴区");// 大兴区
        CITY_CODE_NAME_MAP.put("00109","通州区");// 通州区
        CITY_CODE_NAME_MAP.put("00110","顺义区");// 顺义区
        CITY_CODE_NAME_MAP.put("00111","昌平区");// 昌平区
        CITY_CODE_NAME_MAP.put("00112","门头沟区");// 门头沟区
        CITY_CODE_NAME_MAP.put("00113","平谷区");// 平谷区
        CITY_CODE_NAME_MAP.put("00114","怀柔区");// 怀柔区
        CITY_CODE_NAME_MAP.put("00115","密云县");// 密云县
        CITY_CODE_NAME_MAP.put("00116","延庆县");// 延庆县
        CITY_CODE_NAME_MAP.put("00104","房山区");// 房山区
    }
    public static Map<String, String> WEATHER_MAP = new HashMap<String, String>();
    static {
        WEATHER_MAP.put("晴", "0");//晴
        WEATHER_MAP.put("多云", "1");// 多云
        WEATHER_MAP.put("阴", "2");// 阴
        WEATHER_MAP.put("阵雨", "3");// 阵雨
        WEATHER_MAP.put("雷阵雨", "8");// 雷阵雨
        WEATHER_MAP.put("雷阵雨有冰雹", "8");// 雷阵雨有冰雹
        WEATHER_MAP.put("雨夹雪", "9");// 雨夹雪
        WEATHER_MAP.put("小雨", "4");// 小雨
        WEATHER_MAP.put("中雨", "5");// 中雨
        WEATHER_MAP.put("大雨", "6");// 大雨
        WEATHER_MAP.put("暴雨", "7");// 暴雨
        WEATHER_MAP.put("大暴雨", "7");//大暴雨
        WEATHER_MAP.put("特大暴雨", "7");// 特大暴雨
        WEATHER_MAP.put("阵雪", "10");// 阵雪
        WEATHER_MAP.put("小雪", "11");// 小雪
        WEATHER_MAP.put("中雪", "12");// 中雪
        WEATHER_MAP.put("大雪", "13");// 大雪
        WEATHER_MAP.put("暴雪", "13");// 暴雪
        WEATHER_MAP.put("冻雨", "9");// 冻雨
        WEATHER_MAP.put("沙尘暴", "15");// 沙尘暴
        WEATHER_MAP.put("风沙", "16");// 风沙
        WEATHER_MAP.put("霾", "17");// 霾
    }
}
