package com.bupt.pm25.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by katiemi on 2016/11/7.
 */
public class FileUtils {
    public static List<String> readFileByLines(String fileName) {
        List<String> readStringList=new ArrayList<String>();
        //String writeString = "";
        File file = new File(fileName);
        BufferedReader reader = null;
        //int line = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = "";
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                //line++;

                // ???
                //findLuanMa(tempString);
                readStringList.add(tempString);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return readStringList;
    }

    public static void writeToFile(String filePath,String contentString){
        FileOutputStream fos = null;
        File file=new File(filePath);
        try {
            fos = new FileOutputStream(file);
            fos.write(contentString.getBytes());
            fos.flush();
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (Exception e) {
                //
            }
        }
    }

    public static ArrayList<String> getFilePathList(String dirPath) {
        ArrayList<String> filePathList=new ArrayList<String>();
        File dirFile = new File(dirPath);
        File[] files = dirFile.listFiles();
        if (files == null) {
            return null;
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                ArrayList<String> subPathList=getFilePathList(files[i].getAbsolutePath());
                filePathList.addAll(subPathList);
            } else {
                String strFileName = files[i].getAbsolutePath();
                System.out.println(strFileName);
                filePathList.add(strFileName);
            }
        }
        return filePathList;

    }

    public static List<String> getParentMeFormatList(String filePath){
        List<String> parentMeFormatList=new ArrayList<String>();
        String parentPath = "";

        if(new File(filePath).isDirectory()){
            String[] layerArray = filePath.split("/");
            int layer = layerArray.length;
            for(int i=0;i<layer-1;i++){
                if(layerArray[i] != ""){
                    parentPath += layerArray[i] + "/";
                }
            }
            parentMeFormatList.add(0, parentPath);
            parentMeFormatList.add(1, layerArray[layer - 1]);
            parentMeFormatList.add(2, "/");
        } else {
            String[] formatArray = filePath.split("\\.");
            String[] layerArray=formatArray[0].split("/");
            int layer = layerArray.length;
            for(int i=0;i<layer-1;i++){
                parentPath+=layerArray[i]+"/";
            }
            parentMeFormatList.add(parentPath);
            parentMeFormatList.add(layerArray[layer - 1]);
            parentMeFormatList.add(formatArray[1]);
        }

        return parentMeFormatList;
    }

    public static File createFile(String filePath){
        List<String> parentMeFormatList = getParentMeFormatList(filePath);
        String dirPath = parentMeFormatList.get(0);
        File dirFile = new File(dirPath);
        if(!dirFile.exists()||!dirFile.isDirectory()){
            if(!dirFile.mkdirs()){
                return null;
            }
        }
        File newFile =new File(filePath);
        return newFile;
    }

    /**
     * 递归创建父目录
     * @param dir
     */
    public static void createParentDir(File dir){
        if(dir.getParentFile().exists()){
            dir.mkdir();
        }else{
            createParentDir(dir.getParentFile());
            dir.mkdir();
        }
    }

    public static void main(String[] args) {
        File file = new File("/Users/katiemi/work/bupt/01_pm25_server/src/src/main/webapp/temp/t1/t2/t3");
        FileUtils.createParentDir(file);
    }
}
