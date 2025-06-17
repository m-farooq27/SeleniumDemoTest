package Selenium.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage {
	WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	//Locators
	By logo = By.cssSelector("img[alt='ToolsQA']");
	By footer = By.cssSelector(".footer-text");
	
	By elementsCard = By.xpath("//h5[text()='Elements']");
	By formsCard = By.xpath("//h5[text()='Forms']");
	By alertsCard = By.xpath("//h5[text()='Alerts, Frame & Windows']");
	By widgetsCard = By.xpath("//h5[text()='Widgets']");
	By interactionsCard = By.xpath("//h5[text()='Interactions']");
	By bookStoreCard = By.xpath("//h5[text()='Book Store Application']");
	
	//Page Actions
	
	public boolean isLogoVisible() {
		return driver.findElement(logo).isDisplayed();
	}
	
	public boolean isFooterVisible() {
		return driver.findElement(footer).isDisplayed();
	}
	
	public boolean isCardVisible(String cardName) {
		switch (cardName.toLowerCase()) {
		case "elements":
			return driver.findElement(elementsCard).isDisplayed();
		case "forms":
			return driver.findElement(formsCard).isDisplayed();
		case "alerts":
			return driver.findElement(alertsCard).isDisplayed();
		case "widgets":
			return driver.findElement(widgetsCard).isDisplayed();
		case "interactions":
			return driver.findElement(interactionsCard).isDisplayed();
		case "book store":
			return driver.findElement(bookStoreCard).isDisplayed();
		default:
			throw new IllegalArgumentException("Unknown card name: " + cardName);
		}
	}
	
	public void clickCard(String cardName) {
		switch (cardName.toLowerCase()) {
			case "elements":
				driver.findElement(elementsCard).click();
				break;
			case "forms":
				driver.findElement(formsCard).click();
				break;
			case "alerts":
				driver.findElement(alertsCard).click();
				break;
			case "widgets":
				driver.findElement(widgetsCard).click();
				break;
			case "interactions":
				driver.findElement(interactionsCard).click();
				break;
			case "book store":
				driver.findElement(bookStoreCard).click();
				break;
			default:
				throw new IllegalArgumentException("Unknown card name: " + cardName);
		
		}
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean isHomePageLoaded() {
		return isLogoVisible() && isFooterVisible();
	}
}
