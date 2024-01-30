package Tests;

import BaseTest.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
    }

    @Test
    public void userCanRegistrateWithAllMandatoryFieldsFilled(){
        String name = "korisnik";
        String email = "korisnik@mail.com";
        loginPage.inputNameForSignup(name);
        loginPage.inputEmailForSignup(email);
        loginPage.clickOnSignupButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/signup");

        String password = "korisnik123";
        registrationPage.inputPassword(password);
        scrollToElement(registrationPage.firstNameField);


    }


}
