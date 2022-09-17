package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class OrderSummaryPage {
    protected WebDriver driver;
    WebDriverWait wait;
    By Confirmbtn = By.xpath("//span[contains(text(), \"I confirm my order\")]");
    Boolean verifyTitle;

    public OrderSummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public Boolean OrderSummaryPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void Confirm() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), \"I confirm my order\")]")));
        driver.findElement(Confirmbtn).click();
    }
}
