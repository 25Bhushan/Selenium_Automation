package SeleniumLearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagNameExaple2 {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Notes and Projects\\Jar and drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.rediff.com/");
		
		//TagName
		List<WebElement>allLinks=driver.findElements(By.tagName("a"));
		int numberOflinks = allLinks.size();
		System.out.println("The number of link present on the page are : "+numberOflinks);
		Thread.sleep(6000);
		
		driver.close();

	}

}
