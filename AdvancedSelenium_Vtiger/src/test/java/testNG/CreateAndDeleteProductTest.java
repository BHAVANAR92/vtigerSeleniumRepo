package testNG;

import org.testng.annotations.Test;

import POM_Repo.CreateProdPage;
import POM_Repo.DeletePrd;
import POM_Repo.HomePage;
import POM_Repo.ProdLookUpImg;
import generic_Utility.BaseClassTest;

public class CreateAndDeleteProductTest extends BaseClassTest {
	
	@Test(groups = "smoketest")
	public void createAndDeleteProductTest() throws Throwable {
		
		HomePage hm = new HomePage(drv);
		hm.clickPrdLink();

		ProdLookUpImg prdImg = new ProdLookUpImg(drv);
		prdImg.prdLookUpImg();
		int ranNum = jlib.getRandomValue();
		CreateProdPage prdpage = new CreateProdPage(drv);
		String prodname = elib.getStringData("Sheet4", 0, 0) + ranNum;
		prdpage.enterPrdName(prodname);
		prdpage.clickSaveButton();

		hm.clickPrdLink();

		DeletePrd delete = new DeletePrd(drv);
		delete.selectPrdCheckBox(drv, prodname);

		delete.clickOnDeleteButton();
		wlib.alertAccept(drv);

		delete.ValidatePrdName(drv, prodname);
		Thread.sleep(1000);

		
	}

}
