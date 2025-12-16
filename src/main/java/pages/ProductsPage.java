/*
 * ProductsPage (Inventory Page) represents the page where all products are listed 
 * after a successful login.
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * POM class for the Products inventory page after successful login.
 * Manages product listings, adding items to cart, and navigation to cart.
 */

public class ProductsPage {

    private WebDriver driver;
    
    // constructor 
    public ProductsPage(WebDriver driver) {
        this.driver= driver;    
    }
    
    // Cart Icon / Cart Badge locator
    private By cartIcon = By.cssSelector("a.shopping_cart_link");
    
    // Cart Badge locator (jo count dikhata hai)
    private By shoppingCartBadge = By.cssSelector("a.shopping_cart_link span.shopping_cart_badge");
    
    
    // Methods: Elements par Actions
    
    /**
     * Clicks the 'Add to cart' button for the specific product by name.
     */
    public void addProductByName(String name) {
        
        // Final Correct XPath: यह XPath प्रोडक्ट के नाम से चलता है और सीधे 'Add to cart' data-test ID वाले बटन को क्लिक करता है।
    	String buttonXPath = String.format(
    	        "//div[contains(@class, 'inventory_item_name') and contains(text(), '%s')]/ancestor::div[@class='inventory_item_description']//button[contains(@data-test, 'add-to-cart')]", 
    	        name);
    	
            try {
                driver.findElement(By.xpath(buttonXPath)).click();
                System.out.println(name + " added to cart successfully.");
                
            } catch (Exception e) {
                System.err.println("Error: Could not find 'Add to cart' button for " + name);
                throw e;
            }
        }
    
    /**
     * Navigates the user from the Products page to the Shopping Cart page.
     */
    public void goToCart() {
        driver.findElement(cartIcon).click();
        System.out.println("Navigated to the Cart page.");
    }
    
    /**
     * Returns the count displayed on the shopping cart badge (e.g., "1", "2").
     * @throws InterruptedException 
     */
    
    
    public String getCartBadgeCount() throws InterruptedException {
        try {
            // Agar badge exist karta hai, uska text return karo
        	Thread.sleep(1000);
            return driver.findElement(shoppingCartBadge).getText();
        } catch (Exception e) {
            // Agar cart empty hai aur badge nahi dikhta, toh "0" return karein
            return "0";
        }
    }
}