package com.growOptionChainComparator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.growOptionChainComparator.model.BankNiftyCompanies;
import com.growOptionChainComparator.model.LivePrice;
import com.growOptionChainComparator.repository.DynamicPriceRepository;

import jakarta.transaction.Transactional;

/**
 * Service class to handle the business logic for LivePrice data.
 *
 * This service is responsible for determining the correct table name based on
 * the 'symbol' and then delegating the save operation to the custom repository.
 */
@Service
public class LivePriceService {

	
	//static BankNiftyCompanies bankNiftyCompanies = new BankNiftyCompanies();
	 static BankNiftyCompanies bankNiftyCompanies = BankNiftyCompanies.getInstance();

	private final DynamicPriceRepository dynamicPriceRepository;

	@Autowired
	public LivePriceService(DynamicPriceRepository dynamicPriceRepository) {
		this.dynamicPriceRepository = dynamicPriceRepository;
	}

	/**
	 * Processes and saves a LivePrice object to the appropriate table. The table
	 * name is constructed dynamically from the symbol.
	 *
	 * @param livePrice The LivePrice object to be saved.
	 */
	@Transactional
	public void saveLivePrice(LivePrice livePrice) {
		// Construct the table name from the symbol
		String tableName = livePrice.getSymbol().toLowerCase() + "_prices";

		// Call the custom repository to save the data
		dynamicPriceRepository.saveToDynamicTable(tableName, livePrice);

		//System.out.println(" Data Saved Latest Ltp '" + livePrice.getSymbol() + "' -->>> '" + livePrice.getLtp() + "'.");
		setAllBankNiftyCompanies(livePrice);
		//System.out.println(new Gson().toJson(bankNiftyCompanies));
		

	}

	public void setAllBankNiftyCompanies(LivePrice livePrice) {
		if (livePrice.getSymbol().equals("HDFCBANK")) {
			this.bankNiftyCompanies.setHDFCBANK_close(livePrice.getClose());
			this.bankNiftyCompanies.setHDFCBANK_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setHDFCBANK_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setHDFCBANK_high(livePrice.getHigh());
			this.bankNiftyCompanies.setHDFCBANK_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setHDFCBANK_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setHDFCBANK_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setHDFCBANK_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setHDFCBANK_low(livePrice.getLow());
			this.bankNiftyCompanies.setHDFCBANK_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setHDFCBANK_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setHDFCBANK_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setHDFCBANK_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setHDFCBANK_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setHDFCBANK_open(livePrice.getLtp());
			this.bankNiftyCompanies.setHDFCBANK_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setHDFCBANK_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setHDFCBANK_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setHDFCBANK_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setHDFCBANK_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setHDFCBANK_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setHDFCBANK_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setHDFCBANK_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setHDFCBANK_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setHDFCBANK_type(livePrice.getType());

		} else if (livePrice.getSymbol().equals("ICICIBANK")) {
			this.bankNiftyCompanies.setICICIBANK_close(livePrice.getClose());
			this.bankNiftyCompanies.setICICIBANK_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setICICIBANK_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setICICIBANK_high(livePrice.getHigh());
			this.bankNiftyCompanies.setICICIBANK_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setICICIBANK_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setICICIBANK_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setICICIBANK_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setICICIBANK_low(livePrice.getLow());
			this.bankNiftyCompanies.setICICIBANK_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setICICIBANK_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setICICIBANK_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setICICIBANK_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setICICIBANK_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setICICIBANK_open(livePrice.getLtp());
			this.bankNiftyCompanies.setICICIBANK_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setICICIBANK_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setICICIBANK_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setICICIBANK_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setICICIBANK_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setICICIBANK_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setICICIBANK_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setICICIBANK_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setICICIBANK_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setICICIBANK_type(livePrice.getType());
		} else if (livePrice.getSymbol().equals("SBIN")) {
			this.bankNiftyCompanies.setSBIN_close(livePrice.getClose());
			this.bankNiftyCompanies.setSBIN_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setSBIN_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setSBIN_high(livePrice.getHigh());
			this.bankNiftyCompanies.setSBIN_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setSBIN_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setSBIN_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setSBIN_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setSBIN_low(livePrice.getLow());
			this.bankNiftyCompanies.setSBIN_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setSBIN_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setSBIN_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setSBIN_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setSBIN_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setSBIN_open(livePrice.getLtp());
			this.bankNiftyCompanies.setSBIN_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setSBIN_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setSBIN_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setSBIN_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setSBIN_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setSBIN_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setSBIN_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setSBIN_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setSBIN_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setSBIN_type(livePrice.getType());
		} else if (livePrice.getSymbol().equals("KOTAKBANK")) {

			this.bankNiftyCompanies.setKOTAKBANK_close(livePrice.getClose());
			this.bankNiftyCompanies.setKOTAKBANK_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setKOTAKBANK_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setKOTAKBANK_high(livePrice.getHigh());
			this.bankNiftyCompanies.setKOTAKBANK_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setKOTAKBANK_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setKOTAKBANK_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setKOTAKBANK_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setKOTAKBANK_low(livePrice.getLow());
			this.bankNiftyCompanies.setKOTAKBANK_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setKOTAKBANK_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setKOTAKBANK_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setKOTAKBANK_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setKOTAKBANK_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setKOTAKBANK_open(livePrice.getLtp());
			this.bankNiftyCompanies.setKOTAKBANK_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setKOTAKBANK_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setKOTAKBANK_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setKOTAKBANK_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setKOTAKBANK_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setKOTAKBANK_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setKOTAKBANK_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setKOTAKBANK_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setKOTAKBANK_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setKOTAKBANK_type(livePrice.getType());
		} else if (livePrice.getSymbol().equals("AXISBANK")) {
			this.bankNiftyCompanies.setAXISBANK_close(livePrice.getClose());
			this.bankNiftyCompanies.setAXISBANK_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setAXISBANK_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setAXISBANK_high(livePrice.getHigh());
			this.bankNiftyCompanies.setAXISBANK_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setAXISBANK_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setAXISBANK_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setAXISBANK_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setAXISBANK_low(livePrice.getLow());
			this.bankNiftyCompanies.setAXISBANK_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setAXISBANK_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setAXISBANK_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setAXISBANK_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setAXISBANK_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setAXISBANK_open(livePrice.getLtp());
			this.bankNiftyCompanies.setAXISBANK_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setAXISBANK_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setAXISBANK_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setAXISBANK_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setAXISBANK_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setAXISBANK_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setAXISBANK_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setAXISBANK_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setAXISBANK_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setAXISBANK_type(livePrice.getType());
		} else if (livePrice.getSymbol().equals("PNB")) {
			this.bankNiftyCompanies.setPNB_close(livePrice.getClose());
			this.bankNiftyCompanies.setPNB_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setPNB_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setPNB_high(livePrice.getHigh());
			this.bankNiftyCompanies.setPNB_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setPNB_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setPNB_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setPNB_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setPNB_low(livePrice.getLow());
			this.bankNiftyCompanies.setPNB_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setPNB_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setPNB_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setPNB_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setPNB_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setPNB_open(livePrice.getLtp());
			this.bankNiftyCompanies.setPNB_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setPNB_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setPNB_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setPNB_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setPNB_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setPNB_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setPNB_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setPNB_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setPNB_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setPNB_type(livePrice.getType());
		} else if (livePrice.getSymbol().equals("BANKBARODA")) {
			this.bankNiftyCompanies.setBANKBARODA_close(livePrice.getClose());
			this.bankNiftyCompanies.setBANKBARODA_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setBANKBARODA_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setBANKBARODA_high(livePrice.getHigh());
			this.bankNiftyCompanies.setBANKBARODA_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setBANKBARODA_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setBANKBARODA_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setBANKBARODA_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setBANKBARODA_low(livePrice.getLow());
			this.bankNiftyCompanies.setBANKBARODA_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setBANKBARODA_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setBANKBARODA_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setBANKBARODA_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setBANKBARODA_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setBANKBARODA_open(livePrice.getLtp());
			this.bankNiftyCompanies.setBANKBARODA_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setBANKBARODA_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setBANKBARODA_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setBANKBARODA_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setBANKBARODA_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setBANKBARODA_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setBANKBARODA_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setBANKBARODA_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setBANKBARODA_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setBANKBARODA_type(livePrice.getType());
		} else if (livePrice.getSymbol().equals("CANBK")) {
			this.bankNiftyCompanies.setCANBK_close(livePrice.getClose());
			this.bankNiftyCompanies.setCANBK_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setCANBK_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setCANBK_high(livePrice.getHigh());
			this.bankNiftyCompanies.setCANBK_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setCANBK_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setCANBK_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setCANBK_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setCANBK_low(livePrice.getLow());
			this.bankNiftyCompanies.setCANBK_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setCANBK_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setCANBK_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setCANBK_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setCANBK_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setCANBK_open(livePrice.getLtp());
			this.bankNiftyCompanies.setCANBK_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setCANBK_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setCANBK_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setCANBK_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setCANBK_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setCANBK_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setCANBK_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setCANBK_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setCANBK_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setCANBK_type(livePrice.getType());
		} else if (livePrice.getSymbol().equals("INDUSINDBK")) {
			this.bankNiftyCompanies.setINDUSINDBK_close(livePrice.getClose());
			this.bankNiftyCompanies.setINDUSINDBK_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setINDUSINDBK_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setINDUSINDBK_high(livePrice.getHigh());
			this.bankNiftyCompanies.setINDUSINDBK_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setINDUSINDBK_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setINDUSINDBK_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setINDUSINDBK_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setINDUSINDBK_low(livePrice.getLow());
			this.bankNiftyCompanies.setINDUSINDBK_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setINDUSINDBK_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setINDUSINDBK_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setINDUSINDBK_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setINDUSINDBK_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setINDUSINDBK_open(livePrice.getLtp());
			this.bankNiftyCompanies.setINDUSINDBK_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setINDUSINDBK_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setINDUSINDBK_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setINDUSINDBK_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setINDUSINDBK_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setINDUSINDBK_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setINDUSINDBK_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setINDUSINDBK_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setINDUSINDBK_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setINDUSINDBK_type(livePrice.getType());
		} else if (livePrice.getSymbol().equals("IDFCFIRSTB")) {
			this.bankNiftyCompanies.setIDFCFIRSTB_close(livePrice.getClose());
			this.bankNiftyCompanies.setIDFCFIRSTB_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setIDFCFIRSTB_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setIDFCFIRSTB_high(livePrice.getHigh());
			this.bankNiftyCompanies.setIDFCFIRSTB_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setIDFCFIRSTB_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setIDFCFIRSTB_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setIDFCFIRSTB_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setIDFCFIRSTB_low(livePrice.getLow());
			this.bankNiftyCompanies.setIDFCFIRSTB_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setIDFCFIRSTB_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setIDFCFIRSTB_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setIDFCFIRSTB_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setIDFCFIRSTB_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setIDFCFIRSTB_open(livePrice.getLtp());
			this.bankNiftyCompanies.setIDFCFIRSTB_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setIDFCFIRSTB_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setIDFCFIRSTB_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setIDFCFIRSTB_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setIDFCFIRSTB_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setIDFCFIRSTB_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setIDFCFIRSTB_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setIDFCFIRSTB_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setIDFCFIRSTB_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setIDFCFIRSTB_type(livePrice.getType());
		} else if (livePrice.getSymbol().equals("AUBANK")) {
			this.bankNiftyCompanies.setAUBANK_close(livePrice.getClose());
			this.bankNiftyCompanies.setAUBANK_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setAUBANK_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setAUBANK_high(livePrice.getHigh());
			this.bankNiftyCompanies.setAUBANK_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setAUBANK_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setAUBANK_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setAUBANK_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setAUBANK_low(livePrice.getLow());
			this.bankNiftyCompanies.setAUBANK_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setAUBANK_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setAUBANK_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setAUBANK_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setAUBANK_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setAUBANK_open(livePrice.getLtp());
			this.bankNiftyCompanies.setAUBANK_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setAUBANK_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setAUBANK_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setAUBANK_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setAUBANK_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setAUBANK_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setAUBANK_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setAUBANK_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setAUBANK_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setAUBANK_type(livePrice.getType());
		} else if (livePrice.getSymbol().equals("FEDERALBNK")) {
			this.bankNiftyCompanies.setFEDERALBNK_close(livePrice.getClose());
			this.bankNiftyCompanies.setFEDERALBNK_dayChange(livePrice.getDayChange());
			this.bankNiftyCompanies.setFEDERALBNK_dayChangePerc(livePrice.getDayChangePerc());
			this.bankNiftyCompanies.setFEDERALBNK_high(livePrice.getHigh());
			this.bankNiftyCompanies.setFEDERALBNK_highPriceRange(livePrice.getHighPriceRange());
			this.bankNiftyCompanies.setFEDERALBNK_highTradeRange(livePrice.getHighTradeRange());
			this.bankNiftyCompanies.setFEDERALBNK_lastTradeQty(livePrice.getLastTradeQty());
			this.bankNiftyCompanies.setFEDERALBNK_lastTradeTime(livePrice.getLastTradeTime());
			this.bankNiftyCompanies.setFEDERALBNK_low(livePrice.getLow());
			this.bankNiftyCompanies.setFEDERALBNK_lowPriceRange(livePrice.getLowPriceRange());
			this.bankNiftyCompanies.setFEDERALBNK_lowTradeRange(livePrice.getLowTradeRange());
			this.bankNiftyCompanies.setFEDERALBNK_ltp(livePrice.getLtp());
			this.bankNiftyCompanies.setFEDERALBNK_oiDayChange(livePrice.getLtp());
			this.bankNiftyCompanies.setFEDERALBNK_oiDayChangePerc(livePrice.getLtp());
			this.bankNiftyCompanies.setFEDERALBNK_open(livePrice.getLtp());
			this.bankNiftyCompanies.setFEDERALBNK_openInterest(livePrice.getOpenInterest());
			this.bankNiftyCompanies.setFEDERALBNK_prevOpenInterest(livePrice.getPrevOpenInterest());
			this.bankNiftyCompanies.setFEDERALBNK_symbol(livePrice.getSymbol());
			this.bankNiftyCompanies.setFEDERALBNK_totalBuyQty(livePrice.getTotalBuyQty());
			this.bankNiftyCompanies.setFEDERALBNK_totalSellQty(livePrice.getTotalSellQty());
			this.bankNiftyCompanies.setFEDERALBNK_tsInMillis(livePrice.getTsInMillis());
			this.bankNiftyCompanies.setFEDERALBNK_volume(livePrice.getVolume());
			this.bankNiftyCompanies.setFEDERALBNK_yearHighPrice(livePrice.getYearHighPrice());
			this.bankNiftyCompanies.setFEDERALBNK_yearLowPrice(livePrice.getYearLowPrice());
			this.bankNiftyCompanies.setFEDERALBNK_type(livePrice.getType());
		}

	}
	
	public static  BankNiftyCompanies returnAllBankNiftyCompanies() {
		return bankNiftyCompanies;
	}
}