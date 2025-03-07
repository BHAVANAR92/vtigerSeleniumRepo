package testNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import POM_Repo.CampLookUpImg;
import POM_Repo.CampValidatepage;
import POM_Repo.CreateCampaignePage;
import POM_Repo.HomePage;
import generic_Utility.BaseClassTest;

//@Listeners(generic_Utility.ListenersImp.class)
@Listeners(generic_Utility.ExtentReport.class)
public class CreateCampaignTest extends BaseClassTest {
//@Test(retryAnalyzer = generic_Utility.IRetryAnalyser.class)

	@Test(groups = "regressiontest")
	public void createCampaignTest() throws Throwable {

		HomePage home = new HomePage(drv);
		home.clickCamplink();
		Thread.sleep(3000);

		CampLookUpImg campImg = new CampLookUpImg(drv);
		campImg.clickCreateCampaign();

		// ------------------------------------------------------------------s
		int ranNum = jlib.getRandomValue();
		// ----------------------------------------------------------------
		// to fetch data from excel

		String campname = elib.getStringData("Sheet3", 0, 0) + ranNum;
		CreateCampaignePage campPage = new CreateCampaignePage(drv);
		campPage.enterCampName(campname);
		campPage.clickCampSaveButton();
		//Assert.fail("i am failing");
		Thread.sleep(2000);

		CampValidatepage validate = new CampValidatepage(drv);
		String actData = validate.ValidateCamp(drv);
		Assert.assertEquals(actData,campname );
		System.out.println("campname created");
		// home.logOut();
	}
	@Test
	public void m2() {
		System.out.println("hello");
	}
	/*
	 * @Test public void createCampWithProdTest() throws Throwable {
	 * 
	 * HomePage hm = new HomePage(drv); hm.clickPrdLink();
	 * 
	 * ProdLookUpImg img = new ProdLookUpImg(drv); img.prdLookUpImg();
	 * 
	 * 
	 * int ranNum = jlib.getRandomValue();
	 * 
	 * //to fetch data from excel
	 * 
	 * String prodname = elib.getStringData("Sheet4",0,0)+ranNum; CreateProdPage
	 * prod = new CreateProdPage(drv); prod.enterPrdName(prodname);
	 * prod.clickSaveButton();
	 * 
	 * hm.clickCamp();
	 * 
	 * CampLookUpImg lookUp1 = new CampLookUpImg(drv);
	 * lookUp1.clickCreateCampaign();
	 * 
	 * String campname = elib.getStringData("Sheet4",1,0)+ranNum;
	 * CreateCampaignePage campPage = new CreateCampaignePage(drv);
	 * campPage.enterCampName(campname);
	 * 
	 * WindowSwitchingPage window = new WindowSwitchingPage(drv);
	 * window.clickPrdPlusSign(); wlib.windowSwitching(drv, "Products&action");
	 * window.enterPrdName(prodname); window.clickprdSearchBar();
	 * window.selectPrdName(drv, prodname); wlib.windowSwitching(drv,
	 * "Campaigns&action"); campPage.clickCampSaveButton();
	 * 
	 * Thread.sleep(3000); CampValidatepage Validatecamp = new
	 * CampValidatepage(drv); Validatecamp.ValidateCamp(drv, campname);
	 * Validatecamp.ValidatePrd(drv, prodname);
	 * 
	 * 
	 * }
	 * 
	 * @Test public void createProductTest() throws Throwable { File_Utility flib =
	 * new File_Utility(); Java_Utility jlib = new Java_Utility(); Excel_Utility
	 * elib = new Excel_Utility(); WebDriver_Utility wlib = new WebDriver_Utility();
	 * 
	 * wlib.maximizeWindow(drv); wlib.loadTheElements(drv);
	 * drv.get(flib.getCommondata("url"));
	 * 
	 * 
	 * LoginPageEx login = new LoginPageEx(drv);
	 * login.loginToApp(flib.getCommondata("un"), flib.getCommondata("pw"));
	 * 
	 * 
	 * HomePage hm = new HomePage(drv); hm.clickPrdLink();
	 * 
	 * ProdLookUpImg prdImg = new ProdLookUpImg(drv); prdImg.prdLookUpImg(); int
	 * ranNum = jlib.getRandomValue(); CreateProdPage prdpage = new
	 * CreateProdPage(drv); String prodname = elib.getStringData("Sheet4", 0, 0) +
	 * ranNum; prdpage.enterPrdName(prodname); prdpage.clickSaveButton();
	 * Thread.sleep(3000); ProductValidatePage validate = new
	 * ProductValidatePage(drv); validate.ValidatePrd(drv, prodname);
	 * Thread.sleep(3000); }
	 * 
	 * @Test public void test() { System.out.println("Hi Hello"); }
	 */

}
