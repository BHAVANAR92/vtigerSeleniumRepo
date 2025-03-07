package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdLookUpImg {
	public ProdLookUpImg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[alt=\"Create Product...\"]")
	private WebElement productdlookUp;
	
	public void prdLookUpImg()
	{
		productdlookUp.click();
	}

}
