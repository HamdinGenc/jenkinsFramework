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

        tags="@api"



)

public class Smoke {
}
