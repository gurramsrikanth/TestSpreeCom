package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by srikanth on 25/11/16.
 */
public class SignupPage {
    @FindBy(how = How.ID, using = "spree_user_email")
    WebElement new_customer_email;

    @FindBy(how = How.ID, using = "spree_user_password")
    WebElement new_customer_pwd;


    @FindBy(how = How.ID, using = "spree_user_password_confirmation")
    WebElement new_user_confirm_pwd;

    @FindBy(how = How.LINK_TEXT, using = "Login as Existing Customer")
    WebElement login_existing_customer_link;

    // Set the User Email
    public void setNewUserEmail(){

    }
    // Set the Password

    // Set Confirm Password
    public void setConfirmPassword(String confirmPwd){
        new_user_confirm_pwd.sendKeys(confirmPwd);
    }

    // Submit the form to Signup
    public void submitSignupForm(){
        new_user_confirm_pwd.submit();
    }

    // Click on login as existing customer link
    public void clickLoginAsExistingCustomer(){
        login_existing_customer_link.click();
    }
}
