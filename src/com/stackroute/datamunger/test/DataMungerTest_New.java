package com.stackroute.datamunger.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.stackroute.datamunger.DataMunger;

public class DataMungerTest {

	private String queryString;
	private static DataMunger dataMunger;


	@Before
	public void setup() {
		//setup methods runs, before every test case runs
		//Use this method to initialize the required variables
		dataMunger = new DataMunger();
		
	}
	@After
	public void teardown() {
		//teardown method runs, after every test case run
		//Use this method to clear the initialized variables
		dataMunger = null;

	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void testGetFileName() {
	
		assertEquals("testGetFileName() : ","ipl.csv", dataMunger.getFile("select city,winner,team1,team2 from ipl.csv"));
	
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetFileNameFailure() {
		//TODO: Please include AssertError message for all Asserts. 
		assertNotEquals("testGetFileNameFailure() : Fetching Filename failed", "ipl1.csv", dataMunger.getFile("select city,winner,team1,team2 from ipl.csv"));
	
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetAllColumns() {
	
		assertEquals("testGetAllColumns() : ",new String[] { "*" }, dataMunger.getFields("select * from ipl.csv"));
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetAllColumnsFailure() {
	
		assertNotEquals("testGetAllColumnsFailure() : ",new String[] { "*" }, dataMunger.getFields("select * from ipl1.csv"));
	}


	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnNames() {
	
		
		assertEquals("testGetColumnNames() : ",new String[] { "city", "winner", "team1", "team2" },
				dataMunger.getFields("select city,winner,team1,team2 from ipl.csv"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnNamesFailure() {
	
		
		assertNotEquals("testGetColumnNamesFailure() : ",new String[] { "city", "winner", "team1", "team2" },
				dataMunger.getFields("select city1,winner1,team1,team2 from ipl.csv"));
	}
	


	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithWhereClause() {
	
		assertEquals("testGetColumnsWithWhereClause() : ","ipl.csv", dataMunger.getFile("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals("testGetColumnsWithWhereClause() : ",new String[] { "city", "winner", "player_match" },
				dataMunger.getFields("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals("testGetColumnsWithWhereClause() : ","select city,winner,player_match from ipl.csv ",
				dataMunger.getBaseQuery("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals("testGetColumnsWithWhereClause() : "," season > 2014",
				dataMunger.getConditionsPartQuery("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals("testGetColumnsWithWhereClause() : ",new String[] { "season > 2014" },
				dataMunger.getConditions("select city,winner,player_match from ipl.csv where season > 2014"));

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithWhereClauseFailure() {
	
		assertNotEquals("testGetColumnsWithWhereClauseFailure() : ","ipl.csv", dataMunger.getFile("select city,winner,player_match from ipl1.csv where season1 > 2014"));
		assertNotEquals("testGetColumnsWithWhereClauseFailure() : ",new String[] { "city", "winner", "player_match" },
				dataMunger.getFields("select city,winner,player_match from ipl1.csv where season1 > 2014"));
		assertNotEquals("testGetColumnsWithWhereClauseFailure() : ","select city,winner,player_match from ipl1.csv ",
				dataMunger.getBaseQuery("select city1,winner,player_match from ipl1.csv where season > 2014"));
		assertNotEquals("testGetColumnsWithWhereClauseFailure() : "," season > 2014",
				dataMunger.getConditionsPartQuery("select city,winner,player_match from ipl1.csv where season1 > 2014"));
		assertNotEquals("testGetColumnsWithWhereClauseFailure() : ",new String[] { "season > 2014" },
				dataMunger.getConditions("select city,winner,player_match from ipl1.csv where season1 > 2014"));

	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereClause() {
		
		assertEquals("testGetColumnsWithMultipleWhereClause() : ","ipl.csv", dataMunger
				.getFile("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereClause() : ",new String[] { "city", "winner", "player_match" }, dataMunger
				.getFields("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereClause() : ","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereClause() : "," season > 2014 and city ='bangalore'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereClause() : ",new String[] { "season > 2014", "city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereClause() : ",new String[] { "and" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereClauseFailure() {
		
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : ","ipl.csv", dataMunger
				.getFile("select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : ",new String[] { "city", "winner", "player_match" }, dataMunger
				.getFields("select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : ","select city,winner,player_match from ipl1.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season1 > 2014 and city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : "," season > 2014 and city ='bangalore'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : ",new String[] { "season > 2014", "city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : ",new String[] { "and" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore'"));
	}
	


	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereOrClause() {
		

		assertEquals("testGetColumnsWithMultipleWhereOrClause() : ","ipl.csv", dataMunger
				.getFile("select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereOrClause() : ",new String[] { "city", "winner", "player_match" }, dataMunger
				.getFields("select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereOrClause() : ","select city,winner,player_match from ipl.csv ", dataMunger
				.getBaseQuery("select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereOrClause() : "," season > 2014 or city ='bangalore'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereOrClause() : ",new String[] { "season > 2014", "city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereOrClause() : ",new String[] { "or" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereOrClauseFailure() {
		

		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() : ","ipl.csv", dataMunger
				.getFile("select city,winner,player_match from ipl1.csv where season > 2014 or city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() : ",new String[] { "city", "winner", "player_match" }, dataMunger
				.getFields("select city,winner,player_match from ipl1.csv where season > 2014 or city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() : ","select city,winner,player_match from ipl.csv ", dataMunger
				.getBaseQuery("select city,winner,player_match from ipl1.csv where season > 2014 or city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() : "," season > 2014 or city ='bangalore'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 or city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() : ",new String[] { "season1 > 2014", "city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 or city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() : ",new String[] { "or" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 or city ='Bangalore'"));
	}
	
	
	


	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithThreeWhereOrClause() {
		
		assertEquals("testGetColumnsWithThreeWhereOrClause() : ","ipl.csv", dataMunger.getFile(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("testGetColumnsWithThreeWhereOrClause() : ",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("testGetColumnsWithThreeWhereOrClause() : ","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("testGetColumnsWithThreeWhereOrClause() : "," season > 2014 and city ='bangalore' or city ='delhi'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("testGetColumnsWithThreeWhereOrClause() : ",new String[] { "season > 2014", "city ='bangalore'","city ='delhi'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("testGetColumnsWithThreeWhereOrClause() : ",new String[] { "and","or" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithThreeWhereOrClauseFailure() {
		
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() : ","ipl.csv", dataMunger.getFile(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() : ",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city1,winner,player_match from ipl.csv where season1 > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() : ","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() : "," season > 2014 and city ='bangalore' or city ='delhi'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() : ",new String[] { "season > 2014", "city ='bangalore'","city ='delhi'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() : ",new String[] { "and","or" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ip11.csv where season > 2014 and1 city ='Bangalore' or city ='Delhi'"));
	}
	

	@SuppressWarnings("deprecation")
	  @Test 
	  public void testGetColumnsWithMultipleWhereGroupByClause() {
		   
		  	assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : ",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : ","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : "," season > 2014 and city ='bangalore' ", dataMunger.getConditionsPartQuery(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : ",new String[] { "season > 2014", "city ='bangalore'"}, dataMunger.getConditions(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : ",new String[] { "and" }, dataMunger.getLogicalOperators(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : ",new String[] { "winner" }, dataMunger.getGroupByFields(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
	  
	 }
	@SuppressWarnings("deprecation")
	  @Test 
	  public void testGetColumnsWithMultipleWhereGroupByClauseFailure() {
		   
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : ",new String[] { "city1", "winner", "player_match" }, dataMunger.getFields(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : ","select city1,winner,player_match from ipl1.csv ", dataMunger.getBaseQuery(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : "," season1 > 2014 and city ='bangalore' ", dataMunger.getConditionsPartQuery(
					"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' group by winner"));
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : ",new String[] { "season1 > 2014", "city ='bangalore'"}, dataMunger.getConditions(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : ",new String[] { "and" }, dataMunger.getLogicalOperators(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : ",new String[] { "winner1" }, dataMunger.getGroupByFields(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
	  
	 }
	  


	@SuppressWarnings("deprecation")
	@Test
	public void testGetWithGroupByClause() {
	
		dataMunger.parseQuery("","select city,winner,player_match from ipl.csv group by winner");
		assertEquals("testGetWithGroupByClause() : ",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("testGetWithGroupByClause() : ","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("testGetWithGroupByClause() : ",null, dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("testGetWithGroupByClause() : ",null, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("testGetWithGroupByClause() : ",null, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("testGetWithGroupByClause() : ",new String[] { "winner" }, dataMunger.getGroupByFields(
				"select city,winner,player_match from ipl.csv group by winner"));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetWithGroupByClauseFailure() {
	
		dataMunger.parseQuery("select city,winner,player_match from ipl1.csv group by winner");
		assertNotEquals("testGetWithGroupByClauseFailure() : ",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl1.csv group by winner"));
		assertNotEquals("testGetWithGroupByClauseFailure() : ","select city,winner,player_match from ipl1.csv ", dataMunger.getBaseQuery(
				"select city1,winner,player_match from ipl1.csv group by winner"));
		assertNotEquals("testGetWithGroupByClauseFailure() : ",1, dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl1.csv group by winner"));
		assertNotEquals("testGetWithGroupByClauseFailure() : ",1, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertNotEquals("testGetWithGroupByClauseFailure() : ",1, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl1.csv group by winner"));
		assertNotEquals("testGetWithGroupByClauseFailure() : ",new String[] { "winner" }, dataMunger.getGroupByFields(
				"select city,winner1,player_match from ipl1.csv group by winner"));
	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereAndOrderByClause() {
	
		dataMunger.parseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city");
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : ",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : ","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : "," season > 2014 and city ='bangalore' ", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : ",new String[] {"season > 2014","city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : ",new String[] {"and"}, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : ",null, dataMunger.getGroupByFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : ",new String[] { "city" }, dataMunger.getOrderByFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereAndOrderByClauseFailure() {
	
		dataMunger.parseQuery(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city");
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure():",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure():","select city,winner,player_match from ipl1.csv ", dataMunger.getBaseQuery(
				"select city1,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure():"," season > 2014 and city ='bangalore' ", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure():",new String[] {"season > 2014","city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure():",new String[] {"and"}, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure():",1, dataMunger.getGroupByFields(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure():",new String[] { "city" }, dataMunger.getOrderByFields(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city"));
	}
	 
	
	
	
}