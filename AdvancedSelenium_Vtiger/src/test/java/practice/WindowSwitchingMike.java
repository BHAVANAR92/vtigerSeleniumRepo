package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSwitchingMike {

	public static void main(String[] args) throws Throwable
	{
		WebDriver drv = new ChromeDriver();
		
		drv.get("https://mictests.com/");
		 drv.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		drv.findElement(By.xpath("//button[text()='Test my mic']")).click();
        Alert sa =drv.switchTo().alert();
        System.out.println("The simple alert pop is " +sa.getText());
		//sa.accept();
		drv.close();
		

	}

}
