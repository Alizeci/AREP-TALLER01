package edu.escuelaing.arem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import org.javatuples.Pair;
import org.json.JSONObject;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * StockCache as a temporal storage for Stock's data.
 * @author aleja
 *
 */
public class StockCache {
	
	private static ConcurrentHashMap<Pair<String,String>, StockData> stocksInfo = new ConcurrentHashMap<>();

	/**
	 * This method get information about an specific Stock and Time from an external API. And check if the information exist to avoid consume the external api again.
 	 * @param stock - name of the specific stock.
	 * @param timePeriod - time data: daily, weekly, intraday, monthly
	 * @return An StockData object with the information related.
	 * @throws StockNotFoundException If the stock not exist yet in memory.
	 */
	public StockData getStockData(String stock, String timePeriod) throws StockNotFoundException {
		
		if (!stocksInfo.containsKey(new Pair<String, String>(stock,timePeriod))) {
			//System.out.println("No existe en caché");
			try {
				StockData newStock = addInfoStock(stock, timePeriod, new HttpConnection());
				stocksInfo.put(new Pair<String, String>(stock,timePeriod), newStock);
			} catch (UnirestException e) {
				throw new StockNotFoundException("Not found information of the stock: " + stock);
			}
		}
		return stocksInfo.get(new Pair<String, String>(stock,timePeriod));
	}

	/**
	 * This method get information about an specific Stock and Time from an external API through Http connection.
 	 * @param stock - name of the specific stock.
	 * @param timePeriod - time data: daily, weekly, intraday, monthly
	 * @param httpConnection - instance to make a single request - HTTP server
	 * @return An StockData object with the information related.
	 * @throws UnirestException - If exist an error transfering request/responses.
	 */
	private StockData addInfoStock(String stock, String timePeriod, final HttpConnection httpConnection)
			throws UnirestException {
		
		JSONObject jsonObject = httpConnection.getInfoByStockAndPeriod(stock, timePeriod);

		Iterator<String> iterKeys = jsonObject.keys();
		HashMap<String, TimeData> timeline = new HashMap<>();
		
		while (iterKeys.hasNext()) {
			String key = iterKeys.next();
			JSONObject jsonTimeData = jsonObject.getJSONObject(key);

			TimeData timeData = new TimeData(jsonTimeData.getDouble("1. open"), jsonTimeData.getDouble("2. high"),
					jsonTimeData.getDouble("3. low"), jsonTimeData.getDouble("4. close"),
					jsonTimeData.getLong("5. volume"));
			
			timeline.put(key, timeData);
		}	
		StockData stockFull = new StockData(stock, timeline);
		return stockFull;
	}
}
