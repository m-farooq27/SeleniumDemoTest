package Selenium.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    private WebDriver driver;

    // Constructor: initializes elements using PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.info("HomePage initialized with PageFactory");
    }

    // Locators using @FindBy
    @FindBy(css = "img[alt='ToolsQA']")
    private WebElement logo;

    @FindBy(css = ".footer-text")
    private WebElement footer;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsCard;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsCard;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsCard;

    @FindBy(xpath = "//h5[text()='Widgets']")
    private WebElement widgetsCard;

    @FindBy(xpath = "//h5[text()='Interactions']")
    private WebElement interactionsCard;

    @FindBy(xpath = "//h5[text()='Book Store Application']")
    private WebElement bookStoreCard;

    // Page Actions

    public boolean isLogoVisible() {
        boolean visible = logo.isDisplayed();
        log.info("Logo visible: {}", visible);
        return visible;
    }

    public boolean isFooterVisible() {
        boolean visible = footer.isDisplayed();
        log.info("Footer visible: {}", visible);
        return visible;
    }

    public boolean isCardVisible(String cardName) {
        log.info("Checking card visibility: {}", cardName);
        switch (cardName.toLowerCase()) {
            case "elements":
                return elementsCard.isDisplayed();
            case "forms":
                return formsCard.isDisplayed();
            case "alerts":
                return alertsCard.isDisplayed();
            case "widgets":
                return widgetsCard.isDisplayed();
            case "interactions":
                return interactionsCard.isDisplayed();
            case "book store":
                return bookStoreCard.isDisplayed();
            default:
                log.error("Invalid card name: {}", cardName);
                throw new IllegalArgumentException("Unknown card name: " + cardName);
        }
    }

    public void clickCard(String cardName) {
        log.info("Clicking card: {}", cardName);
        switch (cardName.toLowerCase()) {
            case "elements":
                elementsCard.click();
                break;
            case "forms":
                formsCard.click();
                break;
            case "alerts":
                alertsCard.click();
                break;
            case "widgets":
                widgetsCard.click();
                break;
            case "interactions":
                interactionsCard.click();
                break;
            case "book store":
                bookStoreCard.click();
                break;
            default:
                log.error("Invalid card name clicked: {}", cardName);
                throw new IllegalArgumentException("Unknown card name: " + cardName);
        }
    }

    public String getHomePageTitle() {
        String title = driver.getTitle();
        log.info("Page title: {}", title);
        return title;
    }

    public boolean isHomePageLoaded() {
        boolean loaded = isLogoVisible() && isFooterVisible();
        log.info("Home page loaded status: {}", loaded);
        return loaded;
    }
}

