package com.bupt.pm25.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by katiemi on 2017/9/20.
 */
public class Main3 {
    List<Integer> stack = new ArrayList<Integer>();
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        String a = "abb";
        String b = "abb";
//        Scanner sc = new Scanner(System.in);
//        String a = sc.nextLine();
//        String b = sc.nextLine();
        int total = 0;
        for(int i=0;i<a.length()-b.length()+1;i++){
            String c1 = a.substring(i,i+b.length());
            System.out.println(c1);
            total += compare(c1,b);
        }
        System.out.printf(total+"");

    }
    public static int compare(String a,String b){
        int diff = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
        }
        return diff;
    }

}