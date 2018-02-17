package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	
	private static long nextSerialNumber = 1000000;
	
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
