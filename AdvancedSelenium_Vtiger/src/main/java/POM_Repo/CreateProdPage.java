package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProdPage {
	public CreateProdPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productName;
	
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	public void enterPrdName(String name)
	{
		productName.sendKeys(name);
	}
	
	public void clickSaveButton()
	{
		
		saveButton.click();
	}

}
