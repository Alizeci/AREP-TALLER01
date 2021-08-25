package edu.escuelaing.arem;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * HttpConnection used to send and receive data over the web.
 * @author aleja
 *
 */
public class HttpConnection {

	/**
	 * This method extract from an specific API data.
 	 * @param stock - name of the specific stock.
	 * @param timePeriod - time data: daily, weekly, intraday, monthly to filter the search
	 * @return An JSONObject with the information extracted from the API.
	 * @throws UnirestException - If exist an error transfering request/responses.
	 */
	public JSONObject getInfoByStockAndPeriod(String stock, String timePeriod) throws UnirestException {
		//System.out.println("Inicia conexión a API externo!");
		HttpResponse<String> response;

		if (timePeriod.equals("INTRADAY")) {
			response = Unirest.get("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + stock
					+ "&interval=5min&apikey=F3MFYPD54DJR5QUJ").asString();
		} else {
			response = Unirest.get("https://www.alphavantage.co/query?function=TIME_SERIES_" + timePeriod + "&symbol="
					+ stock + "&apikey=F3MFYPD54DJR5QUJ").asString();
		}

		JSONObject jsonObject = new JSONObject(response.getBody()).getJSONObject(getKey(timePeriod));
		//System.out.println("Consultado API Externo!");
		return jsonObject;
	}

	/**
	 * This method helps to select the key from the URL to extract at getInfoByStockAndPeriod method.
	 * @param timePeriod - represent a key to filter the search, like DAILY, WEEKLY, INTRADAY and MONTHLY
	 * @return the key requeried at getInfoByStockAndPeriod method.
	 */
	public String getKey(String timePeriod) {
		String key = "None";
		if (timePeriod.equals("DAILY")) {
			key = "Time Series (Daily)";
		} else if (timePeriod.equals("WEEKLY")) {
			key = "Weekly Time Series";
		} else if (timePeriod.equals("MONTHLY")) {
			key = "Monthly Time Series";
		}else if (timePeriod.equals("INTRADAY")) {
			key = "Time Series (5min)";
		}
		return key;
	}
}