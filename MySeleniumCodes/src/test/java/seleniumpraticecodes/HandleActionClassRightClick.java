package seleniumpraticecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleActionClassRightClick extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mayoclinic.org/drugs-supplements/drug-list");
		Thread.sleep(1000);
	}
	
	public static void actionsOperationsRightClick()
	{
		WebElement findADoctorLink=driver.findElement(By.id("et_HeaderLinkQuick_9AC3DFAB"));
		highlightElement(findADoctorLink);
		
		Actions act=new Actions(driver);
	 /*  1. constextClick method is a right click on web page this 2 methods 
			contextClick() --this method right click on web page very fist side
			contextClick(WebElement target)	-- this method right click on web page located element
	*/
		act.contextClick(findADoctorLink).perform();	
	}
	public static void main(String[] args) throws Exception {
		openBrowser();
		actionsOperationsRightClick();
		Thread.sleep(4000);
		closeBrowser();
	}

}
