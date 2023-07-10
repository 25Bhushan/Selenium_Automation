package seleniumpraticecodes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFormControl extends BaseClass{

	public static void openBrowser() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(1000);
	}
	
	public static void selectDropDownValue(WebElement element, String dropDownValue)
	{
		Select select=new Select(element);
		select.selectByVisibleText(dropDownValue);
	}

	
	public static void enterFormData(String fName, String LName, String add, String emailId, String phoneNo, String gender,
			String checkBoxesChoice1, String checkBoxesChoice2, String pass, String cPass) throws Exception
	{
		WebElement firstName=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		highlightElement(firstName);
		firstName.clear();
		firstName.sendKeys(fName);
		Thread.sleep(750);
		
		WebElement lastName=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		highlightElement(lastName);
		lastName.clear();
		lastName.sendKeys(LName);
		Thread.sleep(750);
		
		WebElement address=driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
		highlightElement(address);
		address.clear();
		address.sendKeys(add);
		Thread.sleep(750);
		
		WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
		highlightElement(email);
		email.clear();
		email.sendKeys(emailId);
		Thread.sleep(750);
		
		WebElement phone=driver.findElement(By.xpath("//input[@type='tel']"));
		highlightElement(phone);
		phone.clear();
		phone.sendKeys(phoneNo);
		Thread.sleep(750);
		
		//Radio Buttons
		List<WebElement> allRedioButton=driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Total number of radio button : "+allRedioButton.size());  //2
		
		for(int i=0; i<allRedioButton.size(); i++)
		{
			System.out.println(allRedioButton.get(i).getAttribute("value"));
			if(allRedioButton.get(i).getAttribute("value").equalsIgnoreCase(gender))
			{
				allRedioButton.get(i).click();
			}
		}
		
System.out.println("===============================================================================");
		
		//Check Boxes
		List<WebElement> allCheckBoxes= driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Total Number of Check Boxes : "+allCheckBoxes.size());
		
		for(int i=0; i<allCheckBoxes.size(); i++)
		{
			System.out.println(allCheckBoxes.get(i).getAttribute("value"));
			if(allCheckBoxes.get(i).getAttribute("value").equalsIgnoreCase(checkBoxesChoice1))
			{
				allCheckBoxes.get(i).click();
			}
			else if(allCheckBoxes.get(i).getAttribute("value").equalsIgnoreCase(checkBoxesChoice2))
			{
				allCheckBoxes.get(i).click();
			}
		}
		
System.out.println("===============================================================================");	

//language DropDown
		WebElement selectLanguageDropDown=driver.findElement(By.id("msdd"));
		highlightElement(selectLanguageDropDown);
		selectLanguageDropDown.click();
		Thread.sleep(2000);
		
		List<WebElement> allLanguages=driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li"));
		for(WebElement language:allLanguages)
		{
			String langName=language.getText();
			System.out.println("Language is extrected is : "+langName);
			
			if(language.getText().equalsIgnoreCase("Catalan"))
			{
				language.click();
				break;
			}
		}

System.out.println("===============================================================================");	

		WebElement skillsDropDown=driver.findElement(By.id("Skills"));
		highlightElement(skillsDropDown);
		selectDropDownValue(skillsDropDown, "Android");
		
//country DropDown
		
		WebElement selectConuntryDropDown=	driver.findElement(By.xpath("//span[@role='combobox']"));
		highlightElement(selectConuntryDropDown);
		selectConuntryDropDown.click();	
		
		List<WebElement> allCountries =driver.findElements(By.xpath("//ul[@id='select2-country-results']/li"));
		for(WebElement country:allCountries)
		{
			String countryName=country.getText();
			System.out.println("Coutry name is extracted is : "+countryName);
			if(country.getText().equalsIgnoreCase("India"))
			{
				country.click();
				break;
			}
		}

/*
		WebElement skillsDropDown=driver.findElement(By.id("Skills"));
		Select s=new Select(skillsDropDown);
		List<WebElement> skillValues=s.getOptions();
		System.out.println("The total number of drop down value are : "+skillValues.size());
		
//		s.selectByVisibleText("Analytics");	//select by visible text method will use select value as name
//		s.selectByIndex(3);				//select by index method will use select value as number
		s.selectByValue("Analytics");	//select by value method will use select value as attribute value
*/		
		
//Date of Birth Calendar DropDown
		
		WebElement yearDropDown=driver.findElement(By.id("yearbox"));
		highlightElement(yearDropDown);
		selectDropDownValue(yearDropDown, "1999");
//		Select s2=new Select(yearDropDown);
//		s2.selectByVisibleText("1999");
		
		WebElement monthDropDown=driver.findElement(By.xpath("//select[@placeholder='Month']"));
		highlightElement(monthDropDown);
		selectDropDownValue(monthDropDown, "November");
//		Select s3=new Select(monthDropDown);
//		s3.selectByVisibleText("November");
		
		WebElement dayDropDown=driver.findElement(By.id("daybox"));
		highlightElement(dayDropDown);
		selectDropDownValue(dayDropDown, "15");
//		Select s4=new Select(dayDropDown);
//		s4.selectByVisibleText("15");
		
		WebElement password=driver.findElement(By.xpath("//input[@id='firstpassword']"));
		highlightElement(password);
		password.clear();
		password.sendKeys(pass);
		Thread.sleep(750);
		
		WebElement confirmPassword=driver.findElement(By.xpath("//input[@id='secondpassword']"));
		highlightElement(confirmPassword);
		confirmPassword.clear();
		confirmPassword.sendKeys(cPass);
		Thread.sleep(750);
		
		WebElement submitButton=driver.findElement(By.xpath("//button[@id='submitbtn']"));
		highlightElement(submitButton);
		submitButton.click();
		
	}
	
	public static void main(String[] args) throws Exception {
		openBrowser();
		enterFormData("Bhushan", "Dhole", "flat no 10 gangai Pune", "bhushan@test", "9874563210", "Female", "Cricket", "movies", "Bhushu123", "Bhushu123");
		
		Thread.sleep(5000);
		closeBrowser();
	}

}
