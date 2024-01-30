package Tests;

import BaseTest.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
    }

    @Test(priority = 10)
    public void userCanLogInWithValidCredentials() {
        String validEmail = "neda@mail.com";
        String validPassword = "neda123!";
        loginPage.inputEmail(validEmail);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.logoutButton.isDisplayed());
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }

    @Test(priority = 20)
    public void userCannotLogInWithInvalidPassword() {
        String validEmail = "neda@mail.com";
        String invalidPassword = "neda123";
        loginPage.inputEmail(validEmail);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test(priority = 30)
    public void userCannotLogInWithInvalidEmail() {
        String invalidEmail = "neda12@mail.com";
        String validPassword = "neda123!";
        loginPage.inputEmail(invalidEmail);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test(priority = 40)
    public void userCannotLogInWithInvalidCredentials() {
        String invalidEmail = "neda12@mail.com";
        String invalidPassword = "neda123!1";
        loginPage.inputEmail(invalidEmail);
        loginPage.inputPassword(invalidPassword);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test(priority = 50)
    public void userCanLogInWithEmptyPasswordField() {
        String validEmail = "neda@mail.com";
        loginPage.inputEmail(validEmail);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test(priority = 60)
    public void userCanLogInWithEmptyEmailField() {
        String validPassword = "neda123!";
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @Test(priority = 70)
    public void userCanLogInWithEmptyFields() {
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
