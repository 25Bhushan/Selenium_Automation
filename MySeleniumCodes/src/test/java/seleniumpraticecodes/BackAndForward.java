package seleniumpraticecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BackAndForward extends BaseClass{

		public static void openBrowser() throws Exception
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://vishwarajhospital.com/");
			System.out.println("Rediff site title : "+driver.getTitle());
			Thread.sleep(1000);
		}
//2ed Way to handle a Bank and Forward Operation
		public static void linksNavigation() throws Exception
		{
			String xpathpart1= "//ul[@id='menu-1-729f9c2c']/li[";
			String xpathpart2= "]";
			
			for(int i=1; i<=4; i++)
			{
				WebElement link=driver.findElement(By.xpath(xpathpart1+i+xpathpart2));
				highlightElement(link);
				link.click();
				Thread.sleep(1000);
				System.out.println("Site title is : "+driver.getTitle());
				driver.navigate().back();
			}
		}
		
//1st Way to handle a Bank and Forward Operation
	/* 	public static void linksNavigation() throws Exception
		{
			WebElement insuraceLink=driver.findElement(By.xpath("//ul[@id='menu-1-729f9c2c']/li[1]"));
			highlightElement(insuraceLink);
			insuraceLink.click();
			Thread.sleep(750);
			System.out.println("Site title is : "+driver.getTitle());
			driver.navigate().back();
			
			WebElement healthPackagesLink=driver.findElement(By.xpath("//ul[@id='menu-1-729f9c2c']/li[2]"));
			highlightElement(healthPackagesLink);
			healthPackagesLink.click();
			Thread.sleep(750);
			System.out.println("Site title is : "+driver.getTitle());
			driver.navigate().back();
			
			WebElement contactUsLink=driver.findElement(By.xpath("//ul[@id='menu-1-729f9c2c']/li[3]"));
			highlightElement(contactUsLink);
			contactUsLink.click();
			Thread.sleep(750);
			System.out.println("Site title is : "+driver.getTitle());
			driver.navigate().back();
			
			WebElement payOnlineLink=driver.findElement(By.xpath("//ul[@id='menu-1-729f9c2c']/li[4]"));
			highlightElement(payOnlineLink);
			payOnlineLink.click();
			Thread.sleep(750);
			System.out.println("Site title is : "+driver.getTitle());
			driver.navigate().back();
		}
	*/	
		
		public static void highlightElement(WebElement element)
		{
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
			jsExecutor.executeScript("arguments[0].style.border='2px solid yellow'", element); 
		}
		public static void closeBrowser()
		{
			driver.quit();
		}
			
	public static void main(String[] args) throws Exception {
		openBrowser();
		linksNavigation();
		Thread.sleep(1000);
		closeBrowser();
	}

}
