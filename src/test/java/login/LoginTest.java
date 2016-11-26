package login;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.LoginSteps;
import util.DriverManager;
import util.Text2TestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by srikanth on 25/11/16.
 */
public class LoginTest {

    @BeforeSuite
    public void initDriver(){
        DriverManager manager = new DriverManager();
    }

    @AfterSuite
    public void tearDown(){
        DriverManager.driver.quit();
    }

    @DataProvider(name = "validLogin")
    public static Object[][] validLoginCredentials() {
        return new Object[][] {
                {"xt@xt.com", "xt@xt123"}
        };
    }

    @DataProvider(name = "inValidLogin")
    public static Object[][] inValidLoginCredentials() {
        return new Object[][] {
                {"xt1@xt.com", "xt1@xt123"},
                {"xt2@xt.com", "xt2@xt123"},
                };
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
