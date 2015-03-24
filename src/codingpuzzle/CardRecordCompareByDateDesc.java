package codingpuzzle;

import java.util.Comparator;

public class CardRecordCompareByDateDesc implements Comparator<CardRecord> {

	@Override
	public int compare(CardRecord o1, CardRecord o2) {
		return o2.getExpiryDate().compareTo(o1.getExpiryDate());
	}

}
