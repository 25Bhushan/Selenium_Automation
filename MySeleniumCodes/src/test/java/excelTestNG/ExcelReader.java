package excelTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) throws IOException {
		
		File file=new File("D:\\Apmosys\\OrangeHrmExcel.xlsx");
		System.out.println(file.exists());  //true	
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		//Number of row	
		int onOfRow =sheet.getPhysicalNumberOfRows();
		System.out.println(onOfRow);
		
		//get the complete row number using index(0,1,2,3---last one is 2)
		System.out.println(sheet.getLastRowNum());
		
		//no of cell
		int noOfColumns =sheet.getRow(0).getLastCellNum();
		System.out.println(noOfColumns);
		
		workbook.close();
		fis.close();

	}

}
