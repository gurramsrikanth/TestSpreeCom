package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import util.Log;

import java.util.List;

import static util.DriverManager.driver;

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

    @FindBy(how = How.ID, using = "home-link")
    WebElement home_link;

    public void clickOnLoginLink(){
        login_link.click();
        Log.info("Clicked on Login link");
    }

    public void clickOnMyAccountLink(){
        my_account_link.click();
        Log.info("Clicked on MyAccount link");
    }

    public void clickOnLogoutLink(){
        logout_link.click();
        Log.info("Logged out");
    }

    //get all the category names
    public String[] getAllCategories(){
        List<WebElement> category_links = shop_by_category.findElements(By.tagName("a"));
        String [] categories = new String[category_links.size()];
        int counter = 0;
        for( WebElement link : category_links ){
            categories[counter] = link.getText();
            counter += 1;
        }
        Log.info("Categories found are: "+categories.toString());
        return categories;
    }

    public void clickOnHomeLink(){
        home_link.click();
    }

    // check each link and return all the page titles
    public String[][] getCategoryLinksAndTitles(){
        List<WebElement> category_links = shop_by_category.findElements(By.tagName("a"));
        int size = category_links.size();
        String[][] categoryLinksAndTitles = new String[size][size];

        int counter = 0;
        for(WebElement link : category_links){
            categoryLinksAndTitles[counter][0] = link.getText();
            link.click();
            categoryLinksAndTitles[counter][1] = driver.getTitle();
            counter += 1;
        }

        return categoryLinksAndTitles;
    }

    // check each link and return all the page titles
    public String[][] getAllBrandLinksAndTitles(){
        List<WebElement> brand_links = shopping_by_brand.findElements(By.tagName("a"));
        int size = brand_links.size();
        String[][] brandLinksAndTitles = new String[size][size];

        int counter = 0;
        for(WebElement link : brand_links){
            String link_text = link.getText();
            System.out.println("link: "+link_text);
            brandLinksAndTitles[counter][0] = link_text;
            link.click();
            String title = driver.getTitle();
            System.out.println("page title = "+title);
            brandLinksAndTitles[counter][1] = title;
            driver.navigate().back();
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }

            counter += 1;
        }
        return brandLinksAndTitles;
    }


    // Get all the brand names
    public String[] getAllBrands(){
        List<WebElement> brandLinks = shopping_by_brand.findElements(By.tagName("a"));
        String [] brands = new String[brandLinks.size()];
        int counter = 0;
        for( WebElement link : brandLinks ){
            brands[counter] = link.getText();
            counter += 1;
        }

        return brands;
    }
}
