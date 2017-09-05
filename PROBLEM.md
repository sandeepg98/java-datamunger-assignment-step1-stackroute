### Problem Statement

String Parsing  (Query string)

a. Write a program to read the query string as input and split them into words. Print the output on console as given below:

    Input String : 	select * from ipl.csv where season > 2014 and city = 'Bangalore'
    
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
    			    'bangalore'

b. Further enhance your program to now extract certain parts of the same query:

	i. Get only file name from the query string.
	
		Input String : select * from ipl.csv where season > 2014 and city ='Bangalore'
		Output String : ipl.csv
	
	
	ii. Get only base part(before `where` word) of the query from the given query string. 

		Input String : select * from ipl.csv where season > 2014 and city ='Bangalore'
		Output String : select * from ipl.csv 

	iii. Get only filter part(after `where` word) of the query from the given query string. 
	
		Input String : select * from ipl.csv where season > 2014 and city ='Bangalore'
		Output String : season > 2014 and city ='bangalore'

	iv. As there will be multiple conditions, seperate each condition and display in different line.
	    
	    Input String : select * from ipl.csv where season > 2014 and city ='Bangalore'
		Output String : 
	                	          season > 2014 
                                  city ='bangalore'
		                
	v.  Extract the logical operators in sequence from the given query string. 
	    Note: Logical operators are "and, or, not"
	    
	    Input String : select season,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or date > '31-12-2014'
	    Output String : 
		        and
		        or
		        
	vi. Extract the selected fields/information from the given query.
	
	    Input String : select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'
		Output String :
            	city
            	winner
            	player_match
    
    vii. Extract the order by field from the given string.
        Note : user may need the information in sorted order of a particular field.
        
        Input String : select * from ipl.csv where season > 2016 and city='Bangalore' order by win_by_runs
		Output String : win_by_runs
    
    viii. Extract the group by field from the given string.
        Note : user may need the related information grouped together.
        For Example they may require to see the information department wise.
        
        Input String : select team1, sum(win_by_runs) from ipl.csv where season > 2016 and city='Bangalore' group by team1
		Output String : team1
	
	ix. User may required the information like who is getting maximum salary or minimum age etc.. these are called aggregate functions (minimum, maximum, count, average, sum)
	
	    Input String : select avg(win_by_wickets),min(win_by_runs) from ipl.csv 
		Output String : 
		             avg(win_by_wickets)
                     min(win_by_runs)
	            
	   	Note:  Other parts like where clause, order by, group by may be present in the query.
