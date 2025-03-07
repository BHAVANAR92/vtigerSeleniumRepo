package organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import POM_Repo.CampValidatepage;
import POM_Repo.CreateProdPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.ProdLookUpImg;
import generic_Utility.Excel_Utility;
import generic_Utility.File_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.WebDriver_Utility;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

		String browsername = flib.getCommondata("browsername");
		flib.getCommondata("url");
		flib.getCommondata("un");
		flib.getCommondata("pw");
		WebDriver drv;
		if (browsername.equalsIgnoreCase("chrome")) {
			drv = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("edge")) {
			drv = new EdgeDriver();

		} else {
			drv = new ChromeDriver();

		}
		wlib.maximizeWindow(drv);
		wlib.loadTheElements(drv);
		

		LoginPageEx login = new LoginPageEx(drv);
		login.loginToApp(flib.getCommondata("un"), flib.getCommondata("pw"));

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
		CampValidatepage validate = new CampValidatepage(drv);
		validate.ValidatePrd(drv, prodname);
		hm.logOut();
	}
}
