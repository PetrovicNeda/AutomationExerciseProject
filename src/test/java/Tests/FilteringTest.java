package Tests;

import BaseTest.BaseTest;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FilteringTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
        loginPage.logIn();
        productsPage = new ProductsPage();
        homePage.clickOnProductsButton();
        driver.navigate().refresh();
        scrollToElement(productsPage.category.get(0));
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        categoryProductsPage = new CategoryProductsPage();
        productDetailsPage = new ProductDetailsPage();

    }
    @Test(priority = 10)
    public void verifyThatItemsInSubcategoryDressesAreDresses(){
        productsPage.clickOnCategory(0);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/category_products/1'")));
        productsPage.clickOnDressCategoryButton();
        for(int i = 0; i < categoryProductsPage.viewProductButtons.size();i++){
            categoryProductsPage.clickOnViewProductButton(i);
            String text = productDetailsPage.dressCategory.getText();
            Assert.assertTrue(text.contains("Dress"));
            driver.navigate().back();
        }


    }

}