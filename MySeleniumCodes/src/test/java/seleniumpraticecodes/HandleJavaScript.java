package seleniumpraticecodes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJavaScript extends BaseClass {
	
	public static void openBroser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/");
		Thread.sleep(4000);
	}
	public static void handleErrorMsgs()
	{
// Way 1-- To click on check box but it is not working so i will use the javascriptExecutor
		
//		WebElement loginButton=driver.findElement(By.id("persistent"));
//		loginButton.click(); //not working
	
//way 2a-- Using javascriptExecutor it will click on check box button 
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('persistent').click()");
		
//way 2b--
//		WebElement checkbox=driver.findElement(By.xpath("//input[@id='persistent']"));
//		checkbox.click();
//		js.executeScript("arguments[0].click()", checkbox);
		
	}

	public static void main(String[] args) throws Exception {
		
		openBroser();
		handleErrorMsgs();
		Thread.sleep(4000);
		closeBrowser();
		 
	}

}
