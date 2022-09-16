package AutomationPracticeTCs;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.sql.Timestamp;

public class E2EScenario {

    public ChromeDriver driver;
    public String Email;
    public String Password;
    int Counter = 0;
    public String OrderNumber;
    private String chromePath;


    @BeforeTest
    public void openURL() {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win")) {
            chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromePath);
        }
        else{
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

        while (!homePage.HomePage_IsDisplayed()){
            driver.navigate().refresh();
        }
        homePage.SignInbtn_Click();
    }

    @Test(priority = 2)
    public void CreateAccount() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SignInPage signinPage = new SignInPage(driver);
        while (!signinPage.SignIn_IsDisplayed()){
            driver.navigate().refresh();
        }
        signinPage.Set_SignUpEmail("Esraa" + timestamp.getTime() + "@gmail.com");
        signinPage.CreateAccountbtn_Click();
        Email = "Esraa" + timestamp.getTime() + "@gmail.com";
    }

    @Test(priority = 3)
    public void SetPersonalInfo() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CreateAccountPage createAccountpage = new CreateAccountPage(driver);
        while (!createAccountpage.SignIn_IsDisplayed()){
            driver.navigate().refresh();
        }
        createAccountpage.GenderID_Select();
        createAccountpage.FirstName_Set("Esraa");
        createAccountpage.LastName_Set("Nader");
        createAccountpage.Password_Set("EsraaN");
        createAccountpage.Days_Set();
        createAccountpage.Months_Set();
        createAccountpage.Years_Set();
        createAccountpage.FirstNameAddress_Set("Esraa");
        createAccountpage.LastNameAddress_Set("Nader");
        createAccountpage.Address_Set("Compund ElMontazah");
        createAccountpage.City_Set("Cairo");
        createAccountpage.State_Set();
        createAccountpage.PostCode_Set("12345");
        createAccountpage.Country_Set();
        createAccountpage.MobilePhone_Set("01011921556");
        Password = "EsraaN";
        createAccountpage.Registerbtn_Click();
    }

    @Test(priority = 4)
    public void SelectWomenMenu() throws InterruptedException {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        while (!myAccountPage.AccountPage_IsDisplayed()){
            driver.navigate().refresh();
        }
        myAccountPage.Menu_Hover();
    }

    @Test(priority = 5)
    public void AddToCartPage() throws InterruptedException {
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        while (!addToCartPage.AddToCartPage_IsDisplayed()){
            driver.navigate().refresh();
        }
        addToCartPage.Item_Hover();
        addToCartPage.CheckOut();
    }

    @Test(priority = 6)
    public void CheckOut() throws InterruptedException {
        CheckOutPage addToCartPage = new CheckOutPage(driver);
        while (!addToCartPage.CheckOutPage_IsDisplayed()){
            driver.navigate().refresh();
        }

        addToCartPage.CheckOut();
    }

    @Test(priority = 7)
    public void DeliveryAdress() throws InterruptedException {
        DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage(driver);
        while (!deliveryAddressPage.DeliveryAddressPage_IsDisplayed()){
            driver.navigate().refresh();
        }


        deliveryAddressPage.CheckOut();
    }

    @Test(priority = 8)
    public void Shipment() throws InterruptedException {
        ShipmentPage ShipmentCheck = new ShipmentPage(driver);
        DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage(driver);
        while (!deliveryAddressPage.DeliveryAddressPage_IsDisplayed()){
            driver.navigate().refresh();
        }
        ShipmentCheck.CheckOut();
    }

    @Test(priority = 9)
    public void BankPay() throws InterruptedException {
        PaymentPage Bankpay = new PaymentPage(driver);
        while (!Bankpay.PaymentPage_IsDisplayed()){
            driver.navigate().refresh();
        }
        Bankpay.Pay();
    }

    @Test(priority = 10)
    public void OrderSummary() throws InterruptedException {
        OrderSummaryPage orderSummary = new OrderSummaryPage(driver);
        while (!orderSummary.OrderSummaryPage_IsDisplayed()){
            driver.navigate().refresh();
        }
        orderSummary.Confirm();
    }

    @Test(priority = 11)
    public void ConfirmPayment() throws InterruptedException {
        OrderConfirmationPage confirmPayment = new OrderConfirmationPage(driver);
        while (!confirmPayment.OrderConfirmation_IsDisplayed()){
            driver.navigate().refresh();
        }

        OrderNumber = confirmPayment.ReferenceNumber_Get();
        confirmPayment.setBacktoOrdersbtn();
    }

    @Test(priority = 12)
    public void OrderHistory() throws InterruptedException{
        OrderHistoryPage orderhistory = new OrderHistoryPage(driver);
        orderhistory.ConfirmRefernceNo(OrderNumber);
        while (!orderhistory.OrderHistory_IsDisplayed()){
            driver.navigate().refresh();
        }
    }
}



