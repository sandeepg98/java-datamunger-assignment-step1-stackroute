### Problem Statement

String Parsing  (Query string)

a. Write a program to read the query string as input from the user and parse the given string into word

    Input : 	select * from Employee.csv  where  department  = ‘HR’ and salary>=3000

    Output: 	[select ,*, from, Employee.csv,  where,  department,  =, ‘HR’, and, salary,>=,3000]

    Note:  If the query contains group by, order by, having should also fetch

b. Write a program to extract only the parts of query

	i.  Get only base query from the query string. (without where condition)
		Example : select * from Employee.csv  

	ii. Get only where condition part from the query
		Example : department  = ‘HR’ and salary>=3000
		Note: where condition part should not contain group by, order by, having parts.

	iii. Parse the Where condition part based on to the operators
		1. Relational Operators
			a. Ex: if where condition is :   department  = ‘HR’ and salary>=3000
			b. The output should be
				i. Restriction - 1
					1. propertyName : department
					2. properyValue : HR
					3. condtionalOperator : = 
				ii. Restriction - 2
					1. propertyName : salary
					2. properyValue : 3000
					3. condtionalOperator : >=

		2. Logical Operators
			a. Ex: if where condition is : department='Dev'  or department='HR' and salary>=3000 
				i. Extract the logical operators in sequence and display/store in collection	
					Output : [or,and]

		3. Order by Operators
			a. Ex query : select  *  from emp order by salary
			b. The output should be
				i. Order by field :   salary
			c. Note:  ‘where’ may present in the query.


        4. Group by Operators
		    a. Ex Query : select * from emp group by department
		    b. The output should be
			    i. Group by field : department
		    Note: ‘where’ may present in the query.

	    5. Aggregate functions
		    a. Ex: Query: select max(sal), min(age),count(*) from emp
			    i. The output should be
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
