package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.MoneyUtil;
import coinpurse.Valuable;
import coinpurse.ValueComparator;
/**
 * Withdraw strategy to decide what should withdraw by maximum 
 * amount of money.  
 * @author Poorin Pichayamongkol
 */
public class GreedyWithdraw implements WithdrawStrategy {
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
		List<Valuable> temp = new ArrayList<Valuable>();
		Collections.sort(money);
    	Collections.reverse(money);
		double wd = amount.getValue();
		if ( amount.getValue() >= 0) {
    		for (Valuable moneyV: money) {
    			if (wd >= moneyV.getValue()) {
    				wd -= moneyV.getValue();
    				temp.add(moneyV);
    			}
        	}
		}
    	if (wd == 0) {
    		return temp;
    	}
    	return null;
	}                               
}