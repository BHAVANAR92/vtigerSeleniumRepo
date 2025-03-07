package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageEx {
	    //Initialization
		public LoginPageEx(WebDriver driver)
		{
		PageFactory.initElements(driver, this);	
		}
		
		// Declaration
		@FindBy(name = "user_name")
		private WebElement UserTextField;

		@FindBy(name = "user_password")
		private WebElement PassWordTextField;

		@FindBy(id = "submitButton")
		private WebElement loginButton;

		//getter methods
		public WebElement getUserTextField() {
			return UserTextField;
		}

		public WebElement getPassWordTextField() {
			return PassWordTextField;
		}

		public WebElement getLoginButton() {
			return loginButton;
		}
		
		
		public void loginToApp(String username,String password)
		{
			UserTextField.sendKeys(username);
			PassWordTextField.sendKeys(password);
			loginButton.click();
		}
		

	}


