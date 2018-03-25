package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.MoneyFactory;
import coinpurse.Purse;
import coinpurse.Valuable;

public class WithdrawTest {
	private WithdrawStrategy strategy;
	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "BTC";
	List<Valuable> money = null;
	MoneyFactory factory = MoneyFactory.getInstance();
	/**
	 * Set up the Strategy
	 * @throws IllegalArgumentException if it is not withdraw strategy.
	 */
	@Before
	public void setUp() throws IllegalArgumentException {
		strategy = new RecursiveWithdraw();
	}
	/**
	 * make Coin from value. 
	 * @param value is the value of coin.
	 * @return Coin with value and currency.
	 */
	private Valuable makeCoin(double value) {
		return new Coin(value,CURRENCY);
	}
	/**
	 * Test Simple Withdraw from money. 
	 */
	@Test(timeout=1000)
	public void testEasyWithDraw() {
		money = new ArrayList<Valuable>() ;
		Valuable val = makeCoin(4);
		money.add(val);
		money.add(makeCoin(5));
		money.add(makeCoin(2));
		money.add(makeCoin(2));
		double val1 = strategy.withdraw(val, money).get(0).getValue();
		assertEquals(val1, 4, TOL);
	}
	/**
	 * Test Withdraw the first amount in money. 
	 */
	@Test(timeout=1000)
	public void testWithdrawFirstTarget() {
		List<Valuable> money = new ArrayList<Valuable>();
		Valuable target = makeCoin(1);
		money.add(target);
		money.add(makeCoin(2));
		money.add(makeCoin(3));
		List<Valuable> temp = strategy.withdraw(target, money);
		double value = temp.get(0).getValue();
		assertEquals(value, target.getValue(),TOL);
	}
	/**
	 * Test withdraw from money with multiple amount.
	 */
	@Test(timeout=1000)
	public void testMultipleWithDraw() {
		money = new ArrayList<Valuable>() ;
		Valuable val = makeCoin(4);
		Valuable val2 = makeCoin(2);
		money.add(val);
		money.add(val2);
		money.add(makeCoin(5));
		money.add(makeCoin(2));
		money.add(makeCoin(2));		
		double value1 = strategy.withdraw(val, money).get(0).getValue();
		double value2 = strategy.withdraw(val2, money).get(0).getValue();
		assertEquals(value1+value2, 8, TOL);
	}
	/**
	 * Test withdraw that impossible to withdraw.
	 */
	@Test(timeout=1000)
	public void testImpossibleWithDraw() {
		money = new ArrayList<Valuable>() ;
		Valuable val = makeCoin(4);
		Valuable val2 = makeCoin(10);
		money.add(val);
		money.add(makeCoin(3));
		money = strategy.withdraw(val2, money);
		assertNull(money);
	}
	/**
	 * Test withdraw that use for recursive if using
	 * greedy withdraw it will be null.
	 */
	@Test(timeout=1000)
	public void testRecursiveWithdraw() {
		money = new ArrayList<Valuable>();
		List<Valuable> money2 = new ArrayList<Valuable>();
		Valuable val = new Money(6, CURRENCY);
		money.add(makeCoin(5));
		money.add(makeCoin(2));
		money.add(makeCoin(2));
		money.add(makeCoin(2));
		money2 = strategy.withdraw(val, money);
		double result = 0;
		for (Valuable value: money2) {
			result += value.getValue();
		}
//		for recursive
		assertEquals(7, result, TOL);
		//for greedy
//		assertNull(money2);
	}
	/**
	 * Test withdraw that not modify the original list.
	 */
	@Test(timeout=1000)
	public void testWithdrawNotModifyList() {
		money = new ArrayList<Valuable>() ;
		List<Valuable> money2 = new ArrayList<Valuable>();
 		Valuable val = makeCoin(4);
		Valuable val2 = makeCoin(2);
		money.add(val);
		money.add(val2);
		money2.add(val);
		money2.add(val2);
		strategy.withdraw(val2, money);
		strategy.withdraw(val, money);
		assertEquals(money, money2);
	}
}
