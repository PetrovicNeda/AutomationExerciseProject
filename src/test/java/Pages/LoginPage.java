package Pages;

import BaseTest.BaseTest;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

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
}
