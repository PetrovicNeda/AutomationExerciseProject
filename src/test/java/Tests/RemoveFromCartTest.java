package Tests;

import BaseTest.BaseTest;
import Pages.CartPage;
import Pages.ProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.LoginPage.USER_EMAIL;
import static Pages.LoginPage.USER_PASSWORD;

public class RemoveFromCartTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        loginPage.logInAndAssert(USER_EMAIL, USER_PASSWORD);
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        clickOnElementAndCloseVignette(homePage.productsButton);
        productsPage.addItemToCartAndOpetCart();
    }

    @Test(priority = 10)
    public void userCanRemoveItemFromCart() {
        for (int i = 0; i < cartPage.deleteButton.size(); i++) {
            cartPage.clickOnDeleteButton(i);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empty_cart")));
        Assert.assertTrue(cartPage.emptyCart.isDisplayed());
    }
}
