package demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BookStorePage {

    WebDriver driver;
    private static final Logger log = LogManager.getLogger(BookStorePage.class);

    public BookStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Search input box to filter books
    @FindBy(xpath = "//*[@id=\"searchBox\"]")
    private WebElement searchBox;

    // List of book titles in the table (2nd column of each row)
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[1]")
    private List<WebElement> bookTitles;

    // Method to enter search text
    public void searchBook(String bookName) {
        log.info("Searching for book: " + bookName);
        searchBox.clear();
        searchBox.sendKeys(bookName);
    }

    // Method to check if a book title is present in the current filtered results
    public boolean isBookPresent(String bookName) {
        log.info("Checking presence of book: " + bookName);
        for (WebElement title : bookTitles) {
            if (title.getText().equalsIgnoreCase(bookName)) {
                log.info("Book found: " + bookName);
                return true;
            }
        }
        log.warn("Book NOT found: " + bookName);
        return false;
    }

    public void clickBook(String bookName) {
        log.info("Clicking on book: " + bookName);
        for (WebElement title : bookTitles) {
            if (title.getText().equalsIgnoreCase(bookName)) {
                title.click();
                log.info("Clicked on book: " + bookName);
                return;
            }
        }
        log.error("Book not found to click: " + bookName);
        throw new RuntimeException("Book not found: " + bookName);
    }
}