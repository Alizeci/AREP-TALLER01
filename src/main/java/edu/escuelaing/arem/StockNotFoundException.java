package edu.escuelaing.arem;

/**
 * StockNotFoundException is used to indicate a non existence from a particular stock.
 * @author aleja
 *
 */
public class StockNotFoundException extends Exception {

	public StockNotFoundException(String message) {
        super(message);
    }

    public StockNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
