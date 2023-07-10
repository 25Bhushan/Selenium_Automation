package seleniumpraticecodes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {
	
	public static WebDriver driver;
	
	//first common method for highlight the Element 
	public static void highlightElement(WebElement element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.border='2px solid yellow'", element); 
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}
}
