package com.data.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.data.dto.HighStrikePriceDTO;
import com.data.model.OptionChainData;
import com.data.repository.OptionChainDataRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StockDataService {

	@Autowired
	private OptionChainUrlService optionChainUrlService;

	@Autowired
	private OptionChainDataRepository optionChainDataRepository;

	@Autowired
	private ObjectMapper objectMapper;

	// Inner class to hold volume data
	private static class OptionVolumeData implements Comparable<OptionVolumeData> {
		private String symbol;
		private Long volume;
		private String url;

		public OptionVolumeData(String symbol, Long volume, String url) {
			this.symbol = symbol;
			this.volume = volume;
			this.url = url;
		}

		@Override
		public int compareTo(OptionVolumeData other) {
			return other.volume.compareTo(this.volume); // Sort in descending order
		}
	}

	private String extractOptionSymbolFromUrl(String url) {
		try {
			String[] parts = url.split("/");
			return parts[parts.length - 2]; // Returns full symbol like BANKNIFTY25MAY51600CE
		} catch (Exception e) {
			System.err.println("Error extracting option symbol from URL: " + url);
		}
		return null;
	}

	private volatile List<HighStrikePriceDTO> latestHighStrikePrices = new ArrayList<>();

	public List<HighStrikePriceDTO> getLatestHighStrikePrices() {
		return new ArrayList<>(latestHighStrikePrices);
	}

	@Scheduled(fixedRate = 300000) // 5 minutes in milliseconds
	public void fetchStockData() {
		try {
			List<String> urls = optionChainUrlService.generateDynamicOptionUrls();
			List<OptionVolumeData> volumeDataList = new ArrayList<>();

			for (String storedUrl : urls) {
				try {
					URL url = new URL(storedUrl);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();

					int responseCode = conn.getResponseCode();
					if (responseCode == HttpURLConnection.HTTP_OK) {
						BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						StringBuilder response = new StringBuilder();
						String line;

						while ((line = reader.readLine()) != null) {
							response.append(line);
						}
						reader.close();

						// Parse JSON response into OptionChainData
						OptionChainData optionData = objectMapper.readValue(response.toString(), OptionChainData.class);

						// Set the full option symbol as strike price
						String optionSymbol = extractOptionSymbolFromUrl(storedUrl);
						if (optionSymbol != null) {
							optionData.setStrikePrice(optionSymbol); // Assuming you've changed strikePrice to String in OptionChainData
						}

						// Add volume data to list
						volumeDataList.add(new OptionVolumeData(optionSymbol, optionData.getVolume(), storedUrl));

						// Explicitly set all values to ensure proper mapping
						optionData.setType(optionData.getType());
						optionData.setSymbol(optionData.getSymbol());
						optionData.setTsInMillis(optionData.getTsInMillis());
						optionData.setOpen(optionData.getOpen());
						optionData.setHigh(optionData.getHigh());
						optionData.setLow(optionData.getLow());
						optionData.setClose(optionData.getClose());
						optionData.setLtp(optionData.getLtp());
						optionData.setDayChange(optionData.getDayChange());
						optionData.setDayChangePerc(optionData.getDayChangePerc());
						optionData.setLowPriceRange(optionData.getLowPriceRange());
						optionData.setHighPriceRange(optionData.getHighPriceRange());
						optionData.setVolume(optionData.getVolume());
						optionData.setLowTradeRange(optionData.getLowTradeRange());
						optionData.setHighTradeRange(optionData.getHighTradeRange());
						optionData.setTotalBuyQty(optionData.getTotalBuyQty());
						optionData.setTotalSellQty(optionData.getTotalSellQty());
						optionData.setOpenInterest(optionData.getOpenInterest());
						optionData.setPrevOpenInterest(optionData.getPrevOpenInterest());
						optionData.setOiDayChange(optionData.getOiDayChange());
						optionData.setOiDayChangePerc(optionData.getOiDayChangePerc());
						optionData.setLastTradeQty(optionData.getLastTradeQty());
						optionData.setLastTradeTime(optionData.getLastTradeTime());

						// Save to database
						optionChainDataRepository.save(optionData);

						//System.out.println("Saved data for symbol: " + response.toString());
					} else {
						System.out.println("GET request failed. Response code: " + responseCode);
					}
				} catch (Exception e) {
					System.err.println("Error fetching data for URL " + storedUrl + ": " + e.getMessage());
				}
			}

			// Sort and print top 10 volumes with all information
			Collections.sort(volumeDataList);
			System.out.println("\n========== Top 10 Highest Volumes ==========");
			for (int i = 0; i < Math.min(20, volumeDataList.size()); i++) {
				OptionVolumeData data = volumeDataList.get(i);
				System.out.printf("%d. Strike Price: %s, Volume: %d, URL: %s%n", 
					i + 1, data.symbol, data.volume, data.url);
			}
			System.out.println("==========================================\n");

			// After sorting and printing top 10 volumes, update latestHighStrikePrices
			if (!volumeDataList.isEmpty()) {
				OptionVolumeData highestVolumeData = volumeDataList.get(0);
				this.latestHighStrikePrices = Collections.singletonList(
					new HighStrikePriceDTO(
						highestVolumeData.symbol,
						highestVolumeData.url,
						highestVolumeData.volume
					)
				);
			}

		} catch (Exception e) {
			System.err.println("Error fetching stock data: " + e.getMessage());
		}
	}

}
