package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserChoiceDdt {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/credentials.properties");
		//load all keys from properties file
		Properties pro =new Properties();
		pro.load(fis);
		//getting keys from properties file
		String BROWSER =pro.getProperty("browser");
		String URL=pro.getProperty("url");
		String UN=pro.getProperty("username");
		String PWD=pro.getProperty("password");
		
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
		drv.findElement(By.name("user-name")).sendKeys(UN);
		drv.findElement(By.id("password")).sendKeys(PWD);
		drv.findElement(By.id("login-button")).click();
		
		
	}

}
