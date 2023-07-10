package seleniumpraticecodes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleActionsKeyBoardOper extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(1000);
	}
	
	public static void handleActionsKeybord()
	{
		WebElement firstName=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys("Bhushan");
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).
		pause(Duration.ofSeconds(1)).
		sendKeys("Dhole").
		pause(Duration.ofSeconds(1)).
		sendKeys(Keys.TAB).
		pause(Duration.ofSeconds(1)).
		sendKeys("at pune mumabai").
		pause(Duration.ofSeconds(1)).
		sendKeys(Keys.TAB).
		pause(Duration.ofSeconds(1)).
		sendKeys("Bhushan@test.com").
		pause(Duration.ofSeconds(1)).
		build().perform();
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		handleActionsKeybord();
		Thread.sleep(4000);
		closeBrowser();
	}

}
