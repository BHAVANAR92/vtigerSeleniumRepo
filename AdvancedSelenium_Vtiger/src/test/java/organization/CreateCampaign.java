package organization;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import POM_Repo.CampLookUpImg;
import POM_Repo.CampValidatepage;
import POM_Repo.CreateCampaignePage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import generic_Utility.Excel_Utility;
import generic_Utility.File_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.WebDriver_Utility;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable 
	{
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		Excel_Utility elib =new Excel_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		//------------------------------------------------------------------------------
		String browsername =flib.getCommondata("browsername");
		String url =flib.getCommondata("url");
		String username =flib.getCommondata("un");
		String password =flib.getCommondata("pw");
		//----------------------------------------------------------------------------------
		WebDriver drv;
		//---------------------------------------------------------------------------------
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
		//------------------------------------------------------------------------------------
		wlib.maximizeWindow(drv);
		wlib.loadTheElements(drv);
		//------------------------------------------------------------------------------------
		drv.get(url);
		//-----------------------------------------------------------------------------------
		
		LoginPageEx login = new LoginPageEx(drv);
		login.loginToApp(username, password);
		//------------------------------------------------------------------------------------
		
		HomePage home = new HomePage(drv);
		home.clickCamplink();
		Thread.sleep(3000);
		CampLookUpImg campImg = new CampLookUpImg(drv);
		campImg.clickCreateCampaign();
			
		//------------------------------------------------------------------
		int ranNum = jlib.getRandomValue();
		//----------------------------------------------------------------
		//to fetch data from excel
		
		String campname = elib.getStringData("Sheet3",0,0)+ranNum;
		CreateCampaignePage campPage = new CreateCampaignePage(drv);
		campPage.enterCampName(campname);
		campPage.clickCampSaveButton();	
		Thread.sleep(2000);
				
		CampValidatepage validate = new CampValidatepage(drv);
		String actData = validate.ValidateCamp(drv);
		Assert.assertEquals(actData, campname);
		System.out.println("campname is creATED");
		home.logOut();
		
	}
}
	

