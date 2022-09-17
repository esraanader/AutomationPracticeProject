package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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
        System.out.println("Is Page displayed : " + verifyTitle);
        return verifyTitle;
    }

    public void Set_SignUpEmail(String email) {
        driver.findElement(SignUpEmail).sendKeys(email);
    }

    public void CreateAccountbtn_Click() {
        driver.findElement(CreateAccountbtn).click();
    }
}