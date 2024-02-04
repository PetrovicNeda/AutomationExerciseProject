package Pages;

import BaseTest.BaseTest;
import BaseTest.ExcelReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Random;

public class PaymentPage extends BaseTest {

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "form-control")
    public WebElement nameOnCardField;
    @FindBy(css = ".form-control.card-number")
    public WebElement cardNumberField;
    @FindBy(css = ".form-control.card-cvc")
    public WebElement cvcField;
    @FindBy(css = ".form-control.card-expiry-month")
    public WebElement expirationMonthField;
    @FindBy(css = ".form-control.card-expiry-year")
    public WebElement expirationYearField;
    @FindBy(id = "submit")
    public WebElement payAndConfirmButton;
    @FindBy(tagName = "p")
    public WebElement message;

    //-------------------------------

    public void inputNameOnCard(String name) {
        nameOnCardField.clear();
        nameOnCardField.sendKeys(name);
    }

    public void inputCardNumber(String cardNumber) {
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
    }

    public void inputCvc(String cvc) {
        cvcField.clear();
        cvcField.sendKeys(cvc);
    }

    public void inputExpirationMonth(String exp) {
        expirationMonthField.clear();
        expirationMonthField.sendKeys(exp);
    }

    public void inputExpirationYear(String expYear) {
        expirationYearField.clear();
        expirationYearField.sendKeys(expYear);
    }

    public void clickOnPayAndConfirmButton() {
        payAndConfirmButton.click();
    }

    public void fillPaymentFormWithDataFromExcelFile(String sheetName) throws IOException {
        excelReader = new ExcelReader("TestData.xlsx");
        Random random = new Random();
        int customer = random.nextInt(1, excelReader.getLastRow(sheetName));
        inputNameOnCard(excelReader.getStringData(sheetName, customer, 0));
        inputCardNumber(excelReader.getStringData(sheetName, customer, 1));
        inputCvc(String.valueOf(excelReader.getIntegerData(sheetName, customer, 2)));
        inputExpirationMonth(String.valueOf(excelReader.getIntegerData(sheetName, customer, 3)));
        inputExpirationYear(String.valueOf(excelReader.getIntegerData(sheetName, customer, 4)));
        clickOnPayAndConfirmButton();
    }
}
