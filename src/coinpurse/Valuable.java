package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Poorin Pichayamongkol
 *
 */
public interface Valuable {
	
	/**
	 * Get the monetary value of this objects, in its own currency.
	 * @return the value of this object
	 */
	public double getValue();
	public String getCurrency();
	
}
