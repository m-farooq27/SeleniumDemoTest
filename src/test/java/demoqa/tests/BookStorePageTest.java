package demoqa.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import demoqa.base.Base;
import demoqa.pages.BookStorePage;




public class BookStorePageTest extends Base {

    @Test
    public void testSearchBook() {
        BookStorePage bookStorePage = new BookStorePage(driver);

        String bookToSearch = "Git Pocket Guide";

        bookStorePage.searchBook(bookToSearch);
        Assert.assertTrue(bookStorePage.isBookPresent(bookToSearch), "Book should be present in the list.");
    }

    @Test
    public void testClickBook() {
        BookStorePage bookStorePage = new BookStorePage(driver);

        String bookToClick = "Learning JavaScript Design Patterns";

        bookStorePage.searchBook(bookToClick);
        Assert.assertTrue(bookStorePage.isBookPresent(bookToClick), "Book should be present before clicking.");

        bookStorePage.clickBook(bookToClick);

    }
}