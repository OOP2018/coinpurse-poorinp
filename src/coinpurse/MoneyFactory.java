package coinpurse;

public abstract class MoneyFactory {
	/** singleton instance of MoneyFactory. */
	private static MoneyFactory instance = null;
	
	public static MoneyFactory getInstance() {
		if (instance == null) instance = new ThaiMoneyFactory();
		return instance;
	}
	
	public abstract Valuable createMoney(double value);
	
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
	
	public static void setFactory(MoneyFactory f) {
		instance = f;
	}
}
