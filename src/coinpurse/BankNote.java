package coinpurse;
/**
 * BankNote represents banknote with a fixed value and currency.
 * @author Poorin Pichayamongkol 
 */
public class BankNote extends Money {
	
	private static long nextSerialNumber = 1000000;
	private long serialNumber;
	
	/**
	 * Constructure of BankNote with value that cannot be negative and currency. 
	 * @param value is the value of banknote.
	 * @param currency is the currency of banknote.
	 */
	public BankNote( double value, String currency) {
		super(value, currency);
		nextSerialNumber++;
		this.serialNumber = nextSerialNumber;
	}
	
	/**
	 * getSerial() can get the serial number of the banknote and return serial number of the banknote
	 * @return the serial number of BankNote
	 */
	public long getSerial() {
		return serialNumber;
	}
	
	/**
	 * toString() can give the user know the value of banknote and currency.
	 * @return the text contain value of banknote and currency of banknote
	 */
	public String toString() {
		return this.getValue()+"-"+this.getCurrency()+" note ["+this.getSerial()+"]";
	}
}
