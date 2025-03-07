package organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import POM_Repo.CreateOrganizationPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPageEx;
import POM_Repo.OrgLookUp;
import POM_Repo.OrgValidationPage;
import generic_Utility.Excel_Utility;
import generic_Utility.File_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.WebDriver_Utility;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib =new Excel_Utility();
		
		String browsername =flib.getCommondata("browsername");
		String url =flib.getCommondata("url");
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
		/*
		 * drv.manage().window().maximize();
		 * drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 */
		drv.get(url);
		/*
		 * drv.findElement(By.name("user_name")).sendKeys(flib.getCommondata("un"));
		 * drv.findElement(By.name("user_password")).sendKeys(flib.getCommondata("pw"));
		 * drv.findElement(By.id("submitButton")).click();
		 */
		LoginPageEx login = new LoginPageEx(drv);
		
		login.loginToApp(flib.getCommondata("un"), flib.getCommondata("pw"));
		
		HomePage hm = new HomePage(drv);
		hm.clickOrganizationLink();
		
		OrgLookUp lookUp = new OrgLookUp(drv);
		lookUp.CreateOrg();
		/*
		 * login.getPassWordTextField().sendKeys(flib.getCommondata("pw"));
		 * login.getLoginButton().click();
		 */
	    
		/*
		 * drv.findElement(By.linkText("Organizations")).click();
		 * drv.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		 */
		//---------------------------------------------------------------------------------
			
		int ranNum = jlib.getRandomValue();
		
		String OrgName = elib.getStringData("Sheet2", 0, 0) + ranNum;

		String phnNum = elib.readDataUsingDataFormatter("Sheet2", 1, 0);

		String mailId = elib.getStringData("Sheet2", 2, 0);

		CreateOrganizationPage orgPage = new CreateOrganizationPage(drv);
		orgPage.enterOrganizationData(OrgName, phnNum, mailId);
		orgPage.clickOnSaveButton();

		OrgValidationPage validate = new OrgValidationPage(drv);
		validate.orgValidation(drv, OrgName);

		hm.logOut();
	}

	/*
	 * //to fetch data from excel
	 * 
	 * String OrgName = elib.getStringData("Sheet2",0,0)+ranNum;
	 * drv.findElement(By.name("accountname")).sendKeys(OrgName);
	 * //---------------------------------------------------------------------------
	 * ---------------------
	 * 
	 * 
	 * 
	 * Row row1 = sheet.getRow(1); Cell cell1 = row1.getCell(0); DataFormatter
	 * format = new DataFormatter(); String PhoneNo = format.formatCellValue(cell1);
	 * System.out.println(PhoneNo);
	 * 
	 * String PhoneNo = elib.readDataUsingDataFormatter("Sheet2",1,0);
	 * 
	 * drv.findElement(By.id("phone")).sendKeys(PhoneNo);
	 * //---------------------------------------------------------------------------
	 * ----------------------)
	 * 
	 * String Email = elib.getStringData("Sheet2",2,0);
	 * 
	 * drv.findElement(By.id("email1")).sendKeys(Email);
	 * //----------------------------------------------
	 * drv.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 * Thread.sleep(2000);
	 * 
	 * String
	 * verdata=drv.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).
	 * getText();
	 * 
	 * if(verdata.contains(OrgName)) {
	 * System.out.println("Organization is created");
	 * 
	 * } else { System.out.println("Organization is not created");
	 * 
	 * } drv.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).
	 * click(); drv.findElement(By.xpath("//a[text()='Sign Out']")).click();
	 * 
	 * 
	 * 
	 * }
	 */

}
