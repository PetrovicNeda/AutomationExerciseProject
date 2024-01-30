package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseTest {

    public RegistrationPage(){
        PageFactory.initElements(driver,this);
    }

//    @FindBy(css = "input[type='password']")
    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement passwordField;
    @FindBy(id = "first_name")
    public WebElement firstNameField;

    @FindBy(id = "address1")
    public WebElement addressField;


    //-------------------------------------

    public void inputPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    }

