package util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Created by srikanth on 25/11/16.
 */


public class DriverManager {
    public static WebDriver driver;
    String baseUrl = "http://localhost:3000";
    public DriverManager(){
        System.setProperty("webdriver.chrome.driver","/home/srikanth/Downloads/softwares/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
}
