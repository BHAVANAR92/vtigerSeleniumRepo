package organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import POM_Repo.CampLookUpImg;
import POM_Repo.CampValidatepage;
import POM_Repo.CreateCampaignePage;
import POM_Repo.CreateProdPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.ProdLookUpImg;
import POM_Repo.WindowSwitchingPage;
import generic_Utility.Excel_Utility;
import generic_Utility.File_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.WebDriver_Utility;

public class CreateCAmpaignWithProduct {

	public static void main(String[] args) throws Throwable
	{
		
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib =new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		
		
		String browsername =flib.getCommondata("browsername");
		flib.getCommondata("url");
		flib.getCommondata("un");
		flib.getCommondata("pw");
		
		
		WebDriver drv;
		if(browsername.equalsIgnoreCase("chrome"))
		{
			drv = new ChromeDriver();
			
		}
		else if (browsername.equalsIgnoreCase("edge"))
		{
			drv = new EdgeDriver();
			
		}
		else
		{
			drv = new ChromeDriver();
			
		}
		wlib.maximizeWindow(drv);
		wlib.loadTheElements(drv);
		drv.get(flib.getCommondata("url"));

		LoginPageEx login = new LoginPageEx(drv);
		login.loginToApp(flib.getCommondata("un"), flib.getCommondata("pw"));

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
		
		/*
		 * drv.findElement(By.name("productname")).sendKeys(prodname);
		 * drv.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
		 * drv.findElement(By.linkText("More")).click();
		 * drv.findElement(By.linkText("Campaigns")).click();
		 * drv.findElement(By.cssSelector("[title=\"Create Campaign...\"]")).click();
		 */
		
		
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
		
		CampValidatepage Validatecamp = new CampValidatepage(drv);
		Validatecamp.ValidateCamp(drv);
		Validatecamp.ValidatePrd(drv, prodname);

		hm.logOut();
	}
}


		
	