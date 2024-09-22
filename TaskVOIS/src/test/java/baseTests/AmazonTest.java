package baseTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

public class AmazonTest {
    protected WebDriver driver;
    protected AmazonHomePage amazonHomePage;
    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));
        amazonHomePage = new AmazonHomePage(driver);
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testAddCarAccessoriesToCart()
    {
        driver.get("https://www.amazon.com/");
        amazonHomePage.searchForItem("car accessories");
        amazonHomePage.selectFirstItem();
        amazonHomePage.addItemToCart();
        amazonHomePage.goToCart();
        String itemName = amazonHomePage.getItemName();
        Assert.assertTrue(itemName.contains("Car"));
    }
    
    @Test
    public void testAddDealsToCart() {
        driver.get("https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb");
        amazonHomePage.goToTodayDeals();
        amazonHomePage.applyFilters();
        amazonHomePage.applyDiscountFilter();
        amazonHomePage.goToPage(4);
        amazonHomePage.selectFirstItem1();
        amazonHomePage.addItemToCart(); // Reusing the method from AmazonPage
        amazonHomePage.goToCart();
    }

}

