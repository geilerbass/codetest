package codingpuzzle;

public enum Bank {
	HSBC_CANADA("HSBC Canada"),
	ROYAL_BANK_OF_CANADA("Royal Bank of  Canada"),
	AMERICAN_EXPRESS("American Express");
	
	private String name;
	
	private Bank(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
