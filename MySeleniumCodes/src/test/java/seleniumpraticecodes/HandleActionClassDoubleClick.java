package seleniumpraticecodes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleActionClassDoubleClick extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mayoclinic.org/drugs-supplements/drug-list");
		Thread.sleep(1000);
	}
	
	public static void actionsOperationsDoubleClick()
	{
//		WebElement findADoctorLink=driver.findElement(By.id("et_HeaderLinkQuick_9AC3DFAB"));
//		highlightElement(findADoctorLink);
	/* this are two method for double click
	 		doubleClick();
	 		doubleClick(WebElement target)
	*/
		
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	public static void main(String[] args) throws Exception {
		openBrowser();
		actionsOperationsDoubleClick();
		Thread.sleep(4000);
		closeBrowser();
	}

}
