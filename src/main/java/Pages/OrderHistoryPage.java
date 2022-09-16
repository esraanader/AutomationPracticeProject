package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    protected WebDriver driver;
    public OrderHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[1]")
    WebElement OrderReferenceNo;

    Boolean RefNoStatus;
    public void ConfirmRefernceNo(String RefNo) throws InterruptedException {
        Thread.sleep(20000);
        System.out.println(OrderReferenceNo.getText());
        Assert.assertEquals(RefNo, OrderReferenceNo.getText());
    }
}
