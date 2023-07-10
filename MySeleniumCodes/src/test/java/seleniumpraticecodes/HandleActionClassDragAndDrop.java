package seleniumpraticecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleActionClassDragAndDrop extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(5000);
	}
	
	public static void actionsOperationsDragAndDrop()
	{	
		WebElement frameElement=driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frameElement);
		WebElement souceElement=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetElement=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions act=new Actions(driver);
		//1. way to drag and drop method
//		act.dragAndDrop(souceElement, targetElement).perform();
		
		//2. Way to drag and drop method
		act.clickAndHold(souceElement).moveToElement(targetElement).release().build().perform();
		
	}
	public static void main(String[] args) throws Exception {
		openBrowser();
		actionsOperationsDragAndDrop();
		Thread.sleep(4000);
		closeBrowser();
	}

}
