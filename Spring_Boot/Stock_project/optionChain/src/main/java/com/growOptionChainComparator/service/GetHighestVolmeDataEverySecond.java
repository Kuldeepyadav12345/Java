package com.growOptionChainComparator.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.growOptionChainComparator.constant.ApiConstants;
import com.growOptionChainComparator.model.highestVolumeData;
import com.growOptionChainComparator.repository.HighestVolumeDataRepo;


@Service
public class GetHighestVolmeDataEverySecond {

    private final OptionChainUrlService optionChainUrlService;
    private final HighestVolumeDataRepo highestVolumeDataRepo;
    private final ObjectMapper objectMapper;

    public GetHighestVolmeDataEverySecond(OptionChainUrlService optionChainUrlService,
                                          HighestVolumeDataRepo highestVolumeDataRepo,
                                          ObjectMapper objectMapper) {
        this.optionChainUrlService = optionChainUrlService;
        this.highestVolumeDataRepo = highestVolumeDataRepo;
        this.objectMapper = objectMapper;
    }

    public void getHighestVolumeData() {
        try {
            System.out.println("Fetching highest volume data... " + ApiConstants.HIGHEST_VOLUME_URL);

            URL url = new URL(ApiConstants.HIGHEST_VOLUME_URL);
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

                // ✅ Parse JSON response into entity
                highestVolumeData highestVolumeData =
                        objectMapper.readValue(response.toString(), highestVolumeData.class);

                // ✅ Save to database
                highestVolumeDataRepo.save(highestVolumeData);

                System.out.println("Saved data for symbol: " + highestVolumeData.getLtp());
            } else {
                System.out.println("GET request failed. Response code: " + responseCode);
            }

        } catch (Exception e) {
            System.err.println("Error fetching data for URL " + ApiConstants.HIGHEST_VOLUME_URL + ": " + e.getMessage());
        }
    }
}
