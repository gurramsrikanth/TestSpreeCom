package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by srikanth on 25/11/16.
 */
public class LoginPage {
    @FindBy(how = How.ID, using = "spree_user_email")
    WebElement login_email;

    @FindBy(how = How.ID, using = "spree_user_password")
    WebElement login_pwd;

    @FindBy(how = How.LINK_TEXT, using = "Create a new account")
    WebElement new_account_link;

    @FindBy(how = How.LINK_TEXT, using = "Forgot Password?")
    WebElement forgot_password_link;

    @FindBy(how = How.XPATH, using = ".//*[@id='content']/div[1]")
    WebElement login_error_text;

    @FindBy(how = How.ID, using = "home-link")
    WebElement home_link;

    // Set Email
    public void setLoginEmail(String email){
        login_email.sendKeys(email);
    }
    // Set Password
    public void setLoginPassword(String pwd){
        login_pwd.sendKeys(pwd);
    }

    // Submit the form to login
    public String submitLoginForm(){
        login_pwd.submit();

        if(login_error_text.isDisplayed() &&
                login_error_text.getText().equals("Invalid email or password.")){
            return "Invalid email or password.";
        }else{
            return "success";
        }
    }

    // click on new user link
    public void clickOnNewAccountLink(){
        new_account_link.click();
    }

    // click on forgot Password link
    public void clickOnForgotPasswordLink(){
        forgot_password_link.click();
    }

    public void clickOnHomeLink(){
        home_link.click();
    }
}
