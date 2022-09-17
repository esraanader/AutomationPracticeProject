package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import java.net.DatagramSocket;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class AddToCartPage {
    Actions actions;
    WebDriverWait wait;
    protected WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @FindBy(xpath = "//span[contains(text(), \"Add to cart\")]")
    WebElement CategoriesMenu;

    @FindBy(xpath = "//span[contains(text(), \"Proceed to checkout\")]")
    WebElement CheckOutbtn;

    Boolean verifyTitle;

    public Boolean AddToCartPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Blouses - My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println(verifyTitle);
        return verifyTitle;
    }

    public void Item_Hover() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), \"Add to cart\")]")));

        actions.moveToElement(CategoriesMenu).build().perform();
        CategoriesMenu.click();
    }

    public void CheckOut() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), \"Proceed to checkout\")]")));

        CheckOutbtn.click();
    }
}
