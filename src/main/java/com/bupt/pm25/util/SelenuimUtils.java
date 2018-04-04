package com.bupt.pm25.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by katiemi on 2018/1/22.
 */
public class SelenuimUtils {
    private static final Logger logger = LoggerFactory.getLogger(SelenuimUtils.class);

    private static WebDriver driver = null;
    static {
        logger.info("setting phantomjs.binary.path.........................");
        System.setProperty("phantomjs.binary.path", ConfigUtil.getphantomjsBinaryPath());
        logger.info("initing phantomjs.binary.path.........................");
        driver = new PhantomJSDriver();
        driver.manage().window().maximize();
    }
    public static String baiduSearch(String content) throws InterruptedException{
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys(content);
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        List<WebElement> list = driver.findElements(By.className("result"));
        int num=0;
        while (list.size()==0 && num<10){
            num++;
            logger.info("第【{}】次查询【{}】，返回值为null，线程睡眠 0.5s后继续............",num,content);
            Thread.sleep(500);
            list = driver.findElements(By.className("result"));
        }
        if(list.size() == 0){
            throw new RuntimeException("请求超时,没有得到返回结果");
        }
        WebElement contentLeft = driver.findElement(By.id("content_left"));
        return contentLeft.getText();
    }
}
