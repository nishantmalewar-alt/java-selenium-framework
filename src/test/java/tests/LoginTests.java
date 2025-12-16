package tests;


import pages.LoginPage;
import org.testng.annotations.Test; 
import org.testng.Assert;
public class LoginTests extends Basetest{
	
	// Test Case 1: Valid Login (Standard User)
	@Test
	public void testSuccessfulLogin() {
		//object 
		
		LoginPage loginPage =new LoginPage(driver);
		loginPage.login("standard_user","secret_sauce");
		
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        
        Assert.assertEquals(actualUrl, expectedUrl, "Valid login ke baad URL Inventory page ka hona chahiye.");
    }
		
	
	// Test Case 2: Invalid Login (Wrong Credentials)
    @Test
    public void testInvalidLogin() {
    	//object
    	LoginPage loginPage=new LoginPage(driver);
    	loginPage.login("wrong_user", "wrong_password");
    	
    	String expectedError ="Epic sadface: Username and password do not match any user in this service";
    	String actualError =loginPage.getErrorMessage();
    	
    	Assert.assertEquals(actualError, expectedError , "Invalid login par sahi error message dikhna chahiye.");
  
    }
		

}
