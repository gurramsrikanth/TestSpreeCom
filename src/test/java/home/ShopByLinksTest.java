package home;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steps.HomeSteps;

import java.util.Arrays;

/**
 * Created by srikanth on 26/11/16.
 */
public class ShopByLinksTest {
    HomeSteps homeSteps;
    @BeforeTest
    public void initHomeSteps(){
        homeSteps = new HomeSteps();
    }

    @Test
    public void verifyShopByCategoriesLinks(){
        String [] expectedCategories = {"Bags","Mugs","Clothing"};
        String [] categories = homeSteps.getCategories();
        Assert.assertTrue(Arrays.equals(categories,expectedCategories));
    }

    @Test
    public void verifyShopByBrandLinks(){
        String [] expectedBrands = {"Ruby","Apache","Spree","Rails"};
        String [] brands = homeSteps.getBrands();
        Assert.assertTrue(Arrays.equals(brands,expectedBrands));
    }
}
