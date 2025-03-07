package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Repo.CampLookUpImg;
import POM_Repo.CampValidatepage;
import POM_Repo.CreateCampaignePage;
import POM_Repo.CreateProdPage;
import POM_Repo.HomePage;
import POM_Repo.ProdLookUpImg;
import POM_Repo.WindowSwitchingPage;
import generic_Utility.BaseClassTest;

public class CreateCampaignWithProductTest extends BaseClassTest {
	
	@Test(groups = "smoketest")
	public void createCampWithProdTest() throws Throwable {
		
		HomePage hm = new HomePage(drv);
		hm.clickPrdLink();
		
		ProdLookUpImg img = new ProdLookUpImg(drv);
		img.prdLookUpImg();
		
				
		int ranNum = jlib.getRandomValue();
		
		//to fetch data from excel
		
		String prodname = elib.getStringData("Sheet4",0,0)+ranNum;
		CreateProdPage prod = new CreateProdPage(drv);
		prod.enterPrdName(prodname);
		prod.clickSaveButton();
		
		hm.clickCamp();
		
		CampLookUpImg lookUp1 = new CampLookUpImg(drv);
		lookUp1.clickCreateCampaign();

		String campname = elib.getStringData("Sheet4",1,0)+ranNum;
		CreateCampaignePage campPage = new CreateCampaignePage(drv);
		campPage.enterCampName(campname);
		
		WindowSwitchingPage window = new WindowSwitchingPage(drv);
		window.clickPrdPlusSign();
		wlib.windowSwitching(drv, "Products&action");
		window.enterPrdName(prodname);
		window.clickprdSearchBar();
		window.selectPrdName(drv, prodname);
		wlib.windowSwitching(drv, "Campaigns&action");
		campPage.clickCampSaveButton();
		
		Thread.sleep(3000);
		CampValidatepage ValidateCamp = new CampValidatepage(drv);
		String actData = ValidateCamp.ValidateCamp(drv);
		Assert.assertEquals(actData,campname);
		
		CampValidatepage Validate = new CampValidatepage(drv);
		Validate.ValidatePrd(drv, prodname);
		Validate.ValidateCam(drv, campname);

		
	}

}
