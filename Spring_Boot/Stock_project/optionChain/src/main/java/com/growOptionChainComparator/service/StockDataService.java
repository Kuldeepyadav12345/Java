package com.growOptionChainComparator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StockDataService {

	int counter = 0;
	private final GetHighestVolumeEveryFiveSecond highestVolumeEveryFiveSecond;
	private final GetHighestVolmeDataEverySecond highestVolmeDataEverySecond;

	// Flag to control execution order
	private volatile boolean firstFiveSecondJobDone = false;

	@Autowired
	public StockDataService(GetHighestVolumeEveryFiveSecond highestVolumeEveryFiveSecond,
			GetHighestVolmeDataEverySecond highestVolmeDataEverySecond) {
		this.highestVolumeEveryFiveSecond = highestVolumeEveryFiveSecond;
		this.highestVolmeDataEverySecond = highestVolmeDataEverySecond;
	}
	@Autowired
	GetHighestVolmeDataEverySecond livePriceEverySecond;

//	/**
//	 * Runs every 5 seconds
//	 */
//	@Scheduled(fixedRate = 5000, initialDelay = 0)
//	public void getVolumeDataEveryFiveSecond() {
//		highestVolumeEveryFiveSecond.getHighestVolume();
//		// Mark flag true after first successful run
//		firstFiveSecondJobDone = true;
//	}

	/**
	 * Runs every 1 second
	 */
	@Scheduled(fixedRate = 100000, initialDelay = 0)
	public void getBankNiftyCompanyDataEverySecond() {
		livePriceEverySecond.getBankNiftyCompanyData();
		if (counter % 5 == 0) {
			highestVolumeEveryFiveSecond.getHighestVolume();
			// Mark flag true after first successful run
			firstFiveSecondJobDone = true;
			counter = 0;
		}
		counter++;
	}

}
