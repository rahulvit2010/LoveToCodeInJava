package com.rahul.train.junit5;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringTest {

	private String str;
	
	@BeforeAll
	static void beforeAll()
	{
	 System.out.println("init db connection");	
	}
	
	@AfterAll
	static void afterAll()
	{
		System.out.println("db connection is closed");
	}
	@BeforeEach
	void beforeEach(TestInfo testinfo)
	{
		System.out.println("initalizing  test data for each test"+ testinfo.getDisplayName());
	}
	
	@AfterEach
	void afterEach(TestInfo testinfo)
	{
		System.out.println("cleaning test data"+ testinfo.getDisplayName());
	}
	@Test
	void lengthCheck() {
		int actualLength= "RAHUL BHANDARI".length();
		int expectedLength=14;
		assertEquals(expectedLength, actualLength);
	}
	
	
	@ParameterizedTest()
	@ValueSource(strings= {"ABC","ABCD","A","CDF","ABCDEF"})
	void length_greater_than_zero(String str)
	{
		assertTrue(str.length()>0);
	}
	/*
	@ParameterizedTest(name="{0} toUppercase is  {1}")
    @CsvSource(value= {"abcd,ABCD","abc,ABC","'',''","abcdefg,ABCDEFG"} )	
	@Test
	void csvSource_test(String word,String capitalizedWord)
	{
		assertEquals(capitalizedWord, word.toUpperCase());
		
	}
	
	@ParameterizedTest(name="{0} length is  {1}")
    @CsvSource(value= {"abcd,4","abc,3","'',0","abcdefg,7"} )	
	@Test
	void csvSource_test(String word,int length)
	{
		assertEquals(length, word.length());
		
	}
	*/
	@Test
	@DisplayName("when leangth is null , throw an exception")
	void length_exception() {
		String str=null;
		assertThrows(NullPointerException.class,
				()->{
					str.length();
				});
	}
	@Test
	void toUpperCase()
	{
		String str="abcd";
		String result= str.toUpperCase();
		/*assertNull(result);
		assertNotNull(result);*/
	  assertEquals("ABCD", result);
	}
	
	@Test
	@RepeatedTest(10)
	void containCheck()
	{
	String str="rahul";
	boolean result= str.contains("z");
	//assertEquals(false, result);
	assertFalse(result);
}
	
	@Test
	void split_check()
	{
		String str="abc def ghi";
		String result[]= str.split(" ");
		String [] expectedRes= new String[] {"abc","def","ghi"};
		
		assertArrayEquals(expectedRes, result);
		
	}
	
	@Test
	@Disabled
	void performance_Test()
	{
		assertTimeout(Duration.ofSeconds(10)
				, ()->{
					for(int i=0;i<=1000000;i++)
					{
						System.out.println(i);
					}
				});
	}

	@Nested
	@DisplayName("for an empty string")
	class EmptyStringTests{
		
		@BeforeEach
		void setToEmpty(){
			str="";
		}
		
		@Test
		@DisplayName("length should be zero")
		void lengthIsZero() {
			assertEquals(0, str.length());
		}
		
		@Test
		@DisplayName("uppercase is empty")
		void uppercaseIsEmpty()
		{
			assertEquals("", str.toUpperCase());
		}
		
	}

}
