package Tests;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import static Pages.LoginPage.USER_EMAIL;
import static Pages.LoginPage.USER_PASSWORD;

public class LoginTest extends BaseTest {

    @Test(priority = 10)
    public void userCanLogInWithValidCredentials() {
        loginPage.logInAndAssert(USER_EMAIL, USER_PASSWORD);
    }

    @Test(priority = 20)
    public void userCannotLogInWithInvalidPassword() {
        String validEmail = "neda@mail.com";
        String invalidPassword = "neda123";
        loginPage.logInInvalidAndAssert(validEmail, invalidPassword);
    }

    @Test(priority = 30)
    public void userCannotLogInWithInvalidEmail() {
        String invalidEmail = "neda12@mail.com";
        String validPassword = "neda123!";
        loginPage.logInInvalidAndAssert(invalidEmail, validPassword);
    }

    @Test(priority = 40)
    public void userCannotLogInWithInvalidCredentials() {
        String invalidEmail = "neda12@mail.com";
        String invalidPassword = "neda123!1";
        loginPage.logInInvalidAndAssert(invalidEmail, invalidPassword);
    }

    @Test(priority = 50)
    public void userCanLogInWithEmptyPasswordField() {
        String validEmail = "neda@mail.com";
        String emptyPassword = "";
        loginPage.logInInvalidAndAssert(validEmail, emptyPassword);
    }

    @Test(priority = 60)
    public void userCanLogInWithEmptyEmailField() {
        String emptyEmail = "";
        String validPassword = "neda123!";
        loginPage.logInInvalidAndAssert(emptyEmail, validPassword);
    }

    @Test(priority = 70)
    public void userCanLogInWithEmptyFields() {
        String emptyEmail = "";
        String emptyPassword = "";
        loginPage.logInInvalidAndAssert(emptyEmail, emptyPassword);
    }
}
