package seleniumpraticecodes;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetcurrentUrlGetPageSource extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.sentrifugo.com/");
		Thread.sleep(1000);
		
		//1. getting the current URL
		String url=driver.getCurrentUrl();
		System.out.println("Open url is : "+url);
		
		//2. getting the page source
		String pageSource=driver.getPageSource();
		System.out.println("Page Source is : "+pageSource);  // first way to print
		
//		System.out.println("Page Source is : "+driver.getPageSource()); //second way to print	
		
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
	}
}
