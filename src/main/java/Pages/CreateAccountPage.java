package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import java.net.DatagramSocket;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateAccountPage {
    protected WebDriver driver;
    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(id = "id_gender2")
    WebElement GenderID;

    @FindBy(id = "customer_firstname")
    WebElement FirstName;

    @FindBy(id = "customer_lastname")
    WebElement LastName;

    @FindBy(id = "passwd")
    WebElement Password;

    @FindBy(id = "days")
    WebElement Days;

    @FindBy(id = "months")
    WebElement Months;

    @FindBy(id = "years")
    WebElement Years;

    @FindBy(xpath = "//h3[contains(text(),'Your personal information')]")
    WebElement PersonalInfo_Status;

    @FindBy(id = "firstname")
    WebElement FirstName_Address;

    @FindBy(id = "lastname")
    WebElement LasttName_Address;

    @FindBy(id = "address1")
    WebElement Address;

    @FindBy(id = "city")
    WebElement City;

    @FindBy(id = "id_state")
    WebElement State;

    @FindBy(id = "postcode")
    WebElement PostCode;

    @FindBy(id = "id_country")
    WebElement Country;

    @FindBy(id = "phone_mobile")
    WebElement MobilePhone;

    @FindBy(id = "alias")
    WebElement Alias;

    @FindBy(id = "submitAccount")
    WebElement SubmitBtn;

    public void PersonalInfo_IsVisibble() {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Your personal information')]")));
    }

    public void GenderID_Select() throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2")));
        Thread.sleep(10000);
        GenderID.click();
    }

    public void FirstName_Set(String firstname) {
        FirstName.sendKeys(firstname);
    }

    public void LastName_Set(String lastname) {
        LastName.sendKeys(lastname);
    }

    public void Password_Set(String password) {
        Password.sendKeys(password);
    }

    public void Days_Set() {
        Select DaysSelect=new Select(Days);
DaysSelect.selectByIndex(1);
    }

    public void Months_Set() {
        Select MonthsSelect=new Select(Months);
        MonthsSelect.selectByIndex(5);
    }

    public void Years_Set() {
        Select YearsSelect=new Select(Years);
        YearsSelect.selectByIndex(1);
    }

    public void FirstNameAddress_Set(String firstname) {
        FirstName_Address.sendKeys(firstname);
    }

    public void LastNameAddress_Set(String lastname) {
        LasttName_Address.sendKeys(lastname);
    }

    public void Address_Set(String address) {
        Address.sendKeys(address);
    }

    public void City_Set(String city) {
        City.sendKeys(city);
    }

    public void State_Set() {
        Select StateSelect=new Select(State);
        StateSelect.selectByIndex(1);
    }

    public void PostCode_Set(String PCode) {
        PostCode.sendKeys(PCode);
    }

    public void Country_Set() {
        Select CountrySelect=new Select(Country);
        CountrySelect.selectByIndex(1);
    }

    public void MobilePhone_Set(String mobilePhone) {
        MobilePhone.sendKeys(mobilePhone);
    }

    public void Registerbtn_Click() {
        SubmitBtn .click();
    }
}
