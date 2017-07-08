# Design Document Version 2.0

##**Author: Team 35 **

## 1 Design Considerations
The objective of this design is to:

1. Development of a mobile phone application for the kids to practice solving cryptograms and compare their progress.
2.  This app must allow the administrator to add new cryptogram and add new player.



### 1.1 Assumptions
- The application does maintains an underlying database to save persistent information deployment within the android application framework to perform activities as specified in the requirements. We will also consider using the SQLite library  in order to store persistent data. The sdk we create will be deployed on an Android Mobile device.  
-  We assume there may be serval instances of application running because of the need for the external web service utility that is used to communicate with a central server. 
- Our Android application will be written in Java and we will use Android studio our preferred IDE.



### 1.2 Constraints
- The Administrator and Player must have a Android smart phone

### 1.3 System Environment

- Development Environment : Android Studio
- Operating System: Android
- User Operating System: Android
-  Android API level: 22 Lolipop
- Android Device used for development: Nexus 5
- User Environment:  Any Android Phone that supports Android API level 

## 2 Architectural Design
We will create a native Android application and use various packages contained within the android application framework to perform activities as specified in the requirements. We will also consider using the SQLite library  in order to store persistent data. The sdk we create will be deployed on an Android Mobile device.  
### 2.1 Component Diagram
Our system consists of three major components a user interface component , a database component, and an external web service component. The user interface component which is represented by multiple classes including Add_Cryptograms,  Add_Player, AdminHomePage, Cryptogram_List, MainActivity, Player_Home_Page, Ratings, Solve_Cryptogram, Solve_Prior, View_Prior. All these classes interact directly with the user interface and display an element on the android screen. The user interface component directly depends on the interface of the database component. Using the database component the user interface is supplied with data needed to display on the screen.  The database component consists of one class named DBHelper and it contains methods which query an with a sqlite database containing data from our system. The third component, the external web service component, consists of one class ServerUtility. It is designed to directly interact with the external provided database from the requirement. It interacts directly with the android device and receives  call to its provided services on events listed in the requirements


### 2.2 Deployment Diagram
![enter image description here](https://lh3.googleusercontent.com/-xNV_y-Y5lmQ/WVb_4nz_-1I/AAAAAAAAAUU/r9LudGBfgGEx9L1hjR-FnNTL_xRANadlwCLcBGAs/s0/deployment+6300+-+overview.png "deployment 6300 - overview.png")
Our deployment diagram show the architecture of our Cryptogram system. The interaction and composition of each on of the artifacts is shown in the diagram. 
## 3 Low-Level Design

The user interface component internal design includes dependency on various packages within the android package. Specifically it includes depends on packages that interact with the android screen to display data and retrieve user input. Including the android class view in the android.view.* package. The second major dependency of all the user interface classes is the android package Bundle in the android.os.bundle package. This is used to share information between various class of the user interface component. Also included as a dependency is the interface of the  database component which supplies the data to the user interface component
The database component internal design includes dependency on android content used to retrieve data to the android application from an sqlite database. Also used by this component is the android.database.sqlite.* package used for querying an sqlite database in the android. Our external web service component internal design consists of  android.os.* packages in order to query the external database.
 
### 3.1 Class Diagram

![enter image description here](https://lh3.googleusercontent.com/-C0kplubhODg/WWBLC69NfmI/AAAAAAAAAJ8/kA99-KTzoSUP6hrFebhPL-CEgYvcenQ9wCLcBGAs/s0/cs6300+class+diagram+-+Page+1.png "cs6300 class diagram - Page 1.png")


### 3.2 State Diagram of GUI
![enter image description here](https://lh3.googleusercontent.com/-wThix1GfL8g/WWAHuS0G54I/AAAAAAAAAX0/qgcGUoCEzOwircGdXoXW6kWTMCQA-ReCgCLcBGAs/s0/GUI+State+Chart+Diagram.jpg "GUI State Chart Diagram.jpg")


## 4 User Interface Design
![enter image description here](https://lh3.googleusercontent.com/-3sIOie4_5iM/WWAFOpG7EOI/AAAAAAAAAXs/5rAJj-fwvFAq8KlPYvGN7SvQL1dbPFEXwCLcBGAs/s0/UserInterfaceDesign.png "UserInterfaceDesign.png")
