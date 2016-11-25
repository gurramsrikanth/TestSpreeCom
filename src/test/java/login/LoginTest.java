package login;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import steps.LoginSteps;
import util.DriverManager;

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

    @Test
    public void testLogin(){
        LoginSteps loginSteps = new LoginSteps();
        String userName = loginSteps.Login("xt@xt.com","xt@xt123");
        Assert.assertEquals(userName,"xt@xt.com (Edit)","User email mismatched");
    }
}
