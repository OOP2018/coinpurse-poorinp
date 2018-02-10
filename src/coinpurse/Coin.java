package coinpurse;
/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Poorin Pichayamongkol 
 */
public class Coin extends Money implements Valuable {
	/**
	 * Constructure of Coin with value that cannot be negative and currency. 
	 * @param value is the value of coin.
	 * @param currency is the currency of coin.
	 */
	public Coin (double value, String currency) {
		super(value, currency);
	}
	
	/**
	 * toString() can give the user know the value of coin and currency.
	 * @return the text contain value of coin and currency of coin
	 */
	public String toString() {
		return this.getValue()+"-"+this.getCurrency();
	}

}
