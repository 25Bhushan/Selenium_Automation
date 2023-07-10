package excelTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader3 {
	
	@DataProvider(name="login")
	public String[][] getDataFromExcel() throws IOException
	{
		File file=new File("./src/test/resources/ExcelFile/OrangeHrmExcel.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int noOfRows=sheet.getPhysicalNumberOfRows();
		int noOfColums=sheet.getRow(0).getLastCellNum();
		
		String[][] data=new String[noOfRows-1][noOfColums];
		
		for(int i=0; i<noOfRows-1; i++)
		{
			for(int j=0; j<noOfColums; j++)
			{
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
				
			}
		}
		workbook.close();
		fis.close();
		return data;
		
	}

}
