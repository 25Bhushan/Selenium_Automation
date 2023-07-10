package excelTestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader1 {

	public static void main(String[] args) throws IOException {
		
		File file=new File("D:\\Apmosys\\OrangeHrmExcel.xlsx");
		System.out.println(file.exists());
		FileInputStream fis=new FileInputStream(file);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int noOfRow=sheet.getPhysicalNumberOfRows();
		
		int noOfColumns=sheet.getRow(0).getLastCellNum();
		
		for(int i=1; i<noOfRow; i++)
		{
			for(int j=0; j<noOfColumns; j++)
			{
				System.out.println(sheet.getRow(i).getCell(j).getRichStringCellValue());
			}
		
		}
		

	}

}
