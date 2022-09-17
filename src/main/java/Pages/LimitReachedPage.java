package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LimitReachedPage {
    protected WebDriver driver;
    Boolean verifyTitle;
    public LimitReachedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean LimitReachedPage_IsDisplayed() {
        verifyTitle = driver.getTitle().equalsIgnoreCase(" 508 Resource Limit Is Reached");
        SoftAssert softassert = new SoftAssert();
        System.out.println("Is Page displayed : " + verifyTitle);
        System.out.println("Reach Limit Error Page displayed Status is : " + verifyTitle);
        softassert.assertFalse(verifyTitle);
        return verifyTitle;
    }
}
