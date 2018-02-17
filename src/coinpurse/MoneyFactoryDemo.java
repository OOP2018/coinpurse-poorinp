package coinpurse;

import javax.net.ServerSocketFactory;

public class MoneyFactoryDemo {
	public static void main(String[] args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		MoneyFactory factory2 = MoneyFactory.getInstance();
		System.out.println(factory == factory2);
		Valuable m = factory.createMoney( 5 );
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney("1000.0");
		System.out.println(m2.toString());
		Valuable m3 = factory.createMoney("1000.0");
		System.out.println(m3.toString());	
		
		System.out.println("=============================");
		MoneyFactory.setFactory(new MalayMoneyFactory());
		factory = MoneyFactory.getInstance();
		m = factory.createMoney( 5 );
		System.out.println(m.toString());
		m3 = factory.createMoney( 0.05 );
		System.out.println(m3.toString());
		System.out.println(m3.getCurrency());
		m2 = factory.createMoney("1000.0");
	}
}
