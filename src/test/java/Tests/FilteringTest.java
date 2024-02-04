package Tests;

import BaseTest.BaseTest;
import Pages.CategoryProductsPage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.LoginPage.USER_EMAIL;
import static Pages.LoginPage.USER_PASSWORD;

public class FilteringTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        loginPage.logInAndAssert(USER_EMAIL, USER_PASSWORD);
        productsPage = new ProductsPage();
        clickOnElementAndCloseVignette(homePage.productsButton);
        scrollToElement(productsPage.category.get(0));
        categoryProductsPage = new CategoryProductsPage();
        productDetailsPage = new ProductDetailsPage();
    }

    @Test(priority = 10)
    public void verifyThatItemsInSubcategoryDressesAreDresses() {
        productsPage.clickOnCategory(0);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/category_products/1'")));
        productsPage.clickOnDressSubcategoryButton();
        productDetailsPage.checkingItemsInSubcategory("Dress");
    }

    @Test(priority = 20)
    public void verifyThatItemsInSubcategoryTopsAreTops() {
        productsPage.clickOnCategory(0);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/category_products/1'")));
        productsPage.clickOnTopsSubcategoryButton();
        productDetailsPage.checkingItemsInSubcategory("Tops");
    }

    @Test(priority = 30)
    public void verifyThatItemsInSubcategoryTShirtsAreTShirts() {
        productsPage.clickOnCategory(1);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/category_products/3'")));
        productsPage.clickOnTShirtsSubcategoryButton();
        productDetailsPage.checkingItemsInSubcategory("Tshirts");
    }
}
