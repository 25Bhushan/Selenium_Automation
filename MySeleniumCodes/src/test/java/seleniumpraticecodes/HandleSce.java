package seleniumpraticecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSce extends BaseClass{

	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
	}
	
	public static void handleClick()
	{
		WebElement chooseFileButton=driver.findElement(By.id("imagesrc"));
		highlightElement(chooseFileButton);
		chooseFileButton.click();
	}
		
	public static void main(String[] args) throws Exception {
		openBrowser();
		handleClick();
		Thread.sleep(4000);
		closeBrowser();

	}

}
