Design Discussion Team 35
===================
Design 1
----------
![Design1](https://lh3.googleusercontent.com/-qj2jiAhhsFg/WUq0C9dRP6I/AAAAAAAAAOc/X8wOG3CmsCggX3Yp19H2mm_t0neFG-GNQCLcBGAs/s0/Design1.png "Design1.png")

----------

#### <i class="icon-file"></i> Pros and Cons during the team discussion

> **Pros:**

> - Design of this class diagram is concise and well organized. UML design covers most of requirements from Assignment5.  We decided to choose this design as template to build the team's UML design.
> 
> -  The design contains classes which represent all the entities in the requirements. 
> 
> - Most of the needed methods and attributes mentioned within the requirements document are represented.






> **Cons:**

> - Few requirements of Assignment5 are missing.  For example, once the Administrator saves the complete cryptogram, there is no method to realize sending confirmation message. 
>
> - The use of some method declarations is unclear.


Design 2
-------------
![enter image description here](https://lh3.googleusercontent.com/-ARftf7jZO1s/WUrErxY3ZVI/AAAAAAAAAOw/Ormamv0mrpg7OAGxSQkPmLJKV8RyvKP2QCLcBGAs/s0/Desgin2.png "Desgin2.png")
#### <i class="icon-file"></i> Pros and Cons during the team discussion
> **Pros:**

> - This design is very straightforward and easy to follow.  
> - The use of HashMaps to construct solutions is clear and is a good implementation.
> - The classes have little dependency on one another making the design simple. 
> - Well organized
> 
> **Cons:**
> 
> - Few requirements of Assignment5 are missing. For example, Identifier attribute was not listed in the Cryptogram Class. 
> - A few classes that may be needed in order to ensure a better organization of code are missing.



Design 3
-------------
![enter image description here](https://lh3.googleusercontent.com/-WOu9-FoIAO0/WUrE7mHRA8I/AAAAAAAAAO4/LQtwSKLzqmkVdPYAY1luKpRm97XUpkv3wCLcBGAs/s0/Design3.png "Design3.png")
#### <i class="icon-file"></i> Pros and Cons during the team discussion
> **Pros:**

> - This design provides enough details for the Assignment5 requirements. 
> - The design has many separate modules representing the objects and actions from the requirements.
> - Includes all necessary classes as mentioned within the requirements document.

> **Cons:**
> 
> - This design is kind of complicated and not easy to follow. 
> - A few classes that are not needed can be omitted


Team Design
------------------
![design-team](https://lh3.googleusercontent.com/-XsSkdSD7MF0/WUwLaD6xEyI/AAAAAAAAAPU/LGBDHgfuhjgyiPNKHxdCy3cb3Fjzz2btgCLcBGAs/s0/design-team.jpg "design-team.jpg")


**Main Commonalities & Differences:**

>- Design 2 has less classes represented than Design 1 & 3.
>- All the designs included a Administrator class, Player/User class, Cryptogram class and an External Web Service Utility as denoted within the requirements document.
>- Design 3 specified a Data Access Object class with a cryptogram, solution and player attribute.
>- Design 1 & 3 incorporated a Player Ratings class in order to handle ratings for each specified player
>- Design 1 specified a Solution class in order to handle all solutions pertaining to a specific cryptogram
>- Design 3 represented a central server to be used to communicate with the External Web Service
>- Design 3 also included 2 additional classes (PreviouslySolvedCryptogram & ListOfAvailableCryptogram) in order to handle the specific player’s previously solved cryptograms and the list of all available cryptograms within the application.

**Design Justification:**

We had choose to use our design because we wanted the classes that represented the entities from the requirements to have separation and single responsibility. For example we wanted a class to represent a Player, Cryptogram, Solution etc. instead of grouping these items together. This helped us create a concise and well organized UML class diagram. Which will help us when we begin the implementation stage.

**Summary:**

Discussing our different designs together brought to light the many different assumptions about the system that each of us unconsciously made about the system. By walking through our systems as each of us saw them, teammates’ requests for clarifications were invaluable in clarifying our designs and determining which alternatives made the most sense to implement.  This group review also improved our understandings of UML syntax and usage as we each reinforced our understandings and learned new UML functionality from each other. The overall process has helped us understand that group collaboration is very helpful for the process of delivering a good solid design and enhancing the benefits of individual contributions.
