package testngprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


//Apmosys Login with excel data providing 

public class ApmosysMailLoginWithExcel {
	
	WebDriver driver;
	@Test(priority = 1, dataProvider = "login", dataProviderClass = ExcelSheetGetData.class)
	public void loginValidation(String userName, String password) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://mail.apmosys.com/webmail/");
		
		driver.findElement(By.xpath("//input[@name='email-address']")).sendKeys(userName);
		driver.findElement(By.xpath("//button[@data-hook='validate-email']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@name='next']/span")).click();
		Thread.sleep(5000);
		
		
		boolean searchBox =driver.findElement(By.id("gui.frm_main.search.search#main")).isDisplayed();
		Assert.assertTrue(searchBox);
		
//		String title=driver.getTitle();
//		System.out.println(title);
//		Assert.assertEquals(title, "IceWarp WebClient");
	}
	
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}
	

}