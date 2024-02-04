package Tests;

import BaseTest.BaseTest;
import Pages.DeleteAccPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.LoginPage.EMAIL_FOR_REGISTRATION_AND_DELETING;
import static Pages.LoginPage.PASSWORD_FOR_REGISTRATION_AND_DELETING;

public class DeleteAccTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        deleteAccPage = new DeleteAccPage();
    }

    @Test(priority = 10)
    public void userCanDeleteAccount() {
        loginPage.logInAndAssert(EMAIL_FOR_REGISTRATION_AND_DELETING, PASSWORD_FOR_REGISTRATION_AND_DELETING);
        clickOnElementAndCloseVignette(homePage.deleteAccButton);
        Assert.assertTrue(deleteAccPage.deleteMessage.isDisplayed());
    }
}
