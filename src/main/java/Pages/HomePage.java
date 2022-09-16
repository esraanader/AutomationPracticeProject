package Pages;

import Drivers.ChromeDriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class HomePage {
    protected WebDriver driver;
    By SignInbtn=By.xpath("//a[contains(text(), \"Sign in\")]");
    Boolean verifyTitle ;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public Boolean HomePage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase("My Store");
         assertTrue(verifyTitle);
        System.out.println(verifyTitle);
    return verifyTitle;
    }
    public void SignInbtn_Click() {
       driver.findElement(SignInbtn).click();
    }
}
