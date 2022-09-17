package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class OrderHistoryPage {
    protected WebDriver driver;
    WebDriverWait wait;
    By OrderReferenceNo = By.xpath("//td[1]");
    Boolean verifyTitle;

    public OrderHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public Boolean OrderHistory_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Order history - My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void ConfirmRefernceNo(String RefNo) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]")));
        System.out.println("The Order Number displayed on the History Page is : " +
                driver.findElement(OrderReferenceNo).getText());
        Assert.assertEquals(RefNo, driver.findElement(OrderReferenceNo).getText());
    }
}
