package seleniumpraticecodes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultiBrowsersWindos extends BaseClass{

	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.peoplesuniversity.edu.in/enquiry-form/");
//		String browserHandleId= driver.getWindowHandle();
//		System.out.println("The browser handle ID is : "+browserHandleId);
	}
	
	public static void multiBrowserHandling() throws Exception
	{
		String parentHandleWindowId= driver.getWindowHandle();
		System.out.println("The browser handle ID is : "+parentHandleWindowId);
		
		WebElement addmissionButton= driver.findElement(By.xpath("//a[text()=' Click here to admission 2022-23 ']"));
		highlightElement(addmissionButton);
		addmissionButton.click();
		Thread.sleep(1000);
		
		Set<String> allBrowserWindowHandleId=driver.getWindowHandles();
		System.out.println(allBrowserWindowHandleId);
		Iterator<String> itr= allBrowserWindowHandleId.iterator();
		
		while(itr.hasNext())
		{
			String winHandleID=itr.next();
			if(!winHandleID.equalsIgnoreCase(parentHandleWindowId))
			{
				driver.switchTo().window(winHandleID);
				WebElement loginLink= driver.findElement(By.cssSelector("a.loginLinkClass"));
				highlightElement(loginLink);
				loginLink.click();
				Thread.sleep(1000);
				
				WebElement loginButton=driver.findElement(By.id("button1"));
				highlightElement(loginButton);
				loginButton.click();
				Thread.sleep(1000);
				
				WebElement alerOkButton=driver.findElement(By.xpath("//button[@class='okAlertBtn buttonPopupClass']"));
				highlightElement(alerOkButton);
				alerOkButton.click();
				driver.close();
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		multiBrowserHandling();
		
		Thread.sleep(5000);
		closeBrowser();		
	
	}

}
