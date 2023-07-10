package lambdatest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpPage {
	 WebDriver driver;

	@Parameters("browserName")
	@BeforeClass
	public void setup(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
//			ChromeOptions option = new ChromeOptions();
//			option.setHeadless(true);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions option = new FirefoxOptions();
//			option.setHeadless(true);
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
//			EdgeOptions option = new EdgeOptions();
//			option.setHeadless(true);
			driver = new EdgeDriver();
		}
	}

	@BeforeMethod
	public void openBrowser() {
		driver.manage().deleteAllCookies();
		driver.get("https://www.lambdatest.com/webpage");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
	}

	@Test
	public void fullNameTextfeild() {
		//refreshPage();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test lambdatet");
	}

	@Test
	public void businessEmailTextFeild() {
		refreshPage();
		driver.findElement(By.id("email")).sendKeys("Test@gmail.com");
	}

	@Test
	public void desiredPasswordTextfeild() {
		refreshPage();
		driver.findElement(By.id("userpassword")).sendKeys("Test@123");
	}

	@Test
	public void phoneTextfeild() {
		refreshPage();
		driver.findElement(By.id("phone")).sendKeys("9876541230");
	}

	@Test
	public void checkTermAndServices() {
		refreshPage();
		driver.findElement(By.xpath("//div[@class='clearfix registeraArea signUpWithEmail']/form/div[5]/label/samp"))
				.click();
	}

	@Test
	public void ragistrationPage() throws Exception {

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Test lambdatet"); // input Full Name
		driver.findElement(By.id("email")).sendKeys("Test@gmail.com"); // input Business Mail Id
		driver.findElement(By.id("userpassword")).sendKeys("Test@123"); // input desired Password
		driver.findElement(By.id("phone")).sendKeys("9876541230"); // input Phone No.
		driver.findElement(By.xpath("//div[@class='clearfix registeraArea signUpWithEmail']/form/div[5]/label/samp"))
				.click(); // Click Check Box policy and services
	}

	@AfterMethod
	public void RelaunchBrowser() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
}