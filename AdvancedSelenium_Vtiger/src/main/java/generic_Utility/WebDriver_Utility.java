package generic_Utility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	

	public void loadTheElements(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void windowSwitching(WebDriver driver,String partialTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> allWins = driver.getWindowHandles();// win1,win2
		Iterator<String> it = allWins.iterator();

		
		while (it.hasNext()) {
			String win = it.next();
			
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
			}
public static String takeScreenShotEx(WebDriver driver, String screenShotName) throws Throwable {
		
		TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName +".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
}



