 package seleniumpraticecodes;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlert extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	}
	
	public static void alertHandling() throws Exception
	{
		WebElement signButton =driver.findElement(By.xpath("//input[@value='Sign in']"));
		highlightElement(signButton);
		signButton.click();
		Thread.sleep(750);
		
		//Switching the driver control over the alert popup
		Alert alt=driver.switchTo().alert();
		
		//Getting the alert text from the alert popup
		String alertTextMessage=alt.getText();
		System.out.println("The Alert pop up text is : "+alertTextMessage);
		
		//Clicking on OK Button
		alt.accept();
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		alertHandling();
		
		closeBrowser();
	}
	
	public static void closeBrowser()
	{
		driver.close();
	}

}
