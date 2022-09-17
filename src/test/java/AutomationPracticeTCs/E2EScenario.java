package AutomationPracticeTCs;

import Data.JsonReader;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class E2EScenario {

    public ChromeDriver driver;
    public String Email;
    public String Password;
    int Counter = 0;
    public String OrderNumber;
    private String chromePath;
    List<String> AccountData;

    @BeforeTest
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
    public void SignIn() {
        HomePage homePage = new HomePage(driver);
    LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        while (!homePage.HomePage_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        homePage.SignInbtn_Click();
    }

    @Test(priority = 2)
    public void CreateAccount() throws IOException, ParseException {
        JsonReader jsonReader = new JsonReader();
        AccountData = jsonReader.NewAccountData();
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SignInPage signinPage = new SignInPage(driver);
        while (!signinPage.SignIn_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        signinPage.Set_SignUpEmail(AccountData.get(0) + timestamp.getTime() + "@gmail.com");
        signinPage.CreateAccountbtn_Click();
        //Email = "Esraa" + timestamp.getTime() + "@gmail.com";
    }

    @Test(priority = 3)
    public void SetPersonalInfo() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CreateAccountPage createAccountpage = new CreateAccountPage(driver);
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        while (!createAccountpage.SignIn_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        createAccountpage.GenderID_Select();
        createAccountpage.FirstName_Set(AccountData.get(0));
        createAccountpage.LastName_Set(AccountData.get(1));
        createAccountpage.Password_Set(AccountData.get(2));
        createAccountpage.Days_Set();
        createAccountpage.Months_Set();
        createAccountpage.Years_Set();
        createAccountpage.FirstNameAddress_Set(AccountData.get(0));
        createAccountpage.LastNameAddress_Set(AccountData.get(1));
        createAccountpage.Address_Set(AccountData.get(3));
        createAccountpage.City_Set(AccountData.get(4));
        createAccountpage.State_Set();
        createAccountpage.PostCode_Set(AccountData.get(5));
        createAccountpage.Country_Set();
        createAccountpage.MobilePhone_Set(AccountData.get(6));
        Password = AccountData.get(2);
        createAccountpage.Registerbtn_Click();
    }

    @Test(priority = 4)
    public void SelectWomenMenu() throws InterruptedException {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        while (!myAccountPage.AccountPage_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        myAccountPage.Menu_Hover();
    }

    @Test(priority = 5)
    public void AddToCartPage() throws InterruptedException {
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        while (!addToCartPage.AddToCartPage_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        addToCartPage.Item_Hover();
        addToCartPage.CheckOut();
    }

    @Test(priority = 6)
    public void CheckOut() throws InterruptedException {
        CheckOutPage addToCartPage = new CheckOutPage(driver);
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        while (!addToCartPage.CheckOutPage_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }

        addToCartPage.CheckOut();
    }

    @Test(priority = 7)
    public void DeliveryAdress() throws InterruptedException {
        DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage(driver);
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        while (!deliveryAddressPage.DeliveryAddressPage_IsDisplayed()||limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }


        deliveryAddressPage.CheckOut();
    }

    @Test(priority = 8)
    public void Shipment() throws InterruptedException {
        ShipmentPage ShipmentCheck = new ShipmentPage(driver);
        DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage(driver);
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        while (!deliveryAddressPage.DeliveryAddressPage_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        ShipmentCheck.CheckOut();
    }

    @Test(priority = 9)
    public void BankPay() throws InterruptedException {
        PaymentPage Bankpay = new PaymentPage(driver);
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        while (!Bankpay.PaymentPage_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        Bankpay.Pay();
    }

    @Test(priority = 10)
    public void OrderSummary() throws InterruptedException {
        OrderSummaryPage orderSummary = new OrderSummaryPage(driver);
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        while (!orderSummary.OrderSummaryPage_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        orderSummary.Confirm();
    }

    @Test(priority = 11)
    public void ConfirmPayment() throws InterruptedException {
        OrderConfirmationPage confirmPayment = new OrderConfirmationPage(driver);
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        while (!confirmPayment.OrderConfirmation_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }

        OrderNumber = confirmPayment.ReferenceNumber_Get();
        confirmPayment.setBacktoOrdersbtn();
    }

    @Test(priority = 12)
    public void OrderHistory() throws InterruptedException {
        OrderHistoryPage orderhistory = new OrderHistoryPage(driver);
        LimitReachedPage limitreachedpaged=new LimitReachedPage(driver);
        orderhistory.ConfirmRefernceNo(OrderNumber);
        while (!orderhistory.OrderHistory_IsDisplayed()|| limitreachedpaged.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
    }
}



