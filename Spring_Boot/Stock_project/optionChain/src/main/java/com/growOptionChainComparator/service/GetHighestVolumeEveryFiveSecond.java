package com.growOptionChainComparator.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.growOptionChainComparator.constant.ApiConstants;
import com.growOptionChainComparator.dto.HighStrikePriceDTO;
import com.growOptionChainComparator.model.OptionChainData;
import com.growOptionChainComparator.model.OptionVolumeData;
import com.growOptionChainComparator.repository.OptionChainDataRepository;

@Service
public class GetHighestVolumeEveryFiveSecond {

	private final OptionChainUrlService optionChainUrlService;
	private final OptionChainDataRepository optionChainDataRepository;
	private final ObjectMapper objectMapper;

	private static List<HighStrikePriceDTO> latestHighStrikePrices = new ArrayList<>();

	// Constructor injection (recommended in modern Spring)
	public GetHighestVolumeEveryFiveSecond(OptionChainUrlService optionChainUrlService,
			OptionChainDataRepository optionChainDataRepository, ObjectMapper objectMapper) {
		this.optionChainUrlService = optionChainUrlService;
		this.optionChainDataRepository = optionChainDataRepository;
		this.objectMapper = objectMapper;
	}

	private String extractOptionSymbolFromUrl(String url) {
		try {
			String[] parts = url.split("/");
			return parts[parts.length - 2];
		} catch (Exception e) {
			System.err.println("Error extracting option symbol from URL: " + url);
		}
		return null;
	}

	public void getHighestVolume() {
		try {
			List<String> urls = optionChainUrlService.generateDynamicOptionUrls();
			List<OptionVolumeData> volumeDataList = new ArrayList<>();

			// System.out.println("Fetching data for " + urls.size() + " URLs...");

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

						// Parse JSON into OptionChainData
						OptionChainData optionData = objectMapper.readValue(response.toString(), OptionChainData.class);

						// Add strike symbol
						String optionSymbol = extractOptionSymbolFromUrl(storedUrl);
						if (optionSymbol != null) {
							optionData.setStrikePrice(optionSymbol);
						}

						// Add to volume list
						volumeDataList.add(new OptionVolumeData(optionSymbol, optionData.getVolume(), storedUrl));

						// Save to DB
						optionChainDataRepository.save(optionData);

					} else {
						System.out.println("GET request failed. Response code: " + responseCode);
					}
				} catch (Exception e) {
					System.err.println("Error fetching data for URL " + storedUrl + ": " + e.getMessage());
				}
			}

			// Sort & print top 10
			Collections.sort(volumeDataList);
			// System.out.println("\n========== Top 10 Highest Volumes ==========");
			for (int i = 0; i < Math.min(10, volumeDataList.size()); i++) {
				OptionVolumeData data = volumeDataList.get(i);
//                System.out.printf("%d. Strike Price: %s, Volume: %d, URL: %s%n",
//                        i + 1, data.getStrikePrice(), data.getVolume(), data.getUrl());
			}
			// System.out.println("==========================================\n");

			if (!volumeDataList.isEmpty()) {
				ApiConstants.HIGHEST_VOLUME_URL = volumeDataList.get(0).getStrikePrice();
				OptionVolumeData highestVolumeData = volumeDataList.get(0);
				latestHighStrikePrices = Collections.singletonList(new HighStrikePriceDTO(
						highestVolumeData.getStrikePrice(), highestVolumeData.getUrl(), highestVolumeData.getVolume()));
			}

		} catch (Exception e) {
			System.err.println("Error fetching stock data: " + e.getMessage());
		}
	}

	public static List<HighStrikePriceDTO> getLatestHighStrikePrices() {
		return latestHighStrikePrices;
	}
}
