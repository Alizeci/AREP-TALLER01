package edu.escuelaing.arem;

import static spark.Spark.get;

/**
 * StockController is responsible for responding to events related to stock's.
 * @author aleja
 *
 */
public class StocksController {
	
	/**
	 * This method processes incoming REST API requests, prepares a model and returns the response.
	 * @param stocksService - instance to manage the requests.
	 */
	public StocksController(final StocksService stocksService) {
		get("/data", (req, res) -> stocksService.getStockData(req, res, new StockCache()));
	}
	
}