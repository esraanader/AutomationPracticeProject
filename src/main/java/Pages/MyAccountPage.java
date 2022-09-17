package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class MyAccountPage {
    protected WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    Boolean verifyTitle;
    By CategoriesMenu=By.xpath("(//a[contains(text(), \"Women\")])[1]");
    By subMenu=By.xpath("(//a[contains(text(), \"Blouses\")])[1]");

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }


    public Boolean AccountPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("My account - My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void Menu_Hover() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(), \"Women\")])[1]")));
        actions.moveToElement(driver.findElement(CategoriesMenu)).build().perform();
        actions.moveToElement(driver.findElement(subMenu)).build().perform();
        driver.findElement(subMenu).click();
    }
}