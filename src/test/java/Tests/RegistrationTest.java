package Tests;

import BaseTest.BaseTest;
import Pages.AccCreatedPage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.LoginPage.EMAIL_FOR_REGISTRATION_AND_DELETING;
import static Pages.LoginPage.PASSWORD_FOR_REGISTRATION_AND_DELETING;

public class RegistrationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        registrationPage = new RegistrationPage();
        accCreatedPage = new AccCreatedPage();
    }

    @Test
    public void userCanRegistrateWithAllMandatoryFieldsFilled() {
        String name = "korisnik";

        loginPage.inputNameForSignup(name);
        loginPage.inputEmailForSignup(EMAIL_FOR_REGISTRATION_AND_DELETING);
        loginPage.clickOnSignupButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");


        String firstName = "Petar";
        String lastName = "Petrovic";
        String address = "Address 1";
        String state = "State";
        String city = "City";
        String zipcode = "123000";
        String mobile = "0632568455";
        registrationPage.inputPassword(PASSWORD_FOR_REGISTRATION_AND_DELETING);
        scrollToElement(registrationPage.firstNameField);
        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputAddress(address);
        registrationPage.clickOnCountryDropDownMenu("Australia");
        registrationPage.inputState(state);
        registrationPage.inputCity(city);
        registrationPage.inputZipcode(zipcode);
        registrationPage.inputMobile(mobile);
        registrationPage.clickOnCreateAccButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/account_created");
        Assert.assertTrue(accCreatedPage.continueButton.isDisplayed());
        Assert.assertTrue(accCreatedPage.message.isDisplayed());
    }

    @Test(priority = 20)
    public void userCannotSingupWithEmailAlreadyExist() {
        String name = "korisnik";
        loginPage.inputNameForSignup(name);
        loginPage.inputEmailForSignup(EMAIL_FOR_REGISTRATION_AND_DELETING);
        loginPage.clickOnSignupButton();
        Assert.assertEquals(loginPage.errorSignupMessage.getText(), "Email Address already exist!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");
    }

    @Test(priority = 30)
    public void userCannotSingupWithEmptyMandatoryField() {
        String name = "korisnik";
        String email = "korisnik2@mail.com";
        loginPage.inputNameForSignup(name);
        loginPage.inputEmailForSignup(email);
        loginPage.clickOnSignupButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");

        String password = "korisnik123";
//        String firstName = "Petar";
        String lastName = "Petrovic";
        String address = "Address 1";
        String state = "State";
        String city = "City";
        String zipcode = "123000";
        String mobile = "0632568455";
        registrationPage.inputPassword(password);
        scrollToElement(registrationPage.firstNameField);
//        registrationPage.inputFirstName(firstName);
        registrationPage.inputLastName(lastName);
        registrationPage.inputAddress(address);
        registrationPage.clickOnCountryDropDownMenu("Australia");
        registrationPage.inputState(state);
        registrationPage.inputCity(city);
        registrationPage.inputZipcode(zipcode);
        registrationPage.inputMobile(mobile);
        registrationPage.clickOnCreateAccButton();

        Assert.assertTrue(registrationPage.createAccButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");
    }
}



