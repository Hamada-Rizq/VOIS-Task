package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KSRTCPage {
    WebDriver driver;

    // Locators
    By fromCity = By.xpath("//select[@id='fromPlaceName']//option[text()='CHIKKAMAGALURU']");
    By toCity = By.xpath("//select[@id='toPlaceName']//option[text()='BENGALURU']");
    By dateField = By.id("txtJourneyDate");
    By searchButton = By.id("searchBtn");
    By seatSelection = By.cssSelector("input.seat-checkbox"); // Adjust based on actual seat locator
    By boardingPoint = By.id("boardingPoint");
    By droppingPoint = By.id("droppingPoint");
    By customerName = By.id("customerName");
    By contactNumber = By.id("contactNumber");
    By proceedToPaymentButton = By.id("proceedPaymentBtn");

    public KSRTCPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openKSRTCPage() {
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
    }

    public void selectRoute() {
        driver.findElement(fromCity).click();
        driver.findElement(toCity).click();
    }

    public void chooseArrivalDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    public void searchForBus() {
        driver.findElement(searchButton).click();
    }

    public void selectSeat() {
        driver.findElement(seatSelection).click();
    }

    public void fillCustomerDetails(String name, String phone) {
        driver.findElement(customerName).sendKeys(name);
        driver.findElement(contactNumber).sendKeys(phone);
    }

    public void proceedToPayment() {
        driver.findElement(proceedToPaymentButton).click();
    }
}
