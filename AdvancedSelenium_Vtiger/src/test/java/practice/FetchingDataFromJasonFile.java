package practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FetchingDataFromJasonFile {

	public static void main(String[] args) throws Throwable {
		File file = new File("./src/test/resources/jasondata.jason");
		ObjectMapper obj = new ObjectMapper();
		JsonNode data = obj.readTree(file);
		
		String BROWSER =data.get("browser").asText();
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
		
		
	}

}
