package quizizz;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QuizizzAutomate {
	
	static WebDriver driver;

	
	public static void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.google.com/");
	}
	
	public static void searchQuizizz()
	{
		driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("quizizz");
		driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='yuRUbf']/a/h3)[1]")).click();
		
		//login
		driver.findElement(By.xpath("//div[@class='navigation-buttons-container']/a[@i18next-orgval-0='Log in']")).click();
		driver.findElement(By.xpath("(//span[@class='_i18n-container LANG_en'])[5]")).click();
		driver.findElement(By.xpath("//input[@placeholder='000 000 0000']")).sendKeys("9604456408");
		driver.findElement(By.xpath("//input[@placeholder='******']")).sendKeys("Bhushan@1995");
		driver.findElement(By.xpath("//button[@class='mt-4 continue-button']")).click();
		
	}
	
	public static void enterCode() throws IOException, Exception
	{	
		//parent window Id
		String parenetId= driver.getWindowHandle();
		System.out.println("Parent Window Id"+parenetId);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	
		//handle Mutiple windows
		Set<String> allwindowIds=driver.getWindowHandles();
		System.out.println("All Window Id in set"+allwindowIds);
		Iterator<String> itr= allwindowIds.iterator();			
		
		while(itr.hasNext())
		{
			String winHandlId=itr.next();
			if(!winHandlId.equalsIgnoreCase(parenetId))
			{
				driver.switchTo().window(winHandlId);

			}
		}
		
		//read the data from excel
		File file=new File("C:\\Users\\Dell\\Downloads\\Book1.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
	
		//excel data store into the String
		String link =sheet.getRow(0).getCell(0).toString();
		String code =sheet.getRow(0).getCell(1).toString();
		
		String passTheCode=code.substring(0, 6);
		System.out.println(link);
		System.out.println(passTheCode);
		
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@placeholder='Enter a join code']")).sendKeys(passTheCode);
		driver.findElement(By.xpath("//span[text()='JOIN']")).click();
		
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		searchQuizizz();
		enterCode();
		
		Thread.sleep(6000);
		driver.quit();
	}
	
}