package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
    protected WebDriver driver;
    public OrderSummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[contains(text(), \"I confirm my order\")])")
    WebElement Confirmbtn;

    public void Confirm() throws InterruptedException {
        Thread.sleep(20000);
        Confirmbtn.click();
    }
}
