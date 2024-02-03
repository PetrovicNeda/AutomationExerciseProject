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

public class AddToCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
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
        cartPage = new CartPage();
    }

    @Test(priority = 10)
    public void userCanAddOneItemToCart() {
        homePage.clickOnProductsButton();
        driver.navigate().refresh();
        scrollToElement(productsPage.poloButton);
        productsPage.clickOnAddToCartButton(0);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.close-modal.btn-block")));
        Assert.assertTrue(productsPage.continueShoppingButton.isDisplayed());

        productsPage.clickOnViewCartButton();
        Assert.assertTrue(cartPage.products.get(0).isDisplayed());
    }

    @Test(priority = 20)
    public void userCanAddToCartMultipleItems() {
        homePage.clickOnProductsButton();
        driver.navigate().refresh();
        scrollToElement(productsPage.poloButton);
        productsPage.clickOnAddToCartButton(0);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.close-modal.btn-block")));
        Assert.assertTrue(productsPage.continueShoppingButton.isDisplayed());
        int counter = 1;
        for (int i = 1; i < 3; i++) {
            productsPage.clickOnContinueShoppingButton();
            productsPage.clickOnAddToCartButton(i);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.close-modal.btn-block")));
            Assert.assertTrue(productsPage.continueShoppingButton.isDisplayed());
            counter++;
        }
        productsPage.clickOnViewCartButton();
        for (int i = 0; i < counter; i++) {
            Assert.assertTrue(cartPage.products.get(i).isDisplayed());
        }
    }

    @Test(priority = 30)
    public void userCanAddOneItemMultipleTimes() {
        homePage.clickOnProductsButton();
        driver.navigate().refresh();
        scrollToElement(productsPage.poloButton);
        int counter = 0;
        for (int i = 0; i < 5; i++) {
            productsPage.clickOnAddToCartButton(0);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.close-modal.btn-block")));
            productsPage.clickOnContinueShoppingButton();
            counter++;
        }
        String counterAsString = Integer.toString(counter);
        productsPage.clickOnCartButton();
        Assert.assertEquals(cartPage.cartQuantity.getText(), counterAsString);
    }


    @AfterMethod
    public void removeFromCartAndTearDown() {
        for (int i = 0; i < cartPage.deleteButton.size(); i++) {
            cartPage.clickOnDeleteButton(i);
        }
        driver.quit();
    }

}
