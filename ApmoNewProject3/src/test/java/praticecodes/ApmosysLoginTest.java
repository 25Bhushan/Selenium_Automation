package praticecodes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApmosysLoginTest {
	static String ParentId = null;
	static String ChildId = null;

	public static WebDriver driver;
	
	public static void Apmosys_Login() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.navigate().to("http://www.apmosys.in/");
		driver.findElement(By.id("mega-menu-item-1513")).click();
		driver.findElement(By.id("mega-menu-item-1514")).click();
		driver.findElement(By.name("username")).sendKeys("Shikha.Zombade@apmosys.com");
		driver.findElement(By.id("password")).sendKeys("Apmosys@123");
		driver.findElement(By.id("submitButton")).click();
		System.out.println("OTP Sent ");
		String parentId = driver.getWindowHandle();
		System.out.println("Parent" + parentId);
		ParentId = parentId;
	}

	public static void switchWindow(String otp) throws InterruptedException {
		Thread.sleep(30000);
		driver.switchTo().window(ParentId);
		driver.findElement(By.id("otp")).sendKeys(otp);
		driver.findElement(By.className("btn")).click();
	}

	public static String Email() throws InterruptedException {
		
		driver.switchTo().newWindow(WindowType.TAB); 
		driver.navigate().to("http://mail.apmosys.com/");
		
		driver.switchTo().window(driver.getWindowHandle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.name("email-address")).sendKeys("Shikha.Zombade@apmosys.com");
		driver.findElement(By.name("next")).click();
		driver.findElement(By.name("password")).sendKeys("Welcome@2022");
		driver.findElement(By.name("next")).click();
		Thread.sleep(9000);
		
		// This xpath is only for new email that XPATH will be unique on only new email and click on it
		WebElement fistmail = driver.findElement(By.xpath("//div[@class='CLASS_M unread active']"));
		fistmail.click();
		
		//Which inbox email iframe to open email iframe
     	WebElement frame = driver.findElement(By.xpath("//iframe[@id='gui.frm_main.main.mailview#frame']"));
		driver.switchTo().frame(frame);
		
		//and gettext 
    	String  Emailotp = driver.findElement(By.xpath("//body[@id='iw_webmail_msg_body']")).getText().substring(21);    	
       	return Emailotp;

	}
	

	public static void main(String[] args) throws InterruptedException {

		Apmosys_Login();
	
		String OTP=	Email();

		switchWindow(OTP);
	
//		EOD eod= new EOD();
		

	}

}