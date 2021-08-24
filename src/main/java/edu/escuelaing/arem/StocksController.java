package edu.escuelaing.arem;

import static spark.Spark.get;

public class StocksController {
	
	public StocksController(final StocksService stocksService) {
		get("/hello", (req, res) -> stocksService.getHello());
		get("/data", (req, res) -> stocksService.getStockData(req, res, new StockCache()));
	}
	
}