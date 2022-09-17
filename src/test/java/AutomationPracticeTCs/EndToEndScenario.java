package AutomationPracticeTCs;

import Data.JsonReader;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class EndToEndScenario{
    public ChromeDriver driver;
    public String Password;
    public String OrderNumber;
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
    //Validate the Email then Navigate to Create account page
    public void CreateAccount() throws IOException, ParseException {
        JsonReader jsonReader = new JsonReader();
        AccountData = jsonReader.NewAccountData();
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SignInPage signinPage = new SignInPage(driver);
        while (!signinPage.SignIn_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        signinPage.Set_SignUpEmail(AccountData.get(0) + timestamp.getTime() + "@gmail.com");
        signinPage.CreateAccountbtn_Click();
    }

    @Test(priority = 3)
    //Fill the SignUp form And create new account
    public void SetPersonalInfo() throws InterruptedException {
        CreateAccountPage createAccountpage = new CreateAccountPage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        while (!createAccountpage.SignIn_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
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
    //Hover on the Women Category then choose blouse
    public void SelectWomenMenu() throws InterruptedException {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        while (!myAccountPage.AccountPage_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        myAccountPage.Menu_Hover();
    }

    @Test(priority = 5)
    //Choose the displayed result then add to cart
    public void AddToCartPage() throws InterruptedException {
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        while (!addToCartPage.AddToCartPage_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        addToCartPage.Item_Hover();
        addToCartPage.CheckOut();
    }

    @Test(priority = 6)
    //Navigate to Checkout page
    public void CheckOut() throws InterruptedException {
        CheckOutPage addToCartPage = new CheckOutPage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        while (!addToCartPage.CheckOutPage_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        addToCartPage.CheckOut();
    }

    @Test(priority = 7)
    //Complete the address info
    public void DeliveryAddress() throws InterruptedException {
        DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        while (!deliveryAddressPage.DeliveryAddressPage_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        deliveryAddressPage.CheckOut();
    }

    @Test(priority = 8)
    //Complete Shipment Info
    public void Shipment() throws InterruptedException {
        ShipmentPage ShipmentCheck = new ShipmentPage(driver);
        DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        while (!deliveryAddressPage.DeliveryAddressPage_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        ShipmentCheck.CheckOut();
    }

    @Test(priority = 9)
    //Choose Payment type "Bank Wire"
    public void BankPay() {
        PaymentPage BankPay = new PaymentPage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        while (!BankPay.PaymentPage_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        BankPay.Pay();
    }

    @Test(priority = 10)
    //Check the order summary page then navigate to confirmation page
    public void OrderSummary() throws InterruptedException {
        OrderSummaryPage orderSummary = new OrderSummaryPage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        while (!orderSummary.OrderSummaryPage_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        orderSummary.Confirm();
    }

    @Test(priority = 11)
    //Confirm payment and finalize order checkout
    public void ConfirmPayment() throws InterruptedException {
        OrderConfirmationPage confirmPayment = new OrderConfirmationPage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        while (!confirmPayment.OrderConfirmation_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
        OrderNumber = confirmPayment.ReferenceNumber_Get();
        confirmPayment.setBacktoOrdersbtn();
    }

    @Test(priority = 12)
    //Validate that the order has been places successfully and the order number displayed on the order history
    public void OrderHistory() {
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        LimitReachedPage limitReachedPage = new LimitReachedPage(driver);
        orderHistoryPage.ConfirmRefernceNo(OrderNumber);
        while (!orderHistoryPage.OrderHistory_IsDisplayed() || limitReachedPage.LimitReachedPage_IsDisplayed()) {
            driver.navigate().refresh();
        }
    }

    @AfterTest
    //Close the driver
    public void closeBrowser() {
        driver.quit();
    }
}