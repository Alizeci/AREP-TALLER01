package edu.escuelaing.arem;

public class StockNotFoundException extends Exception {

	public StockNotFoundException(String message) {
        super(message);
    }

    public StockNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
