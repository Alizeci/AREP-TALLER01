package edu.escuelaing.arem;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;

public class StocksService {

	public String getHello() {
		return "Hello Heroku, again!";
	}
    
    public String getStockData(Request req, Response res, final StockCache stockCache) throws StockNotFoundException {
    	String stock = req.queryParams("stock");
    	String timePeriod = "DAILY";
    	System.out.println("Stock: "+ stock);
    	Gson gson = new Gson();
    	StockData result = stockCache.getStockData(stock, timePeriod);
    	return gson.toJson(result);
	}

}
