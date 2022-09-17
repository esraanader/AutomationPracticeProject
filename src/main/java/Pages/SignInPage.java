package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SignInPage {
    protected WebDriver driver;
    By SignUpEmail = By.id("email_create");
    By CreateAccountbtn = By.id("SubmitCreate");
    Boolean VerifyErrorMsg;
    Boolean  verifyTitle;
    By ErrorMsg=By.xpath("//li[contains(text(),'An account using this email address has already be')]");
    WebDriverWait wait;


    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(70));
    }

    public Boolean ErrorMessage_IsDisplayed() {
        //verifyTitle = driver.getTitle().equalsIgnoreCase("Login - My Store");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'An account using this email address has already be')]")));

        VerifyErrorMsg=driver.findElement(ErrorMsg).isDisplayed();
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(VerifyErrorMsg);
        System.out.println("Is Error Message displayed : " + VerifyErrorMsg);
        return VerifyErrorMsg;
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