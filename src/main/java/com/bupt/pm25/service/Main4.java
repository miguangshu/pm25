package com.bupt.pm25.service;

import java.util.*;

/**
 * Created by katiemi on 2017/9/20.
 */
public class Main4 {
    List<Integer> stack = new ArrayList<Integer>();
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        Map<Integer,Integer> map1 = new HashMap<Integer, Integer>();

        for(int i=0;i<a.length();i++){
            int s = Integer.parseInt(a.charAt(i)+"");
            Integer b = map.get(s);
            if(b == null){
                b=1;
            }else {
                b++;
            }
            map.put(s,b);
            map1.put(s,b);
        }

        System.out.printf(compare(map,map1)+"");

    }
    public static int compare(Map<Integer,Integer> map,Map<Integer,Integer> map1){
        int i = 1;
        while(true){
            map = map1;
           String iS = i+"";
           Boolean flag = true;
           for(int j = 0;j<iS.length();j++){
               int s = Integer.parseInt(iS.charAt(iS.length()-j-1)+"");
               Integer b = map.get(s);
               if(b == null || b==0){
                   flag = false;
                   break;
               }else {
                   b--;
                   map.put(s,b);
               }
           }
           if(!flag)
               break;
           else
               i++;
       }
       return i;
    }

}