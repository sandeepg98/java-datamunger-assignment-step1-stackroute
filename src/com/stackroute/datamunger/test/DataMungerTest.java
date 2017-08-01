package com.stackroute.datamunger.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.stackroute.datamunger.DataMunger;

public class DataMungerTest {

	private String queryString;
	private static DataMunger dataMunger;

	@BeforeClass
	public static void init() throws FileNotFoundException {
		dataMunger = new DataMunger();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void selectAllTestCase() {
		display();
		// dataMunger.parseQuery("select * from ipl.csv");
		assertEquals("ipl.csv", dataMunger.getFile("select * from ipl.csv"));
		assertEquals(new String[] { "*" }, dataMunger.getFields("select * from ipl.csv"));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void selectColumnsTestCase() {
		display();
		assertEquals("ipl.csv", dataMunger.getFile("select city,winner,team1,team2 from ipl.csv"));
		assertEquals(new String[] { "city", "winner", "team1", "team2" },
				dataMunger.getFields("select city,winner,team1,team2 from ipl.csv"));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void selectColumnsWithWhereTestCase() {
		display();
		assertEquals("ipl.csv", dataMunger.getFile("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals(new String[] { "city", "winner", "player_match" },
				dataMunger.getFields("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals("select city,winner,player_match from ipl.csv ",
				dataMunger.getBaseQuery("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals(" season > 2014",
				dataMunger.getConditionsPartQuery("select city,winner,player_match from ipl.csv where season > 2014"));
		assertEquals(new String[] { "season > 2014" },
				dataMunger.getConditions("select city,winner,player_match from ipl.csv where season > 2014"));

	}

	@Test
	public void selectColumnsWithMultipleWhereAndTestCase() {
		display();
		assertEquals("ipl.csv", dataMunger
				.getFile("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals(new String[] { "city", "winner", "player_match" }, dataMunger
				.getFields("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals("select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals(" season > 2014 and city ='bangalore'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals(new String[] { "season > 2014", "city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
		assertEquals(new String[] { "and" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'"));
	}

	@Test
	public void selectColumnsWithMultipleWhereOrTestCase() {
		display();

		assertEquals("ipl.csv", dataMunger
				.getFile("select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals(new String[] { "city", "winner", "player_match" }, dataMunger
				.getFields("select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals("select city,winner,player_match from ipl.csv ", dataMunger
				.getBaseQuery("select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals(" season > 2014 or city ='bangalore'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals(new String[] { "season > 2014", "city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
		assertEquals(new String[] { "or" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'"));
	}

	@Test
	public void selectColumnsWithThreeWhereOrTestCase() {
		display();
		assertEquals("ipl.csv", dataMunger.getFile(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals(new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals("select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals(" season > 2014 and city ='bangalore' or city ='delhi'", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals(new String[] { "season > 2014", "city ='bangalore'","city ='delhi'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
		assertEquals(new String[] { "and","or" }, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'"));
	}

	
	  @Test public void selectColumnsWithMultipleWhereGroupByTestCase() {
		  display(); 
		  	assertEquals(new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals("select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals(" season > 2014 and city ='bangalore' ", dataMunger.getConditionsPartQuery(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals(new String[] { "season > 2014", "city ='bangalore'"}, dataMunger.getConditions(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals(new String[] { "and" }, dataMunger.getLogicalOperators(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
			assertEquals(new String[] { "winner" }, dataMunger.getGroupByFields(
					"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner"));
	  
	 }
	 
	@Test
	public void selectWithGroupByTestCase() {
		display();
		dataMunger.parseQuery("select city,winner,player_match from ipl.csv group by winner");
		assertEquals(new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals("select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals(null, dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals(null, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals(null, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv group by winner"));
		assertEquals(new String[] { "winner" }, dataMunger.getGroupByFields(
				"select city,winner,player_match from ipl.csv group by winner"));
	}

	@Test
	public void selectColumnsWithMultipleWhereAndOrderByTestCase() {
		display();
		dataMunger.parseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city");
		assertEquals(new String[] { "city", "winner", "player_match" }, dataMunger.getFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals("select city,winner,player_match from ipl.csv ", dataMunger.getBaseQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals(" season > 2014 and city ='bangalore' ", dataMunger.getConditionsPartQuery(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals(new String[] {"season > 2014","city ='bangalore'" }, dataMunger.getConditions(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals(new String[] {"and"}, dataMunger.getLogicalOperators(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals(null, dataMunger.getGroupByFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
		assertEquals(new String[] { "city" }, dataMunger.getOrderByFields(
				"select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city"));
	}
	 

	private void display() {
		System.out.println("================================================================");
	}

}