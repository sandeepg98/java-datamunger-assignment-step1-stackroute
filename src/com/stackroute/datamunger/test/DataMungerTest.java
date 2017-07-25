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
		System.out.println("==============================");
		dataMunger.parseQuery("select * from employee.csv");
	}
	
	@Test
	public void selectColumnsTestCase() {
		System.out.println("==============================");
		dataMunger.parseQuery("select name,salary from employee.csv");
	}
	
	@Test
	public void selectColumnsWithWhereTestCase() {
		System.out.println("==============================");
		dataMunger.parseQuery("select name,salary from employee.csv where department='HR'");
	}
	
	@Test
	public void selectColumnsWithMultipleWhereAndTestCase() {
		System.out.println("==============================");
		dataMunger.parseQuery("select name,salary from employee.csv where department='HR' and salary>30000");
		
	}
	
	@Test
	public void selectColumnsWithMultipleWhereOrTestCase() {
		System.out.println("==============================");
		dataMunger.parseQuery("select name,salary from employee.csv where department='HR' or salary>30000");
		
	}
	
	@Test
	public void selectColumnsWithThreeWhereOrTestCase() {
		System.out.println("==============================");
		dataMunger.parseQuery("select name,salary from employee.csv where department='HR' or salary>30000 and city='Bangalore'");
		
	}
	
	@Test
	public void selectColumnsWithMultipleWhereGroupByTestCase() {
		System.out.println("==============================");
		dataMunger.parseQuery("select city,count(*) from employee.csv where department='HR' and salary>30000 group by city");
		
	}
	
	@Test
	public void selectWithGroupByTestCase() {
		System.out.println("==============================");
		dataMunger.parseQuery("select city,count(*) from employee.csv group by city");
		
	}
	
	@Test
	public void selectColumnsWithMultipleWhereAndOrderByTestCase() {
		System.out.println("==============================");
		dataMunger.parseQuery("select city,name,dept from employee.csv where department='HR' and salary>30000 order by city");
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
