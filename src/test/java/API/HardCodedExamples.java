package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {

    String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODI0NzEzNzksImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4MjUxNDU3OSwidXNlcklkIjoiMzc3MiJ9.VrybcjQWP5C76YXCEQLhFelR-9YuKeQPoF-rLFXUfts";
    static String employee_id;

    @Test
    public void acreateEmployee(){
       //here we prepare the request in this step

     RequestSpecification request=  given().header("Content_Type","application/json").
                header("Authorization",token).body("{\n" +
                        "    \"emp_firstname\": \"manana\",\n" +
                        "    \"emp_lastname\": \"patsatsia\",\n" +
                        "    \"emp_middle_name\": \"MS\",\n" +
                        "    \"emp_gender\": \"F\",\n" +
                        "    \"emp_birthday\": \"2000-04-18\",\n" +
                        "    \"emp_status\": \"probation\",\n" +
                        "    \"emp_job_title\": \"QA\"\n" +
                        "    } ");


        Response response=  request.when().post("/createEmployee.php");//-->this is end point from swagger file
       response.prettyPrint();
       response.then().assertThat().statusCode(201);

       //Hamcrest matchers-->To deal with keys, to verify all the keys.
         response.then().assertThat().body("Message",equalTo("Employee Created"));

       response.then().assertThat().body("Employee.emp_firstname",equalTo("manana"));

       //using JasonPath(), to specify the key in the body so that it returns the value against it

        employee_id =response.jsonPath().getString("Employee.employee_id");

        System.out.println(employee_id);
    }

    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification preparedrequest=given().header("Content-Type","application/json").
                header("Authorization",token).queryParam("employee_id",employee_id);

     Response response= preparedrequest.when().get("/getOneEmployee.php");
     response.prettyPrint();

     response.then().assertThat().statusCode(200);

     String tempId= response.jsonPath().getString("employee.employee_id");

        System.out.println(tempId);
        Assert.assertEquals(tempId,employee_id);

 }
 @Test
    public void cupdateEmployee(){

        RequestSpecification preparedRequest= given().header("Content_Type","application/jason")
     .header("Authorization",token).body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"edward\",\n" +
                        "  \"emp_lastname\": \"sisi\",\n" +
                        "  \"emp_middle_name\": \"MS1\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1995-04-19\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"Manager\"\n" +
                        "}");

        Response response= preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void dGetUpdatedEmployee(){
        RequestSpecification request=given().header("Content-Type","application/json").
                header("Authorization", token).queryParam("employee_id",employee_id);

        Response response= request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
 }

 @Test
    public void eGetAllEmployees(){
        RequestSpecification request =given(). header("Authorization",token)
                .header("Content-Type", "application/json");
        Response response=request.when().get("/getAllEmployees.php");

        //It returns string of response
        String allEmployees= response.prettyPrint();

        // jsonPath() vs jsonPath
       //jsonPath is a class that contains method for converting the values in to jason object
       //jsonPath() is a method belongs to jsonPath class

     JsonPath js = new JsonPath(allEmployees);

     //retrieving the total number of employees
     int count= js.getInt("Employees.size()");
     System.out.println(count);


     //to print only employee  of all the employees
     for(int i=0;i<count;i++){
        String empID=js.getString("Employees["+ i +"].employee_id");
         System.out.println(empID);

     }
 }

}
