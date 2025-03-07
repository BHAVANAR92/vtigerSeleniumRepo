package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToPrintAllPhoneNames {

	public static void main(String[] args) {
		WebDriver drv = new ChromeDriver();
		drv.get("https://www.flipkart.com/");
		WebElement ele = drv.findElement(By.name("q"));
		ele.sendKeys("Iphone");
		drv.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		List<WebElement> phoneList = drv.findElements(By.xpath("//div[@class='KzDlHZ']"));
		for(WebElement e:phoneList) {
			System.out.println(e.getText());
		}
	}

}
