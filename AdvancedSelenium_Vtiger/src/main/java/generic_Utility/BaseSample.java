package generic_Utility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseSample {
	
	@BeforeSuite(groups = {"smoketest","regressiontest"})
	public void BS() {
		System.out.println("BS");
	}

	@BeforeTest(groups = {"smoketest","regressiontest"})
	public void BT() {
		System.out.println("BT");
	}

	@BeforeClass(groups = {"smoketest","regressiontest"})
	public void BC() throws Throwable {

		System.out.println("BC");
	}

	@BeforeMethod(groups = {"smoketest","regressiontest"})
	public void BM() throws Throwable {
		

		
		
		System.out.println("BM");
	}

	@AfterMethod(groups = {"smoketest","regressiontest"})
	public void AM() throws InterruptedException {

		System.out.println("AM");
	}

	@AfterClass(groups = {"smoketest","regressiontest"})
	public void AC() {
		System.out.println("AC");
	}

	@AfterTest(groups = {"smoketest","regressiontest"})
	public void AT() {
		System.out.println("AT");
	}

	@AfterSuite(groups = {"smoketest","regressiontest"})
	public void AS() {
		System.out.println("AS");
	}


}
