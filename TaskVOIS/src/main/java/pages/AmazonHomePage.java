package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
    WebDriver driver;
    public AmazonHomePage(WebDriver driver)
    {
        this.driver = driver;
    }
    //       Task #1
    private final By searchBox =By.id("twotabsearchtextbox");
    public void searchForItem(String searchTerm)
    {
        driver.findElement(searchBox).sendKeys(searchTerm);
        driver.findElement(searchBox).submit();
    }

    private final By firstItem = By.className("(//div[@class= 'a-section aok-relative s-image-square-aspect'])[3]");
    public void selectFirstItem()
    {
        driver.findElement(firstItem).click();
    }
    private final By addToCartButton = By.id("a-autoid-4-announce");
    public void addItemToCart()
    {
        driver.findElement(addToCartButton).click();
    }
    private final By cartIcon = By.id("nav-cart");
    public void goToCart()
    {
        driver.findElement(cartIcon).click();
    }
    private final By cartItemName = By.xpath("(//div[@class='sc-list-item-content'])[1]");
    public String getItemName()
    {
        return driver.findElement(cartItemName).getText();
    }
    //        task #2
    private final By todayDeals = By.linkText("Today's Deals");
    public void goToTodayDeals()
    {
        driver.findElement(todayDeals).click();
    }
    private final By headPhones = By.xpath("(//div[@data-a-input-name='departments'])[15]");
    public void goToHeadPhones()
    {
        driver.findElement(headPhones).click();
    }
    By headphonesFilter = By.xpath("//span[text()='Headphones']");
    public void applyFilters() {
        driver.findElement(headphonesFilter).click();
        driver.findElement(groceryFilter).click();
    }
    By groceryFilter = By.xpath("//span[text()='Grocery']");
    public void applyDiscountFilter() {
        driver.findElement(tenPercentOffFilter).click();
    }
    By tenPercentOffFilter = By.xpath("//span[text()='10% off or more']");
    public void goToPage(int pageNumber) {
        driver.get("https://www.amazon.com/gp/goldbox?page=" + pageNumber);
    }
    private final By firstItem1 = By.cssSelector(".s-main-slot .s-result-item:first-child");
    public void selectFirstItem1() {
        driver.findElement(firstItem).click();
    }

}
