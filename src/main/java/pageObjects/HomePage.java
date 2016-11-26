package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by srikanth on 25/11/16.
 */
public class HomePage {
    @FindBy(how = How.LINK_TEXT,using = "LOGIN")
    private WebElement login_link;

    @FindBy(how = How.LINK_TEXT,using = "LOGOUT")
    private WebElement logout_link;

    @FindBy(how = How.LINK_TEXT, using = "MY ACCOUNT")
    private WebElement my_account_link;

    @FindBy(how = How.XPATH, using = ".//*[@id='taxonomies']/ul[1]")
    private WebElement shop_by_category;

    @FindBy(how = How.XPATH, using = ".//*[@id='taxonomies']/ul[2]")
    private WebElement shopping_by_brand;

    public void clickOnLoginLink(){
        login_link.click();
    }

    public void clickOnMyAccountLink(){
        my_account_link.click();
    }

    public void clickOnLogoutLink(){
        logout_link.click();
    }

    //get all the catefory names
    public String[] getAllCategories(){
        List<WebElement> categoryLinks = shop_by_category.findElements(By.tagName("li"));
        String [] categories = new String[categoryLinks.size()];
        int counter = 0;
        for( WebElement link : categoryLinks ){
            categories[counter] = link.getText();
            counter += 1;
        }
        return categories;
    }

    // Get all the brand names
    public String[] getAllBrands(){
        List<WebElement> brandLinks = shopping_by_brand.findElements(By.tagName("li"));
        String [] brands = new String[brandLinks.size()];
        int counter = 0;
        for( WebElement link : brandLinks ){
            brands[counter] = link.getText();
            counter += 1;
        }

        return brands;
    }
}
