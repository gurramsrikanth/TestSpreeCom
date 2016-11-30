package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by srikanth on 30/11/16.
 */
public class ScreenshotCapturer {

    public static void captureScreenshot(WebDriver driver, String fileName){
        try{
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            String filePath = "";
            filePath = System.getProperty("user.dir")+"/screenshots";
            File destination = new File(filePath+"/"+fileName+".png");
            FileUtils.copyFile(source, destination);
        }catch (IOException e){
            System.out.println("Unable to copy the screenshot. Exception: "+e.getMessage());
        }
    }
}
