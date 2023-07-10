package seleniumpraticecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseBrowserMethods extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://weebly.com/seo/internal-links");
		Thread.sleep(1000);
		WebElement loginLink=driver.findElement(By.xpath("(//div[@data-type='login']/a)[1]"));
		highlightElement(loginLink);
		loginLink.click();
		Thread.sleep(1000);
	}
	
	public static void highlightElement(WebElement element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.border='2px solid yellow'", element); 
	}
	
	public static void closeBrowser()
	{	
		//Close method does not terminate the driver instance running in background, closes the current browser window in focus
		driver.close(); 
		
		//Quite method terminate the driver instance running in background, close all the browser window in one go
//		driver.quit();  
	}
	public static void main(String[] args) throws Exception {
		openBrowser();
		closeBrowser();
	}

}
