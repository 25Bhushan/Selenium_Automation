package seleniumpraticecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleErrorMessages extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.sentrifugo.com/");
		Thread.sleep(2000);
	}
	
	public static void handleActionsMethods()
	{
		WebElement loginButton=driver.findElement(By.id("loginsubmit"));
		loginButton.click();
		
		WebElement unameErrorText=driver.findElement(By.id("usernameerror"));
		String usernameErrorMessage=unameErrorText.getText();
		System.out.println(usernameErrorMessage);
		
		WebElement passwordErrorText=driver.findElement(By.id("pwderror"));
		String passwordErrorMessage=passwordErrorText.getText();
		System.out.println(passwordErrorMessage);
	}

	public static void main(String[] args) throws Exception {
		openBrowser();
		Thread.sleep(2000);
		handleActionsMethods();
		closeBrowser();
	}

}
