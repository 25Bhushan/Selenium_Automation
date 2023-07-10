package com.labdatest;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Poshan{
	static WebDriver driver;
	
	static void openBrowser()
	{	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://poshanabhiyaan.gov.in/#/login");
		driver.findElement(By.xpath("//input[@placeholder='USERNAME']")).sendKeys("mohfw-2749806");
		driver.findElement(By.xpath("//input[@placeholder='PASSWORD']")).sendKeys("mohfw-2749806");
	}

	static void sing() throws Exception
	{	
		WebElement captch1= driver.findElement(By.xpath("//*[@id=\"login_window\"]/form/div/div/div[4]/div[1]/span[2]"));
		WebElement captch2= driver.findElement(By.xpath("//*[@id=\"login_window\"]/form/div/div/div[4]/div[1]/span[3]"));
		String s1=captch1.getText();
		String s2=captch2.getText();
		Integer i=new Integer(s1);
		Integer i1=new Integer(s2);
		int sum=i+i1;
		String s=String.valueOf(sum);
		WebElement captcha3= driver.findElement(By.xpath("//*[@id=\"login_window\"]/form/div/div/div[4]/div[2]/input"));
		captcha3.sendKeys(s);
		driver.findElement(By.id("signin")).click();
		Thread.sleep(3000);
	}
	public static void WebPage() throws Exception{
				
		driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")).click(); Thread.sleep(2000);
		WebElement ActivityDropDown=driver.findElement(By.xpath("//div[@class='mat-select-value']/span[text()='Activity']"));
		ActivityDropDown.click();

		List<WebElement> Activity=driver.findElements(By.xpath("//div[@id='cdk-overlay-0']/div/div/mat-option/span")); //Thread.sleep(2000);
		for(WebElement listOfActivity : Activity)
		{
			String activityNames=listOfActivity.getText();
			System.out.println("Country extracted is : "+activityNames);
			if(listOfActivity.getText().equalsIgnoreCase("Home Visits"))

			{
				listOfActivity.click();
				break;
			}
		}
		Actions act1=new Actions(driver);
		act1.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.xpath("//span[contains(text(),'Theme')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Mahila aur Swasthya')]")).click();

		act1.sendKeys(Keys.TAB).
		sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//span[normalize-space()='Village / AWC']")).click();

		act1.sendKeys(Keys.TAB).build().perform();
		WebElement organizer=driver.findElement(By.xpath("//*[@id=\"mat-select-2\"]/div/div[1]"));

		organizer.click();
		Thread.sleep(750);

		List<WebElement> organizerList=driver.findElements(By.xpath("//mat-option[@role='option']/span"));
		System.out.println("Total number of check box button are : "+organizerList.size()); Thread.sleep(1000);
		for(WebElement organizerName : organizerList)
		{
			String listOraganizer=organizerName.getText();
			System.out.println(listOraganizer);

			if (listOraganizer.contains("ANM"))
			{
				organizerName.click();
			}
			else if(listOraganizer.contains("AYUSH - AYUSH"))
			{
				organizerName.click();
			}
			else if (listOraganizer.contains("ASHA"))
			{
				organizerName.click();
			}
		}
		act1.sendKeys(Keys.TAB).build().perform();

	}

	public static void totalinput(String totalParti, String adultm1, String adultf1, String childm1, String childm2) throws Exception
	{
		WebElement totalpati = driver.findElement(By.xpath("//input[@placeholder='Number']"));
		totalpati.sendKeys(totalParti);

		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).
		pause(Duration.ofSeconds(2)).
		sendKeys(adultm1).
		sendKeys(Keys.TAB).
		sendKeys(adultf1).
		sendKeys(Keys.TAB).
		sendKeys(Keys.TAB).
		sendKeys(childm1).
		sendKeys(Keys.TAB).
		sendKeys(childm2).
		sendKeys(Keys.TAB).
		sendKeys(Keys.TAB).
		sendKeys(Keys.TAB).
		sendKeys("Hol2").
		sendKeys(Keys.TAB).
		pause(Duration.ofSeconds(2)).
		sendKeys(Keys.TAB).
		pause(Duration.ofSeconds(3)).
		sendKeys(Keys.ENTER).
		build().perform();
		Thread.sleep(1000);
	}
	static void submitButton() throws Exception
	{	Thread.sleep(3000);
		WebElement addbution=driver.findElement(By.xpath("//button[@class='dialog-b ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']"));
		addbution.click();
		Thread.sleep(2000);
	}

	public static void main(String[] args) throws Exception {
		openBrowser();
		sing();
		WebPage();
//		Thread.sleep(1000);
//		totalinput("5", "1", "2", "1", "1");
//		submitButton();

//		totalinput	("12","1","2","4","5");	submitButton();
//		totalinput	("14","1","2","3","8");	submitButton();
//		totalinput	("11","1","2","3","5");	submitButton();
//		totalinput	("10","1","2","3","4");	submitButton();
//		totalinput	("14","1","2","4","7");	submitButton();
//		totalinput	("13","1","2","4","6");	submitButton();
//		totalinput	("11","1","2","4","4");	submitButton();
//		totalinput	("10","1","2","4","3");	submitButton();
//		totalinput	("9","1","2","4","2");	submitButton();
//		totalinput	("8","1","2","4","1");	submitButton();
//		totalinput	("14","2","3","1","8");	submitButton();
//		totalinput	("13","2","3","1","7");	submitButton();
//		totalinput	("12","2","3","1","6");	submitButton();
//		totalinput	("11","2","3","1","5");	submitButton();
//		totalinput	("10","2","3","1","4");	submitButton();
//		totalinput	("9","2","3","1","3");	submitButton();
//		totalinput	("4","1","1","1","1");	submitButton();
//		totalinput	("3","1","1","1","0");	submitButton();
//		totalinput	("2","1","1","0","0");	submitButton();
//		totalinput	("1","1","0","0","0");	submitButton();
//		totalinput	("8","2","2","2","2");	submitButton();
//		totalinput	("6","2","2","2","0");	submitButton();
//		totalinput	("4","2","2","0","0");	submitButton();
//		totalinput	("2","2","0","0","0");	submitButton();
//		totalinput	("12","3","3","3","3");	submitButton();
//		totalinput	("9","3","3","3","0");	submitButton();
//		totalinput	("6","3","3","0","0");	submitButton();
//		totalinput	("3","3","0","0","0");	submitButton();
//		totalinput	("9","1","2","3","3");	submitButton();
//		totalinput	("4","1","0","2","1");	submitButton();
//		totalinput	("9","4","0","2","3");	submitButton();
//		totalinput	("6","2","0","3","1");	submitButton();
//		totalinput	("11","2","4","1","4");	submitButton();
//		totalinput	("9","1","4","1","3");	submitButton();
//		totalinput	("6","1","0","3","2");	submitButton();
//		totalinput	("3","1","0","0","2");	submitButton();
//		totalinput	("10","1","4","2","3");	submitButton();
//		totalinput	("10","1","2","3","4");	submitButton();
//		totalinput	("10","4","3","2","1");	submitButton();
//		totalinput	("6","1","1","2","2");	submitButton();
//		totalinput	("10","2","2","3","3");	submitButton();
//		totalinput	("11","3","3","1","4");	submitButton();
//		totalinput	("8","3","3","1","1");	submitButton();
//		totalinput	("7","1","4","0","2");	submitButton();
//		totalinput	("5","3","0","2","0");	submitButton();
//		totalinput	("6","1","0","2","3");	submitButton();
//		totalinput	("5","1","1","1","2");	submitButton();
//		totalinput	("6","2","1","1","2");	submitButton();
//		totalinput	("5","1","2","1","1");	submitButton();
//		totalinput	("27","8","8","3","8");	submitButton();
//		totalinput	("19","2","3","8","6");	submitButton();
//		totalinput	("20","1","5","8","6");	submitButton();
//		totalinput	("21","8","2","5","6");	submitButton();
//		totalinput	("22","6","5","5","6");	submitButton();
//		totalinput	("17","1","5","5","6");	submitButton();
//		totalinput	("15","2","6","2","5");	submitButton();
//		totalinput	("21","2","6","5","8");	submitButton();
//		totalinput	("17","4","2","5","6");	submitButton();
//		totalinput	("16","3","2","5","6");	submitButton();
//		totalinput	("23","2","9","6","6");	submitButton();
//		totalinput	("16","3","3","5","5");	submitButton();
//		totalinput	("14","2","2","5","5");	submitButton();
//		totalinput	("16","2","3","5","6");	submitButton();
//		totalinput	("18","2","5","5","6");	submitButton();
//		totalinput	("19","2","6","5","6");	submitButton();
//		totalinput	("20","6","3","5","6");	submitButton();
//		totalinput	("22","5","3","8","6");	submitButton();
//		totalinput	("22","6","6","5","5");	submitButton();
//		totalinput	("18","6","6","1","5");	submitButton();
//		totalinput	("19","5","3","5","6");	submitButton();
//		totalinput	("23","5","6","6","6");	submitButton();
//		totalinput	("15","5","2","5","3");	submitButton();
//		totalinput	("21","5","6","5","5");	submitButton();
//		totalinput	("20","7","2","6","5");	submitButton();
//		totalinput	("24","5","5","8","6");	submitButton();
//		totalinput	("16","5","3","5","3");	submitButton();
//		totalinput	("22","9","4","4","5");	submitButton();
//		totalinput	("19","3","6","8","2");	submitButton();
//		totalinput	("15","2","2","5","6");	submitButton();
//		totalinput	("12","2","3","5","2");	submitButton();
//		totalinput	("21","5","5","8","3");	submitButton();
//		totalinput	("18","2","5","2","9");	submitButton();
//		totalinput	("14","2","5","5","2");	submitButton();
//		totalinput	("20","1","9","1","9");	submitButton();
//		totalinput	("26","8","8","5","5");	submitButton();
//		totalinput	("20","5","5","5","5");	submitButton();
//		totalinput	("24","6","9","6","3");	submitButton();
//		totalinput	("24","5","8","5","6");	submitButton();
//		totalinput	("18","5","2","5","6");	submitButton();
//		totalinput	("21","5","5","5","6");	submitButton();
//		totalinput	("21","2","8","5","6");	submitButton();
//		totalinput	("19","5","6","5","3");	submitButton();
//		totalinput	("25","8","6","5","6");	submitButton();
//		totalinput	("21","5","6","1","9");	submitButton();
//		totalinput	("17","3","3","5","6");	submitButton();
//		totalinput	("23","5","3","6","9");	submitButton();
//		totalinput	("12","2","5","2","3");	submitButton();
//		totalinput	("18","1","5","6","6");	submitButton();
//		totalinput	("25","6","6","8","5");	submitButton();
//		totalinput	("22","5","6","5","6");	submitButton();
//		totalinput	("20","4","6","5","5");	submitButton();
//		totalinput	("19","8","3","2","6");	submitButton();
//		totalinput	("18","2","2","8","6");	submitButton();
//		totalinput	("22","2","9","5","6");	submitButton();
//		totalinput	("23","8","4","5","6");	submitButton();
//		totalinput	("23","4","8","5","6");	submitButton();
//		totalinput	("24","2","8","5","9");	submitButton();
//		totalinput	("25","7","4","5","9");	submitButton();
//		totalinput	("23","4","5","8","6");	submitButton();
		
//		totalinput	("22","7","4","5","6");	submitButton();
//		totalinput	("20","4","5","5","6");	submitButton();
//		totalinput	("15","4","3","5","3");	submitButton();
//		totalinput	("19","4","2","8","5");	submitButton();
//		totalinput	("26","4","8","8","6");	submitButton();
// 		totalinput	("24","5","5","9","5");	submitButton();
//		totalinput	("19","3","6","5","5");	submitButton();
//		totalinput	("25","5","9","5","6");	submitButton();
//		totalinput	("25","5","6","8","6");	submitButton();
//		totalinput	("25","5","5","9","6");	submitButton();
//		totalinput	("24","8","5","5","6");	submitButton();
//		totalinput	("21","4","6","5","6");	submitButton();
//		totalinput	("19","5","6","2","6");	submitButton();
//		totalinput	("9","2","2","2","3");	submitButton();
//		totalinput	("12","2","2","2","6");	submitButton();
		totalinput	("28","9","6","8","5");	submitButton();
		totalinput	("16","5","3","2","6");	submitButton();
		totalinput	("23","6","6","5","6");	submitButton();
		totalinput	("25","6","6","5","8");	submitButton();
		totalinput	("29","9","6","5","9");	submitButton();
		totalinput	("22","8","3","5","6");	submitButton();
		totalinput	("27","5","5","8","9");	submitButton();
		totalinput	("28","8","6","5","9");	submitButton();
		totalinput	("23","2","7","5","9");	submitButton();
		totalinput	("21","5","6","2","8");	submitButton();
		totalinput	("20","5","5","4","6");	submitButton();
		totalinput	("20","6","6","2","6");	submitButton();
		totalinput	("26","6","9","5","6");	submitButton();
		totalinput	("20","2","9","6","3");	submitButton();
		totalinput	("16","2","6","2","6");	submitButton();
		totalinput	("17","2","6","2","5");	submitButton();
		totalinput	("17","2","5","5","5");	submitButton();
		totalinput	("13","2","3","5","3");	submitButton();
		totalinput	("13","2","3","2","6");	submitButton();
		totalinput	("21","5","3","4","9");	submitButton();
		totalinput	("26","9","6","2","9");	submitButton();
		totalinput	("10","2","3","2","3");	submitButton();
		totalinput	("20","5","2","8","5");	submitButton();
		totalinput	("16","2","6","5","3");	submitButton();
		totalinput	("26","5","8","5","8");	submitButton();
		totalinput	("24","2","8","8","6");	submitButton();
		totalinput	("26","2","9","6","9");	submitButton();
		totalinput	("23","2","9","1","9");	submitButton();
		totalinput	("14","2","3","3","6");	submitButton();
		totalinput	("14","4","1","2","7");	submitButton();
		totalinput	("25","6","5","8","6");	submitButton();
		totalinput	("13","3","1","1","8");	submitButton();
		totalinput	("18","4","3","5","6");	submitButton();
		totalinput	("12","3","1","1","7");	submitButton();
		totalinput	("20","6","3","8","3");	submitButton();
		totalinput	("24","5","6","5","8");	submitButton();
		totalinput	("10","2","2","1","5");	submitButton();
		totalinput	("7","2","3","1","1");	submitButton();
		totalinput	("7","3","3","1","0");	submitButton();
		totalinput	("16","2","3","6","5");	submitButton();
		totalinput	("7","2","4","1","0");	submitButton();
		totalinput	("7","4","2","1","0");	submitButton();
		totalinput	("6","3","2","0","1");	submitButton();
		totalinput	("10","8","1","1","0");	submitButton();
		totalinput	("11","4","1","1","5");	submitButton();
		totalinput	("22","5","6","4","7");	submitButton();
		totalinput	("7","5","1","0","1");	submitButton();
		totalinput	("9","6","2","1","0");	submitButton();
		totalinput	("10","6","3","1","0");	submitButton();
		totalinput	("12","4","1","1","6");	submitButton();
		totalinput	("4","2","1","1","0");	submitButton();
		totalinput	("6","2","1","2","1");	submitButton();
		totalinput	("13","4","1","1","7");	submitButton();
		totalinput	("5","2","2","0","1");	submitButton();
		totalinput	("4","1","1","1","1");	submitButton();
		totalinput	("5","2","2","1","0");	submitButton();
		totalinput	("13","5","3","2","3");	submitButton();
		totalinput	("10","4","1","1","4");	submitButton();
		totalinput	("14","1","4","1","8");	submitButton();
		totalinput	("17","6","3","5","3");	submitButton();
		totalinput	("13","1","4","1","7");	submitButton();
		totalinput	("20","5","6","4","5");	submitButton();
		totalinput	("23","9","3","5","6");	submitButton();
		totalinput	("26","5","6","9","6");	submitButton();
		totalinput	("26","6","6","8","6");	submitButton();
		totalinput	("19","2","3","5","9");	submitButton();
		totalinput	("8","1","2","2","3");	submitButton();
		totalinput	("9","2","2","3","2");	submitButton();
		totalinput	("5","1","1","2","1");	submitButton();
		totalinput	("6","1","2","3","0");	submitButton();
		totalinput	("7","1","3","2","1");	submitButton();
		totalinput	("8","3","2","1","2");	submitButton();
		totalinput	("10","4","1","2","3");	submitButton();
		totalinput	("9","3","4","1","1");	submitButton();
		totalinput	("7","1","1","2","3");	submitButton();
		totalinput	("8","1","3","2","2");	submitButton();
		totalinput	("9","3","2","1","3");	submitButton();
		totalinput	("11","1","1","4","5");	submitButton();
		totalinput	("8","1","1","2","4");	submitButton();
		totalinput	("9","6","0","1","2");	submitButton();
		totalinput	("12","2","1","8","1");	submitButton();
		totalinput	("9","2","2","1","4");	submitButton();
		totalinput	("10","3","1","2","4");	submitButton();
		totalinput	("7","2","1","2","2");	submitButton();
		totalinput	("8","1","3","4","0");	submitButton();
		totalinput	("12","1","1","4","6");	submitButton();
		totalinput	("6","2","2","1","1");	submitButton();
		totalinput	("8","2","3","2","1");	submitButton();
		totalinput	("13","2","4","1","6");	submitButton();
		totalinput	("14","5","2","4","3");	submitButton();
		totalinput	("4","1","1","0","2");	submitButton();
		totalinput	("3","1","1","1","0");	submitButton();
		totalinput	("24","6","6","4","8");	submitButton();
		totalinput	("26","5","8","8","5");	submitButton();
		totalinput	("25","4","7","8","6");	submitButton();
		totalinput	("18","5","3","2","8");	submitButton();
		totalinput	("20","6","3","9","2");	submitButton();
		totalinput	("23","5","6","4","8");	submitButton();
		totalinput	("24","5","9","5","5");	submitButton();
		totalinput	("25","6","8","5","6");	submitButton();
		totalinput	("26","6","8","7","5");	submitButton();
		totalinput	("23","7","2","8","6");	submitButton();
		totalinput	("24","8","4","7","5");	submitButton();
		totalinput	("21","6","5","5","5");	submitButton();
		totalinput	("25","9","8","5","2");	submitButton();
		totalinput	("23","5","7","5","6");	submitButton();
		totalinput	("19","5","6","2","6");	submitButton();
		totalinput	("22","5","6","5","6");	submitButton();
		totalinput	("19","5","3","2","9");	submitButton();
		totalinput	("24","5","8","5","6");	submitButton();
		totalinput	("16","5","3","2","6");	submitButton();
		totalinput	("19","2","6","2","9");	submitButton();
		totalinput	("18","5","5","2","6");	submitButton();
		totalinput	("19","8","3","5","3");	submitButton();
		totalinput	("22","3","8","5","6");	submitButton();
		totalinput	("20","5","4","5","6");	submitButton();
		totalinput	("25","5","6","5","9");	submitButton();
		totalinput	("18","3","7","2","6");	submitButton();
		totalinput	("16","2","9","2","3");	submitButton();
		totalinput	("4","1","1","1","1");	submitButton();
		totalinput	("19","9","5","3","2");	submitButton();
		totalinput	("12","6","2","3","1");	submitButton();
		totalinput	("14","2","5","3","4");	submitButton();
		totalinput	("5","2","2","1","0");	submitButton();
		totalinput	("7","5","1","1","0");	submitButton();
		totalinput	("8","5","1","2","0");	submitButton();
		totalinput	("9","5","3","1","0");	submitButton();
		totalinput	("5","1","2","1","1");	submitButton();
		totalinput	("10","5","4","1","0");	submitButton();
		totalinput	("6","3","1","2","0");	submitButton();
		totalinput	("5","3","1","1","0");	submitButton();
		totalinput	("8","2","2","2","2");	submitButton();
		totalinput	("12","4","4","2","2");	submitButton();
		totalinput	("10","3","3","2","2");	submitButton();
		totalinput	("18","5","5","4","4");	submitButton();
		totalinput	("12","3","3","3","3");	submitButton();
		totalinput	("14","5","5","2","2");	submitButton();
		totalinput	("18","4","4","5","5");	submitButton();
		totalinput	("16","4","4","4","4");	submitButton();
		totalinput	("10","4","4","1","1");	submitButton();
		totalinput	("20","5","5","5","5");	submitButton();
		totalinput	("6","3","2","1","0");	submitButton();
		totalinput	("9","3","3","1","2");	submitButton();
		totalinput	("7","5","1","1","0");	submitButton();
		totalinput	("16","6","2","5","3");	submitButton();

		driver.close();
	}
}
