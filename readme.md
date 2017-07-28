## Seed code - Boilerplate for step 1 - DataMunger Assignment(PLEASE CHANGE THIS README POST CLONNING - SAVE THE INSTRUCTIONS SEPERATELY)

### Problem Statement

As an initial step of building a Utility to get meaningful information out of our Raw data - `as a first step you should be able to parse (decipher) our question. 
In our computing terms, we call this a query.`Our system should be able to interpret this and break it into several parts - so that necessary actions can be triggered to fetch the required information in the proper format.

### STEP 1 - Deciphering the parts of the String (Query)

Please note that the End User interacting with this utility will give out `SQL` like instructions and would expect the system to respond with necessary information. The system perceives this as a
String of characters and we should manipulate and break this string into appropriate Data Structures. For Instance,

Query: `SELECT winner, Count( winner ) FROM ipl.csv WHERE win_by_runs > 100 GROUP BY winner ORDER BY winner;`

Sample Data: 

|    winner                   |  count    |
|:----------------------------|----------:|
|Kings XI Punjab              |   1       |     
|Kolkata Knight Riders        |   1       |
|Rajasthan Royals             |   1       |
|Royal Challengers Bangalore  |   3       |


Query: `SELECT city, winner FROM ipl.csv WHERE winner='Chennai Super Kings' AND city ='Abu Dhabi' AND season=2014;`

Sample Data: 

|    city      |  winner            |
|:-------------|-------------------:|
|Abu Dhabi     | Chennai Super Kings|

-----------
Few terms need to understand before starting the project.

    1. select ->  get the required information

    2. '*' ->  select all the fields 

    3. where ->  filter result

    4. order by ->  sort the result based on particular field

    5. group by ->  get the records together based  on particular field.

    6. aggregate ->  There are 5 aggregates are there called sum,count,min,max,avg.  

    7. Example query string :  select season,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore';

        a. fetching the season, winner and  player of the match 

        b. from the file ipl.csv  (csv -> Comma Separated Value)

        c. where - filter the results. Get the details of the matches played in Bangalore after season 2014
        
        d. ipl.csv - name of the file from which we need to fetch the information/records

-----------

## Our STEP 1 involves two tasks, given below:

a. Write a program to read the query string as input and split them into words. Print the output on console as given below:

    Input String : 	select * from ipl.csv where season > 2014 and city ='Bangalore';
    
    Output String: 	select
    			    * 
    			    from 
    			    ipl.csv  
    			    where  
    			    season
    			    > 
    			    2014
    			    and 
    			    city
    			    =
    			    'Bangalore'

b. Further enhance your program to now extract certain parts of the same query:

	i. Get only file name from the query string.
	
		Input String : select * from ipl.csv where season > 2014 and city ='Bangalore';
		Output String : ipl.csv
	
	
	ii. Get only base part(before `where` word) of the query from the given query string. 

		Input String : select * from ipl.csv where season > 2014 and city ='Bangalore';
		Output String : select * from ipl.csv

	iii. Get only filter part(after `where` word) of the query from the given query string. 
	
		Input String : select * from ipl.csv where season > 2014 and city ='Bangalore';
		Output String : season > 2014 and city ='Bangalore'

	iv. As there will be multiple conditions, seperate each condition and display in different line.
	    
	    Input String : select * from ipl.csv where season > 2014 and city ='Bangalore';
		Output String : 
	                	Condition 1 : season > 2014 
		                Condition 2 : city = 'Bangalore'
		                
	v. Split the condition part into variable (before relational operator) and value (after relational operator) and operator.
	    Note: relational operators are "<, <=, >, >=, =, !="
	
	    Input String : select * from ipl.csv where season > 2014 and city ='Bangalore';
		Output String : 
	                	Condition 1 : 
	                	    variable : season
	                	    operator : > 
	                	    value    : 2014 
		                Condition 2 : 
	                        variable : city
	                        operator : =
	                        value    : 'Bangalore'
	                        
	vi. Extract the logical operators in sequence from the given query string. 
	    Note: Logical operators are "and, or, not"
	    
	    Input String : select season,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or date > '31-12-2014';
	    Output String : 
		        operator 1: and
		        operator 2: or
		        
	vii. Extract the selected fields/information from the given query.
	
	    Input String : select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore';
		Output String :
            	city
            	winner
            	player_match
    
    viii. Extract the order by field from the given string.
        Note : user may need the information in sorted order of a particular field.
        
        Input String : select * from ipl.csv where season > 2016 and city='Bangalore' order by win_by_runs;
		Output String : win_by_runs
    
    ix. Extract the group by field from the given string.
        Note : user may need the related information grouped together.
        For Example they may require to see the information department wise.
        
        Input String : select team1, sum(win_by_runs) from ipl.csv where season > 2016 and city='Bangalore' group by team1;
		Output String : team1
	
	x. User may required the information like who is getting maximum salary or minimum age etc.. these are called aggregate functions (minimum, maximum, count, average, sum)
	
	    Input String : select avg(win_by_wickets),min(win_by_runs) from ipl.csv; 
		Output String : 
		        Aggregate 1
		            Aggregate Name  : avg
		            Aggregate Field : win_by_wickets
	            
	            Aggregate 2
		            Aggregate Name  : min
		            Aggregate Field : win_by_runs
	            
	   	Note:  Other parts like where clause, order by, group by may be present in the query.

### Expected solution

Displaying various `components/parts` of the query like `selected fields, conditional parts, aggregate fields, groupBy field, OrderBy field` 

### Project structure

The folders and files you see in this repositories, is how it is expected to be in projects, which are submitted for automated evaluation by Hobbes

	Project
	|
	├── resources 			        // If project needs any data file, it can be found here/placed here, if data is huge they can be mounted, no need put it in your repository
	|
	├── com.stackroute.datamunger	    // all your java file will be stored in this package
	|	└── test		                // all your test cases are written using JUnit, these test cases can be run by selecting Run As -> JUnit Test 
	|	└── DataMunger.java	        // This is the main file, all your logic is written in this file only
	|
	├── .classpath			        // This file is generated automatically while creating the project in eclipse
	|
	├── .hobbes   			        // Hobbes specific config options, such as type of evaluation schema, type of tech stack etc., Have saved a default values for convenience
	|
	├── .project			            // This is automatically generated by eclipse, if this file is removed your eclipse will not recognize this as your eclipse project. 
	|
	├── pom.xml 			            // This is a default file generated by maven, if this file is removed your project will not get recognised in hobbes.
	|
	└── PROBLEM.md  		            // This files describes the problem of the assignment/project, you can provide as much as information and clarification you want about the project in this file

> PS: All lint rule files are by default copied during the evaluation process, however if need to be customizing, you should copy from this repo and modify in your project repo


#### To use this as a boilerplate for your new project, you can follow these steps

1. Clone the base boilerplate in your local

	`git clone https://gitlab-dev.stackroute.in/datamunger-java/step-1-boilerplate.git`

2. Remove its remote or original reference

	`git remote rm origin`

3. Add your new repository reference as remote

	`git remote add origin ssh://git@gitlab-dev.stackroute.in:2222/yourusername/your-new-project-repo.git`

4. Commit and Push the project to git

	`git commit -a -m "Initial commit | or place your comments according to your need"`

	`git push -u origin master`

5. Check on the git repo online, if the files have been pushed


### Important instructions for Participants
> - We expect you to write the assignment on your own by following through the guidelines, learning plan, and the practice exercises
> - The code must not be plagirized, the mentors will randomly pick the submissions and may ask you to explain the solution
> - The code must be properly indented, code structure maintained as per the boilerplate and properly commented
> - Follow through the problem statement and stories shared with you

### Further Instructions on Release

*** Release 0.1.0 ***

- Right click on the Assignment select Run As -> Java Application to run your Assignment.
- Right click on the Assignment select Run As -> JUnit Test to run your Assignment.