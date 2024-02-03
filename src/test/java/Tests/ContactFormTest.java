package Tests;

import BaseTest.BaseTest;
import Pages.ContactFormPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactFormTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage();
        homePage.clickOnLoginSignupButton();
        loginPage = new LoginPage();
        loginPage.logIn();
        homePage.clickOnContactButton();
        contactFormPage = new ContactFormPage();
    }

    @Test(priority = 10)
    public void userCanContactSiteOwners() {
        contactFormPage.inputName("Neda");
        contactFormPage.inputMail("neda@mail.com");
        contactFormPage.inputSubject("Home Page");
        contactFormPage.inputMessage("Prikaz");
        contactFormPage.uploadImage();
        scrollToElement(contactFormPage.submitButton);
        contactFormPage.clickOnSubmitButton();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertEquals(contactFormPage.message.getText(), "Success! Your details have been submitted successfully.");
    }

    @Test(priority = 20)
    public void userCannotSubmitContactFormWithoutEmailFieldFilled() {
        contactFormPage.inputName("Neda");
        contactFormPage.inputSubject("Home Page");
        contactFormPage.inputMessage("Prikaz");
        contactFormPage.uploadImage();
        scrollToElement(contactFormPage.submitButton);
        contactFormPage.clickOnSubmitButton();
        Assert.assertTrue(contactFormPage.submitButton.isDisplayed());
    }
}
