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
    By GenderID = By.xpath("//input[@id='id_gender2']");
    By FirstName = By.id("customer_firstname");
    By LastName = By.id("customer_lastname");
    By Password = By.id("passwd");
    By Days = By.id("days");
    By Months = By.id("months");
    By Years = By.id("years");
    By PersonalInfo_Status = By.xpath("//h3[contains(text(),'Your personal information')]");
    By FirstName_Address = By.id("firstname");
    By LasttName_Address = By.id("lastname");
    By Address = By.id("address1");
    By City = By.id("city");
    By State = By.id("id_state");
    By PostCode = By.id("postcode");
    By Country = By.id("id_country");
    By MobilePhone = By.id("phone_mobile");
    By SubmitBtn = By.id("submitAccount");

    public CreateAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void PersonalInfo_IsVisibble() {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Your personal information')]")));
    }

    public void GenderID_Select() throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2")));
        Thread.sleep(15000);
        driver.findElement(GenderID).click();
    }

    public void FirstName_Set(String firstname) {
        driver.findElement(FirstName).sendKeys(firstname);
    }

    public void LastName_Set(String lastname) {
        driver.findElement(LastName).sendKeys(lastname);
    }

    public void Password_Set(String password) {
        driver.findElement(Password).sendKeys(password);
    }

    public void Days_Set() {

        Select DaysSelect = new Select(driver.findElement(Days));
        DaysSelect.selectByIndex(1);
    }

    public void Months_Set() {
        Select MonthsSelect = new Select(driver.findElement(Months));
        MonthsSelect.selectByIndex(5);
    }

    public void Years_Set() {
        Select YearsSelect = new Select(driver.findElement(Years));
        YearsSelect.selectByIndex(1);
    }

    public void FirstNameAddress_Set(String firstname) {

        driver.findElement(FirstName_Address).sendKeys(firstname);

    }

    public void LastNameAddress_Set(String lastname) {
        driver.findElement(LasttName_Address).sendKeys(lastname);

    }

    public void Address_Set(String address) {
        driver.findElement(Address).sendKeys(address);

    }

    public void City_Set(String city) {
        driver.findElement(City).sendKeys(city);

    }

    public void State_Set() {
        Select StateSelect = new Select(driver.findElement(State));
        StateSelect.selectByIndex(1);
    }

    public void PostCode_Set(String PCode) {
        driver.findElement(PostCode).sendKeys(PCode);

    }

    public void Country_Set() {
        Select CountrySelect = new Select(driver.findElement(Country));
        CountrySelect.selectByIndex(1);
    }

    public void MobilePhone_Set(String mobilePhone) {

        driver.findElement(MobilePhone).sendKeys(mobilePhone);

    }

    public void Registerbtn_Click() {
        driver.findElement(SubmitBtn).click();

    }
}
