package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

// You will use Collections.sort() to sort the money

/**
 *  A coin purse contains money.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Poorin Pichayamongkol
 */
public class Purse {
    /** Collection of objects in the purse. */
    public List<Valuable> money;
    
    /**
     * Comparator of objects in the purse
     */
    private static final Comparator <Valuable> comp = new ValueComparator();
    
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of money you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	money = new ArrayList<>();
    }

    /**
     * Count and return the number of money in the purse.
     * This is the number of money, not their value.
     * @return the number of money in the purse
     */
    public int count() { 
    	return money.size();
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double sum = 0;
    	for (Valuable moneyValue: money) {
    		sum += moneyValue.getValue();
    	}
		return sum; 
	}

    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity() { 
		return this.capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
        return this.money.size() >= getCapacity();
    }

    /** 
     * Insert money into the purse.
     * The money is only inserted if the purse has space for it
     * and money has positive value.  No worthless money!
     * @param money is a Money object to insert into purse
     * @return true if money inserted, false if can't insert
     */
    public boolean insert( Valuable moneyValue ) {
        // if the purse is already full then can't insert anything.
    	if (this.isFull()==true) {
    		return false;
    	}
    	else {
    		if (moneyValue.getValue() <= 0) return false;
    		else {
    			money.add(moneyValue);
        		return true;
    		}
    	}
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of money withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of money objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
	   /*
		* See lab sheet for outline of a solution, 
		* or devise your own solution.
		* The idea is to be greedy.
		* Try to withdraw the largest coins possible.
		* Each time you choose a coin as a candidate for
		* withdraw, add it to a temporary list and
		* decrease the amount (remainder) to withdraw.
		* 
		* If you reach a point where amountNeededToWithdraw == 0
		* then you found a solution!
		* Now, use the temporary list to remove coins
		* from the money list, and return the temporary
		* list (as an array).
		*/
		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
    	// Your code might use some other variable for the remaining amount to withdraw.
    	Valuable moneyV = new Money(amount, "Baht");
    	return withdraw(moneyV);
		// Success.
		// Remove the coins you want to withdraw from purse,
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array.
		// toArray returns a reference to the array itself.
	}
    
    /**
     * Withdraw the amount that have the same currency that requested
     * @param amount is the amount of money that want to withdraw
     * @return the array of money that have withdrawn
     */
    public Valuable[] withdraw(Valuable amount) {
    	List<Valuable> tempList = new ArrayList<>();
    	List<Valuable> tempList2 = new ArrayList<>();
    	double wd = amount.getValue();
    	tempList = MoneyUtil.filterByCurrency(money, amount.getCurrency());
    	Collections.sort(tempList);
    	Collections.reverse(tempList);
    	if ( wd >= 0) {
    		for (Valuable moneyV: tempList) {
    			if (wd >= moneyV.getValue() && amount.getCurrency().equals(moneyV.getCurrency())) {
    				tempList2.add(moneyV);
    				wd -= moneyV.getValue();
    			}
        	}
		}
    	if (wd == 0) {
    		for(Valuable moneyValue: tempList2) {
    			money.remove(moneyValue);
    		}
    		Valuable[] array = new Valuable[ tempList2.size() ];
    		tempList2.toArray(array);
            return array;
    	}
		return null;
    }
    
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return this.count()+" money with value "+this.getBalance();
    }
    
    //test purse.withdraw(Valuable amount)
	public static void main(String[] args) {
		Purse p = new Purse(10);
		Coin c1 = new Coin(10, "Baht");
		p.insert(new Coin(1,"Baht"));
		p.insert(new Coin(2,"Baht"));
		p.insert(new Coin(4,"Baht"));
		p.insert(new Coin(5,"Baht"));
		p.insert(new Coin(8,"Baht"));
		p.insert(c1);  
		p.withdraw(10);
		System.out.println(p.toString());		
		
	}
}
