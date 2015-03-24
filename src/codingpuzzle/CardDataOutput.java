package codingpuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardDataOutput {

	public String[] outputData(CardRecord[] cardData) {
		String[] output = new String[cardData.length];
		List<CardRecord> cardList = new ArrayList<CardRecord>(Arrays.asList(cardData));
		Collections.sort(cardList, new CardRecordCompareByDateDesc());
		
		int i = 0;
		for (CardRecord cardRecord : cardList) {
			StringBuffer sb = new StringBuffer(cardRecord.getBank());
			sb.append(",").append(maskCardNumber(cardRecord));
			sb.append(",").append(cardRecord.getExpiryDateMMM_YYYY());
			output[i] = sb.toString();
			i++;
		}
		return output;
	}
	
	public String maskCardNumber(CardRecord cardRecord) {
		if (Bank.HSBC_CANADA.getName().equals(cardRecord.getBank())) {
			return maskDigits(cardRecord.getNumber(), 0, 2);
		}
		else if (Bank.ROYAL_BANK_OF_CANADA.getName().equals(cardRecord.getBank())) {
			return maskDigits(cardRecord.getNumber(), 0, 4);
		}
		else if (Bank.AMERICAN_EXPRESS.getName().equals(cardRecord.getBank())) {
			return maskDigits(cardRecord.getNumber(), 15, 18);
		}
		return "";
	}
	
	public String maskDigits(String number, int clearStart, int clearEnd) {
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher(number);
		StringBuffer sb = new StringBuffer(matcher.replaceAll("x"));
		sb.replace(clearStart, clearEnd, number.substring(clearStart, clearEnd));
		return sb.toString();
	}
}
