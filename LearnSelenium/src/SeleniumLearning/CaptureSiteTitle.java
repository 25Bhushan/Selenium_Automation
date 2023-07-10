package SeleniumLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureSiteTitle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Notes and Projects\\Jar and drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		//capture the title
		
		String title= driver.getTitle();
		System.out.println("The title is : "+title);
		
		String actualTitle= "Facebook – log in or sign up";
		
		if(title.equalsIgnoreCase(actualTitle))
		{
			System.out.println("Test Case Pass");
		}
		else
		{
			System.out.println("Test Case Fail");
		}
	}
}
