package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        //features we use to provide the path of all the feature files
        features="src/test/resources/features/",

        //glue is where we find the implementations for gherkin steps
        //We provide the path of package to get all the step definitions

        glue= "steps",

        //dryRun we use to get the step definition of undefined steps.
       //if we set it true ,it will quickly scan all gherkin steps whether they are implemented
        //or not,if we se it "true", it stops actual execution
        //to execute scripts in real time , we should set this value to false

        dryRun=false,
        //it means the console output for cucumber test is having irrelevant information
        //When we set it to true, it simply removes all irrelevant information

        monochrome = true,
       //tags will identify the scenario based on the tag we provide in the "feature directory" file
       //use "or" if we need to execute scenarios from logical "or" keyword
        // which will execute either of the scenario having the tag
        //Use "and" if we need to execute scenario from logical "and" keyword which will execute
        //scenarios having both the tags in it.

       tags="@e2eTest1",
       // html report will be generated under target folder

        plugin= {"html:target/cucumber.html", "pretty", "json:target/cucumber.json",
                "rerun:target/failed.txt"}

)

public class RunnerClass {
 // for the syntaxhrm_mysql url the connection was not responding and the java compiler could not make,
//connection with  SQL database, so the-e2e(End2End)test did not pass the test steps,and l
//run this test steps in Runner-class,test execution section.I have written this note, to remember
//why the test case did not pass the test.(04/11/2023)
}
