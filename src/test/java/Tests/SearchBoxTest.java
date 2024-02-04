package Tests;

import BaseTest.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchBoxTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
        loginPage.logIn();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        productsPage = new ProductsPage();
        homePage.clickOnProductsButton();
        closeVignette();
        homePage.clickOnProductsButton();
        productDetailsPage = new ProductDetailsPage();
        categoryProductsPage = new CategoryProductsPage();
    }

    @Test(priority = 10)
    public void verifyThatWhenUserSearchForSpecificSubcategoryOnlyItemsFromThatSubcategoryAreDisplayed() {
        productsPage.inputTextInSearchBox("dress");
        productsPage.clickOnSearchButton();
        closeVignette();
        productDetailsPage.checkingItemsInSubcategory("Dress");
    }
}
