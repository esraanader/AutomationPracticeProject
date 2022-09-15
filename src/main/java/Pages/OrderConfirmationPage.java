package Pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    protected WebDriver driver;
    public OrderConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='box']")
    WebElement ReferenceNo;

    @FindBy(xpath = "(//a[contains(text(), \"Back to orders\")])")
    WebElement BacktoOrdersbtn;

    public String ReferenceNumber_Get() throws InterruptedException {
        Thread.sleep(20000);
        String ReferenceData = ReferenceNo.getText();
        String ReferenceDataSub = StringUtils.substringAfter(ReferenceData, "order reference");
        String[] ReferenceDataList = ReferenceDataSub.split(" ", 3);
        String OrderNumber = ReferenceDataList[1];
        System.out.println("Order Number : " + OrderNumber);
        return OrderNumber;
    }

    public void setBacktoOrdersbtn() throws InterruptedException {
        Thread.sleep(20000);
        BacktoOrdersbtn.click();
    }
}
