package com.realestatecrm;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRMTC.ExelHandlingUtil;

public class NewTest {
	String filepath="D:\\Apmosys\\loginExcle.xlsx";
	ExelHandlingUtil exelutil;
@DataProvider
public Object[][] dataprovider() throws IOException
{   
	exelutil=new ExelHandlingUtil();
	return exelutil.getexceldata(filepath ,"sheet1");
}
	
	
  @Test(dataProvider="dataprovider")
  public void newtest(String username,String password) throws IOException {
	 
	System.out.println(username+" "+password); 
}
}
