## Seed code - Boilerplate for step 1 - DataMunger Assignment(PLEASE CHANGE THIS README POST CLONNING - SAVE THE INSTRUCTIONS SEPERATELY)

### Problem Statement

As an initial step of building a Utility to get meaningful information out of our Raw data - `as a first step you should be able to parse (decipher) our question. In our computing terms, we call this
a query.`Our system should be able to interpret this and break it into several parts - so that necessary actions can be triggered to fetch the required information in the proper format.

### STEP 1 - Deciphering the parts of the String (Query)

Please note that the End User interacting with this utility will give out English like instructions and would expect the system to respond with necessary information. The system perceives this a
String of characters and we should be manipulate and break this string into appropriate Data Structures. For Instance,

<Q1> 
<SAMPLE DATA - TABLE> 

<Q2> 
<SAMPLE DATA - TABLE>

-----------
EXPLANATION OF PARTS OF A QUERY HERE

-----------
Our STEP 1 involves two tasks, given below:

a. Write a program to read the query string as input from the user and parse the given string and print the output on console as given below:

    Input String : 	select * from Employee.csv  where  department  = ‘HR’ and salary>=3000

    Output String: 	select
    			    * 
    			    from 
    			    Employee.csv  
    			    where  
    			    department  
    			    = 
    			    'HR'
    			    and 
    			    salary
    			    >=
    			    3000

b. Further enhance your program to now extract certain parts of the same query:

	i.  Get only base part(EXPLAINED ABOVE) of the query from the given query string i.e. minus the `*where*` condition. 

		Input String : select * from Employee.csv where  department  = ‘HR’ and salary>=3000
		Output String : select * from Employee.csv

	ii. Fetch the `*where*` condition(EXPLAINED ABOVE) separately from the given query.
	
		Input String : select * from Employee.csv  where  department  = ‘HR’ and salary>=3000
		Output String : department  = ‘HR’ and salary>=3000
	
		Note: where condition part should not contain group by, order by, having parts.
		
b. Write a program to extract only the parts of query

	i.  Get only base query from the query string. (without where condition)
		Example : select * from Employee.csv  

	ii. Get only where condition part from the query
		Example : department  = ‘HR’ and salary>=3000
		Note: where condition part should not contain group by, order by, having parts.

	iii. Parse the Where condition part based on to the operators and display the `propertyName, propertyValue and conditionalOperator` for each conditions
		1. Relational Operators
			a. Ex: if where condition is :   `department  = ‘HR’ and salary >= 3000`
			b. The output String should be
				i. Restriction - 1
					1. propertyName : department
					2. properyValue : HR
					3. condtionalOperator : = 
				ii. Restriction - 2
					1. propertyName : salary
					2. properyValue : 3000
					3. condtionalOperator : >=

		2. Get the Logical Operators (applicable only if multiple conditions exists)
			a. Ex: if where condition is : `department='Dev' or department='HR' and salary>=3000`
				i. Extract the logical operators in sequence and display/store in collection	
					Output String : [or,and]

		3. Get order by fields if Order by Operators exists
			a. Ex query : select  *  from emp order by salary
			b. The output String should be
				i. Order by field :   salary
			Note:  ‘where’ may present in the query.


        4. Get group by fields if Group by Operators exists
		    a. Ex Query : `select * from emp group by department`
		    b. The output String should be
			    i. Group by field : department
		    Note: ‘where’ may present in the query.

	    5. Parse and diaplay the Aggregate functions
		    a. Ex: Query: `select max(sal), min(age),count(*) from emp`
			    i. The output String should be
				    1. Aggregate function - 1
					    a. Function name : max
					    b. Field name        : sal
				    2.  Aggregate function - 2
					    a. Function name : min
					    b. Field name        : age
				    3.  Aggregate function - 3
					    a. Function name : count
					    b. Field name : *
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