package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class OrderHistoryPage {
    protected WebDriver driver;
    WebDriverWait wait;
    By OrderReferenceNo = By.xpath("//td[1]");

    public OrderHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    Boolean verifyTitle;

    public Boolean OrderHistory_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Order history - My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println(verifyTitle);
        return verifyTitle;
    }

    Boolean RefNoStatus;

    public void ConfirmRefernceNo(String RefNo) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]")));


        System.out.println(driver.findElement(OrderReferenceNo).getText());
        Assert.assertEquals(RefNo, driver.findElement(OrderReferenceNo).getText());
    }
}
