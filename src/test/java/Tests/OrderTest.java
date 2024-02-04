package Tests;

import BaseTest.BaseTest;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.PaymentPage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static Pages.LoginPage.USER_EMAIL;
import static Pages.LoginPage.USER_PASSWORD;

public class OrderTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        loginPage.logInAndAssert(USER_EMAIL, USER_PASSWORD);
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();
        clickOnElementAndCloseVignette(homePage.productsButton);
        productsPage.addItemToCartAndOpetCart();
    }

    @Test(priority = 10)
    public void userCanOrderItem() throws IOException {
        cartPage.clickOnProceedToCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/checkout");
        scrollToElement(checkoutPage.placeOrderButton);
        checkoutPage.clickOnPlaceOrderButton();
        paymentPage.fillPaymentFormWithDataFromExcelFile("Data");
        Assert.assertEquals(paymentPage.message.getText(), "Congratulations! Your order has been confirmed!");
    }

    @Test(priority = 20)
    public void userCannotPayIfNameFieldsOnPaymentPageIsNotFilled() throws IOException {
        cartPage.clickOnProceedToCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/checkout");
        scrollToElement(checkoutPage.placeOrderButton);
        checkoutPage.clickOnPlaceOrderButton();
        paymentPage.fillPaymentFormWithDataFromExcelFile("InvalidForm");
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/payment");
    }
}
