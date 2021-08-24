package edu.escuelaing.arem;

import java.util.HashMap;

public class StockData {
	private String name;
	private HashMap<String, TimeData> timeLine;
	
	public StockData (String name, HashMap<String, TimeData> timeLine) {
		this.name = name;
		this.timeLine = timeLine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, TimeData> getTimeLine() {
		return timeLine;
	}

	public void setTimeLine(HashMap<String, TimeData> timeLine) {
		this.timeLine = timeLine;
	}

}
