package edu.escuelaing.arem;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;

/**
 * Stock's Service.
 * @author aleja
 */
public class StocksService {
	/**
	 * This method get information about an specific Stock and time.
	 * @param req - http request.
	 * @param res - http response.
	 * @param stockCache - temporal memory to search an existing information.
	 * @return An Object with Stock's information on a specific time.
	 * @throws StockNotFoundException If the stock not exist yet in memory.
	 */
    public String getStockData(Request req, Response res, final StockCache stockCache) throws StockNotFoundException {
    	String stock = req.queryParams("stock");
    	String timePeriod = req.queryParams("period");
    	Gson gson = new Gson();
    	StockData result = stockCache.getStockData(stock, timePeriod);
    	return gson.toJson(result);
	}

}