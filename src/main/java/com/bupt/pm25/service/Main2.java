package com.bupt.pm25.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by katiemi on 2017/9/20.
 */
public class Main2 {
    List<Integer> stack = new ArrayList<Integer>();
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Main2 main = new Main2();
        for(int i=0;i<len;i++){
            main.push(sc.nextInt());
        }
        main.pop();
        System.out.printf(main.max()+","+main.min());
    }
    public void push(int data){
        if(data < min){
            min = data;
        }
        if(data > max){
            max = data;
        }
        stack.add(data);
    }
    public int pop(){
        int pop = stack.remove(stack.size()-1);
        return pop;
    }
    public int min(){
        return min;
    }
    public int max(){
        return max;
    }
}