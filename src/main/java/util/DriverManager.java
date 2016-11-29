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
        String propFile = "testSetup.properties";
        PropertyFileManager propManager = new PropertyFileManager();
        String browserName = propManager.readProperty(propFile,"browser");
        String driverPath = System.getProperty("user.dir")+"/"+propManager.readProperty(propFile,"driver_path");

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",driverPath);
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",driverPath);
            driver = new FirefoxDriver();
        }else{
            System.out.println("Invalid Browser");
        }
        driver.get(baseUrl);
    }
}
