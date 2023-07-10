package normalProgram;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CamparePrice {
static WebDriver driver=null;
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 	}
	
	public static void searchProduct(String productName)
	{
		driver.navigate().to("https://www.amazon.in/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productName);
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
		
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys(productName);
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
			System.out.println("Test Case is Price Compare");
		}
		else
		{
			System.out.println("Test Cas is fail");
		}

	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		searchProduct("Lenovo laptop");
		driver.quit();
		
		Thread.sleep(4000);
		
		openBrowser();
		searchProduct("iphone 14");
		driver.quit();
	}

}