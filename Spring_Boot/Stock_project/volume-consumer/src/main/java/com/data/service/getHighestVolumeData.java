package com.data.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.data.bean.RuntimeBean;
import com.data.constants.ApiConstants;
import com.data.model.BankNiftyCompaniesData;
import com.data.model.OptionData;
import com.data.model.StrikePriceResponse;
import com.data.modelTraining.ModelTrainer;
import com.data.repo.BankNiftyCompaniesDataRepo;
import com.data.repo.HighestVolumeDataRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class getHighestVolumeData {

	int count = 0;
	double[] dayChangePercentage = new double[11];

	@Autowired
	private HighestVolumeDataRepo highestVolumeDataRepo;

	@Autowired
	private RuntimeBean runtimeBean;

	@Autowired
	private BankNiftyCompaniesDataRepo bankNiftyCompaniesDataRepo;

	private final ObjectMapper objectMapper = new ObjectMapper();
	BankNiftyCompaniesData bankNiftyCompaniesData = BankNiftyCompaniesData.getInstance();

	@Scheduled(fixedRate = 5000) // Run every 1000 milliseconds (1 second)
	private void calleverySecond() {

		if (count == 0 || count >= 300) {
			getHighestVolumeUrl();
			count = 0;
		}
		fetchBankNiftyCompaniesData();
		fetchDataFromHighestVolUrl();
		count++;
	}

	// Method to get the highest volume URL from option chain API
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
						new TypeReference<List<StrikePriceResponse>>() {
						});

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

	private void fetchBankNiftyCompaniesData() {
		try {

			URL url = new URL(ApiConstants.BANKNIFTY_COMPANIES_DATA_URL);
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
				bankNiftyCompaniesData = objectMapper.readValue(jsonResponse.toString(), BankNiftyCompaniesData.class);

				dayChangePercentage = assigningDayChangePercentageValues(bankNiftyCompaniesData);
				ApiConstants.combinedDayChangedPercentage = RuntimeBean.calculateAverage(dayChangePercentage);

				if (bankNiftyCompaniesData != null) {

					// System.out.println("getAUBANK_close: " +
					// bankNiftyCompaniesData.getAUBANK_close());

				}
			} else {
				System.out.println("GET request failed. Response code: " + responseCode);
			}
		} catch (Exception e) {
			System.err.println("Error processing data: " + e.getMessage());
			e.printStackTrace();
		}

	}

	private double[] assigningDayChangePercentageValues(BankNiftyCompaniesData bankNiftyCompaniesData2) {
		dayChangePercentage[0] = bankNiftyCompaniesData2.getHDFCBANK_dayChangePerc();
		dayChangePercentage[1] = bankNiftyCompaniesData2.getICICIBANK_dayChangePerc();
		dayChangePercentage[2] = bankNiftyCompaniesData2.getSBIN_dayChangePerc();
		dayChangePercentage[3] = bankNiftyCompaniesData2.getKOTAKBANK_dayChangePerc();
		dayChangePercentage[4] = bankNiftyCompaniesData2.getAXISBANK_dayChangePerc();
		dayChangePercentage[5] = bankNiftyCompaniesData2.getPNB_dayChangePerc();
		dayChangePercentage[6] = bankNiftyCompaniesData2.getBANKBARODA_dayChangePerc();
		dayChangePercentage[7] = bankNiftyCompaniesData2.getCANBK_dayChangePerc();
		dayChangePercentage[8] = bankNiftyCompaniesData2.getINDUSINDBK_dayChangePerc();
		dayChangePercentage[9] = bankNiftyCompaniesData2.getIDFCFIRSTB_dayChangePerc();
		dayChangePercentage[10] = bankNiftyCompaniesData2.getAUBANK_dayChangePerc();
		dayChangePercentage[11] = bankNiftyCompaniesData2.getFEDERALBNK_dayChangePerc();
		return dayChangePercentage;

	}

	private void fetchDataFromHighestVolUrl() {
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

					bankNiftyCompaniesData.setHighestOptChainVol_type(apiData.getType());
					bankNiftyCompaniesData.setHighestOptChainVol_symbol(apiData.getSymbol());
					bankNiftyCompaniesData.setHighestOptChainVol_tsInMillis(apiData.getTsInMillis());
					bankNiftyCompaniesData.setHighestOptChainVol_open(apiData.getOpen());
					bankNiftyCompaniesData.setHighestOptChainVol_high(apiData.getHigh());
					bankNiftyCompaniesData.setHighestOptChainVol_low(apiData.getLow());
					bankNiftyCompaniesData.setHighestOptChainVol_close(apiData.getClose());
					bankNiftyCompaniesData.setHighestOptChainVol_ltp(apiData.getLtp());
					bankNiftyCompaniesData.setHighestOptChainVol_dayChange(apiData.getDayChange());
					bankNiftyCompaniesData.setHighestOptChainVol_dayChangePerc(apiData.getDayChangePerc());
					bankNiftyCompaniesData.setHighestOptChainVol_lowPriceRange(apiData.getLowPriceRange());
					bankNiftyCompaniesData.setHighestOptChainVol_highPriceRange(apiData.getHighPriceRange());
					bankNiftyCompaniesData.setHighestOptChainVol_volume(apiData.getVolume());
					bankNiftyCompaniesData.setHighestOptChainVol_lowTradeRange(apiData.getLowTradeRange());
					bankNiftyCompaniesData.setHighestOptChainVol_highTradeRange(apiData.getHighTradeRange());
					bankNiftyCompaniesData.setHighestOptChainVol_totalBuyQty(apiData.getTotalBuyQty());
					bankNiftyCompaniesData.setHighestOptChainVol_totalSellQty(apiData.getTotalSellQty());
					bankNiftyCompaniesData.setHighestOptChainVol_openInterest(apiData.getOpenInterest());
					bankNiftyCompaniesData.setHighestOptChainVol_prevOpenInterest(apiData.getPrevOpenInterest());
					bankNiftyCompaniesData.setHighestOptChainVol_oiDayChange(apiData.getOiDayChange());
					bankNiftyCompaniesData.setHighestOptChainVol_oiDayChangePerc(apiData.getOiDayChangePerc());
					bankNiftyCompaniesData.setHighestOptChainVol_lastTradeQty(apiData.getLastTradeQty());
					bankNiftyCompaniesData.setHighestOptChainVol_lastTradeTime(apiData.getLastTradeTime());

					// Convert object to JSON string
//					Gson gson = new GsonBuilder().setPrettyPrinting().create();
//					
//					String jsonOutput = gson.toJson(bankNiftyCompaniesData);
//
//					// Print JSON
//					System.out.println(jsonOutput);

					// Make predictions using both models
					// double djlPrediction = deepLearningService.predict(apiData);
					ModelTrainer.initializeModelAndSave();
					// double dl4jPrediction = dl4jService.predict(bankNiftyCompaniesData);
					// System.out.println("\nDJL Model Prediction: " + djlPrediction);
					// System.out.println("DL4J Model Prediction: " + dl4jPrediction);
//					System.out.println("Current LTP: " + apiData.getLtp());
//					System.out.println("ApiConstants.storedStrikePrice: " + ApiConstants.storedStrikePrice);

					highestVolumeDataRepo.save(apiData);
					bankNiftyCompaniesDataRepo.save(bankNiftyCompaniesData);
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
