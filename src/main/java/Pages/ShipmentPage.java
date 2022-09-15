package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShipmentPage {

    protected WebDriver driver;
    public ShipmentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="cgv")
    WebElement Checkbox;

    @FindBy(xpath = "(//span[contains(text(), \"Proceed to checkout\")])[2]")
    WebElement CheckOutbtn;

    public void CheckOut() throws InterruptedException {
        Thread.sleep(20000);
        Checkbox.click();
        CheckOutbtn.click();
    }



}
