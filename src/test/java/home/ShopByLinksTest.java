package home;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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

    private static String[][] categoryPageTitles(){
        return new String[][]{
                {"Bags", "Categories - Bags - Spree Demo Site"},
                {"Mugs", "Categories - Mugs - Spree Demo Site"},
                {"Clothing", "Categories - Clothing - Spree Demo Site"}
        };
    }

    private static String[][] brandPageTitles(){
        return new String[][]{
                {"Ruby", "Brand - Ruby - Spree Demo Site"},
                {"Apache", "Brand - Apache - Spree Demo Site"},
                {"Spree", "Brand - Spree - Spree Demo Site"},
                {"Rails", "Brand - Rails - Spree Demo Site"}
        };
    }

    @Test
    public void verifyShopByCategoryLinks(){
        String [][] linksPageTitles = categoryPageTitles();
        String [][] categories = homeSteps.getCategoryLinksAndPageTitles();
        Assert.assertTrue(Arrays.equals(categories,linksPageTitles));
    }

    @Test
    public void verifyShopByBrandLinks(){
        String[][] brandPageTitles = brandPageTitles();
        String [][] brands = homeSteps.getBrandLinksAndPageTitles();
        Assert.assertTrue(Arrays.equals(brands,brandPageTitles));
    }
}
