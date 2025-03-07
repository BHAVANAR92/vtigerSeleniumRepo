package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	
	@Test
	public void m1() {
		System.out.println("hi");
		System.out.println("hello");
		Assert.assertEquals("HI", "HELLO");
		System.out.println("hard assert");
		
		
	}
	@Test
	public void m2() {
		System.out.println("hi");
		System.out.println("hello");
		String exp ="Bhavana";
		String act ="Bhavana";
		Assert.assertEquals(act,exp);
	}
	
	
	@Test
	public void m3() {
		System.out.println("hi");
		int a =10;
		int b=20;
		Assert.assertEquals(b, a,"not equaal");
		System.out.println("both are equal");
	}
	
	@Test
	public void m4() {
		System.out.println("hi");
		int a =10;
		int b=10;
		Assert.assertEquals(b, a,"not equaal");
		System.out.println("both are equal");
	}
	@Test
	public void m5() {
	
		int a =10;
		int b=20;
		Assert.assertNotEquals(b, a,"equaal");
		System.out.println("not equal");

}
	@Test
	public void m6() {
		
		int a =10;
		int b=10;
		Assert.assertNotEquals(b, a,"equaal");
		System.out.println("not  equal");

}
}

