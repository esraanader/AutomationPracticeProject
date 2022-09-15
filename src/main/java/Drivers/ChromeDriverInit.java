package Drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;

  public class ChromeDriverInit {
	public static void main(String[] args) {
		String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		ChromeDriver driver = new ChromeDriver();
		Dimension d = new Dimension(1024,768);
		driver.manage().window().setSize(d);
		driver.get("http://automationpractice.com/index.php");
			//driver.quit();



	}



  }