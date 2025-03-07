package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	public  HomePage(WebDriver drv)
	{
		PageFactory.initElements(drv, this);	
		}
	
	@FindBy(linkText = "Products")
	private WebElement productslink;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationlink;
	
	@FindBy(name = "Campaigns")
	private WebElement camplink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement admlink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	

	public WebElement getProductslink() {
		return productslink;
	}

	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getOrganizationlink() {
		return organizationlink;
	}

	public WebElement getCamplink() {
		return camplink;
	}

	public WebElement getAdmlink() {
		return admlink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void clickCamplink()
	{
		morelink.click();
		camplink.click();
	}
	
	public void logOut() {
		admlink.click();
		signOutLink.click();
	}
	
	public void clickPrdLink()
	{
		productslink.click();
	}
	
	public void clickCamp()
	{
		morelink.click();
		camplink.click();
	}
	public void clickOrganizationLink()
	{
		organizationlink.click();
	}
	/*
	 * public void logOut(WebDriver driver) { WebDriver_Utility wlib = new
	 * WebDriver_Utility(); wlib.moveToElement(driver, admlink);
	 * signOutLink.click(); }
	 */
	
}
