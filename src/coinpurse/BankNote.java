package coinpurse;

public class BankNote implements Valuable{
	
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;
	
	public BankNote( double value, String currency) {
		if(value >= 0) {
			this.value = value; 
		}
		this.currency = currency;
		this.serialNumber = 1000000;
	}
	
	public double getValue() {
		return value;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public long getSerial() {
		return serialNumber;
	}
	
	public boolean equals(BankNote obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		BankNote other = (BankNote) obj;
		if (value == other.getValue() && currency.equalsIgnoreCase(other.getCurrency())) return true;
		return false;	
	}
	
	public String toString() {
		return this.getValue()+"-"+this.getCurrency()+" [ "+this.getSerial()+" ]";
	}
}
