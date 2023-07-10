package SeleniumLearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenMultipleBrowser {

	public static void main(String[] args) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Notes and Projects\\Jar and drivers\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		System.setProperty("webdriver.egde.driver" ,"F:\\Selenium Notes and Projects\\Jar and drivers\\edgedriver_win64\\msedgedriver.exe");
		driver= new EdgeDriver();
		driver.get("https://www.facebook.com/");
		
		System.setProperty("webdriver.gecko,driver", "F:\\Selenium Notes and Projects\\Jar and drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver= new FirefoxDriver();
		driver.get("https://www.facebook.com/");	

	}

}
