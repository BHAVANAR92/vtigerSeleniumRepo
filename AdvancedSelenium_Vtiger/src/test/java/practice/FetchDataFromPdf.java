package practice;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;






public class FetchDataFromPdf {

	public static void main(String[] args) throws Throwable {
		File file = new File("");
		
		PDDocument doc = PDDocument.load(file);
		int pages = doc.getNumberOfPages();
		PDFTextStripper pdfdata = new PDFTextStripper();
		

	}

}
