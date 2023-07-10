package testngprograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CamparePrice {

WebDriver driver=null;
	
 @BeforeSuite
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 	}
	
 @Test
	public void searchProduct()
	{
		driver.navigate().to("https://www.amazon.in/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung s22");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String mobilePrice1=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Mobile Price Amazon  "+mobilePrice1);
		
		String comma=mobilePrice1.replaceAll(",", "");
		String qs = comma.replaceFirst("\\₹", "");
//		System.out.println("Amazon Prices "+qs);

System.out.println("================================================================================================================");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("samsung s22");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String mobilePrice2=driver.findElement(By.xpath("(//div[@class='_30jeq3 _1_WHN1'])[1]")).getText();
		System.out.println("Mobile Price flipkart "+mobilePrice2);
		
		String comma1=mobilePrice2.replaceAll(",", "");
		String qs1 = comma1.replaceFirst("\\₹", "");
//		System.out.println("filpkart Prices "+qs1);
	
System.out.println("================================================================================================================");

		if(qs.equalsIgnoreCase(qs1))
		{
			System.out.println("Test Case is Pass");
		}
		else if(!(qs.equalsIgnoreCase(qs1)))
		{
			System.out.println("Test Case give amzone mobile"+qs);
		}
		else if(!(qs1.equalsIgnoreCase(qs)))
		{
			System.out.println("Test Cas is filpkart"+qs1);
		}
		else
		{
			System.out.println("Test case fail");
		}

	}
 
}