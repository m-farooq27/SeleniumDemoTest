package Selenium.demoqa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Selenium.demo.qa.base.Base;
import Selenium.demoqa.pages.ElementsPage;
import Selenium.demoqa.pages.HomePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ElementsPageTest extends Base {

    private static final Logger log = LogManager.getLogger(ElementsPageTest.class);

    @Test
    public void verifyElementsPageLoadsAndTextBoxOptionIsVisible() {
        log.info("Test: Verify Elements page loads and Text Box option is visible");

        // Step 1: Navigate to HomePage and click on 'Elements'
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Home page did not load.");
        log.info("Home page loaded successfully");

        homePage.clickCard("elements");
        log.info("Clicked on 'Elements' card");

        // Step 2: Verify 'Text Box' option is visible
        ElementsPage elementsPage = new ElementsPage(driver);
        boolean isVisible = elementsPage.isElementOptionVisible("text box");
        log.info("Is 'Text Box' option visible: {}", isVisible);
        Assert.assertTrue(isVisible, "'Text Box' option should be visible");
    }

    @Test
    public void verifyClickOnWebTablesOption() {
        log.info("Test: Click on 'Web Tables' option from Elements page");

        // Navigate to Elements page
        HomePage homePage = new HomePage(driver);
        homePage.clickCard("elements");
        log.info("Navigated to Elements section");

        ElementsPage elementsPage = new ElementsPage(driver);
        Assert.assertTrue(elementsPage.isElementOptionVisible("web tables"), "'Web Tables' option should be visible");

        elementsPage.clickElementOption("web tables");
        log.info("Clicked on 'Web Tables' option");

        String pageTitle = elementsPage.getElementsPageTitle();
        log.info("Current page title after clicking: {}", pageTitle);
        Assert.assertTrue(pageTitle.contains("ToolsQA"), "Unexpected page title: " + pageTitle);
    }
}
