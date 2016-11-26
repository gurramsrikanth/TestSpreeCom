package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by srikanth on 25/11/16.
 */
public class HomePage {
    @FindBy(how = How.LINK_TEXT,using = "LOGIN")
    WebElement login_link;

    @FindBy(how = How.LINK_TEXT,using = "LOGOUT")
    WebElement logout_link;

    @FindBy(how = How.LINK_TEXT, using = "MY ACCOUNT")
    WebElement my_account_link;

    public void clickOnLoginLink(){
        login_link.click();
    }

    public void clickOnMyAccountLink(){
        my_account_link.click();
    }

    public void clickOnLogoutLink(){
        logout_link.click();
    }
}
