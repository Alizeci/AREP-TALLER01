package edu.escuelaing.arem;

import static spark.Spark.get;

public class StocksController {
	
	public StocksController(final StocksService stocksService) {
		get("/hello", (req, res) -> stocksService.getHello());
		get("/inputdata", (req, res) -> stocksService.inputDataPage(req, res));
		get("/results", (req, res) -> stocksService.resultsPage(req, res));
		get("/data", (req, res) -> stocksService.getStockData(req, res, new StockCache()));
	}
	
}