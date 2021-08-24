package edu.escuelaing.arem;

import org.json.JSONObject;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;

public class StocksService {

	public String getHello() {
		return "Hello Heroku, again!";
	}
	
    public String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>HTML Forms</h2>"
                + "<form action=\"/results\">"
                + "  First name:<br>"
                + "  <input type=\"text\" name=\"firstname\" value=\"Mickey\">"
                + "  <br>"
                + "  Last name:<br>"
                + "  <input type=\"text\" name=\"lastname\" value=\"Mouse\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    public String resultsPage(Request req, Response res) {
        return req.queryParams("firstname") + " " +
                req.queryParams("lastname");
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
