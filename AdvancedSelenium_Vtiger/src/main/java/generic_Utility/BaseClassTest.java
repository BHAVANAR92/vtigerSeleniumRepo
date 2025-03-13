package generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;

public class BaseClassTest {
	
	public WebDriver drv ;
	public static WebDriver sdriver;
	public WebDriver_Utility wlib = new WebDriver_Utility();
	public File_Utility flib = new File_Utility();
	public Excel_Utility elib =new Excel_Utility();
	public Java_Utility jlib = new Java_Utility();
	@BeforeSuite(groups = {"smoketest","regressiontest"})
	public void BS() {
		System.out.println("DB connection");
	}

	@BeforeTest(groups = {"smoketest","regressiontest"})
	public void BT() {
		System.out.println("Parallel execution");
	}
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smoketest","regressiontest"})
//	public void BC(String BROWSER) throws Throwable {
		
		//File_Utility flib = new File_Utility();
       
        public void BC() throws Throwable{
        
        String BROWSER = flib.getCommondata("browsername");
		//String BROWSER = System.getProperty("browsername");
        
        if (BROWSER.equalsIgnoreCase("chrome")) {
        	ChromeOptions options = new ChromeOptions();
        	options.addArguments("--window-size=1920,1080");
        	// Comment out headless mode for debugging
        	// options.addArguments("--headless"); 
        	drv = new ChromeDriver(options);
			//drv = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			drv = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			drv = new FirefoxDriver();
		} else {
			drv = new ChromeDriver();
		}
        sdriver = drv;
		System.out.println("Launching Browser");
	}

	@BeforeMethod(groups = {"smoketest","regressiontest"})
	public void BM() throws Throwable {
		
		File_Utility flib = new File_Utility();
	    String url =flib.getCommondata("url");
		String username =flib.getCommondata("un");
		String password =flib.getCommondata("pw");
		
		/*
		 * String url = System.getProperty("url"); String username
		 * =System.getProperty("un"); String password =System.getProperty("pw");
		 */
		//WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(drv);
		wlib.loadTheElements(drv);
		drv.get(url);
		
		LoginPageEx login = new LoginPageEx(drv);
		login.loginToApp(username, password);
		
		
		System.out.println("Login to App");
	}

	@AfterMethod(groups = {"smoketest","regressiontest"})
	public void AM() throws InterruptedException {
		HomePage home = new HomePage(drv);
		Thread.sleep(2000);
		home.logOut();
		System.out.println("Logout from App");
	}

	@AfterClass(groups = {"smoketest","regressiontest"})
	public void AC() {
		System.out.println("Close the browser");
	}

	@AfterTest(groups = {"smoketest","regressiontest"})
	public void AT() {
		System.out.println("Parallel execution");
	}

	@AfterSuite(groups = {"smoketest","regressiontest"})
	public void AS() {
		System.out.println("DB Connection close");
	}

}
