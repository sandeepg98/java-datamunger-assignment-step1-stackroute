package com.stackroute.datamunger.test;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.stackroute.datamunger.DataMunger;

public class DataMungerTest {

	private String queryString;
	private static DataMunger dataMunger;
	
	@BeforeClass
	public static void init() throws FileNotFoundException{
		dataMunger=new DataMunger();
	}
	
	@Test
	public void selectAllTestCase() {
		display();
		dataMunger.parseQuery("select * from ipl.csv");
	}
	
	@Test
	public void selectColumnsTestCase() {
		display();
		dataMunger.parseQuery("select city,winner,team1,team2 from ipl.csv");
	}
	
	@Test
	public void selectColumnsWithWhereTestCase() {
		display();
		dataMunger.parseQuery("select city,winner,player_match from ipl.csv where season > 2014");
	}
	
	@Test
	public void selectColumnsWithMultipleWhereAndTestCase() {
		display();
		dataMunger.parseQuery("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore'");
		
	}
	
	@Test
	public void selectColumnsWithMultipleWhereOrTestCase() {
		display();
		dataMunger.parseQuery("select city,winner,player_match from ipl.csv where season > 2014 or city ='Bangalore'");
		
	}
	
	@Test
	public void selectColumnsWithThreeWhereOrTestCase() {
		display();
		dataMunger.parseQuery("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' or city ='Delhi'");
		
	}
	
	@Test
	public void selectColumnsWithMultipleWhereGroupByTestCase() {
		display();
		dataMunger.parseQuery("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' group by winner");
		
	}
	
	@Test
	public void selectWithGroupByTestCase() {
		display();
		dataMunger.parseQuery("select city,winner,player_match from ipl.csv group by winner");
	}
	
	@Test
	public void selectColumnsWithMultipleWhereAndOrderByTestCase() {
		display();
		dataMunger.parseQuery("select city,winner,player_match from ipl.csv where season > 2014 and city ='Bangalore' order by city");
		
	}
	
	private void display() {
		System.out.println("================================================================");
	}
	
	
}