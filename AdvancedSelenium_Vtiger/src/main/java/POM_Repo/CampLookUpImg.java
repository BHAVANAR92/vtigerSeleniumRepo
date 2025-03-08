package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//This class helps to create the caampaigne look up image locater
public class CampLookUpImg {

	public CampLookUpImg(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement lookUpImage;
	
	
	public WebElement getLookUpImage() {
		return lookUpImage;
	}


	public void clickCreateCampaign() {
		lookUpImage.click();
	}

}
