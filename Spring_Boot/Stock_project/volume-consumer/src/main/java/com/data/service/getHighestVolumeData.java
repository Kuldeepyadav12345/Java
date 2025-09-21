package com.data.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.data.constants.ApiConstants;
import com.data.model.OptionData;
import com.data.model.StrikePriceResponse;
import com.data.repo.HighestVolumeDataRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class getHighestVolumeData {

	int count = 0;
	@Autowired
	private HighestVolumeDataRepo highestVolumeDataRepo;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Scheduled(fixedRate = 5000) // Run every 1000 milliseconds (1 second)
	private void calleverySecond() {

		if (count == 0 || count >= 300) {
			getHighestVolumeUrl();
			count = 0;
		}
		fetchDataFromStoredUrl();
		count++;
	}

	private void getHighestVolumeUrl() {
		try {
			URL url = new URL(ApiConstants.HIGH_STRIKE_PRICE_URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder jsonResponse = new StringBuilder();
				String line;

				while ((line = reader.readLine()) != null) {
					jsonResponse.append(line);
				}
				reader.close();

				// Correct way to deserialize a JSON array of objects
				List<StrikePriceResponse> responses = objectMapper.readValue(jsonResponse.toString(),
				    new TypeReference<List<StrikePriceResponse>>() {});

				// Now you can iterate over the list to access each object
				for (StrikePriceResponse response : responses) {
				    // Process each response object here
				    System.out.println("URL: " + response.getUrl());
				    System.out.println("Strike Price: " + response.getStrikePrice());
				    System.out.println("Volume: " + response.getVolume());
				    ApiConstants.storedUrl = response.getStrikePrice();
					ApiConstants.storedStrikePrice = response.getStrikePrice();
				}

				
			} else {
				System.err.println("⚠️ API returned non-OK response: " + responseCode);
			}
		} catch (Exception e) {
			System.err.println("❌ Error fetching highest volume URL: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void fetchDataFromStoredUrl() {
		try {
			if (ApiConstants.storedUrl == null || ApiConstants.storedUrl.isEmpty()) {
				System.out.println("No URL stored yet. Waiting for initial data fetch.");
				return;
			}

			URL url = new URL(ApiConstants.storedUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			int responseCode = conn.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder jsonResponse = new StringBuilder();
				String line;

				while ((line = reader.readLine()) != null) {
					jsonResponse.append(line);
				}
				reader.close();

				// Parse JSON and store in OptionData
				OptionData apiData = objectMapper.readValue(jsonResponse.toString(), OptionData.class);
				if (apiData != null) {
					System.out.println("\n========== Option Data ==========");
					System.out.println("Type: " + apiData.getType());
					System.out.println("Symbol: " + apiData.getSymbol());
					System.out.println("Timestamp: " + apiData.getTsInMillis());
					System.out.println("Open: " + apiData.getOpen());
					System.out.println("High: " + apiData.getHigh());
					System.out.println("Low: " + apiData.getLow());
					System.out.println("Close: " + apiData.getClose());
					System.out.println("LTP: " + apiData.getLtp());
					System.out.println("Day Change: " + apiData.getDayChange());
					System.out.println("Day Change %: " + apiData.getDayChangePerc());
					System.out.println("Low Price Range: " + apiData.getLowPriceRange());
					System.out.println("High Price Range: " + apiData.getHighPriceRange());
					System.out.println("Volume: " + apiData.getVolume());
					System.out.println("Low Trade Range: " + apiData.getLowTradeRange());
					System.out.println("High Trade Range: " + apiData.getHighTradeRange());
					System.out.println("Total Buy Qty: " + apiData.getTotalBuyQty());
					System.out.println("Total Sell Qty: " + apiData.getTotalSellQty());
					System.out.println("Open Interest: " + apiData.getOpenInterest());
					System.out.println("Prev Open Interest: " + apiData.getPrevOpenInterest());
					System.out.println("OI Day Change: " + apiData.getOiDayChange());
					System.out.println("OI Day Change %: " + apiData.getOiDayChangePerc());
					System.out.println("Last Trade Qty: " + apiData.getLastTradeQty());
					System.out.println("Last Trade Time: " + apiData.getLastTradeTime());
					System.out.println("================================\n");

					// Make predictions using both models
					// double djlPrediction = deepLearningService.predict(apiData);
					// double dl4jPrediction = deeplearning4jService.predict(apiData);
					// System.out.println("\nDJL Model Prediction: " + djlPrediction);
					// System.out.println("DL4J Model Prediction: " + dl4jPrediction);
					System.out.println("Current LTP: " + apiData.getLtp());
					System.out.println("ApiConstants.storedStrikePrice: " + ApiConstants.storedStrikePrice);
					
					highestVolumeDataRepo.save(apiData);
				}
			} else {
				System.out.println("GET request failed. Response code: " + responseCode);
			}
		} catch (Exception e) {
			System.err.println("Error processing data: " + e.getMessage());
			e.printStackTrace();
		}

	}
}
