package testNG;

import org.testng.annotations.Test;

import POM_Repo.CreateOrganizationPage;
import POM_Repo.HomePage;
import POM_Repo.OrgLookUp;
import POM_Repo.OrgValidationPage;
import generic_Utility.BaseClassTest;

public class CreateOrganizationTest extends BaseClassTest {
	
	@Test(groups = "regressiontest")
	public void createOrgTest() throws Throwable {
		
		
		HomePage hm = new HomePage(drv);
		hm.clickOrganizationLink();
		
		OrgLookUp lookUp = new OrgLookUp(drv);
		lookUp.CreateOrg();
	
		int ranNum = jlib.getRandomValue();
		
		String OrgName = elib.getStringData("Sheet2", 0, 0) + ranNum;

		String phnNum = elib.readDataUsingDataFormatter("Sheet2", 1, 0);

		String mailId = elib.getStringData("Sheet2", 2, 0);

		CreateOrganizationPage orgPage = new CreateOrganizationPage(drv);
		orgPage.enterOrganizationData(OrgName, phnNum, mailId);
		orgPage.clickOnSaveButton();

		OrgValidationPage validate = new OrgValidationPage(drv);
		validate.orgValidation(drv, OrgName);

		//hm.logOut();
	}

}
