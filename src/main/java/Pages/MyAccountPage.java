package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    protected WebDriver driver;
    Actions actions ;
    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "(//a[contains(text(), \"Women\")])[1]")
    WebElement CategoriesMenu;

    @FindBy(xpath = "(//a[contains(text(), \"Blouses\")])[1]")
    WebElement subMenu;

    public void Menu_Hover() throws InterruptedException {

        Thread.sleep(5000);
        actions.moveToElement(CategoriesMenu).build().perform();
        actions.moveToElement(subMenu).build().perform();
        subMenu.click();
    }
}