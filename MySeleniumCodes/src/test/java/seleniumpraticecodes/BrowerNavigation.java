package seleniumpraticecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowerNavigation extends BaseClass{	

	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.rediff.com/");
		System.out.println("Rediff site title : "+driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Lightning fast free email']")).click();
		System.out.println("Rediff mail site title : "+driver.getTitle());
		Thread.sleep(1000);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	public static void closeBrowser()
	{	
		driver.quit();  
	}
	public static void main(String[] args) throws Exception {
		openBrowser();
		Thread.sleep(1000);
		closeBrowser();
	}

}
