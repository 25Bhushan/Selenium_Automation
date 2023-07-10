package seleniumpraticecodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrames extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/overview-summary.html");
		Thread.sleep(750);
	}
	public static void frameHandling() throws Exception
	{
		WebElement frameLink=driver.findElement(By.xpath("(//a[text()='Frames'])[1]"));
		highlightElement(frameLink);
		frameLink.click();
		Thread.sleep(750);
		
		//frame with frame name
		driver.switchTo().frame("packageFrame");
		WebElement abstractAnnotationsLink=driver.findElement(By.xpath("//a[text()='AbstractAnnotations']"));
		highlightElement(abstractAnnotationsLink);
		abstractAnnotationsLink.click();
		
		//switching back to the main/base frame
		driver.switchTo().defaultContent();
		
		//frame with index number
		driver.switchTo().frame(0);
		WebElement orgSeleniumLink=driver.findElement(By.xpath("//ul[@title='Packages']/li/a[text()='org.openqa.selenium']"));
		highlightElement(orgSeleniumLink);
		orgSeleniumLink.click();
		
		//switching back to the main/base frame
		driver.switchTo().defaultContent();
				
		WebElement thirdFrame=driver.findElement(By.xpath("//iframe[@class='rightIframe']"));
		//frame passed as a web element 
		driver.switchTo().frame(thirdFrame);
		WebElement annotationsLink=driver.findElement(By.xpath("//a[text()='Annotations']"));
		highlightElement(annotationsLink);
		annotationsLink.click();
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		frameHandling();
		
		Thread.sleep(5000);
		closeBrowser();
	}
}
