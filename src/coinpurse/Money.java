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
	
	/**
	 * This method is to compare the money by compare the currency ,then the value.
	 * @return 1 when this money currency is greater than the other one and this value is greater than the other one if in the same currency
	 * 		   0 when this money currency and value is equals the other one.
	 * 		   -1 when this money currency is less than the other one and this value is less than the other one if in the same currency  
	 */
	public int compareTo(Valuable o) {
		double a = this.value;
		double b = o.getValue();
		String c1 = this.currency;
		String c2 = o.getCurrency();
		if (c1.compareTo(c2) < 0) return -1;
		if (c1.compareTo(c2) == 0) return Double.compare(a, b);
		if (c1.compareTo(c2) > 0) return 1;
		else return 0;
	}

}