package seleniumpraticecodes;

interface WebElement2
{
	WebElement2 findElement2(By2 by2);
	//methods
}

class By2 implements WebElement2
{
	static By2 id2(String id2)
	{
		return new By2();
	}

	static By2 name2(String name2)
	{
		return new By2();
	}

	static By2 Xpath2(String Xpath2)
	{
		return new By2();
	}

	public WebElement2 findElement2(By2 by2)
	{
		return null;
	}
}

interface WebDriver2
{
	WebElement2 findElement2(By2 by2);
}

class ChromeDriver2 implements WebDriver2, WebElement2
{
	public WebElement2 findElement2(By2 by2)
	{
		return new ChromeDriver2();
	}
}

