## Project Plan Version 2.0


####**Author: New Team 35 (Combine Team 29 and Team 35),  OMSCS 6300, Summer 2017**
	

###**1 Introduction**

The SDP Cryptogram is an application that allows users to practice solving cryptograms and compare their progress. 


###**2 Process Description**
**Users:**

- Administrator
- Player
	

**2.1 Launch Cryptogram Application:**



- User (which will be an administrator) launches the software application in order to achieve the desired goals of the cryptogram game. This initial process is designed to be straightforward to the user and reminiscent of other software applications that need to be launched.
- Entrance criteria: User has not launched the application and a “push to start” methodology is assumed for this application.
- Exit criteria: By launching the application, the user also initializes dependent processes such as the external web service that manages interactions between the user and cryptograms being solved. This is an indication that the app is running as expected and all intended process have been initialized efficiently.


**2.2 Select Administrator Option:**

- User (Administrator) selects the administrator option in order to complete the necessary operations for maintaining the cryptogram game.The administrator option allows administrators to execute actions such as adding and editing cryptogram, and adding players.
- Entrance Criteria: The user (administrator)  has launched the application and the application is running and functioning properly. 
- Exit Criteria The user (administrator) is able to see options for adding/editing cryptograms and adding players



**2.3 Add Cryptogram:**

- The user (administrator) selects the option to add a cryptogram to the database. This is crucial to the intended functionality of the system. Without a stable way of tracking cryptograms, the administrator would not have a way of maintaining solution attempts for each cryptogram. In addition, there would be no cryptograms for users to solve if this action is not performed.
- Entrance Criteria: The administrator has selected the option to add cryptogram via the application homepage. 
- Exit Criteria: The cryptogram/info is added to the database and stored. Cryptogram information: generated ID, solution phrase and matching encoded phrase.



**2.4 Edit Cryptogram:**

- The user (administrator) has the ability to edit each cryptogram that has been added to the database. The administrator selects the option to edit cryptogram from the “administrator options” and from the list of cryptogram selects the desired one to modify. This is crucial in order to allow the administrator to have a method to ensure the cryptograms are always up to date or in case incorrect data was originally entered. The information an administrator would modify for instance would be solution phrase and matching encoded phrase.
 Entrance Criteria: The administrator has selected the option to edit cryptogram. Cryptograms have already been added to the database.
- Exit Criteria:  The cryptogram information is modified and saved.


**2.5 Add Player:**

- The user (administrator) selects the option to add a player. This is crucial to the intended functionality of the system. For example, because the administrator can add players, they are able to keep track of which cryptograms each players has solved and how many. 
- Entrance Criteria: The administrator has selected the option to add players via the administrator view presented to them on application launch. 
- Exit Criteria: The player/info is added to the database and stored. Player information: first name, last name, user name. 


**2.5 Select Player Option:**

- From the application homepage, the user (player) selects the player view. This view is where all the player’s interaction with the application will take place. The player will have the opportunity to choose a cryptogram to solve, view player ratings and view previously solved cryptograms.
- Entrance Criteria: The user has launched the application and the application is running and functioning. Players and cryptograms have already been added.
- Exit Criteria: The user is able to see options to choose a cryptogram to solve, view player ratings and view previously solved cryptogram


**2.6 Choose a cryptogram:**

- The user (player) is able to select the option to choose a cryptogram to solve. The user is presented with a list of cryptograms that have been loaded by the administrator. The user is able to select an item and proceed to follow the steps in order to solve it by assigning or reassigning replacement letters to the encrypted letters.
- Entrance Criteria: The player has selected the player (user) option.
- Exit Criteria:The player is able to enter a solution for a chosen cryptogram.




## 3 Team

**3.1 Team Members**  

The team consists of 4 individuals from various backgrounds, with diverse skillsets and work experience.

- Tiantian Zhang                
Email: tzhang386@gatech.edu 
- Andrew Angoyar              
Email:aangoyar@gatech.edu 
- Praveena Panineerkandy
Email:  pvp7@gatech.edu
- Ziyan Wang                      
Email: ziyanwangruc@gmail.com

  

**3.2 Roles**

<table>
  <tr>
    <td>Project Manager</td>
    <td>Tiantian Zhang </td> 
  </tr>

<tr>
    <td>Developers</td>
    <td> Praveena Panineerkandy, Andrew Angoyar </td> 
  </tr>
<tr>
    <td>Quality Assurance Testers</td>
    <td> Tiantian Zhang, Ziyan Wang </td> 
  </tr>
</table>
<br>

