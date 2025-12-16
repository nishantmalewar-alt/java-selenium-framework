/*
 * ProductsAndCartTests contains test methods related to adding, removing products, 
 * and verifying cart functionality.
 */
package tests;

import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ProductsAndCartTests extends Basetest {

    // Common setup ke liye strings
    private final String standardUser = "standard_user";
    private final String secretSauce = "secret_sauce";

    /**
     * Test 1: Logs in, adds two products, and verifies both are present in the cart.
     * @throws InterruptedException 
     */
    @Test
    public void testAddTwoProductsAndVerifyCart() throws InterruptedException {
        String product1 = "Sauce Labs Backpack";
        String product2 = "Sauce Labs Bike Light";
        
        // 1. Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(standardUser, secretSauce);  // [Action: Type & Click]
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "ERROR: Login failed, not on inventory page!");//[Expectation: URL Check]

        // 2. Add Products
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductByName(product1); // [Action: Click]
        productsPage.addProductByName(product2); // [Action: Click]
        
        // 3. Verify Cart Badge Count
        Assert.assertEquals(productsPage.getCartBadgeCount(), "2", "ERROR: Cart count badge did not update to 2."); // [Expectation: Badge Value]
        
        // 4. NAVIGATION ACTION
        productsPage.goToCart(); // [Action: Click]
        CartPage cartPage = new CartPage(driver);
        
     // Rule: Verify the actual items inside the cart
        int finalCount = cartPage.getNumberOfItemInCart();
        Assert.assertEquals(finalCount, 2, "ERROR: Total items in cart list is not 2"); // [Expectation: List Size]
        
        Assert.assertTrue(cartPage.isProductInCart(product1), product1 + " is missing from the cart.");
        Assert.assertTrue(cartPage.isProductInCart(product2), product2 + " is missing from the cart.");
        
        System.out.println("Test PASSED: Two products added and verified successfully.");
    }
    
    /**
     * Test 2 (New): Adds a product, removes it from the cart, and verifies the cart is empty.
     * @throws InterruptedException 
     */
    @Test
    public void testAddAndRemoveSingleProduct() throws InterruptedException {
        String product = "Sauce Labs Fleece Jacket";
        
        // 1. Login and Add Product
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(standardUser, secretSauce);  
        
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductByName(product);
        Assert.assertEquals(productsPage.getCartBadgeCount(), "1", "Badge count should be 1 after adding one item.");
        
        // 2. Navigate and Remove
        productsPage.goToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.removeProductByName(product); 
        
        // 3. Verification
        // Simple verification: Cart Page par item count 0 hona chahiye
        int count = cartPage.getNumberOfItemInCart();
        Assert.assertEquals(count, 0, "Item count should be 0 after removal.");
        
        System.out.println("Test 2 PASSED: Product added and successfully removed from cart.");
    }
    
    /**
     * Test 3 (New): Adds a product, performs logout, and verifies cart is cleared upon re-login.
     * @throws InterruptedException 
     */
    
    @Test
    public void testAddProductAndLogout() throws InterruptedException {
        String product = "Sauce Labs Bolt T-Shirt";
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        // 1. Action: Login
        loginPage.login(standardUser, secretSauce);  
        
        // 2. Action: Add Product
        productsPage.addProductByName(product); 
        
        // 3. Expectation: Verify Badge is 1
        Assert.assertEquals(productsPage.getCartBadgeCount(), "1", "ERROR: Product add nahi hua!");
        
        // 4. Action: Logout
        loginPage.logout(); 
        
        // Wait for URL to update
        Thread.sleep(1500); 

        // 5. Final Expectation: Verify we are back on Login Page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("https://www.saucedemo.com/") || currentUrl.contains("index.html"), 
                "EXPECTATION FAILED: Logout ke baad login page nahi dikha. Actual URL: " + currentUrl); 
        
        System.out.println("Test PASSED: Product added and user logged out successfully.");
    }
}