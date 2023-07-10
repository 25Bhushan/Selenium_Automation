package SeleniumLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Notes and Projects\\Jar and drivers\\chromedriver_win32\\chromedriver.exe");
	//	System.setProperty("webdriver.egde.driver" ,"F:\\Selenium Notes and Projects\\Jar and drivers\\edgedriver_win64\\msedgedriver.exe");
	//	System.setProperty("webdriver.gecko,driver", "F:\\Selenium Notes and Projects\\Jar and drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		
		//start Browser
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		
		driver.close();
	}

}
	