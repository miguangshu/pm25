package com.bupt.pm25.util;

/**
 * Created by miguangshu on 2016/10/20.
 */

import com.bupt.pm25.controller.UploadController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.UUID;

public class SocketUploadUtil {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    private static SocketUploadUtil uploadUtil;
    private static final String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
    private static final String PREFIX = "--";
    private static final String LINE_END = "\r\n";
    private static final String CONTENT_TYPE = "multipart/form-data"; // 内容类型
    private SocketUploadUtil() {

    }

    /**
     * 单例模式获取上传工具类
     * @return
     */
    public static SocketUploadUtil getInstance() {
        if (null == uploadUtil) {
            uploadUtil = new SocketUploadUtil();
        }
        return uploadUtil;
    }
    private int readTimeOut = 10 * 1000; // 读取超时
    private int connectTimeout = 10 * 1000; // 超时时间
    /***
     * 请求使用多长时间
     */
    private static int requestTime = 0;

    private static final String CHARSET = "utf-8"; // 设置编码

    /***
     * 上传成功
     */
    public static final int UPLOAD_SUCCESS_CODE = 1;
    /**
     * 文件不存在
     */
    public static final int UPLOAD_FILE_NOT_EXISTS_CODE = 2;
    /**
     * 服务器出错
     */
    public static final int UPLOAD_SERVER_ERROR_CODE = 3;
    protected static final int WHAT_TO_UPLOAD = 1;
    protected static final int WHAT_UPLOAD_DONE = 2;

    /**
     *
     * @param filePath
     * @param address
     * @param port
     */
    public void uploadFile(String filePath, String address,int port) {
        if (filePath == null) {
            sendMessage(UPLOAD_FILE_NOT_EXISTS_CODE,"文件不存在");
            return;
        }
        try {
            File file = new File(filePath);
            uploadFile(file, address,port);
        } catch (Exception e) {
            sendMessage(UPLOAD_FILE_NOT_EXISTS_CODE,"文件不存在");
            e.printStackTrace();
            return;
        }
    }
    /**
     *同步上传图片
     * @param filePath
     * @param address
     * @param port
     */
    public String synUploadFile(String filePath, String address,int port) {
        if (filePath == null) {
            return filePath+"文件不存在";
        }
        try {
            File file = new File(filePath);
            return synUploadFile(file,address,port);
        } catch (Exception e) {
            logger.error("上传文件{}异常，异常原因：{}",filePath,e);
            return e.getMessage();
        }
    }
    /**
     *
     * @param file
     * 需要上传的文件
     * @param address
     * 上传服务器地址
     * @param port
     * 上传服务器端口
     */
    public void uploadFile(final File file, final String address, final int port) {
        if (file == null || (!file.exists())) {
            sendMessage(UPLOAD_FILE_NOT_EXISTS_CODE,"文件不存在");
            return;
        }
        new Thread(new Runnable() { //开启线程上传文件
            public void run() {
                toUploadFile(file, address,port);
            }
        }).start();
    }

    /**
     *
     * @param fileName
     * @param address
     * @param port
     */
    public String uploadFileName(final String fileName, final String address, final int port) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(address, port);
            socket.connect(socketAddress,connectTimeout);
            outputStream = socket.getOutputStream();
            int picNameLen = fileName.length();
            byte[] picNameLenArray = BasicDataTypeTransfer.getInstance().IntToByteArray(picNameLen);
            byte[] picNameArray = BasicDataTypeTransfer.getInstance().StringToByteArray(fileName);
            byte[] headArray = ArrayUtil.getInstance().concat(picNameLenArray, picNameArray);
            long totalLen = 8 + headArray.length;
            byte[] totalLenArray = BasicDataTypeTransfer.getInstance().longToByteArray(totalLen);
            byte[] preHeadArray = ArrayUtil.getInstance().concat(totalLenArray, headArray);
            outputStream.write(preHeadArray);
            outputStream.flush();
            InputStream socketInputStream = socket.getInputStream();
            byte[] responseByte = new byte[1024];
            int responseLen = socketInputStream.read(responseByte);
            socketInputStream.close();
            String responseMessage = new String(Arrays.copyOf(responseByte, responseLen));
            return responseMessage;
        } catch(SocketTimeoutException e){
            logger.error("上传图片名称异常：",e);
            throw new RuntimeException("上传图片异常，异常原因："+e.getMessage());
        } catch (IOException e){
            logger.error("上传图片名称异常：",e);
            throw new RuntimeException("上传图片异常，异常原因："+e.getMessage());
        } catch(Exception e){
            logger.error("上传图片名称异常：",e);
            throw new RuntimeException("上传图片异常，异常原因："+e.getMessage());
        }finally {
            try {
                if(outputStream != null) {
                    outputStream.close();
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                logger.error("上传图片名称异常：",e);
                throw new RuntimeException("上传图片异常，异常原因："+e.getMessage());
            }
        }
    }
    private void toUploadFile(File file, String address, int port) {
        String result = null;
        requestTime= 0;
        Socket socket = null;
        long requestTime = System.currentTimeMillis();
        long responseTime = 0;
        OutputStream outputStream = null;
        try {
            socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(address, port);
            socket.connect(socketAddress,connectTimeout);
            outputStream = socket.getOutputStream();
            String picName = file.getName();//获取图片名称
            int picNameLen = picName.length();
            byte[] picNameLenArray = BasicDataTypeTransfer.getInstance().IntToByteArray(picNameLen);
            byte[] picNameArray = BasicDataTypeTransfer.getInstance().StringToByteArray(picName);
            long picContentLen = file.length();
            byte[] picContentLenArray = BasicDataTypeTransfer.getInstance().longToByteArray(picContentLen);
            byte[] headArray = ArrayUtil.getInstance().concat(ArrayUtil.getInstance().concat(picNameLenArray, picNameArray), picContentLenArray);
            long totalLen = 8 + headArray.length;
            byte[] totalLenArray = BasicDataTypeTransfer.getInstance().longToByteArray(totalLen);
            byte[] preHeadArray = ArrayUtil.getInstance().concat(totalLenArray, headArray);
            byte[] tmpArray = new byte[1024];
            int length = 0;
            int curlen = preHeadArray.length;
            InputStream is = new FileInputStream(file);
            onUploadProcessListener.initUpload((int) file.length());
            onUploadProcessListener.onUploadProcess(curlen);
            outputStream.write(preHeadArray);
            while ((length = is.read(tmpArray)) != -1) {
                curlen = length + curlen;
                outputStream.write(tmpArray, 0, length);
                onUploadProcessListener.onUploadProcess(curlen);
            }
            is.close();
            outputStream.flush();
            responseTime = System.currentTimeMillis();
            this.requestTime = (int)(responseTime - requestTime)/1000;
            InputStream socketInputStream = socket.getInputStream();
            byte[] responseByte = new byte[1024];
            int responseLen = socketInputStream.read(responseByte);
            socketInputStream.close();
            String responseMessage = new String(Arrays.copyOf(responseByte, responseLen));
            sendMessage(UPLOAD_SUCCESS_CODE, responseMessage);
        } catch(SocketTimeoutException e){
            sendMessage(UPLOAD_SERVER_ERROR_CODE,"服务器连接超时");
        } catch (IOException e){
            sendMessage(UPLOAD_SERVER_ERROR_CODE,e.getMessage());
        } catch(Exception e){
            sendMessage(UPLOAD_SERVER_ERROR_CODE,e.getMessage());
        }finally {
            try {
                if(outputStream != null) {
                    outputStream.close();
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private String synUploadFile(File file, String address, int port) {
        String result = null;
        requestTime= 0;
        Socket socket = null;
        long requestTime = System.currentTimeMillis();
        long responseTime = 0;
        OutputStream outputStream = null;
        try {
            socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(address, port);
            socket.connect(socketAddress,connectTimeout);
            outputStream = socket.getOutputStream();
            String picName = file.getName();//获取图片名称
            int picNameLen = picName.length();
            byte[] picNameLenArray = BasicDataTypeTransfer.getInstance().IntToByteArray(picNameLen);
            byte[] picNameArray = BasicDataTypeTransfer.getInstance().StringToByteArray(picName);
            long picContentLen = file.length();
            byte[] picContentLenArray = BasicDataTypeTransfer.getInstance().longToByteArray(picContentLen);
            byte[] headArray = ArrayUtil.getInstance().concat(ArrayUtil.getInstance().concat(picNameLenArray, picNameArray), picContentLenArray);
            long totalLen = 8 + headArray.length;
            byte[] totalLenArray = BasicDataTypeTransfer.getInstance().longToByteArray(totalLen);
            byte[] preHeadArray = ArrayUtil.getInstance().concat(totalLenArray, headArray);
            byte[] tmpArray = new byte[1024];
            int length = 0;
            int curlen = preHeadArray.length;
            InputStream is = new FileInputStream(file);
            outputStream.write(preHeadArray);
            while ((length = is.read(tmpArray)) != -1) {
                curlen = length + curlen;
                outputStream.write(tmpArray, 0, length);
            }
            is.close();
            outputStream.flush();
            responseTime = System.currentTimeMillis();
            this.requestTime = (int)(responseTime - requestTime)/1000;
            InputStream socketInputStream = socket.getInputStream();
            byte[] responseByte = new byte[1024];
            int responseLen = socketInputStream.read(responseByte);
            socketInputStream.close();
            String responseMessage = new String(Arrays.copyOf(responseByte, responseLen));
            return responseMessage;
        } catch(SocketTimeoutException e){
            logger.error("上传图片名称异常：",e);
            throw new RuntimeException("上传图片异常，异常原因："+e.getMessage());
        } catch (IOException e){
            logger.error("上传图片名称异常：",e);
            throw new RuntimeException("上传图片异常，异常原因："+e.getMessage());
        } catch(Exception e){
            logger.error("上传图片名称异常：",e);
            throw new RuntimeException("上传图片异常，异常原因："+e.getMessage());
        }finally {
            try {
                if(outputStream != null) {
                    outputStream.close();
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                logger.error("上传图片名称异常：",e);
                throw new RuntimeException("上传图片异常，异常原因："+e.getMessage());
            }
        }

    }
    /**
     * 发送上传结果
     * @param responseCode
     * @param responseMessage
     */
    private void sendMessage(int responseCode,String responseMessage)
    {
        onUploadProcessListener.onUploadDone(responseCode, responseMessage);
    }

    /**
     * 下面是一个自定义的回调函数，用到回调上传文件是否完成
     *
     * @author shimingzheng
     *
     */
    public static interface OnUploadProcessListener {
        /**
         * 上传响应
         * @param responseCode
         * @param message
         */
        void onUploadDone(int responseCode, String message);
        /**
         * 上传中
         * @param uploadSize
         */
        void onUploadProcess(int uploadSize);
        /**
         * 准备上传
         * @param fileSize
         */
        void initUpload(int fileSize);
    }
    private OnUploadProcessListener onUploadProcessListener;

    public void setOnUploadProcessListener(
            OnUploadProcessListener onUploadProcessListener) {
        this.onUploadProcessListener = onUploadProcessListener;
    }

    public int getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }
    /**
     * 获取上传使用的时间
     * @return
     */
    public static int getRequestTime() {
        return requestTime;
    }

    public static interface uploadProcessListener{

    }

    public static void main(String[] args) {
        SocketUploadUtil uploadUtil = SocketUploadUtil.getInstance();
        uploadUtil.uploadFile("","11.0.1.99",9400);
    }
}