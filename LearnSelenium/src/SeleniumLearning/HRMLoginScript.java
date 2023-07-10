package SeleniumLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginScript {
		
		static WebDriver driver =null;
		
		public static void openBrowser() throws Exception {
	//1. Way to Browser property
//			System.setProperty("webdriver.chrome.driver", "F:\\Selenium Notes and Projects\\Jar and drivers\\chromedriver_win32\\chromedriver.exe");
			
	//2. Way to Browser property
//			System.setProperty("webdriver.chrome.driver", ".\\MyProjectBrowser\\chromedriver.exe");
			
	//3. Way to Browser property
//			String currentWorkingDir =System.getProperty("user.dir");
//			System.setProperty("webdriver.chrome.driver", currentWorkingDir+".\\MyProjectBrowser\\chromedriver.exe");
			
	//4. Way to Browser property
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
			driver.manage().window().maximize();  //maximize the windows
			
	//Complete code of maximize windows
/*			WebDriver.Options option=driver.manage();
			WebDriver.Window win=option.window();
			win.maximize(); */
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Thread.sleep(1000);
		}
		
	//This code is hard code way	
/*		
		public static void loginHrmApplication() throws Exception {
			//userName
			WebElement userNameFeild=driver .findElement(By.xpath("//input[@name='username']"));
			userNameFeild.sendKeys("Admin");
			Thread.sleep(1000);
			
			//Password
			WebElement passwordFeild=driver .findElement(By.xpath("//input[@placeholder='Password']"));
			passwordFeild.sendKeys("admin123");
			Thread.sleep(1000);
			
			//login Button
			WebElement loginButtion=driver .findElement(By.xpath("//button[@type='submit']"));
			loginButtion.click();
			Thread.sleep(1000);
		}
*/
		public static void loginHrmApplication(String userName, String password) throws Exception {
			
			//userName
			WebElement userNameFeild=driver .findElement(By.xpath("//input[@name='username']"));
			userNameFeild.sendKeys(userName);
			Thread.sleep(1000);
			
			//Password
			WebElement passwordFeild=driver .findElement(By.xpath("//input[@placeholder='Password']"));
			passwordFeild.sendKeys(password);
			Thread.sleep(1000);
			
			//login Button
			WebElement loginButtion=driver .findElement(By.xpath("//button[@type='submit']"));
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
