package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingDtaFormatter {

	public static void main(String[] args) throws Throwable {
		FileInputStream file =new FileInputStream("./src/test/resources/exceldatafetch.xlsx");
		Workbook book = WorkbookFactory.create(file);
		  Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		DataFormatter format = new DataFormatter();
		String exceldata = format.formatCellValue(cell);
		System.out.println(exceldata);

	}

}
