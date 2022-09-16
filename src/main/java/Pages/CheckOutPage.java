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

import static org.testng.Assert.assertTrue;

public class CheckOutPage {
    protected WebDriver driver;
    WebDriverWait wait;
    By CheckOutbtn=By.xpath("(//span[contains(text(), \"Proceed to checkout\")])[2]");

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(60));
    }
    Boolean verifyTitle ;

    public Boolean CheckOutPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Order - My Store");
        assertTrue(verifyTitle);
        System.out.println(verifyTitle);
        return verifyTitle;
    }

    public void CheckOut() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(), \"Proceed to checkout\")])[2]")));

        driver.findElement(CheckOutbtn).click();
    }
}
