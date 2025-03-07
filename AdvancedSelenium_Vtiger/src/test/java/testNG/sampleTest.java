package testNG;

import org.testng.annotations.Test;

public class sampleTest {
	
	@Test
	public void createProduct() {
		
		System.out.println("product is created");
	}
	
	@Test(dependsOnMethods = "createProduct",priority = 1)
	public void modifyProduct() {
		System.out.println("product is modified");
	}

	@Test(dependsOnMethods = "createProduct",priority = 0)
	public void deleteProduct() {
		System.out.println("product is deleted");
	}

}
