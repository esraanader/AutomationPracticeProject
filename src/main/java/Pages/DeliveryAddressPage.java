package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryAddressPage {
    protected WebDriver driver;
    public DeliveryAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[contains(text(), \"Proceed to checkout\")])[2]")
    WebElement CheckOutbtn;

    public void CheckOut() throws InterruptedException {
        Thread.sleep(20000);
        CheckOutbtn.click();
    }


}
