package seleniumfileuploads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumpraticecodes.BaseClass;

public class HandleFileUpload extends BaseClass{
	
	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.filemail.com/share/upload-file");
		Thread.sleep(2000);
	}
	
	public static void handleFileUpload() throws Exception
	{
		WebElement uploadButton=driver.findElement(By.id("addBtn"));
		highlightElement(uploadButton);
		uploadButton.click();
		Thread.sleep(1000);
		
		//Integrated with AutoIt(.exe)
// 1. Way	
//		Runtime.getRuntime().exec("F:\\Selenium Notes and Projects\\Jar and drivers\\AutoItScript\\autoItFileUploadScript.exe");  //exe ka path
//		Thread.sleep(1500);
		
// 2. Way 
		Runtime.getRuntime().exec("F:\\Selenium Notes and Projects\\Jar and drivers\\AutoItScript\\autoItFileuploadStaticScript.exe"+" "+"F:\\FileUploadSeleniumScript\\Everything-EMPtable.docx");
		Thread.sleep(1500);
		
		uploadButton.click();
		Thread.sleep(1500);
		
		Runtime.getRuntime().exec("F:\\Selenium Notes and Projects\\Jar and drivers\\AutoItScript\\autoItFileuploadStaticScript.exe"+" "+"F:\\FileUploadSeleniumScript\\RestAssuredFramework-master.zip");
		Thread.sleep(1500);
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		handleFileUpload();
		Thread.sleep(6000);
		closeBrowser();
	}
}
