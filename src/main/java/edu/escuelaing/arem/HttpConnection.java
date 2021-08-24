package edu.escuelaing.arem;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class HttpConnection {
	
	public JSONObject getInfoByStockAndDailyPeriod(String stock, String timePeriod) throws UnirestException {
		System.out.println("Inicia conexión a API externo!");
		HttpResponse<String> response = Unirest.get("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+ stock + "&apikey=F3MFYPD54DJR5QUJ")
                .asString();
		JSONObject jsonObject = new JSONObject (response.getBody()).getJSONObject("Time Series (Daily)");
		System.out.println("Consultado API Externo!");
        return jsonObject;
    }
	
}