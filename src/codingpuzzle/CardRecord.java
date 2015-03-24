package codingpuzzle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardRecord {
	private String bank;
	private String number;
	private Date expiryDate;
	
	private static final String MMM_YYYYDateFormat = "MMM-yyyy";
	
	public CardRecord(String bank, String number, String expiryDate) throws ParseException {
		this.bank = bank;
		this.number = number;
		this.expiryDate = convertMMM_YYYYToDate(expiryDate);
	}

	public Date convertMMM_YYYYToDate(String dateString) throws ParseException {
		DateFormat formatter = new SimpleDateFormat(MMM_YYYYDateFormat);
		return formatter.parse(dateString);
	}
	
	public String outputDateAsMMM_YYYY(Date date) {
		DateFormat formatter = new SimpleDateFormat(MMM_YYYYDateFormat);
		return formatter.format(date);
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof CardRecord) {
			CardRecord cardRecord = (CardRecord) obj;
			if (bank.equals(cardRecord.getBank())) {
				if (number.equals(cardRecord.getNumber())) {
					if (expiryDate.equals(cardRecord.getExpiryDate())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public String getExpiryDateMMM_YYYY() {
		return outputDateAsMMM_YYYY(this.getExpiryDate());
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
}
