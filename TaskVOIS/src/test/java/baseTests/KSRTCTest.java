package baseTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.KSRTCPage;

public class KSRTCTest {
    WebDriver driver;
    KSRTCPage ksrtcPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 768));
        ksrtcPage = new KSRTCPage(driver);
    }

    @Test
    public void testBusBooking() {
        ksrtcPage.openKSRTCPage();
        ksrtcPage.selectRoute();
        ksrtcPage.chooseArrivalDate("25-09-2024");
        ksrtcPage.searchForBus();
        ksrtcPage.selectSeat();
        ksrtcPage.fillCustomerDetails("John Doe", "6789125987");
        ksrtcPage.proceedToPayment();

        // Verify that the payment page is loaded
        Assert.assertTrue(driver.getPageSource().contains("Payment"), "Payment page not loaded.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
