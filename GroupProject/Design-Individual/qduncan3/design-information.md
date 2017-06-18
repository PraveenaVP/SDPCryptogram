# Assignment #5: Software Design, Design-information document

Queen Duncan,OMSCS CS6300 Summer 2017

This document provides additional information on the UML Class Diagram for the Cryptogram game.

<br>

# Requirements <br>


1.	A user shall be able to choose to log in as the administrator or as a specific player when starting the application.  For simplicity, authentication is optional.<br>
<b>I realized this requirement by creating an Administrator class and a Player class</b>

2.	The application shall allow players to  (1) choose a cryptogram to solve, (2) solve cryptograms, (3) see previously solved cryptograms, and (4) view the list of player ratings.<br>
<b>I realized this requirement by creating methods selectCryptogram(), solveCryptogram(), seePreviouslySolvedCryptograms(), and getPlayerRatings() in the Player class </b>

3.	The application shall allow the administrator to (1) add new cryptograms, and (2) add new local players.<br>
<b>I realized this requirement by creating methods addCryptogram() and addPlayer() in the Administrator class</b>

4.	The application shall maintain an underlying database to save persistent information across runs (e.g., cryptograms, players, solutions).<br>
<b>This requirement was not considered because the assignment document lists that a database can be omitted if it is only persisting information otherwise present in the design, and my UML indeed achieves this.</b>

5.	Cryptograms and player ratings will be shared with other instances of the application.  An external web service utility will be used by the application to communicate with a central server to:
a.	Send updated player ratings.
b.	Send new cryptograms and receive a unique identifier for them.
c.	Request a list of additional cryptograms.
d.	Request the current player ratings.
You should represent this utility as a utility class called "ExternalWebService" that (1) is connected to the other classes in the system that use it and (2) explicitly lists relevant methods used by those classes.<br>
<b> I realized this requirement by creating a utility class called "ExternalWebService" and created methods sendPlayerRatings(), sendCryptogram(), getCryptogramId(), requestCryptogram(), and requestCurrentPlayerRatings(). requestPlayerId() method was added to ensure that the correct Player Id is being used.</b>

6.	A cryptogram shall have an encoded phrase (encoded with a simple substitution cipher), and a solution. <br>
<b>I realized this requirement by creating a class called Cryptogram and adding the string attribute encodedPhrase</b>

7.	A cryptogram shall only encode alphabetic characters, but it may include other characters (such as punctuation, numbers, or white spaces).<br>
<b>I realized this requirements by creating a method hasOnlyAlphaCharacters() to check whether or not only encoded alphabetic characters (with the inclusion of punctuation, numbers, and white spaces)  are entered. </b>

8.	To add a player, the administrator will enter the following player information:
a.	A first name
b.	A last name
c.	A unique username <br>
<b>I realized this requirement by creating the method addPlayer (as mentioned above in conjunction to requirement #3. Also 8c. was specifically realized by creating the method isUniqueUsername() in the Player class to ensure that the user names entered for players were all unnique. </b>


9.	To add a new cryptogram, an administrator will:
 .	Enter a solution phrase.
a.	Enter a matching encoded phrase.
b.	Edit any of the above information as necessary.
c.	Save the complete cryptogram.
After doing so, the administrator shall see a confirmation message. The message shall contain the unique identifier assigned to the cryptogram by the external web service utility.<br>
<b>I realized this requirement by creating the method addCryptogram (as mentioned above in conjunction to requirement #3. I created the method editCryptogram() as well in order to allow the administrator to edit details of the cryptogram. </b>

10.	To choose and solve a cryptogram, a player will:
a.	Choose a cryptogram from a list of all available cryptograms (see also Requirement 11).
b.	View the chosen cryptogram (including any prior solution, complete or in progress, in case he or she already worked on the same cryptogram earlier).
c.	Assign (or reassign) replacement letters to the encrypted letters and view the effects of these assignments in terms of resulting potential solution.
d.	Submit the current solution when he or she has replaced all letters in the puzzle and is satisfied with such solution.
At this point, the player shall get a result indicating whether the solution was correct. At any point, the player may return to the list of cryptograms to try another one.<br>
<b>I realized this requirement by creating a method selectCryptogram() to allow the player to select a cryptogram from a list of all available cryptograms. I created the method solveCryptogram() to allow the player to solve the cryptogram.<br> I created the method viewChosenCryptogram() to allow the player to view the chosen cryptogram (including any prior solution, complete or in progress. I created the methods assignReplacementLetters() and reassignReplacementLetters() to allow the player to Assign (or reassign) replacement letters to the encrypted letters and view the effects of these assignments.</b>


11.	The list of available cryptograms shall show, for each cryptogram, its identifier, whether the player has solved it, and the number of incorrect solution submissions, if any.<br>
<b>I realized this requirement by creating a method getAvailableCryptograms() in the Cryptogram class. I also added the attributes cryptId: int, solutionPhrase: String and encodedPhrase: String to the Cryptogram class. I also created the method hasBeenSolved(): Boolean to check whether the player has solved it. <br> In addition, I created another class called Solution in order to handle the solutions for each cryptogram. The number of incorrect solution submissions is tallied using the method getNumberOfIncorrectSolutionSubmissions(). Also, I added the attributes numSolutionSubmissions: int and numIncorrectSolutionSubmission: int in order to  first store the solutions generated and then store the number of incorrect solutions in numSolutionSubmissions. <br>I also created the method getNumberOfSolutionSubmissions() in order to calculate the number of solution submissions first. To continue on, in order to ensure that the correct crypotgram ID and its attributes are being properly passed into the Solution class, I imported a list of cryptograms cryptogram: List<Cryptogram>.</b>


12.	The list of player ratings shall display, for each player, his or her name, the number of cryptograms solved, the number of cryptograms started, and the total number of incorrect solutions submitted. The list shall be sorted in descending order by the number of cryptograms solved.  <br>
<b> I realized this requirement by creating a class called Ratings. I created the method getNumSolvedCrypts() in order to retrieve the number of cryptograms solved. I created the method getNumStartedCrypts() in order to retrieve the number of cryptograms started.<br> In order to retrieve the total number of incorrect solutions submitted, I called two methods from the Solution class getNumberOfSolutionSubmissions() and getNumberOfIncorrectSolutionSubmissions() since this would have already been calculated and completed within the Solution class. The method displayPlayerRatings() displays the player ratings.<br>
In order to retrieve the players name I created a method called getSolvedCryptogramByPlayerId() to retrieve the solved/attempted cryptograms by player ID. </b>

13.	The User Interface (UI) shall be intuitive and responsive.<br>
<b>This requirement was not considered because it does not affect the design directly, per the assignments requirements document</b> 
