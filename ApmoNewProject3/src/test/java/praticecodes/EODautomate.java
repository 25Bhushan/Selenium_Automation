package praticecodes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EODautomate {
	
	static WebDriver driver;
	public static void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
	public static void apmosysPage() throws Exception
	{
		driver.get("http://www.apmosys.in/");
		driver.findElement(By.id("mega-menu-item-1513")).click();
		driver.findElement(By.id("mega-menu-item-1514")).click();
		driver.findElement(By.name("username")).sendKeys("bhushan.dhole@apmosys.com");
		driver.findElement(By.id("password")).sendKeys("Apmosys@123");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(4000);
	}
	
	public static void emailPage() throws Exception
	{	
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://mail.apmosys.com/");
		driver.findElement(By.name("email-address")).sendKeys("bhushan.dhole@apmosys.com");
		driver.findElement(By.name("next")).click();
		driver.findElement(By.name("password")).sendKeys("Welcome@2022");
		driver.findElement(By.name("next")).click();
		Thread.sleep(9000);
	
		WebElement fistmail =driver.findElement(By.xpath("//div[@class='CLASS_M unread active']"));
		highlightElement(fistmail);
		fistmail.click();
		
		driver.switchTo().frame("gui.frm_main.main.list#frame");
		
		driver.switchTo().defaultContent();
		
		WebElement frame=driver.findElement(By.xpath("//iframe[@id='gui.frm_main.main.mailview#frame']"));
		driver.switchTo().frame(frame);
		
		WebElement highlightFrame=driver.findElement(By.xpath("//body[@id='iw_webmail_msg_body']"));
		highlightElement(highlightFrame);
		System.out.println(highlightFrame.getText());
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		apmosysPage();
		emailPage();	
		
	}
	
	public static void highlightElement(WebElement element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element); 
	}
	
}	