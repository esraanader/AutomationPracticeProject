package AutomationPracticeTCs;

import Data.JsonReader;
import Pages.CreateAccountPage;
import Pages.HomePage;
import Pages.LimitReachedPage;
import Pages.SignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class SignInValidation {

    public ChromeDriver driver;
    public String SignUpEmail;
    public String Password;
    public String chromePath;
    List<String> AccountData;

    @BeforeTest
    //Initiate driver and open URL
    public void openURL() {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win")) {
            chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);
        } else {
            chromePath = System.getProperty("user.dir") + "/src/main/resources/chromedriverMAC";
            System.setProperty("webdriver.chrome.driver", chromePath);
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Dimension d = new Dimension(1024, 768);
        driver.manage().window().setSize(d);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(priority = 1)
    //Navigate to SignIn Page
    public void SignIn() {
        HomePage homePage = new HomePage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        while (!homePage.HomePage_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        homePage.SignInbtn_Click();
    }

    @Test(priority = 2)
    //Validate Sign in by using Registered Email before
    public void CreateAccount() throws IOException, ParseException {
        JsonReader jsonReader = new JsonReader();
        AccountData = jsonReader.NewAccountData();
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SignInPage signinPage = new SignInPage(driver);
        while (!signinPage.SignIn_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        SignUpEmail="esraanader@gmail.com";
        signinPage.Set_SignUpEmail("esraanader@gmail.com");
        signinPage.CreateAccountbtn_Click();
        SoftAssert softassert = new SoftAssert();
        softassert.assertTrue(signinPage.ErrorMessage_IsDisplayed());
    }



}
