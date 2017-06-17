# Design Information


Cryptogram game is a mobile-ready application which uses a simple substitution cipher. 
# Features

  1. The application must contain a intuitive and responsive User Interface (UI). At the Login viewpoint, administrator and player will use their specific username to login to either administrator or player viewpoint. Therefore, I added Administrator class with attribute administratorUserName and Player class with attribute playerUserName.
  
  2. Once the player logins into player viewpoint, player could 
  - choose cryptograms to solve. To realize this requirement, Player class is associated with DataAccessObject class. Since this application maintains an underlying database to save persistent information across runs (Requirement #4). DataAccessObject class represents the data saved in the database. This application will connect a database via JDBC later. Player class could choose cryptograms which is stored in the database via implementing operations within ExternalWebService utility class.  All the operations are implemented via ExternalWebService class, class-specific operations are listed in specific class. 
  
  - solve cryptograms. The Player class is associated with Cryptogram class to solve the cryptogram via ExternalWebService class. 
  
  - check previouly solved cryptograms. The Player class could check his/her previously solved cryptogram which is saved in database. PreviouSolvedCryptograms class is the composition of the DataAccessObject class and it has playerUserName, hasBeenSovled and cryptograms attributes.
  
  - view the list of player ratings. The Player class could view the listOfPlayerRating class via utility class. ListOfPlayerRating class also is the composition of the DataAccessObject class and it has playerUserName, lastName, firstName, numberOfCryptogramSolved, numberOfCryptogramStarted, numberOfIncorrectSubmission attributes (Requirement #12).

  3. Once the administrator logins the administrator viewpoint, administrator could
  - add new cryptogram. To realize this requirement, Administrator class could create new cryptogram via utility class. Cryptogram class has solutionPhrase, encodedPhrase attributes (Requirement #9). Administrator could edit solutionPhrase and encodedPhrase as necessary via updateCryptogram operation (Requirement #9).
  
  - add new local player. To realize this requirement, Administrator class could create new player via utility class. Player class has firstName, lastName, playerUserName attributes (Requirement #8). To ensure the new playerUserName is unique, administrator will check the exisiting username in the database via checkUserNameUnique operation. 
  
  4. See Requirement #2.
  
  5. Utility class ExternalWebService will be used by the application to communicate with a central server via sendUpdatedPlayerRating, sendNewCryptogram, receiveUniqueIdentifier (therefore, Cryptogram also has uniqueIdentifier attribute), requestListOfAdditionalCryptogram, requestCurrentPlayerRating operations. 
  
  6. Cryptogram class contains encodedPhrase and solution attributes.
  
  7. Cryptogram shall only encode alphabetic character. This requirement will be realized by code business logic but it does not affect the design directly.
  
  8. See Requirement #3.
  
  9. See Requirement #3. Administrator class could save the complete cryptogram via saveCryptogram operation via utility class and administrator will get a confirmation message (confirmationMessage attribute within utility class) which is sent by ExternalWebService class via sendConfirmationMessage operation. 
  
  10. To choose and solve a cryptogram, player will:
  - Choose a crypogram from ListOfAvailableCryptogram (Requirement #11)
  - View the chosen cryptogram. Player could check PreviousSolvedCryptogram to view prior solution, complete or not via checkPreviousSolvedCryptogram operation within Player class.
  - Assign (or reassign) replacement letters to the encrypted letters via assignReplamentLetter (or reassignReplacementLetter) operations within Player class.  And player could view the effects of these assignments by previewSubmission operation.
  - Submit the solution by the submitSolution operation within Player class.
  - Player will submit the solution to Utility class and get the result from Utility class indicating the solution is correct or not. To realize this requirement, Utility class will send the result to player via checkResult operation within Utility class.
  
  11. ListOfAvailalbeCryptogram is the composition of DataAccessObject class. This list will be generalized by viewListofAvailableCryptogram operation within Player class.  ListOfAvailableCryptogram has uniqueIdentifier, hasBeenSolved, numberOfIncorrectSubmission attributes.
  
  12. See Requirement #2.
  
  13. The User Interface must be intuitive and responsive. At this timepoint, I didn't consider this requirement because it does not affect the UML design directly.
  
  
  
















  

