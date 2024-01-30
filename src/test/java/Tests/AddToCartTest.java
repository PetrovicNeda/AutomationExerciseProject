package Tests;

import BaseTest.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
        String validEmail = "neda@mail.com";
        String validPassword = "neda123!";
        loginPage.inputEmail(validEmail);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.logoutButton.isDisplayed());
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        productsPage = new ProductsPage();

    }
    @Test(priority = 10)
    public void userCanAddOneItemToCart(){
        homePage.clickOnProductsButton();
        driver.navigate().refresh();
        scrollToElement(productsPage.poloButton);
        productsPage.hoverOverFirstProduct();
        productsPage.clickOnFirstAddToCartButton();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.close-modal.btn-block")));

        Assert.assertTrue(productsPage.continueShoppingButton.isDisplayed());


    }
}
