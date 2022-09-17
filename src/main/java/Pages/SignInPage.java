package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class SignInPage {

    protected WebDriver driver;
    By SignUpEmail = By.id("email_create");
    By CreateAccountbtn = By.id("SubmitCreate");
    Boolean verifyTitle;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean SignIn_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("Login - My Store");
        SoftAssert softassert = new SoftAssert();
        softassert.assertFalse(verifyTitle);
        System.out.println(verifyTitle);
        return verifyTitle;
    }

    public void Set_SignUpEmail(String email) {
        driver.findElement(SignUpEmail).sendKeys(email);
    }

    public void CreateAccountbtn_Click() {

        driver.findElement(CreateAccountbtn).click();
    }
}
