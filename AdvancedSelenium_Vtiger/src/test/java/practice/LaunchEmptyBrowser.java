package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchEmptyBrowser {

	public static void main(String[] args) {
		
		WebDriver drv = new ChromeDriver();
		drv.close();
		

	}

}
