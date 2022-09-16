package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShipmentPage {

    protected WebDriver driver;
    WebDriverWait wait;
    By Checkbox= By.id("cgv");
    By CheckOutbtn=By.xpath("(//span[contains(text(), \"Proceed to checkout\")])[2]");

    public ShipmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void CheckOut() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(), \"Proceed to checkout\")])[2]")));
       driver.findElement(Checkbox).click();
        driver.findElement(CheckOutbtn).click();
    }



}
