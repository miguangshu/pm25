package com.bupt.pm25.util;

import com.bupt.pm25.constant.DataConstant;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 数据转换工具类
 * Created by miguangshu on 2016/9/7.
 */
public class ConvertDataUtils {
    /**
     * 城市编码转换，气象台城市编码转换成自己定义的编码
     * */
    public static String convetorCityId(String cityCode) {
        return DataConstant.CITY_CODE_MAP.get(cityCode);
    }

    /**
     * 转换湿度的格式
     * */
    public static String convetorhumidity(Object src) {
        String humidityStr = (String) src;
        String result = null;
        if (humidityStr.contains("%")) {
            String tempStr = humidityStr.replace("%", "").trim();
            result = tempStr;
        } else {
            result = humidityStr;
        }
        return result;
    }
    /**
     * 转换温度
     * */
    public static String convetorTem(Object src) {
        String tem = (String) src;
        String result = null;
        String tempStr = tem.trim().substring(0, tem.length()-1);
        result = tempStr;
        return result;
    }
    /**
     * 格式化采集时间
     * */
    public static String dateFormat(Date date) {
        String format = "yyyy-MM-dd hh:mm:ss";
        return new SimpleDateFormat(format).format(date);
    }
    /**
     * 转换风向
     * */
    public static String convetorWinDirection(Object src) {
        String winDir = (String) src;
        String result = null;
        if (winDir.equals("东风")) {
            result = "1";
        }else if(winDir.equals("西风")){
            result = "2";
        }else if(winDir.equals("南风")){
            result = "3";
        }else if(winDir.equals("北风")){
            result = "4";
        }else if(winDir.equals("东南风")){
            result = "13";
        }else if(winDir.equals("东北风")){
            result = "14";
        }else if(winDir.equals("西南风")){
            result = "23";
        }else if(winDir.equals("西北风")){
            result = "24";
        }else{
            result = "";
        }
        return result;
    }
    /**
     * 天气转换 文字转换成编码
     * */
    public static String convetorWeather(Object src) {
        String weather = (String) src;
        String result = DataConstant.WEATHER_MAP.get(weather);
        return result;
    }
}
