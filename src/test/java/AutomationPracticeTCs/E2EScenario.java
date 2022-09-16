package AutomationPracticeTCs;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.sql.Timestamp;

public class E2EScenario {

    ChromeDriver driver;
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
        homePage.SignInbtn_Click();
    }

    @Test(priority = 2)
    public void CreateAccount() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SignInPage signinPage = new SignInPage(driver);
        signinPage.Set_SignUpEmail("Esraa" + timestamp.getTime() + "@gmail.com");
        signinPage.CreateAccountbtn_Click();
        Email = "Esraa" + timestamp.getTime() + "@gmail.com";
    }

    @Test(priority = 3)
    public void SetPersonalInfo() throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CreateAccountPage createAccountpage = new CreateAccountPage(driver);
        //createAccountpage.PersonalInfo_IsVisibble();
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
        myAccountPage.Menu_Hover();
    }

    @Test(priority = 5)
    public void AddToCartPage() throws InterruptedException {
        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.Item_Hover();
        addToCartPage.CheckOut();
    }

    @Test(priority = 6)
    public void CheckOut() throws InterruptedException {
        CheckOutPage addToCartPage = new CheckOutPage(driver);
        addToCartPage.CheckOut();
    }

    @Test(priority = 7)
    public void DeliveryAdress() throws InterruptedException {
        DeliveryAddressPage deliveryAddressPage = new DeliveryAddressPage(driver);
        deliveryAddressPage.CheckOut();
    }

    @Test(priority = 8)
    public void Shipment() throws InterruptedException {
        ShipmentPage ShipmentCheck = new ShipmentPage(driver);
        ShipmentCheck.CheckOut();
    }

    @Test(priority = 9)
    public void BankPay() throws InterruptedException {
        PaymentPage Bankpay = new PaymentPage(driver);
        Bankpay.Pay();
    }

    @Test(priority = 10)
    public void OrderSummary() throws InterruptedException {
        OrderSummaryPage orderSummary = new OrderSummaryPage(driver);
        orderSummary.Confirm();
    }

    @Test(priority = 11)
    public void ConfirmPayment() throws InterruptedException {
        OrderConfirmationPage confirmPayment = new OrderConfirmationPage(driver);
        OrderNumber = confirmPayment.ReferenceNumber_Get();
        confirmPayment.setBacktoOrdersbtn();
    }
}



