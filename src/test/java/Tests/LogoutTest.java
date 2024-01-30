package Tests;

import BaseTest.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
        String validEmail = "neda@mail.com";
        String validPassword = "neda123!";
        loginPage.inputEmail(validEmail);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLoginButton();

        Assert.assertTrue(homePage.logoutButton.isDisplayed());
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }

    @Test(priority = 10)
    public void userCanLogoutFromHomePage(){
        homePage.clickOnLogoutButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");

    }
}
