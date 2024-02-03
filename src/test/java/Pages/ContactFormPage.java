package Pages;

import BaseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactFormPage extends BaseTest {

    public ContactFormPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[data-qa='name']")
    public WebElement nameField;
    @FindBy(css = "input[data-qa='email']")
    public WebElement emailField;
    @FindBy(css = "input[data-qa='subject']")
    public WebElement subjectField;
    @FindBy(id = "message")
    public WebElement messageField;
    @FindBy(css = "input[type='file'")
    public WebElement chooseFileButton;
    String imageLocation = "C:\\Users\\nelej\\Desktop\\Screenshot 2024-02-03 120410.png";
    @FindBy(css = "input[data-qa='submit-button'")
    public WebElement submitButton;
    @FindBy(css = ".status.alert.alert-success")
    public WebElement message;
    //-----------------------------

    public void inputName(String name){
        nameField.clear();
        nameField.sendKeys(name);
    }
    public void inputMail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void inputSubject(String subject){
        subjectField.clear();
        subjectField.sendKeys(subject);
    }
    public void inputMessage(String message){
        messageField.clear();
        messageField.sendKeys(message);
    }
    public void uploadImage(){
        chooseFileButton.sendKeys(imageLocation);
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }
}
