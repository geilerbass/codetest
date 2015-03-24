package codingpuzzle.tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codingpuzzle.CardDataOutput;
import codingpuzzle.CardRecord;

public class CardDataOutputTest {

	CardDataOutput testClass;
	private String[] testDataArray = {"American Express,xxxx-xxxx-xxxx-345,Dec-2018",
			"HSBC Canada,56xx-xxxx-xxxx-xxxx,Nov-2017",
			"Royal Bank of  Canada,4519-xxxx-xxxx-xxxx,Oct-2017"};
	private CardRecord[] testData = new CardRecord[3];
	
	@Before
	public void setUp() throws Exception {
		testClass = new CardDataOutput();
		testData[0] = new CardRecord("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		testData[1] = new CardRecord("Royal Bank of  Canada", "4519-4532-4524-2456", "Oct-2017");
		testData[2] = new CardRecord("American Express", "3786-7334-8965-345", "Dec-2018");
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOutputData() {
		assertArrayEquals(testDataArray, testClass.outputData(testData));
	}
	
	@Test
	public void testMaskCardDataHSBC() throws ParseException {
		assertEquals("56xx-xxxx-xxxx-xxxx", testClass.maskCardNumber(testData[0]));
	}
	
	@Test
	public void testMaskCardDataRBC() throws ParseException {
		assertEquals("4519-xxxx-xxxx-xxxx", testClass.maskCardNumber(testData[1]));
	}
	
	@Test
	public void testMaskCardDataAMEX() throws ParseException {
		assertEquals("xxxx-xxxx-xxxx-345", testClass.maskCardNumber(testData[2]));
	}
	

}
