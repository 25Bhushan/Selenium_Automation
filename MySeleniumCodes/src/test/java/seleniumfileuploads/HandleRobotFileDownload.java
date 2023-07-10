package seleniumfileuploads;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumpraticecodes.BaseClass;

public class HandleRobotFileDownload extends BaseClass{
	
	public static void openBroswer() throws Exception 
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/downloads/");
		Thread.sleep(750);
	}
	public static void handleFileUploadRobot() throws Exception 
	{
		WebElement	seleniumDownloadLink=driver.findElement(By.xpath("//p[@class='card-text']/a[text()='4.7.1']"));
		highlightElement(seleniumDownloadLink);
		seleniumDownloadLink.click();
		Thread.sleep(2500);
		
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_LEFT);
		rb.keyRelease(KeyEvent.VK_LEFT);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void main(String[] args) throws Exception {
		openBroswer();
		handleFileUploadRobot();
	}
	

}
