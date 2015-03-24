package codingpuzzle.tests;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import codingpuzzle.CardRecord;
import codingpuzzle.DataFileReader;

public class DataFileReaderTest {

	private DataFileReader testClass;
	private CardRecord[] testData = new CardRecord[3];
	
	@Before
	public void setUp() throws Exception {
		testClass = new DataFileReader("mid-test.csv");
		testData[0] = new CardRecord("HSBC Canada", "5601-2345-3446-5678", "Nov-2017");
		testData[1] = new CardRecord("Royal Bank of  Canada", "4519-4532-4524-2456", "Oct-2017");
		testData[2] = new CardRecord("American Express", "3786-7334-8965-345", "Dec-2018");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReadFile() throws Exception {
		assertArrayEquals(testData, testClass.readFile());
	}
	
	@Test
	public void testParseLineValid() throws ParseException {
		assertEquals(testData[0], testClass.parseLine("HSBC Canada,5601-2345-3446-5678,Nov-2017"));
	}
	
	@Test(expected=RuntimeException.class)
	public void testParseLineInvalid() throws ParseException {
		assertEquals(testData[0], testClass.parseLine("HSBC Canada,5601-2345-3446-5678"));
	}

}
