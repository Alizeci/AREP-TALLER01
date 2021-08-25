package edu.escuelaing.arem;

/**
 * TimeData represent an object with detailed information about a stock.
 * @author aleja
 *
 */
public class TimeData {
	
	private double open;
	private double high;
	private double low;
	private double close;
	private long volume;
	
	public TimeData(double open, double high, double low, double close, long volume) {
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}
	
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}

	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
}
