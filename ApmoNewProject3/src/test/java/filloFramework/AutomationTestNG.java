package filloFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTestNG {
	
		
		private String url;
		private String usn;
		private String passwd;
		WebDriver driver;
		
		@BeforeTest
		public void beforeTest() throws Exception {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
			Thread.sleep(3000);
			LoginData();
			System.out.println(url);
			driver.get(url);
			System.out.println("open the URL");
		}
		
		@Test(priority=2)
		public void loginTest() throws Exception {
			System.out.println("Enter the username and password Login");
			Thread.sleep(4000);
			WebElement usernm =driver.findElement(By.xpath("//input[@placeholder='Username']"));
			usernm.clear();
			usernm.sendKeys(usn);
			Thread.sleep(4000);
			WebElement pwd = driver.findElement(By.xpath("//input[@placeholder='Password']"));
			pwd.clear();
			pwd.sendKeys(passwd);
			WebElement loginbtn = driver.findElement(By.xpath("//button[@type='submit']"));
			loginbtn.click();
			Thread.sleep(3000);
		}
		
		@Test(priority=1)
		public  void LoginData() {
			try {
				Fillo fillo = new Fillo();
				Connection connection= fillo.getConnection("C:\\Users\\Dell\\OneDrive\\Desktop\\Book1.xlsx");
				Recordset recordset = connection.executeQuery("SELECT * from Sheet1");
				int numberOfRows=recordset.getCount();
				System.out.println("Size:" + numberOfRows);
				while(recordset.next()) {
					url=recordset.getField("URL");
					usn=recordset.getField("Username");
					passwd=recordset.getField("Password");
				}
				recordset.close();
				connection.close();
			}
			catch(FilloException e) {
				e.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("Readable data from excel file");
		}
		@AfterTest
		public void TearDown() {
			System.out.println("close the browser Window");
			driver.close();
		}
	   }