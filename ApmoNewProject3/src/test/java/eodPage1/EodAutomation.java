package eodPage1;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EodAutomation {

	public static WebDriver driver;
	public static String ParentId=null;
	public static String childId=null;

	public static void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
	}

	public static void loginApmosysPage()
	{
		driver.get("https://apmosys.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Employee'])[1]")).click();
		driver.findElement(By.id("username")).sendKeys("bhushan.dhole@apmosys.com");
		driver.findElement(By.id("password")).sendKeys("Apmosys@123");
		driver.findElement(By.id("submitButton")).click();

		String parentId = driver.getWindowHandle();
		System.out.println(parentId);
		ParentId = parentId;
	}

	public static void loginMailPage() throws Exception
	{
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://mail.apmosys.com/webmail/#sign-in");
		driver.switchTo().window(driver.getWindowHandle());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.name("email-address")).sendKeys("bhushan.dhole@apmosys.com");
		driver.findElement(By.name("next")).click();
		driver.findElement(By.name("password")).sendKeys("Welcome@2022");
		driver.findElement(By.xpath("//button[@data-component='atoms-element-button-2']")).click();
	}

	public static String copyOTP() throws Exception
	{	

		driver.switchTo().frame("gui.frm_main.main.mailview#frame");
		WebElement findText=driver.findElement(By.xpath("//body[@id='iw_webmail_msg_body']/div/div[2]"));
		String text=findText.getText();
		Thread.sleep(5000);
		String subtext=text.substring(21);
		System.out.println(subtext);
		return subtext;
	}

	public static void switchParentWindow(String otp) throws Exception
	{
		driver.switchTo().window(ParentId);
		driver.findElement(By.id("otp")).sendKeys(otp);
		driver.findElement(By.className("btn")).click();
	}

	public static void eodPage(String dates)
	{
		driver.findElement(By.xpath("//i[@class='fa fa-file-text-o']")).click();
		driver.findElement(By.xpath("//ul[@class='nav child_menu']/li/a[text()='Add My EOD']")).click();

		//Eod Details --> dayDropdown
		driver.findElement(By.xpath("//select[@id='datetype']")).click();

		List<WebElement> dayTypeList=driver.findElements(By.xpath("//select[@id='datetype']/option"));
		for(WebElement dayList:dayTypeList)
		{
			System.out.println(dayList.getText());
			if(dayList.getText().equalsIgnoreCase("Working"))
			{
				dayList.click();
			}
		}


		driver.findElement(By.xpath("//input[@id='txtFromDate']")).click();

		List<WebElement> calenderDate= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[@data-handler='selectDay']/a"));
		for(int i=0; i<=calenderDate.size(); i++)
		{
			String dateText=calenderDate.get(i).getText();
			if(dateText.equalsIgnoreCase(dates))
			{
				calenderDate.get(i).click();
				break;
			}	
		}

		Alert alt=driver.switchTo().alert();
		alt.accept();

		//Time		
		driver.findElement(By.xpath("//input[@id='intime']")).click();

		List<WebElement> allTime=driver.findElements(By.xpath("//div[@class='ui-widget-content ui-corner-all']/div/div[2]/div/div/div[2]/a"));
		for(int j=0; j<=allTime.size(); j++)
		{
			String timeText=allTime.get(j).getText();
			if(timeText.equalsIgnoreCase("9"))
			{
				allTime.get(j).click();
				break;
			}
		}

		List<WebElement> allminits=driver.findElements(By.xpath("//div[@class='ui-widget-content ui-corner-all']/div/div[2]/div[2]/div/div/a"));
		for(int m=0; m<=allminits.size(); m++)
		{
			String minitText=allminits.get(m).getText();
			if(minitText.equalsIgnoreCase("30"))
			{
				allminits.get(m).click();
				break;
			}
		}
		//Set button
		driver.findElement(By.xpath("//a[text()='Set']")).click();

System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		//outTime

		driver.findElement(By.xpath("//input[@id='txtToDate']")).click();


		List<WebElement> outCalender= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for(int i=0; i<=outCalender.size(); i++)
		{
			String dateOutText=outCalender.get(i).getText();
			if(dateOutText.equalsIgnoreCase(dates))
			{
				outCalender.get(i).click();
				break;
			}	
		}

		//Time		
		driver.findElement(By.xpath("//input[@id='outtime']")).click();

		driver.findElement(By.xpath("//div[@class='ptTimeSelectHrAmPmCntr']/a[2]")).click();

		List<WebElement> outTimeHr=driver.findElements(By.xpath("//div[@class='ptTimeSelectHrCntr']/a"));
		for(int j=0; j<=outTimeHr.size(); j++)
		{
			String timeTextHr=outTimeHr.get(j).getText();
			if(timeTextHr.equalsIgnoreCase("6"))
			{
				outTimeHr.get(j).click();
				break;
			}
		}

		List<WebElement> outTimeMin=driver.findElements(By.xpath("//div[@class='ptTimeSelectMinCntr']/a"));
		for(int m=0; m<=outTimeMin.size(); m++)
		{
			String outTimeText=outTimeMin.get(m).getText();
			if(outTimeText.equalsIgnoreCase("30"))
			{
				outTimeMin.get(m).click();
				break;
			}
		}
	//Set button
		driver.findElement(By.xpath("//div[@id='ptTimeSelectSetButton']/a[text()='Set']")).click();


//Select Client
		driver.findElement(By.xpath("//select[@id='clientid1']")).click();

		List<WebElement> clientList=driver.findElements(By.xpath("//select[@id='clientid1']/option"));
		for(WebElement clientNames:clientList)
		{
			System.out.println(clientNames.getText());
			if(clientNames.getText().equalsIgnoreCase("ApMoSys"))
			{
				clientNames.click();
			}
		}


		WebElement projectDropDown =driver.findElement(By.xpath("//select[@id='projectname']"));
		projectDropDown.click();

		Actions act=new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).
		sendKeys(Keys.ENTER).
		pause(Duration.ofSeconds(1)).
		sendKeys(Keys.TAB).sendKeys("Stacks").
		sendKeys(Keys.TAB).sendKeys("Training").
//		sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
		build().perform();
		
	}


	public static void main(String[] args) throws Exception {
		Scanner scn=new Scanner(System.in);
		String dates=scn.nextLine();
		System.out.println(dates);
		
		openBrowser();
		loginApmosysPage();
		loginMailPage();
		Thread.sleep(4000);

		String otp=copyOTP();
		switchParentWindow(otp);
		eodPage(dates);
	}

}