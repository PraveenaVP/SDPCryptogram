# Use Case Model Version 1.0
##**Author: Team 35**

## 1 Use Case Diagram
![enter image description here](https://lh3.googleusercontent.com/-Cjdymf33Atc/WVb1X-Z-GfI/AAAAAAAAATg/-i3077-Vq9IoSgzKhnHGWOAT18egyfeYACLcBGAs/s0/Use+Case+Diagram.jpg "Use Case Diagram.jpg")
## 2 Use Case Descriptions
**Manage Cryptogram**

- Requirements: Must allow the Administrator to manage the cryptograms 

- Pre-conditions: 
1. Administrator must have launched the app
2. The app must initialize the LogIn viewpoint
3. The app must initialize the administrator viewpoint based on administrator username entered
- Post-conditions: The cryptogram will be successfully added or edited and Administrator will see a confirmation message

- Scenarios: 
1. Administrator logs in the app via Administrator username
2. Administrator enters a solution phrase and a matching encoded phrase
3. Administrator hits Edit Solution button to edit the solution phrase as necessary
4. Administrator hits Edit Match button to edit the matching encoded phrase as necessary
5. Administrator hit Save button to send the complete cryptogram to the external web service utility
6. Administrator receives a confirmation message sent by external web service utility which contains the unique identifier assigned to the cryptogram
7.  Confirmation message displays in the Message Textfield
8.  Administrator hits the Return button to exit the Manage Cryptogram viewpoint
9. Administrator hits the Log Out button to exit the app



**Register Player**

- Requirements: Must allow the Administrator to add player and enter the player information

- Pre-conditions: 
1. Administrator must have launched the app
2. The app must initialize the LogIn viewpoint
3. The app must initialize the administrator viewpoint based on administrator username entered
- Post-conditions: The player information will be successfully entered and a unique username will be successfully assigned to the player

- Scenarios: 
1. Administrator logs in the app via Administrator username
2.  Administrator enters player information as first name, last name and username in the Textfield
3.  Administrator hits the Check Unique button to check whether the username exists in the database or not
4.  If the username exists in the database, Administrator will assign a new username and check the new username util the Textfield displays True which means this username is unique 
5.  Administrator hits the Register Player button to save the player information to the database
6.  The player information is successfully recorded
7.  Administrator hits the Return button to exit the Register Player viewpoint
8.  Administrator hits the Log Out button to exit the app


**Choose Player Option**

- Requirements: Must allow player to choose and solve a cryptogram, to view previously solved cryptogram and to view the list of player ratings
 
- Pre-conditions: 
1. Player must have launched the app
2. The app must initialize the LogIn viewpoint
3. The app must initialize the user viewpoint "Choose Option"based on player username entered

- Post-conditions: Player will successfully choose player option and accomplish the option task

- Scenarios: 
1. Player logs in the app via unique player username
2.  Player chooses one of the three options and hit Submit button
3.  Once the player option is chosen, the app initializes corresponding player viewpoint 

      3.1. If View Previous Solved Cryptogram option is chosen, Player could scroll up and down the list of previously solved cryptograms to view the ID, Complete or not and Prior Solutions

      3.2. If Choose Cryptogram to Solve option is chosen, Player could scroll up and down the list of available cryptogram to view cryptogram identifier, complete or not, number of incorrect solution submissions 
3.2.1. Player hits the Cryptogram and hits Select button to choose the Cryptogram to solve
3.2.2. Player hits the Assign button to assign replacement letters to the encrypted letters or hits the Reassign button to reassign replacement letters to the encrypted letters
3.2.3. Player hits the View button to view the effects of these assignments in terms of resulting potential solution
3.2.4.  Player hits the Submit button to submit current solution when player is satisfied
3.2.5. Player gets the result indicating whether the solution is correct
3.2.6. Player hits Cancel button to return to the list of available cryptograms to try another one


      3.3. If View Player Rating option is chosen, Player  could scroll up and down the list of Player Rating which display user namer, his or her name, the number of cryptogram solved, the number of Cryptograms started, and the total number of incorrect solutions submitted

4. Player hits the Return button to exit the Cryptogram viewpoint
5. Player hits the Log Out button to exit the app

 




