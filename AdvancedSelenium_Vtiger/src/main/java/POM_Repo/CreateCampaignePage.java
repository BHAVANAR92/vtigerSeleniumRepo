package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignePage {

	public CreateCampaignePage(WebDriver drv)
	{
		PageFactory.initElements(drv, this);	
	}
	
	@FindBy(name="campaignname")
	private WebElement campaignName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(WebElement campaignName) {
		this.campaignName = campaignName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(WebElement saveButton) {
		this.saveButton = saveButton;
	}
	
	public void enterCampName(String campName) {
		campaignName.sendKeys(campName);
		//saveButton.click();
	}
	public void clickCampSaveButton()
	{
		saveButton.click();
	}
	
}
