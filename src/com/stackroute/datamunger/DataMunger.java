package com.stackroute.datamunger;

import java.util.Arrays;

public class DataMunger {

	public static void main(String[] args) {
		// read the query from the user into queryString variable

		// call the parseQuery method and pass the queryString variable as a parameter

	}
	

	public void parseQuery(String queryString) {
		//call the methods
		getSplitStrings(queryString);
		getFile(queryString);
		getBaseQuery(queryString);
		getConditionsPartQuery(queryString);
		getConditions(queryString);
		getLogicalOperators(queryString);
		getFields(queryString);
		getOrderByFields(queryString);
		getGroupByFields(queryString);
		getAggregateFunctions(queryString);
	}
	
	// parse the queryString into words and display
	public String[] getSplitStrings(String queryString) {
		
		
		return null;
	}

	// get and display the filename
	public String getFile(String queryString) {
		
		
		return null;
	}
	
	// getting the baseQuery and display
	public String getBaseQuery(String queryString) {
		
		return null;

	}
	
	// get and display the where conditions part(if where condition exists)
	public String getConditionsPartQuery(String queryString) {
		
	
		return null;

	}
	
	/* parse the where conditions and display the propertyName, propertyValue and
	 conditionalOperator for each conditions*/
	public String[] getConditions(String queryString) {
		
	
		return null;
	}
	
	// get the logical operators(applicable only if multiple conditions exist)
	public String[] getLogicalOperators(String queryString) {

		
		
		return null;
		
	}
	
	/*get the fields from the select clause*/
	public String[] getFields(String queryString) {
		
		
		return null;
		
	}
	// get order by fields if order by clause exists
	public String[] getOrderByFields(String queryString) {
		
		
		return null;
	}
	
	// get group by fields if group by clause exists
	public String[] getGroupByFields(String queryString) {
		
		return null;
	}
	
	// parse and display aggregate functions(if applicable)
	public String[] getAggregateFunctions(String queryString) {
		

		return null;
	}

	
	
	
	
}