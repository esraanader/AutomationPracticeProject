package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryAddressPage {
    protected WebDriver driver;
    public DeliveryAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    By CheckOutbtn=By.xpath("(//span[contains(text(), \"Proceed to checkout\")])[2]");


    public void CheckOut() throws InterruptedException {
        Thread.sleep(20000);
       driver.findElement(CheckOutbtn) .click();
    }


}
