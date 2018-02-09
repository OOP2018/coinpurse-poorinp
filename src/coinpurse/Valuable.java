package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Poorin Pichayamongkol
 *
 */
public interface Valuable implements Comparable<Valuable> {
	
	/**
	 * Get the monetary value of this objects, in its own currency.
	 * @return the value of this object
	 */
	public double getValue();
	
	/**
	 * Get the monetary currency of this objects with the currency.
	 * @return the currency of this this object
	 */
	public String getCurrency();
	
}
