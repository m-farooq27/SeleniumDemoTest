package Selenium.demoqa.tests;

import Selenium.demo.qa.base.Base;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import Selenium.demoqa.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

public class HomePageTest extends Base {
	
	private HomePage homePage;
	
	@BeforeMethod
	public void initializePage() {
		super.setUp();
		homePage = new HomePage(driver);
	}
	
	@Test
	public void verifyHomePageLoadsSuccessfully() {
		assertTrue(homePage.isHomePageLoaded(),"Home page should load with header and footer visible");
	}
	
	@Test
	public void verifyAllMainCardsAreVisible() {
		assertTrue(homePage.isCardVisible("elements"),"Elements card should be visible");
		assertTrue(homePage.isCardVisible("forms"),"Forms card should be visible");
		assertTrue(homePage.isCardVisible("alerts"),"Alerts card should be visible");
		assertTrue(homePage.isCardVisible("widgets"),"Widgets card should be visible");
		assertTrue(homePage.isCardVisible("interactions"),"Interactions card should be visible");
		assertTrue(homePage.isCardVisible("book store"),"Book store card should be visible");
	}
	
	@Test
	public void testNavigationToElementsSection() {
		homePage.clickCard("elements");
		assertTrue(driver.getPageSource().contains("Elements"),"Should navigate to Elements section");
	}
	
	@AfterMethod
	public void cleanUp() {
		super.tearDown();
	}
}