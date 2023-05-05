package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeSearchPage extends CommonMethods {

    @FindBy(xpath="//a[@id='menu_pim_viewPimModule']/b")
    public WebElement pimpOption;


    @FindBy(xpath=" //a[@id='menu_pim_addEmployee']")
    public WebElement addEmployeeOption;

    @FindBy(id="//a[@id='menu_pim_viewEmployeeList']")
    public WebElement empListOption;

    @FindBy(xpath="//input[@name='empsearch[employee_name][empName]']")
    public WebElement nameField;

    @FindBy(css="input[id='empsearch_id']")
    public WebElement idField;

    @FindBy(id="//input[@id='searchBtn']")
    public WebElement searchButton;

    public EmployeeSearchPage(){
    PageFactory.initElements(driver,this);

}

}
