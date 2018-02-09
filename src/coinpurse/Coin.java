package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Poorin Pichayamongkol 
 */
public class Coin extends Money implements Comparable<Coin> , Valuable {
	/**
	 * Constructure of Coin with value that cannot be negative and currency. 
	 * @param value is the value of coin.
	 * @param currency is the currency of coin.
	 */
	public Coin (double value, String currency) {
		super(value, currency);
	}
	
	/**
	 * This method can commpare the value of coin.
	 * @param coin is the value of coin 
	 * @return -1 if this value of Coin is less than value of the others
	 * 		    1 if this value of Coin is more than value of the others
	 * 			0 if this value of Coin is equal to value of the others
	 */
	public int compareTo(Coin coin) {
		if (this.value < coin.value) return -1;
		if (this.value == coin.value) return 0;
		if (this.value > coin.value) return 1;
		else return 0;
	}
	
	/**
	 * toString() can give the user know the value of coin and currency.
	 * @return the text contain value of coin and currency of coin
	 */
	public String toString() {
		return this.getValue()+"-"+this.getCurrency();
	}

}
