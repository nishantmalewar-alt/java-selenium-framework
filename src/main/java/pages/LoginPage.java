/*
 * LoginPage represents the login page of the Sauce Demo application.
 * Contains methods for user login and logout functionality.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    
    private WebDriver driver;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");
    private By errorMessageBy = By.cssSelector("div.error-message-container h3");
    
    
    /**
     * Enters credentials and clicks the login button.
     */
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    
    /**
     * Logs out the user from the application using the side menu.
     */
    public void logout() {
    	try {
            driver.findElement(menuButton).click();
             Thread.sleep(1500);
             driver.findElement(logoutLink).click();
             Thread.sleep(1000); // Wait for logout to process

    	}catch (Exception e) {
			System.out.println("Logout failed: " + e.getMessage());
		}
    }
    
    /**
     * Returns the text of the error message displayed after a failed login attempt.
     */
    public String getErrorMessage() {
        return driver.findElement(errorMessageBy).getText();
    }
}
