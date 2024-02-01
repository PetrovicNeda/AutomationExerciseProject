package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BaseTest {

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    //    @FindBy(css = "input[type='password']")
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(id = "first_name")
    public WebElement firstNameField;
    @FindBy(id = "last_name")
    public WebElement lastNameField;

    @FindBy(id = "address1")
    public WebElement addressField;
    @FindBy(id = "country")
    public WebElement countryDropDown;
    @FindBy(id = "state")
    public WebElement stateField;
    @FindBy(id = "city")
    public WebElement cityField;
    @FindBy(id = "zipcode")
    public WebElement zipcodeField;
    @FindBy(id = "mobile_number")
    public WebElement mobileNumberField;
    @FindBy(css = "button[type='submit'")
    public WebElement createAccButton;



    //-------------------------------------

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void inputFirstName(String name) {
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }

    public void inputLastName(String lastName){
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputAddress(String address){
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void clickOnCountryDropDownMenu(String countryName){
        countryDropDown.click();
        Select selectCountry = new Select(countryDropDown);
        selectCountry.selectByValue(countryName);
        countryDropDown.click();
    }
    public void inputState(String state){
        stateField.clear();
        stateField.sendKeys(state);
    }
    public void inputCity(String city){
        cityField.clear();
        cityField.sendKeys(city);
    }
    public void inputZipcode(String zipcode){
        zipcodeField.clear();
        zipcodeField.sendKeys(zipcode);
    }
    public void inputMobile(String mobile){
        mobileNumberField.clear();
        mobileNumberField.sendKeys(mobile);
    }
    public void clickOnCreateAccButton(){
        createAccButton.click();
    }

}

