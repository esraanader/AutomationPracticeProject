package Pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class OrderConfirmationPage {
    protected WebDriver driver;
    WebDriverWait wait;
    By ReferenceNo = By.xpath("//div[@class='box']");
    By BacktoOrdersbtn = By.xpath("//a[contains(text(), \"Back to orders\")]");
    Boolean verifyTitle;

    public OrderConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public Boolean OrderConfirmation_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Order confirmation - My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public String ReferenceNumber_Get() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), \"Back to orders\")]")));
        String ReferenceData = driver.findElement(ReferenceNo).getText();
        String ReferenceDataSub = StringUtils.substringAfter(ReferenceData, "order reference");
        String[] ReferenceDataList = ReferenceDataSub.split(" ", 3);
        String OrderNumber = ReferenceDataList[1];
        System.out.println("Order Number : " + OrderNumber);
        return OrderNumber;
    }

    public void setBacktoOrdersbtn() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), \"Back to orders\")]")));
        driver.findElement(BacktoOrdersbtn).click();
    }
}
