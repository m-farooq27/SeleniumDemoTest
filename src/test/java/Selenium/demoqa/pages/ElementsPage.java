package Selenium.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ElementsPage {

    private static final Logger log = LogManager.getLogger(ElementsPage.class);
    private WebDriver driver;

    // Constructor initializes elements
    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("ElementsPage initialized using PageFactory");
    }

    // Web Elements (sidebar options in the Elements section)
    @FindBy(xpath = "//*[@id=\"item-0\"]") private WebElement textBoxOption;

    @FindBy(xpath = "//*[@id=\"item-1\"]") private WebElement checkBoxOption;

    @FindBy(xpath = "//*[@id=\"item-2\"]") private WebElement radioButtonOption;

    @FindBy(xpath = "//*[@id=\"item-3\"]") private WebElement webTablesOption;

    @FindBy(xpath = "//*[@id=\"item-4\"]") private WebElement buttonsOption;

    @FindBy(xpath = "//*[@id=\"item-5\"]") private WebElement linksOption;

    @FindBy(xpath = "//*[@id=\"item-6\"]") private WebElement brokenLinksOption;

    @FindBy(xpath = "//*[@id=\"item-7\"]") private WebElement uploadDownloadOption;

    @FindBy(xpath = "//*[@id=\"item-8\"]") private WebElement dynamicPropertiesOption;

    // Actions

    public boolean isElementOptionVisible(String optionName) {
        log.info("Checking visibility of element option: {}", optionName);
        switch (optionName.toLowerCase()) {
            case "text box": return textBoxOption.isDisplayed();
            case "check box": return checkBoxOption.isDisplayed();
            case "radio button": return radioButtonOption.isDisplayed();
            case "web tables": return webTablesOption.isDisplayed();
            case "buttons": return buttonsOption.isDisplayed();
            case "links": return linksOption.isDisplayed();
            case "broken links": return brokenLinksOption.isDisplayed();
            case "upload and download": return uploadDownloadOption.isDisplayed();
            case "dynamic properties": return dynamicPropertiesOption.isDisplayed();
            default:
                log.error("Invalid option name: {}", optionName);
                throw new IllegalArgumentException("Unknown option: " + optionName);
        }
    }

    public void clickElementOption(String optionName) {
        log.info("Clicking on element option: {}", optionName);
        switch (optionName.toLowerCase()) {
            case "text box": textBoxOption.click(); break;
            case "check box": checkBoxOption.click(); break;
            case "radio button": radioButtonOption.click(); break;
            case "web tables": webTablesOption.click(); break;
            case "buttons": buttonsOption.click(); break;
            case "links": linksOption.click(); break;
            case "broken links": brokenLinksOption.click(); break;
            case "upload and download": uploadDownloadOption.click(); break;
            case "dynamic properties": dynamicPropertiesOption.click(); break;
            default:
                log.error("Invalid option name for click: {}", optionName);
                throw new IllegalArgumentException("Unknown option: " + optionName);
        }
    }

    public String getElementsPageTitle() {
    	String title = driver.getTitle();
    	log.info("Elements page title is: {}", title);
    	return title;
    }
}