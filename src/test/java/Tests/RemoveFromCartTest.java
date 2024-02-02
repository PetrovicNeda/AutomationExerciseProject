package Tests;

import BaseTest.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RemoveFromCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
        loginPage.logIn();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        homePage.clickOnProductsButton();
        driver.navigate().refresh();
        productsPage.addItemToCartAndOpetCart();
    }

    @Test(priority = 10)
    public void userCanRemoveItemFromCart(){
        for (int i = 0; i < cartPage.deleteButton.size(); i++) {
            cartPage.clickOnDeleteButton(i);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empty_cart")));
        Assert.assertTrue(cartPage.emptyCart.isDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
