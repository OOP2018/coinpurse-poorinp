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
	public static void printCoins(List<Coin> coins) {
		for (Coin coin : coins) {
			System.out.println(coin);
		}
	}
	
	/**
	 * FilterByCurrency can return only the coins that have the same currency. 
	 * @param coins is the coin we check and sort
	 * @param currency is currency to sort by
	 * @return the new List that have only the same currency coins
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> temp = new ArrayList<>();
		for (Coin coin: coins) {
			if (coin.getCurrency().equals(currency)) {
				temp.add(coin);
			}
		}
		return temp;
	}
	
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add( new Coin(10.0, "Baht") );
		coins.add( new Coin(3.5, "Baht") );
		coins.add( new Coin(6.0, "Rupee") );
		coins.add( new Coin(100.0, "Baht") );
		printCoins( coins );
		System.out.println("-------------------");
//		sortCoins(coins);
//		printCoins( coins );
		System.out.println("-------------------");
		coins = filterByCurrency(coins, "Baht");
		printCoins(coins);
	}
}
