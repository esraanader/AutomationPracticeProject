package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class HomePage {
    protected WebDriver driver;
    By SignInbtn = By.xpath("//a[contains(text(), \"Sign in\")]");
    Boolean verifyTitle;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean HomePage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println("Is Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void SignInbtn_Click() {
        driver.findElement(SignInbtn).click();
    }
}
