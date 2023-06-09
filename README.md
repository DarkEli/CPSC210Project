# CPSC210 Personal Project

## North America Job Offer Comparator

A **job offer comparison application** for graduating UBC CS students. Students can choose the best job offer that they’ve
got according to locations, their own preferences and most importantly, to check whether students got low-balled offers 
or not. I may use this application for choosing job offers.<br>
<br>
First of all, the information (e.g. office location, average salary) of some top companies <em>(e.g. MANGA)</em> is 
stored inside the system already. At the same time, the living cost of North American big cities <em>(e.g. Vancouver, 
Toronto, New York, Palo Alto, Mountainview …)</em> will be stored inside the system as well. <br>
<br>
For instance, the user can choose which companies he/ she got in, and input the offer into the system *(salary + signing 
bonus + stock)*. **The system will help students calculate the average annual salary in CAD/ USD. Then, the user can choose which city the office is
located in, and the system will return the living cost of that city and the average salary of the workers in that 
company for students and eventually calculate the disposable income (after tax) per year of the students if he/ she 
decides to work there. The user is able to compare multiple offers through a bar chart (based on disposable income) and then make a wise choice.**


## User Stories

- As a user, I want to be able to input the job offer (salary + signing bonus + stock).
- As a user, I want to be able to input multiple job offers.
- As a user, I want to be able to find the best job offer (with the highest salary).
- As a user, I want to be able to see all the job offer info.
- As a user, I want to be able to add the city.
- As a user, I want to be able to see all the city info on the panel.
- - As a user, I want to be able to see all job offers on the panel.
- As a user, I want to be able to add companies that have sent me an offer to a list.
- As a user, I want to be able to save my JobOfferList and CityList to file (if I so choose)
- As a user, I want to be able to be able to load my JobOfferList and CityList from file (if I so choose)
- As a user, I want to be able to add multiple Job Offers to a JobOfferList. 
- As a user, I want to be able to add multiple Cities to a CityList. 
- As a user, I want to be able to load and save the state of the application


## Phase 4 task 2
![](/Applications/project_b1w6b/data/Screenshot 2023-04-01 at 2.58.50 AM.png)

## Phase 3 task 3
If I can start the project once again, I would implement override equal and hashcode to ensure that the Objects 
(JobOffer/ City) are the same. Secondly, I would add try-catch to ensure that all the doubles and integers are in 
positive value. Thirdly, I would write the code more neatly. Thirdly, I should create an interface class List
that has addObject/ removeObject and showList methods. The JobOfferList and the CityList should implement the class.
Fourthly, for the JSONReader and JSONWriter, the methods' names are so similar to each other and sometimes I don't even
know which JSON methods are working. Renaming some methods definitely improves the readability of codes.
Lastly, I would try to increase the cohesion of my code and reduce coupling. Definitely, the code can be turned into 
more clean, tidy and readable. 


For the GUI, besides the design of the UI, 
the chat box that allows users to input the info can be improved. When user clicks the add/ remove JobOffer/ City button 
by mistake, the user cannot cancel the process and must have input something or just keep clicking the cancel button for
a few times, which is totally unnecessary and a waste of time. 

