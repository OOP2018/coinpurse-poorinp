package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Poorin Pichayamongkol 
 */
public class Coin implements Comparable<Coin> {
	private double value;
	private String currency;
	
	/**
	 * Constructure of Coin with value that cannot be negative and currency. 
	 * @param value is the value of coin.
	 * @param currency is the currency of coin.
	 */
	public Coin (double value, String currency) {
		if(value >= 0) {
			this.value = value; 
		}
		else System.out.println("Retry!");
		this.currency = currency;
	}
	
	/**
	 * getValue() can get the value and return the value.
	 * @return value of the Coin
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * getCurrency() can get the currency of the coin and return the currency of Coin
	 * @return the currency of Coin
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * This method can check that two Coin can be equal both value and currency or not.
	 * @return true if two Coins are equal
	 * 		   false if two Coins are different
	 */
	public boolean equals(Coin coins) {
		if (coins == null) return false;
		if (coins.getClass() != this.getClass()) return false;
		Coin other = (Coin) coins;
		if (coins.getValue() == other.getValue() && coins.getCurrency() == other.getCurrency() ) return true;
		return false;
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
