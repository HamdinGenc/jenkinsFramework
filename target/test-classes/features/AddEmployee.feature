Feature:Adding the employee in HRMS in Application

  Background:
    When user enters valid admin credentials
    And user clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on add employee option

  @regression
  Scenario:Adding one employee from feature file
   # Given user is navigated to HRMS application
    And user enters first name middle name and last name
   And user clicks on save button
   Then employee added successfully

   @123
   Scenario: Adding one employee using cucumber feature file
     And user enters "zuhoor" "Mujeeb" and "silvia"
     And user clicks on save button
     Then employee added successfully

     @test @test123
     Scenario Outline: Adding multiple employees
       And user enters "<firstName>" "<middleName>" and "<lastName>"
       And user clicks on save button
       Then employee added successfully

       Examples:
       |firstName|middleName|lastName|
       |asel     |MS        |tolga   |
       |yazgul   |MS        |kishan  |
       |tarik    |MS        |mujeeb  |
       |nassir   |MS        |volkan |


    @test @datatable
    Scenario: Add employee using data table
      When user provides multiple employee data and verify they are added
      |firstName|middleName|lastName|
      |asel     |MS        |tolga   |
      |yazgul   |MS        |kishan  |
      |tarik    |MS        |mujeeb  |
      |nassir   |MS        |volkan |

    @excel
      Scenario:Adding multiple employees from excel file
      When user add multiple employees from excel file using "Employeedata" sheet and verify the user added

  @e2eTesT1
  Scenario: Adding one employee using cucumber feature file
    And user enters "Taylor" "Shakira" and "Swift"
    And user Grabs the employee id
    And user clicks on save button
    And user query database for same employee id
    Then user verifies the results

     #And user Grabs the employee id
     # And user query database for same employee id
     #  Then user verifies the results
     #THIS 3 TEST STEPS DID NOT PASS THE TEST EXECUTION SCENARIO, EVEN THOUGH I FOLLOWED THE EXACT STEPS OF
     #INSTRUCTOR,BY CODING THE EXACT SAME METHODS AND DATA IN EACH OBJECT MODEL PAGE,
     #ACORDING THE FRAMEWORK REQUIREMENTS,HOWEVER SINCE I HAVE STARTED LONG TIME AFTER THIS
    #COURSE ENDED, THERE MIGHT BE CHANGES AND UPDATE TO THE WEBSITE OR MYSQL WORKBENCH,
    #I RECORDED THIS NOTE HERE, IN ORDER TO REMEMBER IN THE FUTURE WHEN I RETURNED BACK
     #TO SEE THE CODE I HAVE WRITTEN IN PURPOSE TO FOLLOW THE PATH OF THE INSTRUCTOR,
     # DATE:4/11/2023(TUESDAY-SUNNYVALE).