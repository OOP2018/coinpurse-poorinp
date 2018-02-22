package coinpurse;

public abstract class MoneyFactory {
	/** singleton instance of MoneyFactory. */
	private static MoneyFactory instance = null;
	
	/**
	 * The method can get the instance of MoneyFactory 
	 * @return the new instance of MoneyFactory if there is no MoneyFactory
	 */
	public static MoneyFactory getInstance() {
		if (instance == null) instance = new ThaiMoneyFactory();
		return instance;
	}
	
	/**
	 * Abstract method create money with double value.
	 * @param value is the value in double
	 * @return the Money with value
	 */
	public abstract Valuable createMoney(double value);
	
	/**
	 * Method accepts the money value with String ,then let the abstract createMoney create the money with double value.
	 * @param value String that can parse to double and will return new money with value.
	 * @return createMoney(double value) to create money from value.
	 * @throws IllegalArgumentException if value is not String or cannot parse to double.
	 */
	public Valuable createMoney(String value) {
		double value2 = 0;
		try {
			value2 = Double.parseDouble(value);
		}catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return createMoney(value2);
	}
	
	/**
	 * This method can set the MoneyFactory to new other MoneyFactory.
	 * @param f the new other MoneyFactory that have the new currency
	 */
	public static void setFactory(MoneyFactory f) {
		instance = f;
	}
}
