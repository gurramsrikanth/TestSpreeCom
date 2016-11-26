package steps;

import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;
import util.DriverManager;

/**
 * Created by srikanth on 26/11/16.
 */
public class HomeSteps {
    HomePage homePageObj = PageFactory.initElements(DriverManager.driver, HomePage.class);

    public String[] getCategories(){
        return homePageObj.getAllCategories();
    }

    public String[] getBrands(){
        return homePageObj.getAllBrands();
    }

}
