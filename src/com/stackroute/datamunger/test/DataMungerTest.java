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
		//This method is used to initialize the required variables
		dataMunger = new DataMunger();
		
	}
	@After
	public void teardown() {
		//teardown method runs, after every test case run
		//This method is used to clear the initialized variables
		dataMunger = null;

	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void testGetFileName() {
	
		assertEquals("testGetFileName() : Retrieval of Filename failed","ipl.csv", dataMunger.getFile("select city,winner,team1,team2 from ipl.csv"));
	
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetFileNameFailure() {
		//TODO: Please include AssertError message for all Asserts. 
		assertNotEquals("testGetFileNameFailure() : Checking for filename", "ipl1.csv", dataMunger.getFile("select city,winner,team1,team2 from ipl.csv"));
	
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetAllColumns() {
	
		assertEquals("testGetAllColumns() : Retrieval of all columns failed",new String[] { "*" }, dataMunger.getFields("select * from ipl.csv"));
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetAllColumnsFailure() {
	
		assertNotEquals("testGetAllColumnsFailure() : Checking column names",new String[] { "*" }, dataMunger.getFields("select * from ipl1.csv"));
	}


	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnNames() {
	
		
		assertEquals("testGetColumnNames() : Retrieval of selected columns failed",new String[] { "city", "winner", "team1", "team2" },
				dataMunger.getFields("select city,winner,team1,team2 from ipl.csv"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnNamesFailure() {
	
		
		assertNotEquals("testGetColumnNamesFailure() : Checking column names",new String[] { "city", "winner", "team1", "team2" },
				dataMunger.getFields("select city1,winner1,team1,team2 from ipl.csv"));
	}
	


	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithWhereClause() {
	
		assertEquals("testGetColumnsWithWhereClause() : Retrieval of Filename failed","ipl.csv", dataMunger.getFile("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals("testGetColumnsWithWhereClause() : Retrieval of selected columns failed",new String[] { "city", "winner", "player_match" },
				dataMunger.getFields("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals("testGetColumnsWithWhereClause() : Retrieval of Base Query failed","select city,winner,player_match from ipl.csv ",
				dataMunger.getBaseQuery("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals("testGetColumnsWithWhereClause() : Retrieval of conditions part failed"," season > 2014",
				dataMunger.getConditionsPartQuery("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals("testGetColumnsWithWhereClause() : Retrieval of conditions failed",new String[] { "season > 2014" },
				dataMunger.getConditions("select city,winner,player_match from ipl.csv where season > 2014"));

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithWhereClauseFailure() {
	
		assertNotEquals("testGetColumnsWithWhereClauseFailure() : Checking filename","ipl.csv", dataMunger.getFile("select city,winner,player_match from ipl1.csv where season1 > 2014"));
		assertNotEquals("testGetColumnsWithWhereClauseFailure() : Checking column names",new String[] { "city", "winner", "player_match" },
				dataMunger.getFields("select city,winner,player_match from ipl1.csv where season1 > 2014"));
		assertNotEquals("testGetColumnsWithWhereClauseFailure() : Checking Base Query","select city,winner,player_match from ipl.csv ",
				dataMunger.getBaseQuery("select city1,winner,player_match from ipl1.csv where season > 2014"));
		assertNotEquals("testGetColumnsWithWhereClauseFailure() : Checking conditions part"," season > 2014",
				dataMunger.getConditionsPartQuery("select city,winner,player_match from ipl1.csv where season1 > 2014"));
		assertNotEquals("testGetColumnsWithWhereClauseFailure() : Checking conditions",new String[] { "season > 2014" },
				dataMunger.getConditions("select city,winner,player_match from ipl1.csv where season1 > 2014"));

	}
	
	
	

	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereClause() {
		
		assertEquals("testGetColumnsWithMultipleWhereClause() : Retrieval of Invalid filename","ipl.csv", dataMunger
				.getFile("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereClause() : Retrieval of selected columns failed",new String[] { "city", "winner", "player_match" }, dataMunger
				.getFields("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereClause() : Retrieval of Base Query failed","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereClause() : Retrieval of conditions part failed"," season > 2014 and city ='bangalore'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereClause() : Retrieval of select columns failed",new String[] { "season > 2014", "city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereClause() : Retrieval of Logical Operators failed",new String[] { "and" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereClauseFailure() {
		
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : Checking filename","ipl.csv", dataMunger
				.getFile("select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : Checking column names",new String[] { "city", "winner", "player_match" }, dataMunger
				.getFields("select city1,winner1,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : Checking Base Query","select city,winner,player_match from ipl1.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season1 > 2014 and city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : Checking conditions part"," season < 2014 and city != 'bangalore'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : Checking conditions",new String[] { "season > 2014", "city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='chennai'"));
		assertNotEquals("testGetColumnsWithMultipleWhereClauseFailure() : Checking Logical Operators",new String[] { "and" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl1.csv where season > 2014 or city ='Bangalore'"));
	}
	


	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereOrClause() {
		

		assertEquals("testGetColumnsWithMultipleWhereOrClause() : Retrieval of Filename failed","ipl.csv", dataMunger
				.getFile("select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereOrClause() : Retrieval of selected columns failed",new String[] { "city", "winner", "player_match" }, dataMunger
				.getFields("select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereOrClause() : Retrieval of Base Query failed","select city,winner,player_match from ipl.csv ", dataMunger
				.getBaseQuery("select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereOrClause() :  Retrieval of conditions part failed"," season > 2014 or city ='bangalore'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereOrClause() :  Retrieval of selected columns failed",new String[] { "season > 2014", "city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("testGetColumnsWithMultipleWhereOrClause() :  Retrieval of Logical Operators failed",new String[] { "or" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereOrClauseFailure() {
		

		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() :  Checking filename","ipl.csv", dataMunger
				.getFile("select city,winner,player_match from ipl1.csv where season > 2014 or city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() :  Checking column names",new String[] { "city1", "winner1", "player_match1" }, dataMunger
				.getFields("select city,winner,player_match from ipl1.csv where season > 2014 or city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() :  Checking Base Query","select city,winner,player_match from ipl.csv ", dataMunger
				.getBaseQuery("select city,winner,player_match from ipl1.csv where season > 2014 or city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() :  Checking conditions part"," season < 2014 or city !='bangalore'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 or city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() :  Checking conditions",new String[] { "season1 < 2014", "city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 or city ='Bangalore'"));
		assertNotEquals("testGetColumnsWithMultipleWhereOrClauseFailure() :  Checking Logical Operators",new String[] { "or" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore'"));
	}
	
	
	


	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithThreeWhereOrClause() {
		
		assertEquals("testGetColumnsWithThreeWhereOrClause() :  Retrieval of Filename failed","ipl.csv", dataMunger.getFile(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("testGetColumnsWithThreeWhereOrClause() :  Retrieval of selected columns failed",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("testGetColumnsWithThreeWhereOrClause() :  Retrieval of Base Query failed","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("testGetColumnsWithThreeWhereOrClause() :  Retrieval of conditions part failed"," season > 2014 and city ='bangalore' or city ='delhi'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("testGetColumnsWithThreeWhereOrClause() :  Retrieval of conditions failed",new String[] { "season > 2014", "city ='bangalore'","city ='delhi'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("testGetColumnsWithThreeWhereOrClause() :  Retrieval of Logical Operators failed",new String[] { "and","or" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithThreeWhereOrClauseFailure() {
		
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() :  Checking filename","ipl.csv", dataMunger.getFile(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() :  Checking columns names",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city1,winner,player_match from ipl.csv where season1 > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() :  Checking Base Query","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() : Checking Conditions Part"," season > 2014 and city ='bangalore' or city ='delhi'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl1.csv where season1 < 2014 and city ='Bangalore' or city ='Delhi'"));
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() : Checking Conditions",new String[] { "season > 2014", "city ='bangalore'","city ='chennai'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl1.csv where season1 < 2014 and city ='Bangalore' or city ='Delhi'"));
		assertNotEquals("testGetColumnsWithThreeWhereOrClauseFailure() : Checking Logical Operators",new String[] { "and","or" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ip11.csv where season > 2014 and1 city ='Bangalore' or city ='Delhi'"));
	}
	

	@SuppressWarnings("deprecation")
	  @Test 
	  public void testGetColumnsWithMultipleWhereGroupByClause() {
		   
		  	assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : Retrieval of selected columns failed",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : Retrieval of Base Query failed","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : Retrieval of conditions part failed"," season > 2014 and city ='bangalore' ", dataMunger.getConditionsPartQuery(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : Retrieval of conditions failed",new String[] { "season > 2014", "city ='bangalore'"}, dataMunger.getConditions(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : Retrieval of Logical Operators failed",new String[] { "and" }, dataMunger.getLogicalOperators(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("testGetColumnsWithMultipleWhereGroupByClause() : Retrieval of Group by fields failed",new String[] { "winner" }, dataMunger.getGroupByFields(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
	  
	 }
	@SuppressWarnings("deprecation")
	  @Test 
	  public void testGetColumnsWithMultipleWhereGroupByClauseFailure() {
		   
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : Checking column names",new String[] { "city1", "winner", "player_match" }, dataMunger.getFields(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : Checking Base Query","select city1,winner,player_match from ipl1.csv ", dataMunger.getBaseQuery(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : Checking Conditions part"," season1 < 2014 and city ='bangalore' ", dataMunger.getConditionsPartQuery(
					"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' group by winner"));
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : Checking Conditions ",new String[] { "season1 < 2014", "city ='bangalore'"}, dataMunger.getConditions(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : Checking Logical Operators",new String[] { "or" }, dataMunger.getLogicalOperators(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
		  	assertNotEquals("testGetColumnsWithMultipleWhereGroupByClauseFailure() : Checking  Group By field",new String[] { "winner1" }, dataMunger.getGroupByFields(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
	  
	 }
	  


	@SuppressWarnings("deprecation")
	@Test
	public void testGetWithGroupByClause() {
	
		dataMunger.parseQuery("select city,winner,player_match from ipl.csv group by winner");
		assertEquals("testGetWithGroupByClause() : Retrieval of selected columns failed",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("testGetWithGroupByClause() : Retrieval of Base Query failed","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("testGetWithGroupByClause() : Conditions part is not null",null, dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("testGetWithGroupByClause() : Conditions is not null",null, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("testGetWithGroupByClause() : Logical Operator is not null",null, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("testGetWithGroupByClause() : Retrieval of Group By  field failed",new String[] { "winner" }, dataMunger.getGroupByFields(
				"select city,winner,player_match from ipl.csv group by winner"));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetWithGroupByClauseFailure() {
	
		dataMunger.parseQuery("select city,winner,player_match from ipl1.csv group by winner");
		assertNotEquals("testGetWithGroupByClauseFailure() : Checking column names",new String[] { "city1", "winner1", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl1.csv group by winner"));
		assertNotEquals("testGetWithGroupByClauseFailure() : Checking Base Query","select city1,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city1,winner,player_match from ipl1.csv group by winner"));
		assertNotEquals("testGetWithGroupByClauseFailure() : Checking Conditions Part",1, dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl1.csv group by winner"));
		assertNotEquals("testGetWithGroupByClauseFailure() : Checking Conditions",1, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertNotEquals("testGetWithGroupByClauseFailure() : Checking Logical Operators",1, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl1.csv group by winner"));
		assertNotEquals("testGetWithGroupByClauseFailure() : Checking Group by Column",new String[] { "winner" }, dataMunger.getGroupByFields(
				"select city,winner1,player_match from ipl1.csv group by winner"));
	}
	

	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereAndOrderByClause() {
	
		dataMunger.parseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city");
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : Retrieval of selected columns failed",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : Retrieval of Base Query failed","select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : Retrieval of conditions part failed"," season > 2014 and city ='bangalore' ", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : Retrieval of conditions failed",new String[] {"season > 2014","city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : Retrieval of Logical Operators failed",new String[] {"and"}, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : Retrieval of Invalid group by fields",null, dataMunger.getGroupByFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("testGetColumnsWithMultipleWhereAndOrderByClause() : Retrieval of Invalid Order by value ",new String[] { "city" }, dataMunger.getOrderByFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testGetColumnsWithMultipleWhereAndOrderByClauseFailure() {
	
		dataMunger.parseQuery(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city");
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure(): Retrieval of invalid columns ",new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure(): Retrieval of invalid Base Query","select city,winner,player_match from ipl1.csv ", dataMunger.getBaseQuery(
				"select city1,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure(): Retrieval of invalid conditions part"," season < 2014 and city ='bangalore' ", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure(): Retrieval of invalid conditions",new String[] {"season < 2014","city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl1.csv where season1 > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure(): Retrieval of invalid Logical Operators failed",new String[] {"or"}, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure(): Retrieval of Invalid Group by column",1, dataMunger.getGroupByFields(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city"));
		assertNotEquals("testGetColumnsWithMultipleWhereAndOrderByClauseFailure(): Retrieval of invalid order by city",new String[] { "city1" }, dataMunger.getOrderByFields(
				"select city,winner,player_match from ipl1.csv where season > 2014 and city ='Bangalore' order by city"));
	}
	 
	
	
	
}