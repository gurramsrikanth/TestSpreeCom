package steps;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import util.DriverManager;
import util.Log;

/**
 * Created by srikanth on 25/11/16.
 */
public class LoginSteps {
    HomePage homePageObj = PageFactory.initElements(DriverManager.driver, HomePage.class);
    LoginPage loginPageObj = PageFactory.initElements(DriverManager.driver, LoginPage.class);
    AccountPage accountPageObj = PageFactory.initElements(DriverManager.driver, AccountPage.class);

    /**
     * Click on Login link in the home page
     * Set Login ID (email)
     * Set Login Pwd
     * Submit the login form
     * Click on My Account in the home Page
     * Get user email from My Account page
     * return the email
     * */
    public String Login(String loginId, String password){
        Log.info("Click on login link");
        homePageObj.clickOnLoginLink();
        Log.info("set Login ID field");
        loginPageObj.setLoginEmail(loginId);
        Log.info("Set password field");
        loginPageObj.setLoginPassword(password);
        Log.info("Sign IN");
        String status = loginPageObj.submitLoginForm();
        Log.info("Check login is successful");
        if(status.equals("success")){
            homePageObj.clickOnMyAccountLink();
            String userEmail = accountPageObj.getUserEmail();
            return userEmail;
        }else{
            loginPageObj.clickOnHomeLink();
            return status;
        }
    }

    public void Logout(){
        homePageObj.clickOnLogoutLink();
    }
}
