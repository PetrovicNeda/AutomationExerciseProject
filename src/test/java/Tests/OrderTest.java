package Tests;

import BaseTest.BaseTest;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.LoginPage.USER_EMAIL;
import static Pages.LoginPage.USER_PASSWORD;

public class OrderTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        loginPage.logInAndAssert(USER_EMAIL, USER_PASSWORD);
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        paymentPage = new PaymentPage();
        clickOnElementAndCloseVignette(homePage.productsButton);
        productsPage.addItemToCartAndOpetCart();
    }

    @Test(priority = 10)
    public void userCanOrderItem(){
        cartPage.clickOnProceedToCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/checkout");
        scrollToElement(checkoutPage.placeOrderButton);
        checkoutPage.clickOnPlaceOrderButton();

        String name = "Neda";
        String cardNumber = "236-52158-125";
        String cvc = "100";
        String expMonth = "10";
        String expYear = "2025";

        paymentPage.inputNameOnCard(name);
        paymentPage.inputCardNumber(cardNumber);
        paymentPage.inputCvc(cvc);
        paymentPage.inputExpirationMonth(expMonth);
        paymentPage.inputExpirationYear(expYear);
        paymentPage.clickOnPayAndConfirmButton();

        Assert.assertEquals(paymentPage.message.getText(), "Congratulations! Your order has been confirmed!");
    }

    @Test(priority = 20)
    public void userCannotPayIfNameFieldsOnPaymentPageIsNotFilled(){
        cartPage.clickOnProceedToCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/checkout");
        scrollToElement(checkoutPage.placeOrderButton);
        checkoutPage.clickOnPlaceOrderButton();

        String cardNumber = "236-52158-125";
        String cvc = "100";
        String expMonth = "10";
        String expYear = "2025";

        paymentPage.inputCardNumber(cardNumber);
        paymentPage.inputCvc(cvc);
        paymentPage.inputExpirationMonth(expMonth);
        paymentPage.inputExpirationYear(expYear);
        paymentPage.clickOnPayAndConfirmButton();

        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/payment");
    }
}
