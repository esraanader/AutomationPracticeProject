package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderHistoryPage {
    protected WebDriver driver;
    WebDriverWait wait;
    By OrderReferenceNo= By.xpath("//td[1]");

    public OrderHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    }


    Boolean RefNoStatus;
    public void ConfirmRefernceNo(String RefNo) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[1]")));


        System.out.println(driver.findElement(OrderReferenceNo).getText());
        Assert.assertEquals(RefNo, driver.findElement(OrderReferenceNo).getText());
    }
}
