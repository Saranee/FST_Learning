package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelExample {

	public static void main(String[] args) throws Exception {
		
		
		
		
		FileInputStream fis = new FileInputStream(".\\testData\\testData.xlsx");
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		
//		workbook.getSheetAt(0);
		XSSFSheet sheet = workbook.getSheet("sample");
		
		
		
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		
		
		//no of rows in excel file
		int rowCount = sheet.getLastRowNum();
		
		System.out.println("Row count:  " + (rowCount+1)); 
		System.out.println("columns count:  " + columnCount); 
		
		
		for (int i = 1; i <= rowCount; i++) {
			
			
			String firstname = sheet.getRow(i).getCell(0).toString();
			String address = sheet.getRow(i).getCell(1).toString();
			
			System.out.println("member details are: " + firstname + " : " + address);
			
//			for (int col = 0; col < columnCount; col++) {
//				
//				String celldata = sheet.getRow(i).getCell(col).toString();
//				
//			}
//			
			
			
			
			
		}
		

	}

}
