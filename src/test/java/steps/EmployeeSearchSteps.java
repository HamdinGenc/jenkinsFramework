package steps;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import java.util.concurrent.TimeUnit;

public class EmployeeSearchSteps extends CommonMethods {


    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openBrowserAndLunchApplication();
    }

    @When("user enters valid admin credentials")
    public void user_enters_valid_admin_credentials() throws InterruptedException {
        //LoginPage login=new LoginPage();
        // WebElement usernamefield = driver.findElement(By.id("txtUsername"));
      //  usernamefield.sendKeys(ConfigReader.getPropertyValue("username"));
        sendText(login.usernameBox,ConfigReader.getPropertyValue("username"));
        // WebElement passwordField = driver.findElement(By.name("txtPassword"));
        sendText(login.passwordBox,ConfigReader.getPropertyValue("password"));
       // passwordField.sendKeys(ConfigReader.getPropertyValue("password"));

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
      //LoginPage login=new LoginPage();
      //  WebElement loginButton = driver.findElement(By.id("btnLogin"));
        click(login.loginBtn);
       // loginButton.click();
        //driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @When("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        //WebElement pimpOption = driver.findElement(By.id("menu_pim_viewPimModule"));
      // pimpOption.click();
       // click(pimpOption);
        click(employeeSearchPage.pimpOption);
       // WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        //empListOption.click();
       // click(empListOption);
         click(employeeSearchPage.empListOption);


    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        //driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT,TimeUnit.SECONDS);
        // WebElement searchName=driver.findElement(By.xpath("//*[@type='text'][1]"));
        // searchName.sendKeys("Zagros");
       sendText(employeeSearchPage.nameField,"Cuneyt");



    }
    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
          // WebElement searchId = driver.findElement(By.id("empsearch_id"));
         //searchId.sendKeys("51852A");
        //sendText(searchId,"51852A");
        sendText(employeeSearchPage.idField,"17282181");

    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        //WebElement searchButton = driver.findElement(By.id("searchBtn"));
        // searchButton.click();
        click(employeeSearchPage.searchButton);

    }

        @Then("user is able to see employee information")
        public void user_is_able_to_see_employee_information() {
            System.out.println("Result is displayed");
           // tearDown();
    }
}