package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

/**
 * Withdraw strategy to decide what should withdraw the amount of money 
 * recursively and accurately. 
 * @author Poorin Pichayamogkol
 */
public class RecursiveWithdraw implements WithdrawStrategy {
	/**
	 * Find and return items from a collection whose total value equals 
	 * the requested amount.
	 * @param amount is the amount of money to withdraw, with currency.
	 * @param money the contents that are available for possible withdraw.
	 * 		  Must not be null, but may be an empty list.
	 * 		  This list is not modified.
	 * @return if a solution is found, return a List containing references
	 * 		   form the money parameter (List) whose sum equals the amount. 
	 * 		   If a solution is not found, return null.
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> list = new ArrayList<Valuable>();
		if (amount.getValue() == 0) return new ArrayList<Valuable>();
		if (money.isEmpty() || amount.getValue() < 0) return null;
		// select the first item in the list, for possible withdraw
		Valuable first = money.get(0);
		// Case 1: select this item for withdraw -- currency must match,
		// and try to withdraw the remaining amount using rest of the list.
		// Some code is missing (you don't want it to be too easy, do you?)
		Valuable remaining = new Money(amount.getValue() - first.getValue(), first.getCurrency());
		List<Valuable> result = withdraw( remaining,money.subList(1,money.size()) );
		if (result != null) {
			list.add(first);
			list.addAll(result);
			return list;
		}
		// test if the recursion succeeded.
		// Case 2: don't use this item for withdraw.
		// Try to withdraw amount using the rest of the list.
		List<Valuable> wd = withdraw( amount, money.subList(1, money.size()) );
		if ( wd != null ) {
			list.addAll(wd);
			return list;
		}
		return null;
	}
	
}
