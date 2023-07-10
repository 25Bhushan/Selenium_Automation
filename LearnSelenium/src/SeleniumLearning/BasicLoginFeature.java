package SeleniumLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLoginFeature {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Notes and Projects\\Jar and drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		
		//userName
		WebElement userNameFeild=driver.findElement(By.xpath("//input[@name='username']"));
		boolean presenceOfUserName=userNameFeild.isDisplayed();
		System.out.println("Username Element is Present ? : "+presenceOfUserName);
		userNameFeild.clear(); // it will clear the existing data
		userNameFeild.sendKeys("Admin");
		Thread.sleep(1000);
		
		//Password
		WebElement passwordFeild=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		boolean presenceOfPassword=passwordFeild.isDisplayed();
		System.out.println("Username Element is Present ? : "+presenceOfPassword);
		passwordFeild.clear(); // it will clear the existing data
		passwordFeild.sendKeys("admin123");
		Thread.sleep(1000);
		
		//login Button
		WebElement loginButtion=driver.findElement(By.xpath("//input[@placeholder='Password']"));
		boolean presenceOfLoginButtion=passwordFeild.isDisplayed();
		System.out.println("Username Element is Present ? : "+presenceOfLoginButtion);
		loginButtion.click();
		Thread.sleep(1000);
		
		driver.close();

	}

}
