package excelTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader2 {

	public static void main(String[] args) throws IOException  {
		
		File file=new File("C:\\Users\\Dell\\eclipse-workspace\\MySeleniumCodes\\src\\test\\resources\\ExcelFile\\OrangeHrmExcel.xlsx");
		System.err.println(file.exists());
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//number of row
		int noOfRow=sheet.getPhysicalNumberOfRows();
		//no of Cell
		int noOfColumns=sheet.getRow(0).getLastCellNum();
		
		String[][] data=new String[noOfRow-1][noOfColumns];
		
		//if you write i=0 then it will print userName and password so start index from 1
		
		for(int i=0; i<noOfRow-1; i++)
		{
			for(int j=0; j<noOfColumns; j++)
			{
				//we use this to print our data in String --even you pass integer in excel
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		for(String[] dataArry : data)
		{
			System.out.println(Arrays.toString(dataArry));
		}
//		System.out.println(Arrays.toString(data));
	}

}
