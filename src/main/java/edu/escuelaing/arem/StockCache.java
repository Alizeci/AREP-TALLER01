package edu.escuelaing.arem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONObject;
import com.mashape.unirest.http.exceptions.UnirestException;

public class StockCache {
	
	private static ConcurrentHashMap<String, StockData> stocksInfo = new ConcurrentHashMap<String, StockData>();

	public StockData getStockData(String stock, String timePeriod) throws StockNotFoundException {
		
		if (!stocksInfo.containsKey(stock)) {
			System.out.println("No existe en caché");
			try {
				StockData newStock = addInfoStock(stock, timePeriod, new HttpConnection());
				stocksInfo.put(stock, newStock);
			} catch (UnirestException e) {
				throw new StockNotFoundException("Not found information of the stock: " + stock);
			}
		}
		return stocksInfo.get(stock);

	}

	private StockData addInfoStock(String stock, String timePeriod, final HttpConnection httpConnection)
			throws UnirestException {
		
		JSONObject jsonObject = httpConnection.getInfoByStockAndDailyPeriod(stock, timePeriod);

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
