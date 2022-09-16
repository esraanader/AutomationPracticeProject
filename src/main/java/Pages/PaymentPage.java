package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {

    protected WebDriver driver;
    WebDriverWait wait;
    By PayBankbtn=By.xpath("(//a[contains(text(), \"Pay by bank wire\")])");

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));

    }

    public void Pay() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), \"Pay by bank wire\")])")));

        driver.findElement(PayBankbtn) .click();

    }


}
