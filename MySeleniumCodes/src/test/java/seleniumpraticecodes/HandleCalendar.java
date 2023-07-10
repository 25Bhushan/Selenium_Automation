package seleniumpraticecodes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCalendar extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(1000);
	}
	
	public static void selectPickUpdate(String enteredDate, String enteredMonth, String enteredYear) throws Exception
	{
		WebElement calendarOption =driver.findElement(By.xpath("//input[@id='onward_cal']"));
		calendarOption.click();
		Thread.sleep(750);
		
		WebElement yearValue=driver.findElement(By.xpath("//td[@class='monthTitle']"));
		if(yearValue.getText().contains(enteredYear))
		{
			WebElement monthValue=driver.findElement(By.xpath("//td[@class='monthTitle']"));
			while(!monthValue.getText().contains(enteredMonth))
			{	
				WebElement nextArrow=driver.findElement(By.xpath("//td[@class='next']/button"));
				nextArrow.click();
				Thread.sleep(1000);
			}
			
			List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[@class='wd day' or @class='we day']"));
			for(int i=0; i<allDates.size(); i++)
			{
				String dateText =allDates.get(i).getText();
				if(dateText.equalsIgnoreCase(enteredDate))
				{
					allDates.get(i).click();
					break;
				}
			}
		}
		else
		{
			yearValue.click();
			Thread.sleep(750);
			WebElement yearSelection=driver.findElement(By.xpath(""));
			if(yearSelection.getText().equalsIgnoreCase(enteredYear))
			{
				WebElement nextYearArrow=driver.findElement(By.xpath(""));
				nextYearArrow.click();
				Thread.sleep(750);
			}
			List<WebElement> allAvailableMonths=driver.findElements(By.xpath(""));
			for(int i=0; i<allAvailableMonths.size(); i++)
			{
				if(allAvailableMonths.get(i).getText().contains(enteredMonth))
				{
					allAvailableMonths.get(i).click();
					break;
				}
			}
			
			List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[@class='wd day' or @class='we day']"));
			for(int i=0; i<allDates.size(); i++)
			{
				String dateText =allDates.get(i).getText();
				if(dateText.equalsIgnoreCase(enteredDate))
				{
					allDates.get(i).click();
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		selectPickUpdate("25", "Nov", "2022");
		Thread.sleep(7000);
		//closeBrowser();
	}

}
