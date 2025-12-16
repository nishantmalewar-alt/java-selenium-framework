package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod; 
import java.time.Duration;

/**
 * Base class for all Selenium tests. 
 * Handles WebDriver initialization (setup) and cleanup (teardown).
 */
public class Basetest {
	
	// WebDriver instance jise sabhi test classes access karengi
	protected WebDriver driver;
	
	/**
     * Initializes WebDriver, applies Chrome options (Incognito), and opens the application URL.
     */
	@BeforeMethod
	public void setUp() {
		
		// Step 1: ChromeOptions object create karna
	    ChromeOptions options = new ChromeOptions();
	    
	    // ----------------------------------------------------
	    // ✅ Incognito Mode on karna
	    options.addArguments("--incognito");
	    // ----------------------------------------------------
	    
	    // Step 2: Options ke saath ChromeDriver ko initialize karna
	    driver = new ChromeDriver(options); 
	    
	    // Step 3: Driver settings
	    driver.manage().window().maximize();
	    // Implicit Wait ko wapas rakhein (15 seconds)
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    driver.get("https://www.saucedemo.com/");
	    
	}

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Browser band karna
        }
    }
}


