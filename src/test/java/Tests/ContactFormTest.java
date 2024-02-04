package Tests;

import BaseTest.BaseTest;
import Pages.ContactFormPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.LoginPage.USER_EMAIL;
import static Pages.LoginPage.USER_PASSWORD;

public class ContactFormTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        loginPage.logInAndAssert(USER_EMAIL, USER_PASSWORD);
        homePage.clickOnContactButton();
        contactFormPage = new ContactFormPage();
    }

    @Test(priority = 10)
    public void userCanContactSiteOwners() {
        contactFormPage.inputName("Neda");
        contactFormPage.inputMail(USER_EMAIL);
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
