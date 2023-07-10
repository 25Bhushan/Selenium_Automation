package seleniumfileuploads;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumpraticecodes.BaseClass;

public class HandleRobotFileUploads extends BaseClass{
	
	public static void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.filemail.com/share/upload-file");
	}
	
	public static void handleFileUploadRobot() throws Exception
	{
		WebElement uploadButton=driver.findElement(By.id("addBtn"));
		highlightElement(uploadButton);
		uploadButton.click();
		Thread.sleep(750);
		
		String path="F:\\Selenium Notes and Projects\\FileUploadSeleniumScript\\newFile.txt";
		
		StringSelection filepath=new StringSelection(path); //filepath becomes transferable
		
		//transferable file path needs to be copied to clip board
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null); //transferable file path is copied to clip bord
		
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		handleFileUploadRobot();
		closeBrowser();

	}

}
