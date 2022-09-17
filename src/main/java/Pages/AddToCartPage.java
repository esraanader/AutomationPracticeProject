package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddToCartPage {

    Actions actions;
    WebDriverWait wait;
    protected WebDriver driver;
    By CategoriesMenu = By.xpath("//span[contains(text(), \"Add to cart\")]");
    By CheckOutbtn = By.xpath("//span[contains(text(), \"Proceed to checkout\")]");
    Boolean verifyTitle;

    public AddToCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public Boolean AddToCartPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Blouses - My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void Item_Hover() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), \"Add to cart\")]")));
        actions.moveToElement(driver.findElement(CategoriesMenu)).build().perform();
        driver.findElement(CategoriesMenu).click();
    }

    public void CheckOut() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), \"Proceed to checkout\")]")));
        driver.findElement(CheckOutbtn).click();
    }
}
