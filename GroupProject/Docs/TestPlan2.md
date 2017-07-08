# Test Plan Version 2.0

*This is the template for your test plan. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: \6300Summer17Team35\>

## 1 Testing Strategy

### 1.1 Overall strategy

*This section should provide details about your unit-, integration-, system-, and regression-testing strategies. In particular, it should discuss which activities you will perform as part of your testing process, and who will perform such activities.*

Unit Testing:
> In this process the individual module of the software application will be tested for its verification of the specification, validation of the result , boundary condition's etc.


> This will be done by the developer who codes the module, after the development of the module.

Integration Testing:

> In this process the individual modules are combined and tested.  If the main module/top level of the application is developed then,  a Top Down approach is chosen, here Test Stubs will stimulate lower modules, if not available. If the lower level modules are available, and the top level modules are not available then Bottom Up approach is chosen. On the availability of all modules Big Bang approach will be done.

>This will be done by programmer who coded the modules.


System Testing:

> In this process the following testing will be done to verify and validate the requirement
* Usability Testing:  This will be used to test the UI .
* Functional Testing: This will be used to test all the functionality and flow of the application.
* Load Testing: This will be used to test the boundary conditions.
* Recovery Testing: This is to test the reliability of the  software incase of unforeseen crashes.
* Migration Testing: This is used to test the application performance on various version's of the system.

> This will be done by independent tester(any team member)

Regression Testing:

> During prior phases of testing, the bugs found will be fixed, and regression testing will be done to ensure the change does not affect the overall system. Regression testing will be done using automated tools like JUnit. Manual testing will also be done.

> This testing will be done by the developer who fixes a bug/ updates any module.


### 1.2 Test Selection

*Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

Unit Testing:
>  White-box testing techniques :   Statement Coverage,Branch Coverage,Path Coverage techniques will be used.
Black Box testing techniques:  Boundary Value Analysis

Integration Testing:
>White-box testing techniques: Interface Interaction.
 Black-box testing techniques: functionality, cause effect graph.

System Testing:
>Black-box testing techniques: Cause Effect Graphing, Functionality.

Regression Testing :
> All the above mentioned White-box testing techniques, Black-box techniques will be used and be automated.


### 1.3 Adequacy Criterion

*Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that.*

A Requirement Traceability Matrix document will be maintained. Every requirement will be captured by at least one test case.
The requirements from "Assignment 5: Software Design" file is used as the source of the requirements.


### 1.4 Bug Tracking

*Describe how bugs and enhancement requests will be tracked.*

JIRA (community edition) will be used to track the issues and enhancement requests. # Not being used presently for deliverable 3.

The tester follows up the test plan document. The tester and developer are same, hence the bugs found are fixed simultaneously.

### 1.5 Technology

*Describe any testing technology you intend to use or build (e.g., JUnit, Selenium).*

Robotium/Appium (open source) is being considered for automation of UI. JUnit  will also be used for for automated test cases. # Not being used.

Manual Testing is being followed for deliverable 3.


## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*



| Test ID |  Test Description                             | Execution Steps | Expected Result                               | Actual Result | Pass/Fail | Additional Information |
|---------|----------------------------------------------|-----------------|-----------------------------------------------|---------------|-----------|------------------------|
| 1       | Check of Appliction Load |  Step 1:  Click on application icon | Application should start, with Home page display. |    Application is Loaded           |     Pass      |                        .|
| 2       | Empty Username field |  Step 1: Start the application  <br/>Step 2: Click on "Enter" button without any username .| Should display Error Message "Enter Username" |    The application moves to Player Home Page           |     Fail.      |    Bug Fixed                    .|
| 3        | Validation of Username field |  Step 1: Start the application   <br/> Step 2: Enter Admin username| Should open the Admin Home Page |  Admin Page Loaded             |     Pass      |                        .|
| 4        | Validation Username field |  Step 1: Start the application   <br/> Step 2: Enter Player username| Should open the Player Home Page |   Player Home Page Loaded            |  Pass         |                        .|
| 5        | Validation of Mode field |  Step 1: Start the application  <br/>Step 2: Select "Admin" from the Mode field. <br/> Step 3: Enter Player username| Should display Error Message "Not an Admin" |       Mode Field missing        |     NA      |                 Design updated       .|
| 6        | Validation of Mode field |  Step 1: Start the application  <br/>Step 2: Select "Player" from the Mode field. <br/> Step 3: Enter Admin username| Should display Error Message "Not an Player" |         Mode Field missing        |     NA      |                 Design updated       .|
| 7        | Validation of Player Home Page |  Step 1: Start the application  <br/>Step 2: Select "Player" from the Mode field. <br/> Step 3: Enter Player username| The Player Home Page should be displayed. The Home page contains, a list of cryptograms to be solved, a "View Previously Solved Cryptogram" button, a "View Player Rating" button and a "Choose Cryptogram to Solve" button |         Loaded as selection option      |   NA        |            Design change            .|
| 8        | Selection of Cryptogram |  Step 1: Start the application  <br/> Step 2: Enter Player username <br/> Step 3: Select a cryptogram from list| A Solution field to enter the solution should be made visible , with Solve and Save Button. |           Loaded as expected    |          Pass |                        .|
| 9        | Selection of Cryptogram-Solution field |  Step 1: Start the application  <br/>Step 2: Enter Player username <br/> Step 3: Select a cryptogram from list <br/> Step 4: Keep the Solution Field empty and click on Solve button| Should display a Error Message "Solution field Empty" |   Solution gets submitted             |   Fail        |      Bug Fixed                  .|
| 10        | Selection of Cryptogram-Solution field |  Step 1: Start the application  <br/>Step 2: Enter Player username <br/> Step 3: Select a cryptogram from list <br/> Step 4: Keep the Solution Field empty and click on Save button| Should display a Error Message "Solution field Empty" |   Solution gets saved             |   Fail        |      Bug Fixed                  .|
| 11        | Selection of Cryptogram-Solve button |  Step 1: Start the application  <br/>Step 2: Enter Player username <br/> Step 3: Select a cryptogram from list <br/> Step 5: Enter wrong solution and click on Solve button| Should display a  Message "Incorrect Solution" |           Displays the required message    |     Pass      |                        .|
| 12        | Selection of Cryptogram-Solve button |  Step 1: Start the application  <br/>Step 2: Enter Player username <br/> Step 3: Select a cryptogram from list <br/> Step 4: Enter correct solution and click on Solve button| Should display a  Message "Correct Solution" |   Displays the required message            |   Pass        |                        .|
| 13        | Selection of Cryptogram-Save button |  Step 1: Start the application  <br/>Step 2: Select "Player" from the Mode field. <br/> Step 3: Enter Player username <br/> Step 4: Select a cryptogram from list <br/> Step 5: Enter partial solution and click on Save button| Should display a  Message "Successfully Saved" |          Displays the required message     | Pass          |                        .|
| 14        | Selection of Cryptogram-Save button |  Step 1: Start the application  <br/>Step 2: Enter Player username <br/> Step 3: Select a cryptogram from list <br/> Step 4: Enter partial solution and click on Save button| Should display a  Message "Successfully Saved", and should be present in the "View Prior" section  |      Displays the required message and the entry is present in the View Prior section         |        Pass   |                        .|
| 15        | Validation of  "View Previously Solved Cryptograms" |  Step 1: Start the application  <br/>Step 2: Enter Player username <br/> Step 3: Select on "View Previously Solved Cryptograms" | All the prior cryptograms solved and attempted by the logged in Player should be displayed.  |    All the prior attempted games are present           |    Pass       |                        .|
| 16        | Validation of "View Prior" section |  Step 1: Start the application  <br/>Step 2: Enter Player username <br/> Step 3: Select on "View Previously Solved Cryptograms"<br/> Step 4: Click on a prior cryptogram | All the prior cryptograms solved and attempted by the logged in Player should be displayed, upon selecting a prior cryptogram, a new page should load wiith the selected cryptogram and the attempted solution with an option to assign reassign letters and view their effect  |    A new page is loaded with the selected cryptogram and the prior attemped entry, there are no assign reassign options, but the solution field is editable, with an option to Save and Solve the newly attempted entry |    Fail       |            Design Failure/Requirement Failure            .|
| 17        | Validation of "Load More Cryptograms" button |  Step 1: Start the application  <br/>Step 2:  Enter Player username <br/> Step 3: Click on "Choose Cryptogram to Solve" button<br/> Step 4: Click on "Load More Cryptograms"| New unsolved cryptograms must be loaded.  |    "Load More Cryptograms" Button    is not present       |        Fail   |             Design Failure/REquirement Failure           .|
| 18        | Validation of "View Ratings" section |  Step 1: Start the application  <br/>Step 2:  Enter Player username <br/> Step 3: Click on "View Player Rating" button| The Current Player rating should be displayed  |     The current player ratings is displayed          |      Pass     |                        .|
| 19        | Validation of Admin Home Page |  Step 1: Start the application  <br/>Step 2: : Enter Admin username| The Home page of the Admin should be displayed, with the options to "Manage Player" and "Manage Cryptogram"  |         Loaded the Admin Home Page with the correct options      |        Pass   |                        .|
| 20        | Validation of Manage Player |  Step 1: Start the application  <br/>Step 2:  Enter Admin username <br/> Step 3: Select "Manage Player" | The Admin should be redirected to a page to add new Player containing the following fields (1) First Name (2) Last Name (3) Username (4) Register Player Button  |   Loaded  the Manage Player Page with the required fields          |    Pass       |                        .|
| 21        | Validation of Manage Player- First Name field |  Step 1: Start the application  <br/>Step 2: Select "Admin" from the Mode field. <br/> Step 3: Enter Admin username <br/> Step 4: Select "Manage Player" <br/> Step 5:Enter numeric values in First Name  <br/>Step 6: Click on "Register Player"| Should display Error Message "Alphabets only" |    Successfully added Player with numeric values in fields           |    Fail       |  Design/Requirement failure                      .|
| 22        | Validation of Manage Player- First Name field |  Step 1: Start the application  <br/>Step 2: Enter Admin username <br/> Step 3: Select "Manage Player" <br/> Step 5: Keep the field blank, click on "Register Player" | Should display Error Message "First Name  is missing." |          Displayed the required messgage     |       Pass    |                        .|
| 23       | Validation of Manage Player- Last Name field |  Step 1: Start the application  <br/>Step 2:  Enter Admin username <br/> Step 3: Select "Manage Player" <br/> Step 4: Enter numeric values in Last Name <br/>Step 6: Click on "Register Player"| Should display Error Message "Alphabets only" |  Successfully added Player with numeric values in fields                   |     Fail      |             Design/Requirement Failure           .|
| 24        | Validation of Manage Player- Last Name field |  Step 1: Start the application  <br/>Step 2: Select "Admin" from the Mode field. <br/> Step 3: Enter Admin username <br/> Step 4: Select "Manage Player" <br/> Step 5: Keep the field blank, click on "Register Player" | Should display Error Message "Last Name  is empty." |         Displayed the required message      |    Pass       |                        .|
| 25        | Validation of Manage Player- Username field |  Step 1: Start the application  <br/>Step 2: Select "Admin" from the Mode field. <br/> Step 3: Enter Admin username <br/> Step 4: Select "Add New Player" <br/> Step 5: Keep the field blank, click on "Add New Player" | Should display Error Message "Username  is empty." |    Displayed the required message           |  Pass         |                        .|
| 26       | Validation of Manage Player- Register Player button |  Step 1: Start the application  <br/>Step 2:  Enter Admin username <br/> Step 3: Select "Manage Player" <br/> Step 4: Fill the fields with existing player details, click on "Register Player" | Should display Error Message "User Name already exists." |      Displayed the required messgage         |     Pass      |                        .|
| 27        | Validation of Manage  Player- Add New Player button |  Step 1: Start the application  <br/>Step 2:  Enter Admin username <br/> Step 4: Select "Manage Player" <br/> Step 5: Fill the fields with new player details, click on "Register Player" | Should display a success "User Name registered successfully" . |    Displayed the required message           |        Pass   |                        .|
| 28        | Validation of Manage Cryptogram |  Step 1: Start the application  <br/>Step 2: Enter Admin username <br/> Step 4: Select "Manage Cryptogram" | The Admin should be redirected to a page to add new Cryptogram containing the following fields (1) Input Phrase (2) Encoded Phrase (3) Encode  Button (4) Save Cryptogram Button |    Manage Cryptogram page loaded as required           |   Pass        |                        .|
| 29       | Validation of Manage Cryptogram - Input Phrase field |  Step 1: Start the application  <br/>Step 2: Enter Admin username <br/> Step 3: Select "ManageCryptogram"<br/> Step 4: Click on Encode button with input phrase field empty | Should display Error Message "Input field is Empty"  |  Displayed the required message             |    Pass       |                        .|
| 30       | Validation of Manage Cryptogram - Encode button |  Step 1: Start the application  <br/>Step 2:  Enter Admin username <br/> Step 3: Select "Manage Cryptogram"<br/> Step 4: Enter "Abc" in Input Phrase, click on Encode button | Should display "Zab"  |   Generated the correct encoded message            |        Pass   |                        .|
| 31       | Validation of Manage Cryptogram - Save Cryptogram button |  Step 1: Start the application  <br/>Step 2:  Enter Admin username <br/> Step 4: Select "Manage Cryptogram"<br/> Step 5: Enter "Abc" in Input Phrase, click on Encode button, click Save Cryptogram button | Should display a success message with a unique identifier .  |      Displayed only the success message, no unique Identifier         |       Fail    |  Requirement Failure                      .|
| 32       | Validation of Menu icon  |  Step 1: Start the application  <br/> | Menu Icon should be present with the following options (1)Home (2)Back (3)Exit (4)Help (5)About  |    Menu Icon Missing           |   Fail        |    Design Failure                    .|
| 33       | Validation of Menu icon - Home  |  Step 1: Start the application  <br/> Step2: Select Home from Menu | Should return to Home Page.  |   Menu Icon missing            |       Fail    |             Design Failure           .|
| 34       | Validation of Menu icon - Back  |  Step 1: Start the application  <br/> Step2: Select Back from Menu | Should return to previous page.  |       Menu Icon missing         |   Fail        |                  Design Failure.      .|
| 35       | Validation of Exit icon - Home  |  Step 1: Start the application  <br/> Step2: Select Exit from Menu | Should exit the application.  |  Menu Icon Missing             |      Fail     |            Design Failure            .|
| 36       | Validation of Help icon - Home  |  Step 1: Start the application  <br/> Step2: Select Help from Menu | Should display the rules of the application.  |  Menu Icon missing             |    Fail       |            DEsign Failure           .|
| 37       | Validation of About icon - Home  |  Step 1: Start the application  <br/> Step2: Select About from Menu | Should display description of the application along with software hardware requirements.  |     Menu Icon Missing         |      Fail     |                 Design Failure       .|
| 38       | Validation of Choose Cryptogram  |  Step 1: Start the application  <br/> Step2: Select enter player username <br/> Step3: select "Choose Cryptograms to Solve" | Should display a list of crytograms, with the number of incorrect attempts and status if solved for the user  |     Loads only the list of cryptograms       |      Fail     |                 Design Failure /Requirement Failure      .|
| 39       | Validation of View Player Ratings  |  Step 1: Start the application  <br/> Step2: Select enter player username <br/> Step3: select "View Player Ratings" | Should display the list of player ratings shall display, for each player, his or her name, the number of cryptograms solved, the number of cryptograms started, and the total number of incorrect solutions submitted. The list shall be sorted in descending order by the number of cryptograms solved.  |     Loads the ratings of current player alone      |      Fail     |                 Design Failure /Requirement Failure      .|
| 40       | Validation of Web service  |  Step 1: Start the application  <br/> Step2: Select enter admin username <br/> Step3: select "Manage Cryptograms", click on "Save cryptogram" | Should display a unique reference for teh saved cryptogram from thw webservice  |     Displays the unique reference number      |      Pass     |                      .|
| 41       | Validation of View Player Ratings.  |  Step 1: Start the application  <br/> Step2: Select enter as a new player username <br/> Step3: select "Choose a Cryptogram to Solve", click on "Save cryptogram"<br/> Step4:Click on View Ratings  | Should display "Saved: 1"  |     Displays the expected result    |      Pass     |                       .|
| 41       | Validation of New Player.  |  Step 1: Start the application  <br/> Step2: Select enter as a new player username <br/> Step3: select "View Player Ratings" | Should display "Records not found"  |     Displays the expected result    |      Pass     |                       .|
| 42       | Validation of New Player.  |  Step 1: Start the application  <br/> Step2: Select enter as a new player username <br/> Step3: select "View Previously Solved Cryptogram" | Should display "Records not found"  |     Displays the expected result    |      Pass     |                       .|
| 43       | Validation of Choose Cryptogram to Solve.  |  Step 1: Start the application first time(can change the DATABASE_NAME in DBHelper.java to achieve thsi) <br/> Step2: Select enter as a new player username <br/> Step3: select "Choose Cryptogram to Solve" | Should display "No Cryptograms found"  |     Displays the expected result    |      Pass     |                       .|
