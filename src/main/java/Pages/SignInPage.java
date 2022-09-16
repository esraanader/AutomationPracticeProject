package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class SignInPage {

    protected WebDriver driver;
    By SignUpEmail = By.id("email_create");
    By CreateAccountbtn = By.id("SubmitCreate");

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void Set_SignUpEmail(String email) {
        driver.findElement(SignUpEmail).sendKeys(email);
    }

    public void CreateAccountbtn_Click() {

        driver.findElement(CreateAccountbtn).click();
    }
}
