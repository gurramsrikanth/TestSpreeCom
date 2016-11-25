package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by srikanth on 25/11/16.
 */
public class RecoverPasswordPage {
    @FindBy(how = How.ID, using = "spree_user_email")
    WebElement login_email;


}
