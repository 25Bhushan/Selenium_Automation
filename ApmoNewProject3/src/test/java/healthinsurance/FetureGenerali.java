package healthinsurance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetureGenerali {
	
	public static WebDriver driver;
	
	public static void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	public static void homePage()
	{
		driver.get("https://general.futuregenerali.in/");
		String webPageTitle=driver.getTitle();
		if(webPageTitle.contentEquals("General Insurance: Buy & Renew Health & Car Insurance Online| Future Generali"))
		{
			System.out.println("Test Case is Pass");
		}
		else
		{
			System.out.println("Test case is Fail");
		}
	
		driver.findElement(By.xpath("//a[text()='BUY']")).click();
	}
	
	public static void healthInsurance() throws Exception
	{
		driver.findElement(By.xpath("(//a[text()='FG Health Absolute'])[1]")).click();
		String healthInsurancePage=driver.getTitle();
		
		if(healthInsurancePage.equalsIgnoreCase("Health Super Saver"))
		{
			System.out.println("Test Case is Pass");
		}
		else
		{
			System.out.println("Test case is Fail");
		}
		
		driver.findElement(By.id("proposerName")).sendKeys("Bhushan Dhole");
		driver.findElement(By.id("mail")).sendKeys("dholebhushan5@gmail.com");
		driver.findElement(By.id("mobNum")).sendKeys("9604456408");
		driver.findElement(By.id("pinCode")).sendKeys("425405");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='GET QUOTE']")).click();
	}
	
	public static void selectFamilymembers() throws Exception
	{
		driver.findElement(By.xpath("(//input[@placeholder='DD/MM/YYYY'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@data-handler='selectDay'])[25]")).click();
		driver.findElement(By.xpath("//a[@class='primaryRedBtn submitBtn btngetaQuote']")).click();
	}
	
	public static void buildYourPlan() throws Exception
	{
		driver.findElement(By.xpath("(//div[@class='yearList']/div/label)[2]/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class=\"checkmark\"])[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='innerMidWrap'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
	}
	
	public static void ClaimRenewAndManage()
	{
		driver.findElement(By.xpath("//a[text()='GET STARTED']")).click();
	}

	public static void otpPage() throws Exception
	{
		driver.findElement(By.xpath("//input[@class='form-control noOnlyInput otpValidate']")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//a[text()='Login']")).click(); 
		
		driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
	}
	
	public static void makePayment() throws Exception
	{	
		driver.findElement(By.xpath("//span[@id='SalutationSelectBoxIt']")).click();
		driver.findElement(By.xpath("//span[@id='SalutationSelectBoxItContainer']/ul/li[@data-id='1']")).click();
		
		driver.findElement(By.xpath("//span[@id='maritalStatusSelectBoxIt']")).click();
		driver.findElement(By.xpath("//span[@id='maritalStatusSelectBoxItContainer']/ul/li[@data-id='1']")).click();
		
		driver.findElement(By.xpath("//span[@class='selectboxit occupation selectboxit-enabled selectboxit-btn']")).click();
		driver.findElement(By.xpath("(//span[@class='selectboxit-container selectboxit-container'])[3]/ul/li[@data-id='2']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Address Line 1']")).sendKeys("flat no 100 mumbai");
		
		
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		homePage();
		healthInsurance();
		selectFamilymembers();
		buildYourPlan();
		ClaimRenewAndManage();
		otpPage();
		makePayment();
		
		//Thread.sleep(4000);
		//driver.quit();

	}
	
	public static void selectDropDownValue(WebElement element, String dropDownValue)
	{
		Select select=new Select(element);
		select.selectByVisibleText(dropDownValue);
	}

}