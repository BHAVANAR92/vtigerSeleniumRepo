package testNG;

import org.testng.annotations.Test;

import POM_Repo.CreateProdPage;
import POM_Repo.HomePage;
import POM_Repo.ProdLookUpImg;
import POM_Repo.ProductValidatePage;
import generic_Utility.BaseClassTest;
import generic_Utility.Excel_Utility;
import generic_Utility.File_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.WebDriver_Utility;

public class CreateProductTest extends  BaseClassTest{
	
	@Test(groups = "regressiontest")
	public void createProductTest() throws Throwable {
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

		wlib.maximizeWindow(drv);
		wlib.loadTheElements(drv);
		drv.get(flib.getCommondata("url"));
		
		/*
		 * LoginPageEx login = new LoginPageEx(drv);
		 * login.loginToApp(flib.getCommondata("un"), flib.getCommondata("pw"));
		 */

		HomePage hm = new HomePage(drv);
		hm.clickPrdLink();

		ProdLookUpImg prdImg = new ProdLookUpImg(drv);
		prdImg.prdLookUpImg();
		int ranNum = jlib.getRandomValue();
		CreateProdPage prdpage = new CreateProdPage(drv);
		String prodname = elib.getStringData("Sheet4", 0, 0) + ranNum;
		prdpage.enterPrdName(prodname);
		prdpage.clickSaveButton();
		Thread.sleep(3000);
		ProductValidatePage validate = new ProductValidatePage(drv);
		validate.ValidatePrd(drv, prodname);
		Thread.sleep(3000);
	}

}
