package seleniumpraticecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicLoginScript extends BaseClass{

	public static void openBrowser() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
	}
	public static void highlightElement(WebElement element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.border='2px solid yellow'", element); 
	}
	public static void loginHrmApplication(String userName, String password) throws Exception {

		//userName
		WebElement userNameFeild=driver .findElement(By.xpath("//input[@name='username']"));
		highlightElement(userNameFeild);
		userNameFeild.sendKeys(userName);
		Thread.sleep(1000);

		//Password
		WebElement passwordFeild=driver .findElement(By.xpath("//input[@placeholder='Password']"));
		highlightElement(passwordFeild);
		passwordFeild.sendKeys(password);
		Thread.sleep(1000);

		//login Button
		WebElement loginButtion=driver .findElement(By.xpath("//button[@type='submit']"));
		highlightElement(loginButtion);
		loginButtion.click();
		Thread.sleep(1000);
	}
	public static void closeBroser()
	{
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		openBrowser();
		loginHrmApplication("Admin", "admin123");
		closeBroser();
	}

}
