package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Random;

import static Pages.LoginPage.PASSWORD_FOR_REGISTRATION_AND_DELETING;

public class RegistrationPage extends BaseTest {

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

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

    Random random;
    public final String emailNew = "korisnik2@mail.com";
    public final String name = "korisnik";
    public final String firstName = "Petar";
    public final String lastName = "Petrovic";
    public final String address = "Address 1";
    public final String state = "State";
    public final String city = "City";
    public final String zipcode = "123000";
    public final String mobile = "0632568455";
    public final String[] fieldsValues = {PASSWORD_FOR_REGISTRATION_AND_DELETING, firstName, lastName, address, state, city, zipcode, mobile};
    public ArrayList<WebElement> mandatoryFields = new ArrayList<>();
    public final String[] countries = {"India", "United States", "Canada", "Australia", "Israel", "New Zealand", "Singapore"};

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void allMandatoryFields() {
        mandatoryFields.add(passwordField);
        mandatoryFields.add(firstNameField);
        mandatoryFields.add(lastNameField);
        mandatoryFields.add(addressField);
        mandatoryFields.add(stateField);
        mandatoryFields.add(cityField);
        mandatoryFields.add(zipcodeField);
        mandatoryFields.add(mobileNumberField);
    }

    public void inputFirstName(String name) {
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public String getRandomCountry() {
        random = new Random();
        return countries[random.nextInt(countries.length)];
    }

    public void clickOnCountryDropDownMenu() {
        countryDropDown.click();
        Select selectCountry = new Select(countryDropDown);
        selectCountry.selectByValue(getRandomCountry());
        countryDropDown.click();
    }

    public void inputState(String state) {
        stateField.clear();
        stateField.sendKeys(state);
    }

    public void inputCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void inputZipcode(String zipcode) {
        zipcodeField.clear();
        zipcodeField.sendKeys(zipcode);
    }

    public void inputMobile(String mobile) {
        mobileNumberField.clear();
        mobileNumberField.sendKeys(mobile);
    }

    public void clickOnCreateAccButton() {
        createAccButton.click();
    }

    public void fillRegisterForm() {
        allMandatoryFields();
        scrollToElement(firstNameField);
        for (int i = 0; i < mandatoryFields.size(); i++) {
            mandatoryFields.get(i).sendKeys(fieldsValues[i]);
        }
        clickOnCountryDropDownMenu();
        clickOnCreateAccButton();
    }

    public void fillRegistrationFormWithoutOneMandatoryField() {
        allMandatoryFields();
        scrollToElement(firstNameField);
        random = new Random();
        int fieldToLeaveEmpty = random.nextInt(fieldsValues.length);
        for (int i = 0; i < mandatoryFields.size(); i++) {
            if (i == fieldToLeaveEmpty) {
                mandatoryFields.get(i).clear();
            } else {
                mandatoryFields.get(i).clear();
                mandatoryFields.get(i).sendKeys(fieldsValues[i]);
            }
        }
        clickOnCountryDropDownMenu();
        clickOnCreateAccButton();
    }
}

