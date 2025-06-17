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
    @FindBy(xpath = "//span[text()='Text Box']")
    private WebElement textBoxOption;

    @FindBy(xpath = "//span[text()='Check Box']")
    private WebElement checkBoxOption;

    @FindBy(xpath = "//span[text()='Radio Button']")
    private WebElement radioButtonOption;

    @FindBy(xpath = "//span[text()='Web Tables']")
    private WebElement webTablesOption;

    @FindBy(xpath = "//span[text()='Buttons']")
    private WebElement buttonsOption;

    @FindBy(xpath = "//span[text()='Links']")
    private WebElement linksOption;

    @FindBy(xpath = "//span[text()='Broken Links - Images']")
    private WebElement brokenLinksOption;

    @FindBy(xpath = "//span[text()='Upload and Download']")
    private WebElement uploadDownloadOption;

    @FindBy(xpath = "//span[text()='Dynamic Properties']")
    private WebElement dynamicPropertiesOption;

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