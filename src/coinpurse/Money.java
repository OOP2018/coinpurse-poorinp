package coinpurse;

public class Money implements Valuable{

	protected double value;
	protected String currency;

	public Money(double value, String currency) {
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
	 * This method can check that two Money can be equal both value and currency or not.
	 * @return true if two Money are equal
	 * 		   false if two Money are different
	 */
	public boolean equals(Valuable obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		Valuable other = (Valuable) obj;
		if (value == other.getValue() && currency.equalsIgnoreCase(other.getCurrency())) return true;
		return false;	
	}

}