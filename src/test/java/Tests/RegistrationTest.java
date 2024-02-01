package Tests;

import BaseTest.BaseTest;
import Pages.AccCreatedPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        accCreatedPage = new AccCreatedPage();

    }

    @Test
    public void userCanRegistrateWithAllMandatoryFieldsFilled() {
        String name = "korisnik";
        String email = "korisnik@mail.com";
        loginPage.inputNameForSignup(name);
        loginPage.inputEmailForSignup(email);
        loginPage.clickOnSignupButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");

        String password = "korisnik123";
        String firstName = "Petar";
        String lastName = "Petrovic";
        String address = "Address 1";
        String state = "State";
        String city = "City";
        String zipcode = "123000";
        String mobile = "0632568455";
        registrationPage.inputPassword(password);
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
        String email = "korisnik@mail.com";
        loginPage.inputNameForSignup(name);
        loginPage.inputEmailForSignup(email);
        loginPage.clickOnSignupButton();
        Assert.assertEquals(loginPage.errorSignupMessage.getText(), "Email Address already exist!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");
    }
}



