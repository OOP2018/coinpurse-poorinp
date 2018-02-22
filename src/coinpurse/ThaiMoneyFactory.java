package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory{
	
	private static long nextSerialNumber = 1000000;
	
	/**
	 * This method can make the new money that have local currency (Baht) and value that is double.
	 * @param value is the value is parse from String value in createMoney(String value)
	 * @return new Money that is created
	 * @throws IllegalArgumentException if the value is invalid
	 */
	public Valuable createMoney(double value) {		
		if (value == 1 || value == 2 || value == 5 || value == 10) {
			return new Coin(value, "Baht");
		}
		else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) {
			return new BankNote(value, "Baht", nextSerialNumber++); 
		}
		else throw new IllegalArgumentException(value+" is not a valid currency value");
	}
}
