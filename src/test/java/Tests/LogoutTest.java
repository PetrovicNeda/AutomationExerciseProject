package Tests;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.LoginPage.USER_EMAIL;
import static Pages.LoginPage.USER_PASSWORD;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        loginPage.logInAndAssert(USER_EMAIL, USER_PASSWORD);
    }

    @Test(priority = 10)
    public void userCanLogoutFromHomePage() {
        homePage.clickOnLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }
}
