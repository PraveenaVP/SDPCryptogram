1.	A user shall be able to choose to log in as the administrator or as a specific player when starting the application.  For simplicity, authentication is optional.
	●	I did not consider this requirement because it does not affect the design directly.
2.	The application shall allow players to  (1) choose a cryptogram to solve, 
	●	The UML class diagram represents cryptograms with a Cryptogram class which a collection of all Cryptogram can be retrieved for the user from the Administrator class 
3.	(2) Players solve cryptograms,
	●	The User class contains a method called solveCryptogram accepting two strings the cryptogramID the unique identifier of a Cryptograms class and an attempted solution.
4.	 (3)Players see previously solved cryptograms, and
	●	This class diagram contains a class called User which has Hashmap called solutions with a String as a  key and a Arraylist of Strings as its value. The key will represents cryptogram which is found in the cryptogram class. The Arraylist of string is going to represent all attempted solution by that user for the specific cryptogram 
5.	 (4)Players view the list of player ratings.
	●	The Administrator class contains an Arraylist of all instances of the players represented by the User class. Each score can be retrieved from a User instance using the getUserRating method which will calculate the rating from the solutions variable and return a variable. 
6.	The application shall allow the administrator to (1) add new cryptograms
	●	This class diagram contains a class called Administrator representing an administrator of the application and has a method called createCryptogram which allows the administrator to create an instance of a Cryptogram

7.	Administrator add new local players.
	●	This class diagram contains a class called Administrator has a method called createUser  which allows the administrator to create an instance the User class representing a player

8.	The application shall maintain an underlying database to save persistent information across runs (e.g., cryptograms, players, solutions).
	●	This ability is not specified in the UML class diagram.

9.	Cryptograms and player ratings will be shared with other instances of the application.  An external web service utility will be used by the application to communicate with a central server to:
a.	Send updated player ratings.
b.	Send new cryptograms and receive a unique identifier for them.
c.	Request a list of additional cryptograms.
d.	Request the current player ratings.
You should represent this utility as a utility class called "ExternalWebService" that (1) is connected to the other classes in the system that use it and (2) explicitly lists relevant methods used by those classes.
	●	This class diagram contains a class called ExternalWebService and in this class an instance of an administrator is defined the ExternalWebService contains methods to do the following:
a. solveCryptogram- this method takes two string an attempt at a solution and a username allowing the ExternalWebService class to update the user's score.
b. createCryptogram - taking three strings representing a solution, an encoded phrase, and returning a String as a Cryptogram unique identifier
c. getCryptograms - returning all the Cryptograms 
d. getUserRating - returning a hashmap of a String as a key and a Double as a value the string is the username and the double represents the score.  

10.	A cryptogram shall have an encoded phrase (encoded with a simple substitution cipher), and a solution. 
	●	The cryptogram class contains a variable called encodedPhrase representing an encoded phrase.

11.	A cryptogram shall only encode alphabetic characters, but it may include other characters (such as punctuation, numbers, or white spaces).
	●	This ability is not specified in the UML class diagram.
12.	To add a player, the administrator will enter the following player information:
a.	A first name
b.	A last name
c.	A unique username
	●	The User class contains a variable called firstname, lastname, and username representing this information this ability is explained in requirements #7.

13.	To add a new cryptogram, an administrator will:
a.	Enter a solution phrase.
b.	Enter a matching encoded phrase.
c.	Edit any of the above information as necessary.
d.	Save the complete cryptogram.
After doing so, the administrator shall see a confirmation message. The message shall contain the unique identifier assigned to the cryptogram by the external web service utility.
	●	The Cryptogram class contains a variable called solution and encodedPhrase representing this information this ability is explained in requirement #6.
14.	To choose and solve a cryptogram, a player will:
a.	Choose a cryptogram from a list of all available cryptograms (see also Requirement 11).
b.	View the chosen cryptogram (including any prior solution, complete or in progress, in case he or she already worked on the same cryptogram earlier).
c.	Assign (or reassign) replacement letters to the encrypted letters and view the effects of these assignments in terms of resulting potential solution.
d.	Submit the current solution when he or she has replaced all letters in the puzzle and is satisfied with such solution.
At this point, the player shall get a result indicating whether the solution was correct. At any point, the player may return to the list of cryptograms to try another one.
	●	I did not consider this requirement because it does not affect the design directly.

15.	The list of available cryptograms shall show, for each cryptogram, its identifier, whether the player has solved it, and the number of incorrect solution submissions, if any.
	●	The User class contains in the solutions variable a hashmap of the string the cryptogramID and all attempts by the user.

16.	The list of player ratings shall display, for each player, his or her name, the number of cryptograms solved, the number of cryptograms started, and the total number of incorrect solutions submitted. The list shall be sorted in descending order by the number of cryptograms solved.  
	●	The Administrator class contains an Arraylist of Users for which all this information can be retrieved

17.	The User Interface (UI) shall be intuitive and responsive.
	●	I did not consider this requirement because it does not affect the design directly.


