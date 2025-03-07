package generic_Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	public String getStringData(String sheetName,int rowNum,int cellNum ) throws Throwable
	{
		FileInputStream file =new FileInputStream("./src/test/resources/exceldatafetch.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetName);
		Row r = sh.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		return c.getStringCellValue();
			
	}
	public String readDataUsingDataFormatter(String sheetName,int rowNum,int cellNum ) throws Throwable
	{
		FileInputStream file =new FileInputStream("./src/test/resources/exceldatafetch.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sh = book.getSheet(sheetName);
		Row r = sh.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		DataFormatter format =new DataFormatter();
		String Exceldata = format.formatCellValue(c);
		
		return Exceldata;		
	}
	

}
