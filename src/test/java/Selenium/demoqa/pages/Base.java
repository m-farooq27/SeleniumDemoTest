package Selenium.demoqa.pages;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import Selenium.demoqa.utilities.PropertiesHandler;


public class Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		String browserType = PropertiesHandler.get("browserType").toLowerCase();
		String applicationUnderTest = PropertiesHandler.get("applicationUnderTest");
		int timeout = PropertiesHandler.getInt("timeout", 10);
		
		switch (browserType) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default: //default browser
			System.out.println("Unsupported browser - defaulting to Chrome");
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.get(applicationUnderTest);
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
 
}