package Pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderConfirmationPage {
    protected WebDriver driver;
    WebDriverWait wait;
    By ReferenceNo = By.xpath("//div[@class='box']");
    By BacktoOrdersbtn = By.xpath("//a[contains(text(), \"Back to orders\")]");

    public OrderConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
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
