package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class SignInPage {
    protected WebDriver driver;
    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    WebElement SignUpEmail;

    @FindBy(id = "SubmitCreate")
    WebElement CreateAccountbtn;

    public void Set_SignUpEmail(String email) {
        SignUpEmail.sendKeys(email);
    }

    public void CreateAccountbtn_Click(){
       // JavascriptExecutor j = (JavascriptExecutor) driver;
        //j.executeScript("window.scrollBy(0,500)");
        CreateAccountbtn.click();
    }
}
