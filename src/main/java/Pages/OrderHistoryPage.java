package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    protected WebDriver driver;
    By OrderReferenceNo= By.xpath("//td[1]");

    public OrderHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    Boolean RefNoStatus;
    public void ConfirmRefernceNo(String RefNo) throws InterruptedException {
        Thread.sleep(20000);
        System.out.println(driver.findElement(OrderReferenceNo).getText());
        Assert.assertEquals(RefNo, driver.findElement(OrderReferenceNo).getText());
    }
}
