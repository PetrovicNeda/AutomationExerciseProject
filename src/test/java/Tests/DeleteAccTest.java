package Tests;

import BaseTest.BaseTest;
import Pages.DeleteAccPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteAccTest extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
        loginPage.logIn("korisnik@mail.com", "korisnik123");
        deleteAccPage = new DeleteAccPage();
    }
    @Test(priority = 10)
    public void userCanDeleteAccount(){
        homePage.clickOnDeleteAccButton();
        closeVignette();
        homePage.clickOnDeleteAccButton();
        Assert.assertTrue(deleteAccPage.deleteMessage.isDisplayed());
    }

}
