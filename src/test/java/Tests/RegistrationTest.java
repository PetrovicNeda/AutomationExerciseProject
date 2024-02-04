package Tests;

import BaseTest.BaseTest;
import Pages.AccCreatedPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.LoginPage.EMAIL_FOR_REGISTRATION_AND_DELETING;

public class RegistrationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        registrationPage = new RegistrationPage();
        accCreatedPage = new AccCreatedPage();
    }

    @Test(priority = 10)
    public void userCanRegisterWithAllMandatoryFieldsFilled() {
        loginPage.inputNameForSignup(registrationPage.name);
        loginPage.inputEmailForSignup(EMAIL_FOR_REGISTRATION_AND_DELETING);
        loginPage.clickOnSignupButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");

        registrationPage.fillRegisterForm();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created");
        Assert.assertTrue(accCreatedPage.continueButton.isDisplayed());
        Assert.assertTrue(accCreatedPage.message.isDisplayed());
    }

    @Test(priority = 20)
    public void userCannotSingUpWithEmailAlreadyExist() {
        loginPage.inputNameForSignup(registrationPage.name);
        loginPage.inputEmailForSignup(EMAIL_FOR_REGISTRATION_AND_DELETING);
        loginPage.clickOnSignupButton();
        Assert.assertEquals(loginPage.errorSignupMessage.getText(), "Email Address already exist!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");
    }

    @Test(priority = 30)
    public void userCannotSingUpWithEmptyMandatoryField() {
        loginPage.inputNameForSignup(registrationPage.name);
        loginPage.inputEmailForSignup(registrationPage.emailNew);
        loginPage.clickOnSignupButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");

        registrationPage.fillRegistrationFormWithoutOneMandatoryField();
        Assert.assertTrue(registrationPage.createAccButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");
    }
}



