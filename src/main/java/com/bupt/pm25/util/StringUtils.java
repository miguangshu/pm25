package com.bupt.pm25.util;

/**
 * Created by katiemi on 2018/1/22.
 */
public class StringUtils {
    public static int getCounts(String content,String reg){
        int count=0;
        String str =content.toLowerCase();//你要测试的字符串
        reg = reg.toLowerCase();
        //index为字符串中第一次出现c的位置，如果字符串中没有c将返回-1
        int index = str.indexOf(reg);
        while( str.indexOf(reg)!=-1){
            count++;
            //将字符串出现reg的位置之前的全部截取掉
            str = str.substring(str.indexOf(reg)+reg.length());
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.printf(getCounts("北京北京北京北京","北京")+"");
    }
}
