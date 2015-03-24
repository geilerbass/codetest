package codingpuzzle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader {

	private String filePath;
	
	public DataFileReader(String filePath) {
		this.filePath = filePath;
	}
	
	public CardRecord[] readFile() throws FileNotFoundException, IOException, ParseException {
		List<CardRecord> cardRecords = new ArrayList<CardRecord>();
		try (BufferedReader	br = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = br.readLine()) != null) {
				cardRecords.add(parseLine(line));
			}
		}
		
		return cardRecords.toArray(new CardRecord[cardRecords.size()]);
	}
	
	public CardRecord parseLine(String line) throws ParseException {
		String[] dataFields = line.split(",");
		if (dataFields.length != 3) {
			throw new RuntimeException("Line : \"" + line + "\" could not be parsed.");
		}
		return new CardRecord(dataFields[0], dataFields[1], dataFields[2]);
	}
	
}
