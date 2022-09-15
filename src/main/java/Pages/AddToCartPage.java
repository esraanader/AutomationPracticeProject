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

import java.net.DatagramSocket;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCartPage {
    Actions actions;
    public AddToCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//span[contains(text(), \"Add to cart\")]")
    WebElement CategoriesMenu;

    @FindBy(xpath = "//span[contains(text(), \"Proceed to checkout\")]")
    WebElement CheckOutbtn;

    public void Item_Hover() throws InterruptedException {
        Thread.sleep(5000);
        actions.moveToElement(CategoriesMenu).build().perform();
        CategoriesMenu.click();
    }

    public void CheckOut() throws InterruptedException {
        Thread.sleep(20000);
        CheckOutbtn.click();
    }
}
