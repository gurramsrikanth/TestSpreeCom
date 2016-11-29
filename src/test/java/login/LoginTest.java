package login;

import org.testng.Assert;
import org.testng.annotations.*;
import steps.LoginSteps;
import util.DriverManager;
import util.ExcelFileManager;
import util.PropertyFileManager;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Created by srikanth on 25/11/16.
 */
public class LoginTest {


    @BeforeSuite
    public void initDriver(){
        String propFile = "testSetup.properties";
        PropertyFileManager propManager = new PropertyFileManager();
        String browserName = propManager.readProperty(propFile,"browser");

        DriverManager manager = new DriverManager();
    }

    @AfterSuite
    public void tearDown(){
        DriverManager.driver.quit();
    }

    @DataProvider(name = "validLogin")
    public static Object[][] validLoginCredentials() {
        String filePath = "";
        filePath = System.getProperty("user.dir")+"/src/main/resources/testData";
        ExcelFileManager excelManager = new ExcelFileManager();
        String testDataFile = "userLoginData.xls";
        Object [][]data = excelManager.readExcelData(filePath,testDataFile,"sheet1");
        return data;
    }

    @DataProvider(name = "inValidLogin")
    public static Object[][] inValidLoginCredentials() {
        String filePath = "";
        filePath = System.getProperty("user.dir")+"/src/main/resources/testData";
        ExcelFileManager excelManager = new ExcelFileManager();
        String testDataFile = "userLoginData.xls";
        Object [][]data = excelManager.readExcelData(filePath,testDataFile,"sheet2");
        return data;
    }

    @Test(dataProvider = "validLogin")
    public void verifyWithValidLoginData(String userName, String password){
        LoginSteps loginSteps = new LoginSteps();
        String accountName = loginSteps.Login(userName, password);
        Assert.assertEquals(accountName.equals(userName+" (Edit)"), true);
        //Logout to re-login
        loginSteps.Logout();
    }

    @Test(dataProvider = "inValidLogin")
    public void verifyWithInValidLoginData(String userName, String password){
        LoginSteps loginSteps = new LoginSteps();
        String accountName = loginSteps.Login(userName, password);
        Assert.assertEquals(accountName.equals("Invalid email or password."), true);
    }

}

