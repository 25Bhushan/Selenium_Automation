package seleniumpraticecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleActionMouseOverWebElement extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mayoclinic.org/");
		Thread.sleep(2000);
	}
	
	public static void mouseOverWebElement() throws Exception
	{
		WebElement careAtMayoOption=driver.findElement(By.xpath("//button[@id='et_globalNavigationButton_0B9BEADC']/span"));
		careAtMayoOption.click();
		Thread.sleep(1000);
		
		WebElement locationsOptions=driver.findElement(By.id("et_globalNavigation_16C51EF4"));
		
		Actions act=new Actions(driver);
		act.moveToElement(locationsOptions).click().build().perform();
	}
	public static void main(String[] args) throws Exception {
		openBrowser();
		mouseOverWebElement();
		Thread.sleep(4000);
		closeBrowser();
	}

}
