package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Collection;

/**
 * This Class is a class to practice the using of List.
 * @author Poorin Pichayamongkol
 */
public class MoneyUtil {
	
	/**
	 * Sorting the Collections about value of coins.
	 * @param coins is the coin in List to sort.
	 */
	public static void sortCoins(List<? extends Valuable> money){
		java.util.Collections.sort(money);
	}
	
	/**
	 * print the solution of coins
	 * @param coins is the coin in List to print
	 */
	public static void printCoins(List<? extends Valuable> money) {
		for (Valuable moneyValue : money) {
			System.out.println(moneyValue);
		}
	}
	
	/**
	 * FilterByCurrency can return only the coins that have the same currency. 
	 * @param coins is the coin we check and sort
	 * @param currency is currency to sort by
	 * @return the new List that have only the same currency coins
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> money, String currency) {
		List<E> temp = new ArrayList<>();
		for (E moneyValue: money) {
			if (moneyValue.getCurrency().equals(currency)) {
				temp.add(moneyValue);
			}
		}
		return temp;
	}
	
	/**
	 * Return the larger of a and b, according to the natural
	 * ordering (defined by compareTo).
	 * @param args one or more Comparable objects to compare.
	 * @throws IllegalArgumentException if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E ... args) {
		E max = null;
		for (int i = 0; i < args.length - 1; i++) {
			if (max == null) max = args[i];
			if (args[i].compareTo(max) > 0) {
				max = args[i];
			}
		}
		return max;
	}
	
	//test MoneyUtil
	public static void main(String[] args) {
//		List<Valuable> money = new ArrayList<Valuable>();
//		money.add( new Coin(10.0, "Baht") );
//		money.add( new Coin(3.5, "Baht") );
//		money.add( new Coin(6.0, "Rupee") );
//		money.add( new Coin(100.0, "Baht") );
//		printCoins( money );
//		System.out.println("-------------------");
////		sortCoins(coins);
////		printCoins( coins );
//		System.out.println("-------------------");
//		money = filterByCurrency(money, "Baht");
//		printCoins(money);
		
//		String max = MoneyUtil.max( "dog", "zebra", "cat");
//		System.out.println(max);
		
		Money m1 = new BankNote(10, "Baht", 0);
		Money m2 = new BankNote(100, "Baht", 0);
		Money m3 = new Coin(20, "Baht");
		Money max = MoneyUtil.max(m1, m2, m3);
		System.out.println(max);
		
		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10.0, "USD", 0));
		list.add(new BankNote(500.0, "Baht", 0));
		MoneyUtil.sortCoins(list);
		System.out.println(list);
		
		List<Coin> coins = Arrays.asList( new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent") );
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		System.out.println(result);
		
	}
}
