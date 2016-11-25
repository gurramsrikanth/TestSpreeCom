package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by srikanth on 25/11/16.
 */
public class AccountPage {

    @FindBy(how = How.XPATH, using = ".//*[@id='user-info']/dd")
    WebElement user_info_email;

    public String getUserEmail(){
        String userName = user_info_email.getText();
        return userName;
    }
}
