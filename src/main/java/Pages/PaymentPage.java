package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    protected WebDriver driver;

    public PaymentPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "(//a[contains(text(), \"Pay by bank wire\")])")
    WebElement PayBankbtn;

    public void Pay() throws InterruptedException {
        Thread.sleep(20000);
        PayBankbtn.click();

    }


}
