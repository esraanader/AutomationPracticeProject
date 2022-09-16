package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class MyAccountPage {
    protected WebDriver driver;
    WebDriverWait wait;
    Actions actions ;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @FindBy(xpath = "(//a[contains(text(), \"Women\")])[1]")
    WebElement CategoriesMenu;

    @FindBy(xpath = "(//a[contains(text(), \"Blouses\")])[1]")
    WebElement subMenu;

    Boolean verifyTitle ;

    public Boolean AccountPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("My account - My Store");
        assertTrue(verifyTitle);
        System.out.println(verifyTitle);
        return verifyTitle;
    }
    public void Menu_Hover() throws InterruptedException {


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), \"Women\")])[1]")));

        actions.moveToElement(CategoriesMenu).build().perform();
        actions.moveToElement(subMenu).build().perform();
        subMenu.click();
    }
}