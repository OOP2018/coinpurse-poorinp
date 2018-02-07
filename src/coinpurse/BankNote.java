package coinpurse;
/**
 * BankNote represents banknote with a fixed value and currency.
 * @author Poorin Pichayamongkol 
 */
public class BankNote implements Valuable{
	
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;
	
	/**
	 * Constructure of BankNote with value that cannot be negative and currency. 
	 * @param value is the value of banknote.
	 * @param currency is the currency of banknote.
	 */
	public BankNote( double value, String currency) {
		nextSerialNumber++;
		this.serialNumber = nextSerialNumber;
		if(value >= 0) {
			this.value = value; 
		}
		this.currency = currency;
	}
	
	/**
	 * getValue() can get the value and return the value.
	 * @return value of the BankNote
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * getCurrency() can get the currency of the banknote and return the currency of BankNote
	 * @return the currency of BankNote
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * getSerial() can get the serial number of the banknote and return serial number of the banknote
	 * @return the serial number of BankNote
	 */
	public long getSerial() {
		return serialNumber;
	}
	
	/**
	 * This method can check that two BankNotes can be equal both value and currency or not.
	 * @return true if two BankNotes are equal
	 * 		   false if two BankNotes are different
	 */
	public boolean equals(BankNote obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		BankNote other = (BankNote) obj;
		if (value == other.getValue() && currency.equalsIgnoreCase(other.getCurrency())) return true;
		return false;	
	}
	
	/**
	 * toString() can give the user know the value of banknote and currency.
	 * @return the text contain value of banknote and currency of banknote
	 */
	public String toString() {
		return this.getValue()+"-"+this.getCurrency()+" [ "+this.getSerial()+" ]";
	}
}
