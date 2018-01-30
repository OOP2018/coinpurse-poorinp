package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable> {
	
	/**
	* Compare two objects that implement Valuable.
	* First compare them by currency, so that "Baht" < "Dollar".
	* If both objects have the same currency, order them by value.
	* @return -1 if value of a less than b in the same currency or a is "Baht" and b is "Dollar"
	* 		  0	if value of a equal b in the same currency 
	* 		  1 if value of a more than b in the same currency or a is "Dollar" and b is "Baht"
	*/
	public int compare(Valuable a, Valuable b) {
		if (a.getCurrency() == "Baht" && b.getCurrency() == "Dollar") return -1;
		if (a.getCurrency() == b.getCurrency()){
			if (a.getValue() < b.getValue()) return -1;
			if (a.getValue() == b.getValue()) return 0;
			if (a.getValue() > b.getValue()) return 1;
		}
		if (a.getCurrency() == "Dollar" && b.getCurrency() == "Baht") return 1;
		else return 0;
	}
}
