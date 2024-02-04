package Tests;

import BaseTest.BaseTest;
import Pages.CartPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.LoginPage.USER_EMAIL;
import static Pages.LoginPage.USER_PASSWORD;

public class AddToCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        loginPage.logInAndAssert(USER_EMAIL, USER_PASSWORD);
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        clickOnElementAndCloseVignette(homePage.productsButton);
        scrollToElement(productsPage.poloButton);
    }

    @Test(priority = 10)
    public void userCanAddOneItemToCart() {
        productsPage.clickOnAddToCartButton(0);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.close-modal.btn-block")));
        Assert.assertTrue(productsPage.continueShoppingButton.isDisplayed());

        productsPage.clickOnViewCartButton();
        Assert.assertTrue(cartPage.products.get(0).isDisplayed());
    }

    @Test(priority = 20)
    public void userCanAddToCartMultipleItems() {

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
    public void removeFromCart() {
        for (int i = 0; i < cartPage.deleteButton.size(); i++) {
            cartPage.clickOnDeleteButton(i);
        }
    }
}
