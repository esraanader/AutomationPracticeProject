package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CheckOutPage {
    protected WebDriver driver;
    By CheckOutbtn=By.xpath("(//span[contains(text(), \"Proceed to checkout\")])[2]");

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void CheckOut() throws InterruptedException {
        Thread.sleep(20000);
       driver.findElement(CheckOutbtn).click();
    }
}
