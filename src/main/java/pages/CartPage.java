/*
 * CartPage represents the shopping cart view where added items are displayed.
 */
package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;
    
    public CartPage(WebDriver driver) {
        this.driver=driver;
    }
    
    // Locators
    private By cartItemContainer = By.cssSelector("div.cart_item");
    private By checkoutButtonBy = By.id("checkout");
    
    
    /**
     * Returns the total number of items currently displayed in the cart.
     */
    public int getNumberOfItemInCart() {
        // cart_item कंटेनर को ढूंढकर, आइटम की संख्या रिटर्न करें
        return driver.findElements(cartItemContainer).size();
    }
    
    /**
     * Checks if a specific product (by name) is present in the cart.
     */
    public boolean isProductInCart(String productName) {
        // XPath जो विशिष्ट प्रोडक्ट नाम को सीधे कार्ट कंटेनर में ढूंढता है
        String itemXPath = String.format("//div[@class='inventory_item_name' and text()='%s']", productName);
        
        List<WebElement> items = driver.findElements(By.xpath(itemXPath));
        return items.size() > 0;
    }
    
    /**
     * Removes a product from the cart by its name.
     */
    public void removeProductByName(String productName) {
        // XPath to find the specific item row and click its 'Remove' button.
        String removeButtonXpath = String.format(
            "//div[text()='%s']/ancestor::div[@class='cart_item']//button[text()='Remove']", 
            productName);
        
        driver.findElement(By.xpath(removeButtonXpath)).click();
        System.out.println(productName + " removed from cart successfully.");
    }

    /**
     * Clicks the Checkout button to proceed to the next step.
     */
    public void clickCheckout() {
    	driver.findElement(checkoutButtonBy).click();
    	System.out.println("Clicked Checkout");
    }
}