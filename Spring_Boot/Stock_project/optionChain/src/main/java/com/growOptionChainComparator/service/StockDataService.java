package com.growOptionChainComparator.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StockDataService {

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

	/**
	 * Runs every 5 seconds
	 */
	@Scheduled(fixedRate = 5000, initialDelay = 0)
	public void getVolumeDataEveryFiveSecond() {
		highestVolumeEveryFiveSecond.getHighestVolume();
		// Mark flag true after first successful run
		firstFiveSecondJobDone = true;
	}

	/**
	 * Runs every 1 second
	 */
//	@Scheduled(fixedRate = 1000, initialDelay = 1000)
//	public void getHighestVolumeDataEverySecond() {
//		if (!firstFiveSecondJobDone) {
//			
//			return;
//		}
//		//highestVolmeDataEverySecond.getHighestVolumeData();
//	}
}
