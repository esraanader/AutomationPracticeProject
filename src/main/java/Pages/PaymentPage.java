package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    protected WebDriver driver;
    By PayBankbtn=By.xpath("(//a[contains(text(), \"Pay by bank wire\")])");

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void Pay() throws InterruptedException {
        Thread.sleep(20000);
       driver.findElement(PayBankbtn) .click();

    }


}
