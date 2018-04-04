import com.bupt.pm25.util.SelenuimUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.List;

/**
 * Created by katiemi on 2018/1/21.
 */
public class TestSelenuim {
    public static void main(String[] args) throws Exception{
        /*System.setProperty("phantomjs.binary.path", "/Users/katiemi/work/part_time_job/13_pdd/01_doc/phantomjs-2.1.1-macosx/bin/phantomjs");
        WebDriver driver = new PhantomJSDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("北京邮电大学");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        List<WebElement> list = driver.findElements(By.className("result"));
        while (list.size()==0){
            System.out.printf("sleep....");
            Thread.sleep(500);
            list = driver.findElements(By.className("result"));
        }
        WebElement contentLeft = driver.findElement(By.id("content_left"));
        System.out.printf(contentLeft.getText());*/
        String content = SelenuimUtils.baiduSearch("北京邮电大学");
        System.out.printf(content);
    }
}
