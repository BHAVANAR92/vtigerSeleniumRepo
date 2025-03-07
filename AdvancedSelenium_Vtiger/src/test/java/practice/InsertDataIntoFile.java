package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InsertDataIntoFile {

	public static void main(String[] args) throws Throwable  {
		
		
		//keeping properties file in read mode
		Properties pro = new Properties();
		pro.setProperty("browser", "edge");
		pro.setProperty("URL", "https://www.flipkart.com/");
		
		//give the path in file output stream where we have to add the data or inserting data into properties file
		FileOutputStream fos =new FileOutputStream("./src/test/resources/credentials.properties");
		pro.store(fos, "commondata");
		
		FileInputStream fis = new FileInputStream("./src/test/resources/credentials.properties");
		pro.load(fis);
		String BROWSER =pro.getProperty("browser");
		String URL=pro.getProperty("URL");
		System.out.println(BROWSER);
		System.out.println(URL);
		
		WebDriver drv;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			drv = new ChromeDriver();
			
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			drv = new EdgeDriver();
			
		}
		else
		{
			drv = new ChromeDriver();
			
		}
		drv.get(URL);
		

	}

}
