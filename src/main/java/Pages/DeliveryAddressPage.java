package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class DeliveryAddressPage {
    protected WebDriver driver;
    WebDriverWait wait;
    public DeliveryAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    By CheckOutbtn = By.xpath("(//span[contains(text(), \"Proceed to checkout\")])[2]");
    Boolean verifyTitle;

    public Boolean DeliveryAddressPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Order - My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void CheckOut() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(), \"Proceed to checkout\")])[2]")));
        driver.findElement(CheckOutbtn).click();
    }
}