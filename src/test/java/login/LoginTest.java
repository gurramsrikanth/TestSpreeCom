package login;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.*;
import steps.LoginSteps;
import util.DriverManager;
import util.ExcelFileManager;
import util.Log;
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
        DOMConfigurator.configure("log4j.xml");
    }

    @AfterSuite
    public void tearDown(){
        DriverManager.driver.quit();
    }

    @BeforeTest
    public void TestInit(){
        Log.startTestCase("Login_Test");
    }

    @AfterTest
    public void TestClose(){
        Log.endTestCase("Login_Test");
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

    @Test(dataProvider = "validLogin", description = "Verify login with valid credentails",
            groups = { "group2" })
    public void verifyWithValidLoginData(String userName, String password){
        LoginSteps loginSteps = new LoginSteps();
        String accountName = loginSteps.Login(userName, password);
        Assert.assertEquals(accountName.equals(userName+" (Edit)"), true);
        //Logout to re-login
        loginSteps.Logout();
    }

    @Test(dataProvider = "inValidLogin", description = "Verify login with invalid credentials",
            groups = { "group1" })

    public void verifyWithInValidLoginData(String userName, String password){
        LoginSteps loginSteps = new LoginSteps();
        String accountName = loginSteps.Login(userName, password);
        Assert.assertEquals(accountName.equals("Invalid email or password."), true);
    }

}

