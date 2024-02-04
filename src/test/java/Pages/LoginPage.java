package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    HomePage homePage = new HomePage();


    @FindBy(css = "input[type='email'")
    public WebElement emailField;

    @FindBy(css = "input[type='password'")
    public WebElement passwordField;

    @FindBy(css = "button[type='submit'")
    public WebElement loginButton;

    @FindBy(tagName = "p")
    public WebElement errorMessage;

    @FindBy(css = "input[type='text']")
    public WebElement nameFieldForSignup;

    @FindBy(css = "input[data-qa='signup-email'")
    public WebElement emailForSignup;
    @FindBy(css = "button[data-qa='signup-button'")
    public WebElement signupButton;
    @FindBy(css = "p[style='color: red;'")
    public WebElement errorSignupMessage;

    //-----------------------------------

    public void inputEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void inputNameForSignup(String name){
        nameFieldForSignup.clear();
        nameFieldForSignup.sendKeys(name);
    }

    public void inputEmailForSignup(String email){
        emailForSignup.clear();
        emailForSignup.sendKeys(email);
    }
    public void clickOnSignupButton(){
        signupButton.click();
    }

    public void logIn(){
        String validEmail = "neda@mail.com";
        String validPassword = "neda123!";
        inputEmail(validEmail);
        inputPassword(validPassword);
        clickOnLoginButton();
        Assert.assertTrue(homePage.logoutButton.isDisplayed());
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }
    public void logIn(String email, String password){
        inputEmail(email);
        inputPassword(password);
        clickOnLoginButton();
        Assert.assertTrue(homePage.logoutButton.isDisplayed());
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }

}
