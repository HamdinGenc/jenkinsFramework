package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@id='middleName']")
    public WebElement middleNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement saveButton;


    @FindBy(xpath = "//input[@id='employeeId']")
    public WebElement empIDLocator;

    @FindBy(xpath = "//input[@id='photofile']")
    public WebElement photograph;

    @FindBy(xpath = "//input[@id='chkLogin'] ")
    public WebElement checkBox;

    @FindBy(xpath = "//input[@id='user_name'] ")
    public WebElement createUsername;

    @FindBy(xpath = "//input[@id='user_password'] ")
    public WebElement createPassword;

    @FindBy(xpath = "//input[@id='re_password'] ")
    public WebElement confirmPassword;



    public AddEmployeePage(){
        PageFactory.initElements(driver,this);
    }

}
