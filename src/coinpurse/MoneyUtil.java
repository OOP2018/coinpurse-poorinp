package coinpurse;

import java.util.ArrayList;
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
	public static void sortCoins(List<Coin> coins){
		java.util.Collections.sort(coins);
	}
	
	/**
	 * print the solution of coins
	 * @param coins is the coin in List to print
	 */
	public static void printCoins(List<Valuable> money) {
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
	public static List<Valuable> filterByCurrency(List<Valuable> money, String currency) {
		List<Valuable> temp = new ArrayList<>();
		for (Valuable moneyValue: money) {
			if (moneyValue.getCurrency().equals(currency)) {
				temp.add(moneyValue);
			}
		}
		return temp;
	}
	
	public static void main(String[] args) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.add( new Coin(10.0, "Baht") );
		money.add( new Coin(3.5, "Baht") );
		money.add( new Coin(6.0, "Rupee") );
		money.add( new Coin(100.0, "Baht") );
		printCoins( money );
		System.out.println("-------------------");
//		sortCoins(coins);
//		printCoins( coins );
		System.out.println("-------------------");
		money = filterByCurrency(money, "Baht");
		printCoins(money);
	}
}
