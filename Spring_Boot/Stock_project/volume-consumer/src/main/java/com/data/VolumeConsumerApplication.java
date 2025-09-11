package com.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.data.model.OptionData;
import com.data.model.StrikePriceResponse;
import com.data.repo.HighestVolumeDataRepo;
import com.data.service.Deeplearning4jService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackages = "com.data.model")
@EnableJpaRepositories(basePackages = "com.data.repo")
@EnableScheduling
public class VolumeConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VolumeConsumerApplication.class, args);
		System.setProperty("org.deeplearning4j.ui.port", "9004");

	}

}
