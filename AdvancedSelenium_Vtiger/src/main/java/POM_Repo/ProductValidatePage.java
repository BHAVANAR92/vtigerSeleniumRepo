package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductValidatePage {
	
	 public ProductValidatePage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }
	    

	    public void ValidatePrd(WebDriver driver,String prdName)
		{
			String data = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

			if (data.contains(prdName)) {
				System.out.println("Product name is created");
			} else {
				System.out.println("Product name is not created");
			}
		}

}
