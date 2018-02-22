package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	
	private static long nextSerialNumber = 1000000;
	
	/**
	 * This method can make the new money that have local currency (Ringgit) and value that is double.
	 * @param value is the value is parse from String value in createMoney(String value)
	 * @return new Money that is created
	 * @throws IllegalArgumentException if the value is invalid
	 */
	public Valuable createMoney(double value) {
		if (value == 0.05 || value == 0.1 || value == 0.2 || value == 0.5) {	
			return new Coin(value, "Sen");	
		}
		else if (value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100) {
			return new BankNote(value, "Ringgit", nextSerialNumber++);
		}
		else throw new IllegalArgumentException(value+" is not a valid currency value");
	}

}
