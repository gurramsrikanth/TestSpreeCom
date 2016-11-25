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

    // Set Email
    public void setLoginEmail(String email){
        login_email.sendKeys(email);
    }
    // Set Password
    public void setLoginPassword(String pwd){
        login_pwd.sendKeys(pwd);
    }

    // Submit the form to login
    public void submitLoginForm(){
        login_pwd.submit();
    }

    // click on new user link
    public void clickOnNewAccountLink(){
        new_account_link.click();
    }

    // click on forgot Password link
    public void clickOnForgotPasswordLink(){
        forgot_password_link.click();
    }

}
