package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class PaymentPage {

    protected WebDriver driver;
    WebDriverWait wait;
    By PayBankbtn = By.xpath("(//a[contains(text(), \"Pay by bank wire\")])");
    Boolean verifyTitle;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public Boolean PaymentPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Order - My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void Pay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), \"Pay by bank wire\")])")));
        driver.findElement(PayBankbtn).click();
    }
}
