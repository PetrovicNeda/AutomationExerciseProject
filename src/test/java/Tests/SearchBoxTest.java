package Tests;

import BaseTest.BaseTest;
import Pages.CategoryProductsPage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.LoginPage.USER_EMAIL;
import static Pages.LoginPage.USER_PASSWORD;

public class SearchBoxTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        loginPage.logInAndAssert(USER_EMAIL, USER_PASSWORD);
        productsPage = new ProductsPage();
        clickOnElementAndCloseVignette(homePage.productsButton);
        productDetailsPage = new ProductDetailsPage();
        categoryProductsPage = new CategoryProductsPage();
    }

    @Test(priority = 10)
    public void verifyThatWhenUserSearchForSpecificSubcategoryOnlyItemsFromThatSubcategoryAreDisplayed() {
        productsPage.inputTextInSearchBox("dress");
        clickOnElementAndCloseVignette(productsPage.searchButton);
        productDetailsPage.checkingItemsInSubcategory("Dress");
    }
}
