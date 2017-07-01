# Design Document Version 1.0

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
![enter image description here](https://lh3.googleusercontent.com/-OezjbJpha_I/WVb8pd82wEI/AAAAAAAAAT4/1YXlUo9zXRM-2pYVLEvn1UdJ5KyGlUbJwCLcBGAs/s0/component+6300+-+overview.png "component 6300 - overview.png")

Our component diagram contains contains the relationship among the components outlined within our class diagram and the dependency that they have on each other. The User interface is also outlined in this diagram which can function by only relying on the Administrator class. Also contained in our component diagram is the Persistence database representation which provides an data for the for major components Player, Cryptogram, Solution and Ratings.

### 2.2 Deployment Diagram
![enter image description here](https://lh3.googleusercontent.com/-xNV_y-Y5lmQ/WVb_4nz_-1I/AAAAAAAAAUU/r9LudGBfgGEx9L1hjR-FnNTL_xRANadlwCLcBGAs/s0/deployment+6300+-+overview.png "deployment 6300 - overview.png")
Our deployment diagram show the architecture of our Cryptogram system. The interaction and composition of each on of the artifacts is shown in the diagram. 
## 3 Low-Level Design
![enter image description here](https://lh3.googleusercontent.com/-rqq96Lx5p2g/WVcAD2hkFYI/AAAAAAAAAUc/j0ifmavBEDkVu7GEj9q_gt6Jy9jehkI-ACE0YBhgL/s0/component+6300+-+administrator.png "component 6300 - administrator.png")
![enter image description here](https://lh3.googleusercontent.com/-uhhU58JDC_M/WVcAKEZzK3I/AAAAAAAAAUs/pJ3WnaEIVhEtLRJHBJP_x8pD9kWc7A2qgCLcBGAs/s0/component+6300+-+player.png "component 6300 - player.png")
![enter image description here](https://lh3.googleusercontent.com/-i-KWtQHhb-Y/WVcAR9SLe6I/AAAAAAAAAU0/FMac8F8yH9ohKRwmD6spUWBTmxQjE_pLwCLcBGAs/s0/component+6300+-+solution.png "component 6300 - solution.png")
![enter image description here](https://lh3.googleusercontent.com/-O6X8ZHs3YzM/WVcAX5bmnxI/AAAAAAAAAU8/XRDxwfFBuCwfSz5HhYEdSYd7WC1kVvZ_gCLcBGAs/s0/component+6300+-+rating.png "component 6300 - rating.png")
To Illustrate how the components within our systems are designed on a low level we used internal component diagrams. Each of the individual internal component diagram corresponds to our (2.1) component diagram by referring back to this diagram you can see the interfaces that this individual component is dependent on and which it provides an interface for another component.  
### 3.1 Class Diagram
![enter image description here](https://lh3.googleusercontent.com/-i6Q6RR4D9CQ/WVcLCOwliaI/AAAAAAAAAVw/X09W1P5ZtMMKq22nNy7jbuR8F-Ub-MI4QCLcBGAs/s0/designP2.png "designP2.png")



### 3.2 State Diagram of GUI
![enter image description ⧸⧸here](https://lh3.googleusercontent.com/-w3p-QPzjGfc/WVbxuZzmGCI/AAAAAAAAATM/RavYITDGPikOvhOTDGaLDdBjd4kiQFc3ACLcBGAs/s0/GUI+State+Chart+Diagram.jpg "GUI State Chart Diagram.jpg")


## 4 User Interface Design
![enter image description here](https://lh3.googleusercontent.com/-C4ZBJrRwQNY/WVVuIiGd6DI/AAAAAAAAAQc/cQ-n8VmT0wQgA_69zpDbl0BIo15L82UsACE0YBhgL/s0/User+Interface.jpg "User Interface.jpg")
