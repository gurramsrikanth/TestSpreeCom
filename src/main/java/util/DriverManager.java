package util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by srikanth on 25/11/16.
 */


public class DriverManager {
    public static WebDriver driver;
    String baseUrl = "http://localhost:3000";
    public DriverManager(){
//        System.setProperty("webdriver.chrome.driver","/home/srikanth/Downloads/softwares/drivers/chromedriver");
//        driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","//home//srikanth//Downloads//softwares//drivers//geckodriver");
        driver = new FirefoxDriver();
        driver.get(baseUrl);
    }
}
