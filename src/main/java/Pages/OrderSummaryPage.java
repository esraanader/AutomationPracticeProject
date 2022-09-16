package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
    protected WebDriver driver;
    By Confirmbtn= By.xpath("//span[contains(text(), \"I confirm my order\")]");

    public OrderSummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void Confirm() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElement(Confirmbtn).click();
    }
}
