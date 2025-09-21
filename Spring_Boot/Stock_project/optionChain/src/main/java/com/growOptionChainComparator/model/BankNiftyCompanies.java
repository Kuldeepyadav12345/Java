package com.growOptionChainComparator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//This model holds the data of 12 BankNifty companies fetched from the API every second and stores it in the database
@Entity
@Table(name = "BANKNIFTYCOMPANIES")
public class BankNiftyCompanies {

	 private static BankNiftyCompanies instance;
	 
	@Id
	@JsonIgnoreProperties(ignoreUnknown = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // A primary key is required for a JPA entity	
	 
	private double HDFCBANK_close;
	private double ICICIBANK_close;
	private double SBIN_close;
	private double KOTAKBANK_close;
	private double AXISBANK_close;
	private double PNB_close;
	private double BANKBARODA_close;
	private double CANBK_close;
	private double INDUSINDBK_close;
	private double IDFCFIRSTB_close;
	private double AUBANK_close;
	private double FEDERALBNK_close;


	 
	private double HDFCBANK_dayChange;
	private double ICICIBANK_dayChange;
	private double SBIN_dayChange;
	private double KOTAKBANK_dayChange;
	private double AXISBANK_dayChange;
	private double PNB_dayChange;
	private double BANKBARODA_dayChange;
	private double CANBK_dayChange;
	private double INDUSINDBK_dayChange;
	private double IDFCFIRSTB_dayChange;
	private double AUBANK_dayChange;
	private double FEDERALBNK_dayChange;



	private double HDFCBANK_dayChangePerc;
	private double ICICIBANK_dayChangePerc;
	private double SBIN_dayChangePerc;
	private double KOTAKBANK_dayChangePerc;
	private double AXISBANK_dayChangePerc;
	private double PNB_dayChangePerc;
	private double BANKBARODA_dayChangePerc;
	private double CANBK_dayChangePerc;
	private double INDUSINDBK_dayChangePerc;
	private double IDFCFIRSTB_dayChangePerc;
	private double AUBANK_dayChangePerc;
	private double FEDERALBNK_dayChangePerc;



	private double HDFCBANK_high;
	private double ICICIBANK_high;
	private double SBIN_high;
	private double KOTAKBANK_high;
	private double AXISBANK_high;
	private double PNB_high;
	private double BANKBARODA_high;
	private double CANBK_high;
	private double INDUSINDBK_high;
	private double IDFCFIRSTB_high;
	private double AUBANK_high;
	private double FEDERALBNK_high;


	private double HDFCBANK_highPriceRange;
	private double ICICIBANK_highPriceRange;
	private double SBIN_highPriceRange;
	private double KOTAKBANK_highPriceRange;
	private double AXISBANK_highPriceRange;
	private double PNB_highPriceRange;
	private double BANKBARODA_highPriceRange;
	private double CANBK_highPriceRange;
	private double INDUSINDBK_highPriceRange;
	private double IDFCFIRSTB_highPriceRange;
	private double AUBANK_highPriceRange;
	private double FEDERALBNK_highPriceRange;



	private String HDFCBANK_highTradeRange;
	private String ICICIBANK_highTradeRange;
	private String SBIN_highTradeRange;
	private String KOTAKBANK_highTradeRange;
	private String AXISBANK_highTradeRange;
	private String PNB_highTradeRange;
	private String BANKBARODA_highTradeRange;
	private String CANBK_highTradeRange;
	private String INDUSINDBK_highTradeRange;
	private String IDFCFIRSTB_highTradeRange;
	private String AUBANK_highTradeRange;
	private String FEDERALBNK_highTradeRange;



	private int HDFCBANK_lastTradeQty;
	private int ICICIBANK_lastTradeQty;
	private int SBIN_lastTradeQty;
	private int KOTAKBANK_lastTradeQty;
	private int AXISBANK_lastTradeQty;
	private int PNB_lastTradeQty;
	private int BANKBARODA_lastTradeQty;
	private int CANBK_lastTradeQty;
	private int INDUSINDBK_lastTradeQty;
	private int IDFCFIRSTB_lastTradeQty;
	private int AUBANK_lastTradeQty;
	private int FEDERALBNK_lastTradeQty;



	private long HDFCBANK_lastTradeTime;
	private long ICICIBANK_lastTradeTime;
	private long SBIN_lastTradeTime;
	private long KOTAKBANK_lastTradeTime;
	private long AXISBANK_lastTradeTime;
	private long PNB_lastTradeTime;
	private long BANKBARODA_lastTradeTime;
	private long CANBK_lastTradeTime;
	private long INDUSINDBK_lastTradeTime;
	private long IDFCFIRSTB_lastTradeTime;
	private long AUBANK_lastTradeTime;
	private long FEDERALBNK_lastTradeTime;



	private double HDFCBANK_low;
	private double ICICIBANK_low;
	private double SBIN_low;
	private double KOTAKBANK_low;
	private double AXISBANK_low;
	private double PNB_low;
	private double BANKBARODA_low;
	private double CANBK_low;
	private double INDUSINDBK_low;
	private double IDFCFIRSTB_low;
	private double AUBANK_low;
	private double FEDERALBNK_low;



	private double HDFCBANK_lowPriceRange;
	private double ICICIBANK_lowPriceRange;
	private double SBIN_lowPriceRange;
	private double KOTAKBANK_lowPriceRange;
	private double AXISBANK_lowPriceRange;
	private double PNB_lowPriceRange;
	private double BANKBARODA_lowPriceRange;
	private double CANBK_lowPriceRange;
	private double INDUSINDBK_lowPriceRange;
	private double IDFCFIRSTB_lowPriceRange;
	private double AUBANK_lowPriceRange;
	private double FEDERALBNK_lowPriceRange;



	private String HDFCBANK_lowTradeRange;
	private String ICICIBANK_lowTradeRange;
	private String SBIN_lowTradeRange;
	private String KOTAKBANK_lowTradeRange;
	private String AXISBANK_lowTradeRange;
	private String PNB_lowTradeRange;
	private String BANKBARODA_lowTradeRange;
	private String CANBK_lowTradeRange;
	private String INDUSINDBK_lowTradeRange;
	private String IDFCFIRSTB_lowTradeRange;
	private String AUBANK_lowTradeRange;
	private String FEDERALBNK_lowTradeRange;



	private double HDFCBANK_ltp;
	private double ICICIBANK_ltp;
	private double SBIN_ltp;
	private double KOTAKBANK_ltp;
	private double AXISBANK_ltp;
	private double PNB_ltp;
	private double BANKBARODA_ltp;
	private double CANBK_ltp;
	private double INDUSINDBK_ltp;
	private double IDFCFIRSTB_ltp;
	private double AUBANK_ltp;
	private double FEDERALBNK_ltp;



	private double HDFCBANK_oiDayChange;
	private double ICICIBANK_oiDayChange;
	private double SBIN_oiDayChange;
	private double KOTAKBANK_oiDayChange;
	private double AXISBANK_oiDayChange;
	private double PNB_oiDayChange;
	private double BANKBARODA_oiDayChange;
	private double CANBK_oiDayChange;
	private double INDUSINDBK_oiDayChange;
	private double IDFCFIRSTB_oiDayChange;
	private double AUBANK_oiDayChange;
	private double FEDERALBNK_oiDayChange;


	private double HDFCBANK_oiDayChangePerc;
	private double ICICIBANK_oiDayChangePerc;
	private double SBIN_oiDayChangePerc;
	private double KOTAKBANK_oiDayChangePerc;
	private double AXISBANK_oiDayChangePerc;
	private double PNB_oiDayChangePerc;
	private double BANKBARODA_oiDayChangePerc;
	private double CANBK_oiDayChangePerc;
	private double INDUSINDBK_oiDayChangePerc;
	private double IDFCFIRSTB_oiDayChangePerc;
	private double AUBANK_oiDayChangePerc;
	private double FEDERALBNK_oiDayChangePerc;



	private double HDFCBANK_open;
	private double ICICIBANK_open;
	private double SBIN_open;
	private double KOTAKBANK_open;
	private double AXISBANK_open;
	private double PNB_open;
	private double BANKBARODA_open;
	private double CANBK_open;
	private double INDUSINDBK_open;
	private double IDFCFIRSTB_open;
	private double AUBANK_open;
	private double FEDERALBNK_open;



	private String HDFCBANK_openInterest;
	private String ICICIBANK_openInterest;
	private String SBIN_openInterest;
	private String KOTAKBANK_openInterest;
	private String AXISBANK_openInterest;
	private String PNB_openInterest;
	private String BANKBARODA_openInterest;
	private String CANBK_openInterest;
	private String INDUSINDBK_openInterest;
	private String IDFCFIRSTB_openInterest;
	private String AUBANK_openInterest;
	private String FEDERALBNK_openInterest;



	private String HDFCBANK_prevOpenInterest;
	private String ICICIBANK_prevOpenInterest;
	private String SBIN_prevOpenInterest;
	private String KOTAKBANK_prevOpenInterest;
	private String AXISBANK_prevOpenInterest;
	private String PNB_prevOpenInterest;
	private String BANKBARODA_prevOpenInterest;
	private String CANBK_prevOpenInterest;
	private String INDUSINDBK_prevOpenInterest;
	private String IDFCFIRSTB_prevOpenInterest;
	private String AUBANK_prevOpenInterest;
	private String FEDERALBNK_prevOpenInterest;



	private String HDFCBANK_symbol;
	private String ICICIBANK_symbol;
	private String SBIN_symbol;
	private String KOTAKBANK_symbol;
	private String AXISBANK_symbol;
	private String PNB_symbol;
	private String BANKBARODA_symbol;
	private String CANBK_symbol;
	private String INDUSINDBK_symbol;
	private String IDFCFIRSTB_symbol;
	private String AUBANK_symbol;
	private String FEDERALBNK_symbol;



	private int HDFCBANK_totalBuyQty;
	private int ICICIBANK_totalBuyQty;
	private int SBIN_totalBuyQty;
	private int KOTAKBANK_totalBuyQty;
	private int AXISBANK_totalBuyQty;
	private int PNB_totalBuyQty;
	private int BANKBARODA_totalBuyQty;
	private int CANBK_totalBuyQty;
	private int INDUSINDBK_totalBuyQty;
	private int IDFCFIRSTB_totalBuyQty;
	private int AUBANK_totalBuyQty;
	private int FEDERALBNK_totalBuyQty;



	private int HDFCBANK_totalSellQty;
	private int ICICIBANK_totalSellQty;
	private int SBIN_totalSellQty;
	private int KOTAKBANK_totalSellQty;
	private int AXISBANK_totalSellQty;
	private int PNB_totalSellQty;
	private int BANKBARODA_totalSellQty;
	private int CANBK_totalSellQty;
	private int INDUSINDBK_totalSellQty;
	private int IDFCFIRSTB_totalSellQty;
	private int AUBANK_totalSellQty;
	private int FEDERALBNK_totalSellQty;



	private long HDFCBANK_tsInMillis;
	private long ICICIBANK_tsInMillis;
	private long SBIN_tsInMillis;
	private long KOTAKBANK_tsInMillis;
	private long AXISBANK_tsInMillis;
	private long PNB_tsInMillis;
	private long BANKBARODA_tsInMillis;
	private long CANBK_tsInMillis;
	private long INDUSINDBK_tsInMillis;
	private long IDFCFIRSTB_tsInMillis;
	private long AUBANK_tsInMillis;
	private long FEDERALBNK_tsInMillis;



	private int HDFCBANK_volume;
	private int ICICIBANK_volume;
	private int SBIN_volume;
	private int KOTAKBANK_volume;
	private int AXISBANK_volume;
	private int PNB_volume;
	private int BANKBARODA_volume;
	private int CANBK_volume;
	private int INDUSINDBK_volume;
	private int IDFCFIRSTB_volume;
	private int AUBANK_volume;
	private int FEDERALBNK_volume;



	private double HDFCBANK_yearHighPrice;
	private double ICICIBANK_yearHighPrice;
	private double SBIN_yearHighPrice;
	private double KOTAKBANK_yearHighPrice;
	private double AXISBANK_yearHighPrice;
	private double PNB_yearHighPrice;
	private double BANKBARODA_yearHighPrice;
	private double CANBK_yearHighPrice;
	private double INDUSINDBK_yearHighPrice;
	private double IDFCFIRSTB_yearHighPrice;
	private double AUBANK_yearHighPrice;
	private double FEDERALBNK_yearHighPrice;



	private double HDFCBANK_yearLowPrice;
	private double ICICIBANK_yearLowPrice;
	private double SBIN_yearLowPrice;
	private double KOTAKBANK_yearLowPrice;
	private double AXISBANK_yearLowPrice;
	private double PNB_yearLowPrice;
	private double BANKBARODA_yearLowPrice;
	private double CANBK_yearLowPrice;
	private double INDUSINDBK_yearLowPrice;
	private double IDFCFIRSTB_yearLowPrice;
	private double AUBANK_yearLowPrice;
	private double FEDERALBNK_yearLowPrice;



	private String HDFCBANK_type;
	private String ICICIBANK_type;
	private String SBIN_type;
	private String KOTAKBANK_type;
	private String AXISBANK_type;
	private String PNB_type;
	private String BANKBARODA_type;
	private String CANBK_type;
	private String INDUSINDBK_type;
	private String IDFCFIRSTB_type;
	private String AUBANK_type;
	private String FEDERALBNK_type;
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getHDFCBANK_close() {
		return HDFCBANK_close;
	}
	public void setHDFCBANK_close(double hDFCBANK_close) {
		HDFCBANK_close = hDFCBANK_close;
	}
	public double getICICIBANK_close() {
		return ICICIBANK_close;
	}
	public void setICICIBANK_close(double iCICIBANK_close) {
		ICICIBANK_close = iCICIBANK_close;
	}
	public double getSBIN_close() {
		return SBIN_close;
	}
	public void setSBIN_close(double sBIN_close) {
		SBIN_close = sBIN_close;
	}
	public double getKOTAKBANK_close() {
		return KOTAKBANK_close;
	}
	public void setKOTAKBANK_close(double kOTAKBANK_close) {
		KOTAKBANK_close = kOTAKBANK_close;
	}
	public double getAXISBANK_close() {
		return AXISBANK_close;
	}
	public void setAXISBANK_close(double aXISBANK_close) {
		AXISBANK_close = aXISBANK_close;
	}
	public double getPNB_close() {
		return PNB_close;
	}
	public void setPNB_close(double pNB_close) {
		PNB_close = pNB_close;
	}
	public double getBANKBARODA_close() {
		return BANKBARODA_close;
	}
	public void setBANKBARODA_close(double bANKBARODA_close) {
		BANKBARODA_close = bANKBARODA_close;
	}
	public double getCANBK_close() {
		return CANBK_close;
	}
	public void setCANBK_close(double cANBK_close) {
		CANBK_close = cANBK_close;
	}
	public double getINDUSINDBK_close() {
		return INDUSINDBK_close;
	}
	public void setINDUSINDBK_close(double iNDUSINDBK_close) {
		INDUSINDBK_close = iNDUSINDBK_close;
	}
	public double getIDFCFIRSTB_close() {
		return IDFCFIRSTB_close;
	}
	public void setIDFCFIRSTB_close(double iDFCFIRSTB_close) {
		IDFCFIRSTB_close = iDFCFIRSTB_close;
	}
	public double getAUBANK_close() {
		return AUBANK_close;
	}
	public void setAUBANK_close(double aUBANK_close) {
		AUBANK_close = aUBANK_close;
	}
	public double getFEDERALBNK_close() {
		return FEDERALBNK_close;
	}
	public void setFEDERALBNK_close(double fEDERALBNK_close) {
		FEDERALBNK_close = fEDERALBNK_close;
	}
	public double getHDFCBANK_dayChange() {
		return HDFCBANK_dayChange;
	}
	public void setHDFCBANK_dayChange(double hDFCBANK_dayChange) {
		HDFCBANK_dayChange = hDFCBANK_dayChange;
	}
	public double getICICIBANK_dayChange() {
		return ICICIBANK_dayChange;
	}
	public void setICICIBANK_dayChange(double iCICIBANK_dayChange) {
		ICICIBANK_dayChange = iCICIBANK_dayChange;
	}
	public double getSBIN_dayChange() {
		return SBIN_dayChange;
	}
	public void setSBIN_dayChange(double sBIN_dayChange) {
		SBIN_dayChange = sBIN_dayChange;
	}
	public double getKOTAKBANK_dayChange() {
		return KOTAKBANK_dayChange;
	}
	public void setKOTAKBANK_dayChange(double kOTAKBANK_dayChange) {
		KOTAKBANK_dayChange = kOTAKBANK_dayChange;
	}
	public double getAXISBANK_dayChange() {
		return AXISBANK_dayChange;
	}
	public void setAXISBANK_dayChange(double aXISBANK_dayChange) {
		AXISBANK_dayChange = aXISBANK_dayChange;
	}
	public double getPNB_dayChange() {
		return PNB_dayChange;
	}
	public void setPNB_dayChange(double pNB_dayChange) {
		PNB_dayChange = pNB_dayChange;
	}
	public double getBANKBARODA_dayChange() {
		return BANKBARODA_dayChange;
	}
	public void setBANKBARODA_dayChange(double bANKBARODA_dayChange) {
		BANKBARODA_dayChange = bANKBARODA_dayChange;
	}
	public double getCANBK_dayChange() {
		return CANBK_dayChange;
	}
	public void setCANBK_dayChange(double cANBK_dayChange) {
		CANBK_dayChange = cANBK_dayChange;
	}
	public double getINDUSINDBK_dayChange() {
		return INDUSINDBK_dayChange;
	}
	public void setINDUSINDBK_dayChange(double iNDUSINDBK_dayChange) {
		INDUSINDBK_dayChange = iNDUSINDBK_dayChange;
	}
	public double getIDFCFIRSTB_dayChange() {
		return IDFCFIRSTB_dayChange;
	}
	public void setIDFCFIRSTB_dayChange(double iDFCFIRSTB_dayChange) {
		IDFCFIRSTB_dayChange = iDFCFIRSTB_dayChange;
	}
	public double getAUBANK_dayChange() {
		return AUBANK_dayChange;
	}
	public void setAUBANK_dayChange(double aUBANK_dayChange) {
		AUBANK_dayChange = aUBANK_dayChange;
	}
	public double getFEDERALBNK_dayChange() {
		return FEDERALBNK_dayChange;
	}
	public void setFEDERALBNK_dayChange(double fEDERALBNK_dayChange) {
		FEDERALBNK_dayChange = fEDERALBNK_dayChange;
	}
	public double getHDFCBANK_dayChangePerc() {
		return HDFCBANK_dayChangePerc;
	}
	public void setHDFCBANK_dayChangePerc(double hDFCBANK_dayChangePerc) {
		HDFCBANK_dayChangePerc = hDFCBANK_dayChangePerc;
	}
	public double getICICIBANK_dayChangePerc() {
		return ICICIBANK_dayChangePerc;
	}
	public void setICICIBANK_dayChangePerc(double iCICIBANK_dayChangePerc) {
		ICICIBANK_dayChangePerc = iCICIBANK_dayChangePerc;
	}
	public double getSBIN_dayChangePerc() {
		return SBIN_dayChangePerc;
	}
	public void setSBIN_dayChangePerc(double sBIN_dayChangePerc) {
		SBIN_dayChangePerc = sBIN_dayChangePerc;
	}
	public double getKOTAKBANK_dayChangePerc() {
		return KOTAKBANK_dayChangePerc;
	}
	public void setKOTAKBANK_dayChangePerc(double kOTAKBANK_dayChangePerc) {
		KOTAKBANK_dayChangePerc = kOTAKBANK_dayChangePerc;
	}
	public double getAXISBANK_dayChangePerc() {
		return AXISBANK_dayChangePerc;
	}
	public void setAXISBANK_dayChangePerc(double aXISBANK_dayChangePerc) {
		AXISBANK_dayChangePerc = aXISBANK_dayChangePerc;
	}
	public double getPNB_dayChangePerc() {
		return PNB_dayChangePerc;
	}
	public void setPNB_dayChangePerc(double pNB_dayChangePerc) {
		PNB_dayChangePerc = pNB_dayChangePerc;
	}
	public double getBANKBARODA_dayChangePerc() {
		return BANKBARODA_dayChangePerc;
	}
	public void setBANKBARODA_dayChangePerc(double bANKBARODA_dayChangePerc) {
		BANKBARODA_dayChangePerc = bANKBARODA_dayChangePerc;
	}
	public double getCANBK_dayChangePerc() {
		return CANBK_dayChangePerc;
	}
	public void setCANBK_dayChangePerc(double cANBK_dayChangePerc) {
		CANBK_dayChangePerc = cANBK_dayChangePerc;
	}
	public double getINDUSINDBK_dayChangePerc() {
		return INDUSINDBK_dayChangePerc;
	}
	public void setINDUSINDBK_dayChangePerc(double iNDUSINDBK_dayChangePerc) {
		INDUSINDBK_dayChangePerc = iNDUSINDBK_dayChangePerc;
	}
	public double getIDFCFIRSTB_dayChangePerc() {
		return IDFCFIRSTB_dayChangePerc;
	}
	public void setIDFCFIRSTB_dayChangePerc(double iDFCFIRSTB_dayChangePerc) {
		IDFCFIRSTB_dayChangePerc = iDFCFIRSTB_dayChangePerc;
	}
	public double getAUBANK_dayChangePerc() {
		return AUBANK_dayChangePerc;
	}
	public void setAUBANK_dayChangePerc(double aUBANK_dayChangePerc) {
		AUBANK_dayChangePerc = aUBANK_dayChangePerc;
	}
	public double getFEDERALBNK_dayChangePerc() {
		return FEDERALBNK_dayChangePerc;
	}
	public void setFEDERALBNK_dayChangePerc(double fEDERALBNK_dayChangePerc) {
		FEDERALBNK_dayChangePerc = fEDERALBNK_dayChangePerc;
	}
	public double getHDFCBANK_high() {
		return HDFCBANK_high;
	}
	public void setHDFCBANK_high(double hDFCBANK_high) {
		HDFCBANK_high = hDFCBANK_high;
	}
	public double getICICIBANK_high() {
		return ICICIBANK_high;
	}
	public void setICICIBANK_high(double iCICIBANK_high) {
		ICICIBANK_high = iCICIBANK_high;
	}
	public double getSBIN_high() {
		return SBIN_high;
	}
	public void setSBIN_high(double sBIN_high) {
		SBIN_high = sBIN_high;
	}
	public double getKOTAKBANK_high() {
		return KOTAKBANK_high;
	}
	public void setKOTAKBANK_high(double kOTAKBANK_high) {
		KOTAKBANK_high = kOTAKBANK_high;
	}
	public double getAXISBANK_high() {
		return AXISBANK_high;
	}
	public void setAXISBANK_high(double aXISBANK_high) {
		AXISBANK_high = aXISBANK_high;
	}
	public double getPNB_high() {
		return PNB_high;
	}
	public void setPNB_high(double pNB_high) {
		PNB_high = pNB_high;
	}
	public double getBANKBARODA_high() {
		return BANKBARODA_high;
	}
	public void setBANKBARODA_high(double bANKBARODA_high) {
		BANKBARODA_high = bANKBARODA_high;
	}
	public double getCANBK_high() {
		return CANBK_high;
	}
	public void setCANBK_high(double cANBK_high) {
		CANBK_high = cANBK_high;
	}
	public double getINDUSINDBK_high() {
		return INDUSINDBK_high;
	}
	public void setINDUSINDBK_high(double iNDUSINDBK_high) {
		INDUSINDBK_high = iNDUSINDBK_high;
	}
	public double getIDFCFIRSTB_high() {
		return IDFCFIRSTB_high;
	}
	public void setIDFCFIRSTB_high(double iDFCFIRSTB_high) {
		IDFCFIRSTB_high = iDFCFIRSTB_high;
	}
	public double getAUBANK_high() {
		return AUBANK_high;
	}
	public void setAUBANK_high(double aUBANK_high) {
		AUBANK_high = aUBANK_high;
	}
	public double getFEDERALBNK_high() {
		return FEDERALBNK_high;
	}
	public void setFEDERALBNK_high(double fEDERALBNK_high) {
		FEDERALBNK_high = fEDERALBNK_high;
	}
	public double getHDFCBANK_highPriceRange() {
		return HDFCBANK_highPriceRange;
	}
	public void setHDFCBANK_highPriceRange(double hDFCBANK_highPriceRange) {
		HDFCBANK_highPriceRange = hDFCBANK_highPriceRange;
	}
	public double getICICIBANK_highPriceRange() {
		return ICICIBANK_highPriceRange;
	}
	public void setICICIBANK_highPriceRange(double iCICIBANK_highPriceRange) {
		ICICIBANK_highPriceRange = iCICIBANK_highPriceRange;
	}
	public double getSBIN_highPriceRange() {
		return SBIN_highPriceRange;
	}
	public void setSBIN_highPriceRange(double sBIN_highPriceRange) {
		SBIN_highPriceRange = sBIN_highPriceRange;
	}
	public double getKOTAKBANK_highPriceRange() {
		return KOTAKBANK_highPriceRange;
	}
	public void setKOTAKBANK_highPriceRange(double kOTAKBANK_highPriceRange) {
		KOTAKBANK_highPriceRange = kOTAKBANK_highPriceRange;
	}
	public double getAXISBANK_highPriceRange() {
		return AXISBANK_highPriceRange;
	}
	public void setAXISBANK_highPriceRange(double aXISBANK_highPriceRange) {
		AXISBANK_highPriceRange = aXISBANK_highPriceRange;
	}
	public double getPNB_highPriceRange() {
		return PNB_highPriceRange;
	}
	public void setPNB_highPriceRange(double pNB_highPriceRange) {
		PNB_highPriceRange = pNB_highPriceRange;
	}
	public double getBANKBARODA_highPriceRange() {
		return BANKBARODA_highPriceRange;
	}
	public void setBANKBARODA_highPriceRange(double bANKBARODA_highPriceRange) {
		BANKBARODA_highPriceRange = bANKBARODA_highPriceRange;
	}
	public double getCANBK_highPriceRange() {
		return CANBK_highPriceRange;
	}
	public void setCANBK_highPriceRange(double cANBK_highPriceRange) {
		CANBK_highPriceRange = cANBK_highPriceRange;
	}
	public double getINDUSINDBK_highPriceRange() {
		return INDUSINDBK_highPriceRange;
	}
	public void setINDUSINDBK_highPriceRange(double iNDUSINDBK_highPriceRange) {
		INDUSINDBK_highPriceRange = iNDUSINDBK_highPriceRange;
	}
	public double getIDFCFIRSTB_highPriceRange() {
		return IDFCFIRSTB_highPriceRange;
	}
	public void setIDFCFIRSTB_highPriceRange(double iDFCFIRSTB_highPriceRange) {
		IDFCFIRSTB_highPriceRange = iDFCFIRSTB_highPriceRange;
	}
	public double getAUBANK_highPriceRange() {
		return AUBANK_highPriceRange;
	}
	public void setAUBANK_highPriceRange(double aUBANK_highPriceRange) {
		AUBANK_highPriceRange = aUBANK_highPriceRange;
	}
	public double getFEDERALBNK_highPriceRange() {
		return FEDERALBNK_highPriceRange;
	}
	public void setFEDERALBNK_highPriceRange(double fEDERALBNK_highPriceRange) {
		FEDERALBNK_highPriceRange = fEDERALBNK_highPriceRange;
	}
	public String getHDFCBANK_highTradeRange() {
		return HDFCBANK_highTradeRange;
	}
	public void setHDFCBANK_highTradeRange(String hDFCBANK_highTradeRange) {
		HDFCBANK_highTradeRange = hDFCBANK_highTradeRange;
	}
	public String getICICIBANK_highTradeRange() {
		return ICICIBANK_highTradeRange;
	}
	public void setICICIBANK_highTradeRange(String iCICIBANK_highTradeRange) {
		ICICIBANK_highTradeRange = iCICIBANK_highTradeRange;
	}
	public String getSBIN_highTradeRange() {
		return SBIN_highTradeRange;
	}
	public void setSBIN_highTradeRange(String sBIN_highTradeRange) {
		SBIN_highTradeRange = sBIN_highTradeRange;
	}
	public String getKOTAKBANK_highTradeRange() {
		return KOTAKBANK_highTradeRange;
	}
	public void setKOTAKBANK_highTradeRange(String kOTAKBANK_highTradeRange) {
		KOTAKBANK_highTradeRange = kOTAKBANK_highTradeRange;
	}
	public String getAXISBANK_highTradeRange() {
		return AXISBANK_highTradeRange;
	}
	public void setAXISBANK_highTradeRange(String aXISBANK_highTradeRange) {
		AXISBANK_highTradeRange = aXISBANK_highTradeRange;
	}
	public String getPNB_highTradeRange() {
		return PNB_highTradeRange;
	}
	public void setPNB_highTradeRange(String pNB_highTradeRange) {
		PNB_highTradeRange = pNB_highTradeRange;
	}
	public String getBANKBARODA_highTradeRange() {
		return BANKBARODA_highTradeRange;
	}
	public void setBANKBARODA_highTradeRange(String bANKBARODA_highTradeRange) {
		BANKBARODA_highTradeRange = bANKBARODA_highTradeRange;
	}
	public String getCANBK_highTradeRange() {
		return CANBK_highTradeRange;
	}
	public void setCANBK_highTradeRange(String cANBK_highTradeRange) {
		CANBK_highTradeRange = cANBK_highTradeRange;
	}
	public String getINDUSINDBK_highTradeRange() {
		return INDUSINDBK_highTradeRange;
	}
	public void setINDUSINDBK_highTradeRange(String iNDUSINDBK_highTradeRange) {
		INDUSINDBK_highTradeRange = iNDUSINDBK_highTradeRange;
	}
	public String getIDFCFIRSTB_highTradeRange() {
		return IDFCFIRSTB_highTradeRange;
	}
	public void setIDFCFIRSTB_highTradeRange(String iDFCFIRSTB_highTradeRange) {
		IDFCFIRSTB_highTradeRange = iDFCFIRSTB_highTradeRange;
	}
	public String getAUBANK_highTradeRange() {
		return AUBANK_highTradeRange;
	}
	public void setAUBANK_highTradeRange(String aUBANK_highTradeRange) {
		AUBANK_highTradeRange = aUBANK_highTradeRange;
	}
	public String getFEDERALBNK_highTradeRange() {
		return FEDERALBNK_highTradeRange;
	}
	public void setFEDERALBNK_highTradeRange(String fEDERALBNK_highTradeRange) {
		FEDERALBNK_highTradeRange = fEDERALBNK_highTradeRange;
	}
	public int getHDFCBANK_lastTradeQty() {
		return HDFCBANK_lastTradeQty;
	}
	public void setHDFCBANK_lastTradeQty(int hDFCBANK_lastTradeQty) {
		HDFCBANK_lastTradeQty = hDFCBANK_lastTradeQty;
	}
	public int getICICIBANK_lastTradeQty() {
		return ICICIBANK_lastTradeQty;
	}
	public void setICICIBANK_lastTradeQty(int iCICIBANK_lastTradeQty) {
		ICICIBANK_lastTradeQty = iCICIBANK_lastTradeQty;
	}
	public int getSBIN_lastTradeQty() {
		return SBIN_lastTradeQty;
	}
	public void setSBIN_lastTradeQty(int sBIN_lastTradeQty) {
		SBIN_lastTradeQty = sBIN_lastTradeQty;
	}
	public int getKOTAKBANK_lastTradeQty() {
		return KOTAKBANK_lastTradeQty;
	}
	public void setKOTAKBANK_lastTradeQty(int kOTAKBANK_lastTradeQty) {
		KOTAKBANK_lastTradeQty = kOTAKBANK_lastTradeQty;
	}
	public int getAXISBANK_lastTradeQty() {
		return AXISBANK_lastTradeQty;
	}
	public void setAXISBANK_lastTradeQty(int aXISBANK_lastTradeQty) {
		AXISBANK_lastTradeQty = aXISBANK_lastTradeQty;
	}
	public int getPNB_lastTradeQty() {
		return PNB_lastTradeQty;
	}
	public void setPNB_lastTradeQty(int pNB_lastTradeQty) {
		PNB_lastTradeQty = pNB_lastTradeQty;
	}
	public int getBANKBARODA_lastTradeQty() {
		return BANKBARODA_lastTradeQty;
	}
	public void setBANKBARODA_lastTradeQty(int bANKBARODA_lastTradeQty) {
		BANKBARODA_lastTradeQty = bANKBARODA_lastTradeQty;
	}
	public int getCANBK_lastTradeQty() {
		return CANBK_lastTradeQty;
	}
	public void setCANBK_lastTradeQty(int cANBK_lastTradeQty) {
		CANBK_lastTradeQty = cANBK_lastTradeQty;
	}
	public int getINDUSINDBK_lastTradeQty() {
		return INDUSINDBK_lastTradeQty;
	}
	public void setINDUSINDBK_lastTradeQty(int iNDUSINDBK_lastTradeQty) {
		INDUSINDBK_lastTradeQty = iNDUSINDBK_lastTradeQty;
	}
	public int getIDFCFIRSTB_lastTradeQty() {
		return IDFCFIRSTB_lastTradeQty;
	}
	public void setIDFCFIRSTB_lastTradeQty(int iDFCFIRSTB_lastTradeQty) {
		IDFCFIRSTB_lastTradeQty = iDFCFIRSTB_lastTradeQty;
	}
	public int getAUBANK_lastTradeQty() {
		return AUBANK_lastTradeQty;
	}
	public void setAUBANK_lastTradeQty(int aUBANK_lastTradeQty) {
		AUBANK_lastTradeQty = aUBANK_lastTradeQty;
	}
	public int getFEDERALBNK_lastTradeQty() {
		return FEDERALBNK_lastTradeQty;
	}
	public void setFEDERALBNK_lastTradeQty(int fEDERALBNK_lastTradeQty) {
		FEDERALBNK_lastTradeQty = fEDERALBNK_lastTradeQty;
	}
	public long getHDFCBANK_lastTradeTime() {
		return HDFCBANK_lastTradeTime;
	}
	public void setHDFCBANK_lastTradeTime(long hDFCBANK_lastTradeTime) {
		HDFCBANK_lastTradeTime = hDFCBANK_lastTradeTime;
	}
	public long getICICIBANK_lastTradeTime() {
		return ICICIBANK_lastTradeTime;
	}
	public void setICICIBANK_lastTradeTime(long iCICIBANK_lastTradeTime) {
		ICICIBANK_lastTradeTime = iCICIBANK_lastTradeTime;
	}
	public long getSBIN_lastTradeTime() {
		return SBIN_lastTradeTime;
	}
	public void setSBIN_lastTradeTime(long sBIN_lastTradeTime) {
		SBIN_lastTradeTime = sBIN_lastTradeTime;
	}
	public long getKOTAKBANK_lastTradeTime() {
		return KOTAKBANK_lastTradeTime;
	}
	public void setKOTAKBANK_lastTradeTime(long kOTAKBANK_lastTradeTime) {
		KOTAKBANK_lastTradeTime = kOTAKBANK_lastTradeTime;
	}
	public long getAXISBANK_lastTradeTime() {
		return AXISBANK_lastTradeTime;
	}
	public void setAXISBANK_lastTradeTime(long aXISBANK_lastTradeTime) {
		AXISBANK_lastTradeTime = aXISBANK_lastTradeTime;
	}
	public long getPNB_lastTradeTime() {
		return PNB_lastTradeTime;
	}
	public void setPNB_lastTradeTime(long pNB_lastTradeTime) {
		PNB_lastTradeTime = pNB_lastTradeTime;
	}
	public long getBANKBARODA_lastTradeTime() {
		return BANKBARODA_lastTradeTime;
	}
	public void setBANKBARODA_lastTradeTime(long bANKBARODA_lastTradeTime) {
		BANKBARODA_lastTradeTime = bANKBARODA_lastTradeTime;
	}
	public long getCANBK_lastTradeTime() {
		return CANBK_lastTradeTime;
	}
	public void setCANBK_lastTradeTime(long cANBK_lastTradeTime) {
		CANBK_lastTradeTime = cANBK_lastTradeTime;
	}
	public long getINDUSINDBK_lastTradeTime() {
		return INDUSINDBK_lastTradeTime;
	}
	public void setINDUSINDBK_lastTradeTime(long iNDUSINDBK_lastTradeTime) {
		INDUSINDBK_lastTradeTime = iNDUSINDBK_lastTradeTime;
	}
	public long getIDFCFIRSTB_lastTradeTime() {
		return IDFCFIRSTB_lastTradeTime;
	}
	public void setIDFCFIRSTB_lastTradeTime(long iDFCFIRSTB_lastTradeTime) {
		IDFCFIRSTB_lastTradeTime = iDFCFIRSTB_lastTradeTime;
	}
	public long getAUBANK_lastTradeTime() {
		return AUBANK_lastTradeTime;
	}
	public void setAUBANK_lastTradeTime(long aUBANK_lastTradeTime) {
		AUBANK_lastTradeTime = aUBANK_lastTradeTime;
	}
	public long getFEDERALBNK_lastTradeTime() {
		return FEDERALBNK_lastTradeTime;
	}
	public void setFEDERALBNK_lastTradeTime(long fEDERALBNK_lastTradeTime) {
		FEDERALBNK_lastTradeTime = fEDERALBNK_lastTradeTime;
	}
	public double getHDFCBANK_low() {
		return HDFCBANK_low;
	}
	public void setHDFCBANK_low(double hDFCBANK_low) {
		HDFCBANK_low = hDFCBANK_low;
	}
	public double getICICIBANK_low() {
		return ICICIBANK_low;
	}
	public void setICICIBANK_low(double iCICIBANK_low) {
		ICICIBANK_low = iCICIBANK_low;
	}
	public double getSBIN_low() {
		return SBIN_low;
	}
	public void setSBIN_low(double sBIN_low) {
		SBIN_low = sBIN_low;
	}
	public double getKOTAKBANK_low() {
		return KOTAKBANK_low;
	}
	public void setKOTAKBANK_low(double kOTAKBANK_low) {
		KOTAKBANK_low = kOTAKBANK_low;
	}
	public double getAXISBANK_low() {
		return AXISBANK_low;
	}
	public void setAXISBANK_low(double aXISBANK_low) {
		AXISBANK_low = aXISBANK_low;
	}
	public double getPNB_low() {
		return PNB_low;
	}
	public void setPNB_low(double pNB_low) {
		PNB_low = pNB_low;
	}
	public double getBANKBARODA_low() {
		return BANKBARODA_low;
	}
	public void setBANKBARODA_low(double bANKBARODA_low) {
		BANKBARODA_low = bANKBARODA_low;
	}
	public double getCANBK_low() {
		return CANBK_low;
	}
	public void setCANBK_low(double cANBK_low) {
		CANBK_low = cANBK_low;
	}
	public double getINDUSINDBK_low() {
		return INDUSINDBK_low;
	}
	public void setINDUSINDBK_low(double iNDUSINDBK_low) {
		INDUSINDBK_low = iNDUSINDBK_low;
	}
	public double getIDFCFIRSTB_low() {
		return IDFCFIRSTB_low;
	}
	public void setIDFCFIRSTB_low(double iDFCFIRSTB_low) {
		IDFCFIRSTB_low = iDFCFIRSTB_low;
	}
	public double getAUBANK_low() {
		return AUBANK_low;
	}
	public void setAUBANK_low(double aUBANK_low) {
		AUBANK_low = aUBANK_low;
	}
	public double getFEDERALBNK_low() {
		return FEDERALBNK_low;
	}
	public void setFEDERALBNK_low(double fEDERALBNK_low) {
		FEDERALBNK_low = fEDERALBNK_low;
	}
	public double getHDFCBANK_lowPriceRange() {
		return HDFCBANK_lowPriceRange;
	}
	public void setHDFCBANK_lowPriceRange(double hDFCBANK_lowPriceRange) {
		HDFCBANK_lowPriceRange = hDFCBANK_lowPriceRange;
	}
	public double getICICIBANK_lowPriceRange() {
		return ICICIBANK_lowPriceRange;
	}
	public void setICICIBANK_lowPriceRange(double iCICIBANK_lowPriceRange) {
		ICICIBANK_lowPriceRange = iCICIBANK_lowPriceRange;
	}
	public double getSBIN_lowPriceRange() {
		return SBIN_lowPriceRange;
	}
	public void setSBIN_lowPriceRange(double sBIN_lowPriceRange) {
		SBIN_lowPriceRange = sBIN_lowPriceRange;
	}
	public double getKOTAKBANK_lowPriceRange() {
		return KOTAKBANK_lowPriceRange;
	}
	public void setKOTAKBANK_lowPriceRange(double kOTAKBANK_lowPriceRange) {
		KOTAKBANK_lowPriceRange = kOTAKBANK_lowPriceRange;
	}
	public double getAXISBANK_lowPriceRange() {
		return AXISBANK_lowPriceRange;
	}
	public void setAXISBANK_lowPriceRange(double aXISBANK_lowPriceRange) {
		AXISBANK_lowPriceRange = aXISBANK_lowPriceRange;
	}
	public double getPNB_lowPriceRange() {
		return PNB_lowPriceRange;
	}
	public void setPNB_lowPriceRange(double pNB_lowPriceRange) {
		PNB_lowPriceRange = pNB_lowPriceRange;
	}
	public double getBANKBARODA_lowPriceRange() {
		return BANKBARODA_lowPriceRange;
	}
	public void setBANKBARODA_lowPriceRange(double bANKBARODA_lowPriceRange) {
		BANKBARODA_lowPriceRange = bANKBARODA_lowPriceRange;
	}
	public double getCANBK_lowPriceRange() {
		return CANBK_lowPriceRange;
	}
	public void setCANBK_lowPriceRange(double cANBK_lowPriceRange) {
		CANBK_lowPriceRange = cANBK_lowPriceRange;
	}
	public double getINDUSINDBK_lowPriceRange() {
		return INDUSINDBK_lowPriceRange;
	}
	public void setINDUSINDBK_lowPriceRange(double iNDUSINDBK_lowPriceRange) {
		INDUSINDBK_lowPriceRange = iNDUSINDBK_lowPriceRange;
	}
	public double getIDFCFIRSTB_lowPriceRange() {
		return IDFCFIRSTB_lowPriceRange;
	}
	public void setIDFCFIRSTB_lowPriceRange(double iDFCFIRSTB_lowPriceRange) {
		IDFCFIRSTB_lowPriceRange = iDFCFIRSTB_lowPriceRange;
	}
	public double getAUBANK_lowPriceRange() {
		return AUBANK_lowPriceRange;
	}
	public void setAUBANK_lowPriceRange(double aUBANK_lowPriceRange) {
		AUBANK_lowPriceRange = aUBANK_lowPriceRange;
	}
	public double getFEDERALBNK_lowPriceRange() {
		return FEDERALBNK_lowPriceRange;
	}
	public void setFEDERALBNK_lowPriceRange(double fEDERALBNK_lowPriceRange) {
		FEDERALBNK_lowPriceRange = fEDERALBNK_lowPriceRange;
	}
	public String getHDFCBANK_lowTradeRange() {
		return HDFCBANK_lowTradeRange;
	}
	public void setHDFCBANK_lowTradeRange(String hDFCBANK_lowTradeRange) {
		HDFCBANK_lowTradeRange = hDFCBANK_lowTradeRange;
	}
	public String getICICIBANK_lowTradeRange() {
		return ICICIBANK_lowTradeRange;
	}
	public void setICICIBANK_lowTradeRange(String iCICIBANK_lowTradeRange) {
		ICICIBANK_lowTradeRange = iCICIBANK_lowTradeRange;
	}
	public String getSBIN_lowTradeRange() {
		return SBIN_lowTradeRange;
	}
	public void setSBIN_lowTradeRange(String sBIN_lowTradeRange) {
		SBIN_lowTradeRange = sBIN_lowTradeRange;
	}
	public String getKOTAKBANK_lowTradeRange() {
		return KOTAKBANK_lowTradeRange;
	}
	public void setKOTAKBANK_lowTradeRange(String kOTAKBANK_lowTradeRange) {
		KOTAKBANK_lowTradeRange = kOTAKBANK_lowTradeRange;
	}
	public String getAXISBANK_lowTradeRange() {
		return AXISBANK_lowTradeRange;
	}
	public void setAXISBANK_lowTradeRange(String aXISBANK_lowTradeRange) {
		AXISBANK_lowTradeRange = aXISBANK_lowTradeRange;
	}
	public String getPNB_lowTradeRange() {
		return PNB_lowTradeRange;
	}
	public void setPNB_lowTradeRange(String pNB_lowTradeRange) {
		PNB_lowTradeRange = pNB_lowTradeRange;
	}
	public String getBANKBARODA_lowTradeRange() {
		return BANKBARODA_lowTradeRange;
	}
	public void setBANKBARODA_lowTradeRange(String bANKBARODA_lowTradeRange) {
		BANKBARODA_lowTradeRange = bANKBARODA_lowTradeRange;
	}
	public String getCANBK_lowTradeRange() {
		return CANBK_lowTradeRange;
	}
	public void setCANBK_lowTradeRange(String cANBK_lowTradeRange) {
		CANBK_lowTradeRange = cANBK_lowTradeRange;
	}
	public String getINDUSINDBK_lowTradeRange() {
		return INDUSINDBK_lowTradeRange;
	}
	public void setINDUSINDBK_lowTradeRange(String iNDUSINDBK_lowTradeRange) {
		INDUSINDBK_lowTradeRange = iNDUSINDBK_lowTradeRange;
	}
	public String getIDFCFIRSTB_lowTradeRange() {
		return IDFCFIRSTB_lowTradeRange;
	}
	public void setIDFCFIRSTB_lowTradeRange(String iDFCFIRSTB_lowTradeRange) {
		IDFCFIRSTB_lowTradeRange = iDFCFIRSTB_lowTradeRange;
	}
	public String getAUBANK_lowTradeRange() {
		return AUBANK_lowTradeRange;
	}
	public void setAUBANK_lowTradeRange(String aUBANK_lowTradeRange) {
		AUBANK_lowTradeRange = aUBANK_lowTradeRange;
	}
	public String getFEDERALBNK_lowTradeRange() {
		return FEDERALBNK_lowTradeRange;
	}
	public void setFEDERALBNK_lowTradeRange(String fEDERALBNK_lowTradeRange) {
		FEDERALBNK_lowTradeRange = fEDERALBNK_lowTradeRange;
	}
	public double getHDFCBANK_ltp() {
		return HDFCBANK_ltp;
	}
	public void setHDFCBANK_ltp(double hDFCBANK_ltp) {
		HDFCBANK_ltp = hDFCBANK_ltp;
	}
	public double getICICIBANK_ltp() {
		return ICICIBANK_ltp;
	}
	public void setICICIBANK_ltp(double iCICIBANK_ltp) {
		ICICIBANK_ltp = iCICIBANK_ltp;
	}
	public double getSBIN_ltp() {
		return SBIN_ltp;
	}
	public void setSBIN_ltp(double sBIN_ltp) {
		SBIN_ltp = sBIN_ltp;
	}
	public double getKOTAKBANK_ltp() {
		return KOTAKBANK_ltp;
	}
	public void setKOTAKBANK_ltp(double kOTAKBANK_ltp) {
		KOTAKBANK_ltp = kOTAKBANK_ltp;
	}
	public double getAXISBANK_ltp() {
		return AXISBANK_ltp;
	}
	public void setAXISBANK_ltp(double aXISBANK_ltp) {
		AXISBANK_ltp = aXISBANK_ltp;
	}
	public double getPNB_ltp() {
		return PNB_ltp;
	}
	public void setPNB_ltp(double pNB_ltp) {
		PNB_ltp = pNB_ltp;
	}
	public double getBANKBARODA_ltp() {
		return BANKBARODA_ltp;
	}
	public void setBANKBARODA_ltp(double bANKBARODA_ltp) {
		BANKBARODA_ltp = bANKBARODA_ltp;
	}
	public double getCANBK_ltp() {
		return CANBK_ltp;
	}
	public void setCANBK_ltp(double cANBK_ltp) {
		CANBK_ltp = cANBK_ltp;
	}
	public double getINDUSINDBK_ltp() {
		return INDUSINDBK_ltp;
	}
	public void setINDUSINDBK_ltp(double iNDUSINDBK_ltp) {
		INDUSINDBK_ltp = iNDUSINDBK_ltp;
	}
	public double getIDFCFIRSTB_ltp() {
		return IDFCFIRSTB_ltp;
	}
	public void setIDFCFIRSTB_ltp(double iDFCFIRSTB_ltp) {
		IDFCFIRSTB_ltp = iDFCFIRSTB_ltp;
	}
	public double getAUBANK_ltp() {
		return AUBANK_ltp;
	}
	public void setAUBANK_ltp(double aUBANK_ltp) {
		AUBANK_ltp = aUBANK_ltp;
	}
	public double getFEDERALBNK_ltp() {
		return FEDERALBNK_ltp;
	}
	public void setFEDERALBNK_ltp(double fEDERALBNK_ltp) {
		FEDERALBNK_ltp = fEDERALBNK_ltp;
	}
	public double getHDFCBANK_oiDayChange() {
		return HDFCBANK_oiDayChange;
	}
	public void setHDFCBANK_oiDayChange(double hDFCBANK_oiDayChange) {
		HDFCBANK_oiDayChange = hDFCBANK_oiDayChange;
	}
	public double getICICIBANK_oiDayChange() {
		return ICICIBANK_oiDayChange;
	}
	public void setICICIBANK_oiDayChange(double iCICIBANK_oiDayChange) {
		ICICIBANK_oiDayChange = iCICIBANK_oiDayChange;
	}
	public double getSBIN_oiDayChange() {
		return SBIN_oiDayChange;
	}
	public void setSBIN_oiDayChange(double sBIN_oiDayChange) {
		SBIN_oiDayChange = sBIN_oiDayChange;
	}
	public double getKOTAKBANK_oiDayChange() {
		return KOTAKBANK_oiDayChange;
	}
	public void setKOTAKBANK_oiDayChange(double kOTAKBANK_oiDayChange) {
		KOTAKBANK_oiDayChange = kOTAKBANK_oiDayChange;
	}
	public double getAXISBANK_oiDayChange() {
		return AXISBANK_oiDayChange;
	}
	public void setAXISBANK_oiDayChange(double aXISBANK_oiDayChange) {
		AXISBANK_oiDayChange = aXISBANK_oiDayChange;
	}
	public double getPNB_oiDayChange() {
		return PNB_oiDayChange;
	}
	public void setPNB_oiDayChange(double pNB_oiDayChange) {
		PNB_oiDayChange = pNB_oiDayChange;
	}
	public double getBANKBARODA_oiDayChange() {
		return BANKBARODA_oiDayChange;
	}
	public void setBANKBARODA_oiDayChange(double bANKBARODA_oiDayChange) {
		BANKBARODA_oiDayChange = bANKBARODA_oiDayChange;
	}
	public double getCANBK_oiDayChange() {
		return CANBK_oiDayChange;
	}
	public void setCANBK_oiDayChange(double cANBK_oiDayChange) {
		CANBK_oiDayChange = cANBK_oiDayChange;
	}
	public double getINDUSINDBK_oiDayChange() {
		return INDUSINDBK_oiDayChange;
	}
	public void setINDUSINDBK_oiDayChange(double iNDUSINDBK_oiDayChange) {
		INDUSINDBK_oiDayChange = iNDUSINDBK_oiDayChange;
	}
	public double getIDFCFIRSTB_oiDayChange() {
		return IDFCFIRSTB_oiDayChange;
	}
	public void setIDFCFIRSTB_oiDayChange(double iDFCFIRSTB_oiDayChange) {
		IDFCFIRSTB_oiDayChange = iDFCFIRSTB_oiDayChange;
	}
	public double getAUBANK_oiDayChange() {
		return AUBANK_oiDayChange;
	}
	public void setAUBANK_oiDayChange(double aUBANK_oiDayChange) {
		AUBANK_oiDayChange = aUBANK_oiDayChange;
	}
	public double getFEDERALBNK_oiDayChange() {
		return FEDERALBNK_oiDayChange;
	}
	public void setFEDERALBNK_oiDayChange(double fEDERALBNK_oiDayChange) {
		FEDERALBNK_oiDayChange = fEDERALBNK_oiDayChange;
	}
	public double getHDFCBANK_oiDayChangePerc() {
		return HDFCBANK_oiDayChangePerc;
	}
	public void setHDFCBANK_oiDayChangePerc(double hDFCBANK_oiDayChangePerc) {
		HDFCBANK_oiDayChangePerc = hDFCBANK_oiDayChangePerc;
	}
	public double getICICIBANK_oiDayChangePerc() {
		return ICICIBANK_oiDayChangePerc;
	}
	public void setICICIBANK_oiDayChangePerc(double iCICIBANK_oiDayChangePerc) {
		ICICIBANK_oiDayChangePerc = iCICIBANK_oiDayChangePerc;
	}
	public double getSBIN_oiDayChangePerc() {
		return SBIN_oiDayChangePerc;
	}
	public void setSBIN_oiDayChangePerc(double sBIN_oiDayChangePerc) {
		SBIN_oiDayChangePerc = sBIN_oiDayChangePerc;
	}
	public double getKOTAKBANK_oiDayChangePerc() {
		return KOTAKBANK_oiDayChangePerc;
	}
	public void setKOTAKBANK_oiDayChangePerc(double kOTAKBANK_oiDayChangePerc) {
		KOTAKBANK_oiDayChangePerc = kOTAKBANK_oiDayChangePerc;
	}
	public double getAXISBANK_oiDayChangePerc() {
		return AXISBANK_oiDayChangePerc;
	}
	public void setAXISBANK_oiDayChangePerc(double aXISBANK_oiDayChangePerc) {
		AXISBANK_oiDayChangePerc = aXISBANK_oiDayChangePerc;
	}
	public double getPNB_oiDayChangePerc() {
		return PNB_oiDayChangePerc;
	}
	public void setPNB_oiDayChangePerc(double pNB_oiDayChangePerc) {
		PNB_oiDayChangePerc = pNB_oiDayChangePerc;
	}
	public double getBANKBARODA_oiDayChangePerc() {
		return BANKBARODA_oiDayChangePerc;
	}
	public void setBANKBARODA_oiDayChangePerc(double bANKBARODA_oiDayChangePerc) {
		BANKBARODA_oiDayChangePerc = bANKBARODA_oiDayChangePerc;
	}
	public double getCANBK_oiDayChangePerc() {
		return CANBK_oiDayChangePerc;
	}
	public void setCANBK_oiDayChangePerc(double cANBK_oiDayChangePerc) {
		CANBK_oiDayChangePerc = cANBK_oiDayChangePerc;
	}
	public double getINDUSINDBK_oiDayChangePerc() {
		return INDUSINDBK_oiDayChangePerc;
	}
	public void setINDUSINDBK_oiDayChangePerc(double iNDUSINDBK_oiDayChangePerc) {
		INDUSINDBK_oiDayChangePerc = iNDUSINDBK_oiDayChangePerc;
	}
	public double getIDFCFIRSTB_oiDayChangePerc() {
		return IDFCFIRSTB_oiDayChangePerc;
	}
	public void setIDFCFIRSTB_oiDayChangePerc(double iDFCFIRSTB_oiDayChangePerc) {
		IDFCFIRSTB_oiDayChangePerc = iDFCFIRSTB_oiDayChangePerc;
	}
	public double getAUBANK_oiDayChangePerc() {
		return AUBANK_oiDayChangePerc;
	}
	public void setAUBANK_oiDayChangePerc(double aUBANK_oiDayChangePerc) {
		AUBANK_oiDayChangePerc = aUBANK_oiDayChangePerc;
	}
	public double getFEDERALBNK_oiDayChangePerc() {
		return FEDERALBNK_oiDayChangePerc;
	}
	public void setFEDERALBNK_oiDayChangePerc(double fEDERALBNK_oiDayChangePerc) {
		FEDERALBNK_oiDayChangePerc = fEDERALBNK_oiDayChangePerc;
	}
	public double getHDFCBANK_open() {
		return HDFCBANK_open;
	}
	public void setHDFCBANK_open(double hDFCBANK_open) {
		HDFCBANK_open = hDFCBANK_open;
	}
	public double getICICIBANK_open() {
		return ICICIBANK_open;
	}
	public void setICICIBANK_open(double iCICIBANK_open) {
		ICICIBANK_open = iCICIBANK_open;
	}
	public double getSBIN_open() {
		return SBIN_open;
	}
	public void setSBIN_open(double sBIN_open) {
		SBIN_open = sBIN_open;
	}
	public double getKOTAKBANK_open() {
		return KOTAKBANK_open;
	}
	public void setKOTAKBANK_open(double kOTAKBANK_open) {
		KOTAKBANK_open = kOTAKBANK_open;
	}
	public double getAXISBANK_open() {
		return AXISBANK_open;
	}
	public void setAXISBANK_open(double aXISBANK_open) {
		AXISBANK_open = aXISBANK_open;
	}
	public double getPNB_open() {
		return PNB_open;
	}
	public void setPNB_open(double pNB_open) {
		PNB_open = pNB_open;
	}
	public double getBANKBARODA_open() {
		return BANKBARODA_open;
	}
	public void setBANKBARODA_open(double bANKBARODA_open) {
		BANKBARODA_open = bANKBARODA_open;
	}
	public double getCANBK_open() {
		return CANBK_open;
	}
	public void setCANBK_open(double cANBK_open) {
		CANBK_open = cANBK_open;
	}
	public double getINDUSINDBK_open() {
		return INDUSINDBK_open;
	}
	public void setINDUSINDBK_open(double iNDUSINDBK_open) {
		INDUSINDBK_open = iNDUSINDBK_open;
	}
	public double getIDFCFIRSTB_open() {
		return IDFCFIRSTB_open;
	}
	public void setIDFCFIRSTB_open(double iDFCFIRSTB_open) {
		IDFCFIRSTB_open = iDFCFIRSTB_open;
	}
	public double getAUBANK_open() {
		return AUBANK_open;
	}
	public void setAUBANK_open(double aUBANK_open) {
		AUBANK_open = aUBANK_open;
	}
	public double getFEDERALBNK_open() {
		return FEDERALBNK_open;
	}
	public void setFEDERALBNK_open(double fEDERALBNK_open) {
		FEDERALBNK_open = fEDERALBNK_open;
	}
	public String getHDFCBANK_openInterest() {
		return HDFCBANK_openInterest;
	}
	public void setHDFCBANK_openInterest(String hDFCBANK_openInterest) {
		HDFCBANK_openInterest = hDFCBANK_openInterest;
	}
	public String getICICIBANK_openInterest() {
		return ICICIBANK_openInterest;
	}
	public void setICICIBANK_openInterest(String iCICIBANK_openInterest) {
		ICICIBANK_openInterest = iCICIBANK_openInterest;
	}
	public String getSBIN_openInterest() {
		return SBIN_openInterest;
	}
	public void setSBIN_openInterest(String sBIN_openInterest) {
		SBIN_openInterest = sBIN_openInterest;
	}
	public String getKOTAKBANK_openInterest() {
		return KOTAKBANK_openInterest;
	}
	public void setKOTAKBANK_openInterest(String kOTAKBANK_openInterest) {
		KOTAKBANK_openInterest = kOTAKBANK_openInterest;
	}
	public String getAXISBANK_openInterest() {
		return AXISBANK_openInterest;
	}
	public void setAXISBANK_openInterest(String aXISBANK_openInterest) {
		AXISBANK_openInterest = aXISBANK_openInterest;
	}
	public String getPNB_openInterest() {
		return PNB_openInterest;
	}
	public void setPNB_openInterest(String pNB_openInterest) {
		PNB_openInterest = pNB_openInterest;
	}
	public String getBANKBARODA_openInterest() {
		return BANKBARODA_openInterest;
	}
	public void setBANKBARODA_openInterest(String bANKBARODA_openInterest) {
		BANKBARODA_openInterest = bANKBARODA_openInterest;
	}
	public String getCANBK_openInterest() {
		return CANBK_openInterest;
	}
	public void setCANBK_openInterest(String cANBK_openInterest) {
		CANBK_openInterest = cANBK_openInterest;
	}
	public String getINDUSINDBK_openInterest() {
		return INDUSINDBK_openInterest;
	}
	public void setINDUSINDBK_openInterest(String iNDUSINDBK_openInterest) {
		INDUSINDBK_openInterest = iNDUSINDBK_openInterest;
	}
	public String getIDFCFIRSTB_openInterest() {
		return IDFCFIRSTB_openInterest;
	}
	public void setIDFCFIRSTB_openInterest(String iDFCFIRSTB_openInterest) {
		IDFCFIRSTB_openInterest = iDFCFIRSTB_openInterest;
	}
	public String getAUBANK_openInterest() {
		return AUBANK_openInterest;
	}
	public void setAUBANK_openInterest(String aUBANK_openInterest) {
		AUBANK_openInterest = aUBANK_openInterest;
	}
	public String getFEDERALBNK_openInterest() {
		return FEDERALBNK_openInterest;
	}
	public void setFEDERALBNK_openInterest(String fEDERALBNK_openInterest) {
		FEDERALBNK_openInterest = fEDERALBNK_openInterest;
	}
	public String getHDFCBANK_prevOpenInterest() {
		return HDFCBANK_prevOpenInterest;
	}
	public void setHDFCBANK_prevOpenInterest(String hDFCBANK_prevOpenInterest) {
		HDFCBANK_prevOpenInterest = hDFCBANK_prevOpenInterest;
	}
	public String getICICIBANK_prevOpenInterest() {
		return ICICIBANK_prevOpenInterest;
	}
	public void setICICIBANK_prevOpenInterest(String iCICIBANK_prevOpenInterest) {
		ICICIBANK_prevOpenInterest = iCICIBANK_prevOpenInterest;
	}
	public String getSBIN_prevOpenInterest() {
		return SBIN_prevOpenInterest;
	}
	public void setSBIN_prevOpenInterest(String sBIN_prevOpenInterest) {
		SBIN_prevOpenInterest = sBIN_prevOpenInterest;
	}
	public String getKOTAKBANK_prevOpenInterest() {
		return KOTAKBANK_prevOpenInterest;
	}
	public void setKOTAKBANK_prevOpenInterest(String kOTAKBANK_prevOpenInterest) {
		KOTAKBANK_prevOpenInterest = kOTAKBANK_prevOpenInterest;
	}
	public String getAXISBANK_prevOpenInterest() {
		return AXISBANK_prevOpenInterest;
	}
	public void setAXISBANK_prevOpenInterest(String aXISBANK_prevOpenInterest) {
		AXISBANK_prevOpenInterest = aXISBANK_prevOpenInterest;
	}
	public String getPNB_prevOpenInterest() {
		return PNB_prevOpenInterest;
	}
	public void setPNB_prevOpenInterest(String pNB_prevOpenInterest) {
		PNB_prevOpenInterest = pNB_prevOpenInterest;
	}
	public String getBANKBARODA_prevOpenInterest() {
		return BANKBARODA_prevOpenInterest;
	}
	public void setBANKBARODA_prevOpenInterest(String bANKBARODA_prevOpenInterest) {
		BANKBARODA_prevOpenInterest = bANKBARODA_prevOpenInterest;
	}
	public String getCANBK_prevOpenInterest() {
		return CANBK_prevOpenInterest;
	}
	public void setCANBK_prevOpenInterest(String cANBK_prevOpenInterest) {
		CANBK_prevOpenInterest = cANBK_prevOpenInterest;
	}
	public String getINDUSINDBK_prevOpenInterest() {
		return INDUSINDBK_prevOpenInterest;
	}
	public void setINDUSINDBK_prevOpenInterest(String iNDUSINDBK_prevOpenInterest) {
		INDUSINDBK_prevOpenInterest = iNDUSINDBK_prevOpenInterest;
	}
	public String getIDFCFIRSTB_prevOpenInterest() {
		return IDFCFIRSTB_prevOpenInterest;
	}
	public void setIDFCFIRSTB_prevOpenInterest(String iDFCFIRSTB_prevOpenInterest) {
		IDFCFIRSTB_prevOpenInterest = iDFCFIRSTB_prevOpenInterest;
	}
	public String getAUBANK_prevOpenInterest() {
		return AUBANK_prevOpenInterest;
	}
	public void setAUBANK_prevOpenInterest(String aUBANK_prevOpenInterest) {
		AUBANK_prevOpenInterest = aUBANK_prevOpenInterest;
	}
	public String getFEDERALBNK_prevOpenInterest() {
		return FEDERALBNK_prevOpenInterest;
	}
	public void setFEDERALBNK_prevOpenInterest(String fEDERALBNK_prevOpenInterest) {
		FEDERALBNK_prevOpenInterest = fEDERALBNK_prevOpenInterest;
	}
	public String getHDFCBANK_symbol() {
		return HDFCBANK_symbol;
	}
	public void setHDFCBANK_symbol(String hDFCBANK_symbol) {
		HDFCBANK_symbol = hDFCBANK_symbol;
	}
	public String getICICIBANK_symbol() {
		return ICICIBANK_symbol;
	}
	public void setICICIBANK_symbol(String iCICIBANK_symbol) {
		ICICIBANK_symbol = iCICIBANK_symbol;
	}
	public String getSBIN_symbol() {
		return SBIN_symbol;
	}
	public void setSBIN_symbol(String sBIN_symbol) {
		SBIN_symbol = sBIN_symbol;
	}
	public String getKOTAKBANK_symbol() {
		return KOTAKBANK_symbol;
	}
	public void setKOTAKBANK_symbol(String kOTAKBANK_symbol) {
		KOTAKBANK_symbol = kOTAKBANK_symbol;
	}
	public String getAXISBANK_symbol() {
		return AXISBANK_symbol;
	}
	public void setAXISBANK_symbol(String aXISBANK_symbol) {
		AXISBANK_symbol = aXISBANK_symbol;
	}
	public String getPNB_symbol() {
		return PNB_symbol;
	}
	public void setPNB_symbol(String pNB_symbol) {
		PNB_symbol = pNB_symbol;
	}
	public String getBANKBARODA_symbol() {
		return BANKBARODA_symbol;
	}
	public void setBANKBARODA_symbol(String bANKBARODA_symbol) {
		BANKBARODA_symbol = bANKBARODA_symbol;
	}
	public String getCANBK_symbol() {
		return CANBK_symbol;
	}
	public void setCANBK_symbol(String cANBK_symbol) {
		CANBK_symbol = cANBK_symbol;
	}
	public String getINDUSINDBK_symbol() {
		return INDUSINDBK_symbol;
	}
	public void setINDUSINDBK_symbol(String iNDUSINDBK_symbol) {
		INDUSINDBK_symbol = iNDUSINDBK_symbol;
	}
	public String getIDFCFIRSTB_symbol() {
		return IDFCFIRSTB_symbol;
	}
	public void setIDFCFIRSTB_symbol(String iDFCFIRSTB_symbol) {
		IDFCFIRSTB_symbol = iDFCFIRSTB_symbol;
	}
	public String getAUBANK_symbol() {
		return AUBANK_symbol;
	}
	public void setAUBANK_symbol(String aUBANK_symbol) {
		AUBANK_symbol = aUBANK_symbol;
	}
	public String getFEDERALBNK_symbol() {
		return FEDERALBNK_symbol;
	}
	public void setFEDERALBNK_symbol(String fEDERALBNK_symbol) {
		FEDERALBNK_symbol = fEDERALBNK_symbol;
	}
	public int getHDFCBANK_totalBuyQty() {
		return HDFCBANK_totalBuyQty;
	}
	public void setHDFCBANK_totalBuyQty(int hDFCBANK_totalBuyQty) {
		HDFCBANK_totalBuyQty = hDFCBANK_totalBuyQty;
	}
	public int getICICIBANK_totalBuyQty() {
		return ICICIBANK_totalBuyQty;
	}
	public void setICICIBANK_totalBuyQty(int iCICIBANK_totalBuyQty) {
		ICICIBANK_totalBuyQty = iCICIBANK_totalBuyQty;
	}
	public int getSBIN_totalBuyQty() {
		return SBIN_totalBuyQty;
	}
	public void setSBIN_totalBuyQty(int sBIN_totalBuyQty) {
		SBIN_totalBuyQty = sBIN_totalBuyQty;
	}
	public int getKOTAKBANK_totalBuyQty() {
		return KOTAKBANK_totalBuyQty;
	}
	public void setKOTAKBANK_totalBuyQty(int kOTAKBANK_totalBuyQty) {
		KOTAKBANK_totalBuyQty = kOTAKBANK_totalBuyQty;
	}
	public int getAXISBANK_totalBuyQty() {
		return AXISBANK_totalBuyQty;
	}
	public void setAXISBANK_totalBuyQty(int aXISBANK_totalBuyQty) {
		AXISBANK_totalBuyQty = aXISBANK_totalBuyQty;
	}
	public int getPNB_totalBuyQty() {
		return PNB_totalBuyQty;
	}
	public void setPNB_totalBuyQty(int pNB_totalBuyQty) {
		PNB_totalBuyQty = pNB_totalBuyQty;
	}
	public int getBANKBARODA_totalBuyQty() {
		return BANKBARODA_totalBuyQty;
	}
	public void setBANKBARODA_totalBuyQty(int bANKBARODA_totalBuyQty) {
		BANKBARODA_totalBuyQty = bANKBARODA_totalBuyQty;
	}
	public int getCANBK_totalBuyQty() {
		return CANBK_totalBuyQty;
	}
	public void setCANBK_totalBuyQty(int cANBK_totalBuyQty) {
		CANBK_totalBuyQty = cANBK_totalBuyQty;
	}
	public int getINDUSINDBK_totalBuyQty() {
		return INDUSINDBK_totalBuyQty;
	}
	public void setINDUSINDBK_totalBuyQty(int iNDUSINDBK_totalBuyQty) {
		INDUSINDBK_totalBuyQty = iNDUSINDBK_totalBuyQty;
	}
	public int getIDFCFIRSTB_totalBuyQty() {
		return IDFCFIRSTB_totalBuyQty;
	}
	public void setIDFCFIRSTB_totalBuyQty(int iDFCFIRSTB_totalBuyQty) {
		IDFCFIRSTB_totalBuyQty = iDFCFIRSTB_totalBuyQty;
	}
	public int getAUBANK_totalBuyQty() {
		return AUBANK_totalBuyQty;
	}
	public void setAUBANK_totalBuyQty(int aUBANK_totalBuyQty) {
		AUBANK_totalBuyQty = aUBANK_totalBuyQty;
	}
	public int getFEDERALBNK_totalBuyQty() {
		return FEDERALBNK_totalBuyQty;
	}
	public void setFEDERALBNK_totalBuyQty(int fEDERALBNK_totalBuyQty) {
		FEDERALBNK_totalBuyQty = fEDERALBNK_totalBuyQty;
	}
	public int getHDFCBANK_totalSellQty() {
		return HDFCBANK_totalSellQty;
	}
	public void setHDFCBANK_totalSellQty(int hDFCBANK_totalSellQty) {
		HDFCBANK_totalSellQty = hDFCBANK_totalSellQty;
	}
	public int getICICIBANK_totalSellQty() {
		return ICICIBANK_totalSellQty;
	}
	public void setICICIBANK_totalSellQty(int iCICIBANK_totalSellQty) {
		ICICIBANK_totalSellQty = iCICIBANK_totalSellQty;
	}
	public int getSBIN_totalSellQty() {
		return SBIN_totalSellQty;
	}
	public void setSBIN_totalSellQty(int sBIN_totalSellQty) {
		SBIN_totalSellQty = sBIN_totalSellQty;
	}
	public int getKOTAKBANK_totalSellQty() {
		return KOTAKBANK_totalSellQty;
	}
	public void setKOTAKBANK_totalSellQty(int kOTAKBANK_totalSellQty) {
		KOTAKBANK_totalSellQty = kOTAKBANK_totalSellQty;
	}
	public int getAXISBANK_totalSellQty() {
		return AXISBANK_totalSellQty;
	}
	public void setAXISBANK_totalSellQty(int aXISBANK_totalSellQty) {
		AXISBANK_totalSellQty = aXISBANK_totalSellQty;
	}
	public int getPNB_totalSellQty() {
		return PNB_totalSellQty;
	}
	public void setPNB_totalSellQty(int pNB_totalSellQty) {
		PNB_totalSellQty = pNB_totalSellQty;
	}
	public int getBANKBARODA_totalSellQty() {
		return BANKBARODA_totalSellQty;
	}
	public void setBANKBARODA_totalSellQty(int bANKBARODA_totalSellQty) {
		BANKBARODA_totalSellQty = bANKBARODA_totalSellQty;
	}
	public int getCANBK_totalSellQty() {
		return CANBK_totalSellQty;
	}
	public void setCANBK_totalSellQty(int cANBK_totalSellQty) {
		CANBK_totalSellQty = cANBK_totalSellQty;
	}
	public int getINDUSINDBK_totalSellQty() {
		return INDUSINDBK_totalSellQty;
	}
	public void setINDUSINDBK_totalSellQty(int iNDUSINDBK_totalSellQty) {
		INDUSINDBK_totalSellQty = iNDUSINDBK_totalSellQty;
	}
	public int getIDFCFIRSTB_totalSellQty() {
		return IDFCFIRSTB_totalSellQty;
	}
	public void setIDFCFIRSTB_totalSellQty(int iDFCFIRSTB_totalSellQty) {
		IDFCFIRSTB_totalSellQty = iDFCFIRSTB_totalSellQty;
	}
	public int getAUBANK_totalSellQty() {
		return AUBANK_totalSellQty;
	}
	public void setAUBANK_totalSellQty(int aUBANK_totalSellQty) {
		AUBANK_totalSellQty = aUBANK_totalSellQty;
	}
	public int getFEDERALBNK_totalSellQty() {
		return FEDERALBNK_totalSellQty;
	}
	public void setFEDERALBNK_totalSellQty(int fEDERALBNK_totalSellQty) {
		FEDERALBNK_totalSellQty = fEDERALBNK_totalSellQty;
	}
	public long getHDFCBANK_tsInMillis() {
		return HDFCBANK_tsInMillis;
	}
	public void setHDFCBANK_tsInMillis(long hDFCBANK_tsInMillis) {
		HDFCBANK_tsInMillis = hDFCBANK_tsInMillis;
	}
	public long getICICIBANK_tsInMillis() {
		return ICICIBANK_tsInMillis;
	}
	public void setICICIBANK_tsInMillis(long iCICIBANK_tsInMillis) {
		ICICIBANK_tsInMillis = iCICIBANK_tsInMillis;
	}
	public long getSBIN_tsInMillis() {
		return SBIN_tsInMillis;
	}
	public void setSBIN_tsInMillis(long sBIN_tsInMillis) {
		SBIN_tsInMillis = sBIN_tsInMillis;
	}
	public long getKOTAKBANK_tsInMillis() {
		return KOTAKBANK_tsInMillis;
	}
	public void setKOTAKBANK_tsInMillis(long kOTAKBANK_tsInMillis) {
		KOTAKBANK_tsInMillis = kOTAKBANK_tsInMillis;
	}
	public long getAXISBANK_tsInMillis() {
		return AXISBANK_tsInMillis;
	}
	public void setAXISBANK_tsInMillis(long aXISBANK_tsInMillis) {
		AXISBANK_tsInMillis = aXISBANK_tsInMillis;
	}
	public long getPNB_tsInMillis() {
		return PNB_tsInMillis;
	}
	public void setPNB_tsInMillis(long pNB_tsInMillis) {
		PNB_tsInMillis = pNB_tsInMillis;
	}
	public long getBANKBARODA_tsInMillis() {
		return BANKBARODA_tsInMillis;
	}
	public void setBANKBARODA_tsInMillis(long bANKBARODA_tsInMillis) {
		BANKBARODA_tsInMillis = bANKBARODA_tsInMillis;
	}
	public long getCANBK_tsInMillis() {
		return CANBK_tsInMillis;
	}
	public void setCANBK_tsInMillis(long cANBK_tsInMillis) {
		CANBK_tsInMillis = cANBK_tsInMillis;
	}
	public long getINDUSINDBK_tsInMillis() {
		return INDUSINDBK_tsInMillis;
	}
	public void setINDUSINDBK_tsInMillis(long iNDUSINDBK_tsInMillis) {
		INDUSINDBK_tsInMillis = iNDUSINDBK_tsInMillis;
	}
	public long getIDFCFIRSTB_tsInMillis() {
		return IDFCFIRSTB_tsInMillis;
	}
	public void setIDFCFIRSTB_tsInMillis(long iDFCFIRSTB_tsInMillis) {
		IDFCFIRSTB_tsInMillis = iDFCFIRSTB_tsInMillis;
	}
	public long getAUBANK_tsInMillis() {
		return AUBANK_tsInMillis;
	}
	public void setAUBANK_tsInMillis(long aUBANK_tsInMillis) {
		AUBANK_tsInMillis = aUBANK_tsInMillis;
	}
	public long getFEDERALBNK_tsInMillis() {
		return FEDERALBNK_tsInMillis;
	}
	public void setFEDERALBNK_tsInMillis(long fEDERALBNK_tsInMillis) {
		FEDERALBNK_tsInMillis = fEDERALBNK_tsInMillis;
	}
	public int getHDFCBANK_volume() {
		return HDFCBANK_volume;
	}
	public void setHDFCBANK_volume(int hDFCBANK_volume) {
		HDFCBANK_volume = hDFCBANK_volume;
	}
	public int getICICIBANK_volume() {
		return ICICIBANK_volume;
	}
	public void setICICIBANK_volume(int iCICIBANK_volume) {
		ICICIBANK_volume = iCICIBANK_volume;
	}
	public int getSBIN_volume() {
		return SBIN_volume;
	}
	public void setSBIN_volume(int sBIN_volume) {
		SBIN_volume = sBIN_volume;
	}
	public int getKOTAKBANK_volume() {
		return KOTAKBANK_volume;
	}
	public void setKOTAKBANK_volume(int kOTAKBANK_volume) {
		KOTAKBANK_volume = kOTAKBANK_volume;
	}
	public int getAXISBANK_volume() {
		return AXISBANK_volume;
	}
	public void setAXISBANK_volume(int aXISBANK_volume) {
		AXISBANK_volume = aXISBANK_volume;
	}
	public int getPNB_volume() {
		return PNB_volume;
	}
	public void setPNB_volume(int pNB_volume) {
		PNB_volume = pNB_volume;
	}
	public int getBANKBARODA_volume() {
		return BANKBARODA_volume;
	}
	public void setBANKBARODA_volume(int bANKBARODA_volume) {
		BANKBARODA_volume = bANKBARODA_volume;
	}
	public int getCANBK_volume() {
		return CANBK_volume;
	}
	public void setCANBK_volume(int cANBK_volume) {
		CANBK_volume = cANBK_volume;
	}
	public int getINDUSINDBK_volume() {
		return INDUSINDBK_volume;
	}
	public void setINDUSINDBK_volume(int iNDUSINDBK_volume) {
		INDUSINDBK_volume = iNDUSINDBK_volume;
	}
	public int getIDFCFIRSTB_volume() {
		return IDFCFIRSTB_volume;
	}
	public void setIDFCFIRSTB_volume(int iDFCFIRSTB_volume) {
		IDFCFIRSTB_volume = iDFCFIRSTB_volume;
	}
	public int getAUBANK_volume() {
		return AUBANK_volume;
	}
	public void setAUBANK_volume(int aUBANK_volume) {
		AUBANK_volume = aUBANK_volume;
	}
	public int getFEDERALBNK_volume() {
		return FEDERALBNK_volume;
	}
	public void setFEDERALBNK_volume(int fEDERALBNK_volume) {
		FEDERALBNK_volume = fEDERALBNK_volume;
	}
	public double getHDFCBANK_yearHighPrice() {
		return HDFCBANK_yearHighPrice;
	}
	public void setHDFCBANK_yearHighPrice(double hDFCBANK_yearHighPrice) {
		HDFCBANK_yearHighPrice = hDFCBANK_yearHighPrice;
	}
	public double getICICIBANK_yearHighPrice() {
		return ICICIBANK_yearHighPrice;
	}
	public void setICICIBANK_yearHighPrice(double iCICIBANK_yearHighPrice) {
		ICICIBANK_yearHighPrice = iCICIBANK_yearHighPrice;
	}
	public double getSBIN_yearHighPrice() {
		return SBIN_yearHighPrice;
	}
	public void setSBIN_yearHighPrice(double sBIN_yearHighPrice) {
		SBIN_yearHighPrice = sBIN_yearHighPrice;
	}
	public double getKOTAKBANK_yearHighPrice() {
		return KOTAKBANK_yearHighPrice;
	}
	public void setKOTAKBANK_yearHighPrice(double kOTAKBANK_yearHighPrice) {
		KOTAKBANK_yearHighPrice = kOTAKBANK_yearHighPrice;
	}
	public double getAXISBANK_yearHighPrice() {
		return AXISBANK_yearHighPrice;
	}
	public void setAXISBANK_yearHighPrice(double aXISBANK_yearHighPrice) {
		AXISBANK_yearHighPrice = aXISBANK_yearHighPrice;
	}
	public double getPNB_yearHighPrice() {
		return PNB_yearHighPrice;
	}
	public void setPNB_yearHighPrice(double pNB_yearHighPrice) {
		PNB_yearHighPrice = pNB_yearHighPrice;
	}
	public double getBANKBARODA_yearHighPrice() {
		return BANKBARODA_yearHighPrice;
	}
	public void setBANKBARODA_yearHighPrice(double bANKBARODA_yearHighPrice) {
		BANKBARODA_yearHighPrice = bANKBARODA_yearHighPrice;
	}
	public double getCANBK_yearHighPrice() {
		return CANBK_yearHighPrice;
	}
	public void setCANBK_yearHighPrice(double cANBK_yearHighPrice) {
		CANBK_yearHighPrice = cANBK_yearHighPrice;
	}
	public double getINDUSINDBK_yearHighPrice() {
		return INDUSINDBK_yearHighPrice;
	}
	public void setINDUSINDBK_yearHighPrice(double iNDUSINDBK_yearHighPrice) {
		INDUSINDBK_yearHighPrice = iNDUSINDBK_yearHighPrice;
	}
	public double getIDFCFIRSTB_yearHighPrice() {
		return IDFCFIRSTB_yearHighPrice;
	}
	public void setIDFCFIRSTB_yearHighPrice(double iDFCFIRSTB_yearHighPrice) {
		IDFCFIRSTB_yearHighPrice = iDFCFIRSTB_yearHighPrice;
	}
	public double getAUBANK_yearHighPrice() {
		return AUBANK_yearHighPrice;
	}
	public void setAUBANK_yearHighPrice(double aUBANK_yearHighPrice) {
		AUBANK_yearHighPrice = aUBANK_yearHighPrice;
	}
	public double getFEDERALBNK_yearHighPrice() {
		return FEDERALBNK_yearHighPrice;
	}
	public void setFEDERALBNK_yearHighPrice(double fEDERALBNK_yearHighPrice) {
		FEDERALBNK_yearHighPrice = fEDERALBNK_yearHighPrice;
	}
	public double getHDFCBANK_yearLowPrice() {
		return HDFCBANK_yearLowPrice;
	}
	public void setHDFCBANK_yearLowPrice(double hDFCBANK_yearLowPrice) {
		HDFCBANK_yearLowPrice = hDFCBANK_yearLowPrice;
	}
	public double getICICIBANK_yearLowPrice() {
		return ICICIBANK_yearLowPrice;
	}
	public void setICICIBANK_yearLowPrice(double iCICIBANK_yearLowPrice) {
		ICICIBANK_yearLowPrice = iCICIBANK_yearLowPrice;
	}
	public double getSBIN_yearLowPrice() {
		return SBIN_yearLowPrice;
	}
	public void setSBIN_yearLowPrice(double sBIN_yearLowPrice) {
		SBIN_yearLowPrice = sBIN_yearLowPrice;
	}
	public double getKOTAKBANK_yearLowPrice() {
		return KOTAKBANK_yearLowPrice;
	}
	public void setKOTAKBANK_yearLowPrice(double kOTAKBANK_yearLowPrice) {
		KOTAKBANK_yearLowPrice = kOTAKBANK_yearLowPrice;
	}
	public double getAXISBANK_yearLowPrice() {
		return AXISBANK_yearLowPrice;
	}
	public void setAXISBANK_yearLowPrice(double aXISBANK_yearLowPrice) {
		AXISBANK_yearLowPrice = aXISBANK_yearLowPrice;
	}
	public double getPNB_yearLowPrice() {
		return PNB_yearLowPrice;
	}
	public void setPNB_yearLowPrice(double pNB_yearLowPrice) {
		PNB_yearLowPrice = pNB_yearLowPrice;
	}
	public double getBANKBARODA_yearLowPrice() {
		return BANKBARODA_yearLowPrice;
	}
	public void setBANKBARODA_yearLowPrice(double bANKBARODA_yearLowPrice) {
		BANKBARODA_yearLowPrice = bANKBARODA_yearLowPrice;
	}
	public double getCANBK_yearLowPrice() {
		return CANBK_yearLowPrice;
	}
	public void setCANBK_yearLowPrice(double cANBK_yearLowPrice) {
		CANBK_yearLowPrice = cANBK_yearLowPrice;
	}
	public double getINDUSINDBK_yearLowPrice() {
		return INDUSINDBK_yearLowPrice;
	}
	public void setINDUSINDBK_yearLowPrice(double iNDUSINDBK_yearLowPrice) {
		INDUSINDBK_yearLowPrice = iNDUSINDBK_yearLowPrice;
	}
	public double getIDFCFIRSTB_yearLowPrice() {
		return IDFCFIRSTB_yearLowPrice;
	}
	public void setIDFCFIRSTB_yearLowPrice(double iDFCFIRSTB_yearLowPrice) {
		IDFCFIRSTB_yearLowPrice = iDFCFIRSTB_yearLowPrice;
	}
	public double getAUBANK_yearLowPrice() {
		return AUBANK_yearLowPrice;
	}
	public void setAUBANK_yearLowPrice(double aUBANK_yearLowPrice) {
		AUBANK_yearLowPrice = aUBANK_yearLowPrice;
	}
	public double getFEDERALBNK_yearLowPrice() {
		return FEDERALBNK_yearLowPrice;
	}
	public void setFEDERALBNK_yearLowPrice(double fEDERALBNK_yearLowPrice) {
		FEDERALBNK_yearLowPrice = fEDERALBNK_yearLowPrice;
	}
	public String getHDFCBANK_type() {
		return HDFCBANK_type;
	}
	public void setHDFCBANK_type(String hDFCBANK_type) {
		HDFCBANK_type = hDFCBANK_type;
	}
	public String getICICIBANK_type() {
		return ICICIBANK_type;
	}
	public void setICICIBANK_type(String iCICIBANK_type) {
		ICICIBANK_type = iCICIBANK_type;
	}
	public String getSBIN_type() {
		return SBIN_type;
	}
	public void setSBIN_type(String sBIN_type) {
		SBIN_type = sBIN_type;
	}
	public String getKOTAKBANK_type() {
		return KOTAKBANK_type;
	}
	public void setKOTAKBANK_type(String kOTAKBANK_type) {
		KOTAKBANK_type = kOTAKBANK_type;
	}
	public String getAXISBANK_type() {
		return AXISBANK_type;
	}
	public void setAXISBANK_type(String aXISBANK_type) {
		AXISBANK_type = aXISBANK_type;
	}
	public String getPNB_type() {
		return PNB_type;
	}
	public void setPNB_type(String pNB_type) {
		PNB_type = pNB_type;
	}
	public String getBANKBARODA_type() {
		return BANKBARODA_type;
	}
	public void setBANKBARODA_type(String bANKBARODA_type) {
		BANKBARODA_type = bANKBARODA_type;
	}
	public String getCANBK_type() {
		return CANBK_type;
	}
	public void setCANBK_type(String cANBK_type) {
		CANBK_type = cANBK_type;
	}
	public String getINDUSINDBK_type() {
		return INDUSINDBK_type;
	}
	public void setINDUSINDBK_type(String iNDUSINDBK_type) {
		INDUSINDBK_type = iNDUSINDBK_type;
	}
	public String getIDFCFIRSTB_type() {
		return IDFCFIRSTB_type;
	}
	public void setIDFCFIRSTB_type(String iDFCFIRSTB_type) {
		IDFCFIRSTB_type = iDFCFIRSTB_type;
	}
	public String getAUBANK_type() {
		return AUBANK_type;
	}
	public void setAUBANK_type(String aUBANK_type) {
		AUBANK_type = aUBANK_type;
	}
	public String getFEDERALBNK_type() {
		return FEDERALBNK_type;
	}
	public void setFEDERALBNK_type(String fEDERALBNK_type) {
		FEDERALBNK_type = fEDERALBNK_type;
	}
	@Override
	public String toString() {
		return "BankNiftyCompanies [id=" + id + ", HDFCBANK_close=" + HDFCBANK_close + ", ICICIBANK_close="
				+ ICICIBANK_close + ", SBIN_close=" + SBIN_close + ", KOTAKBANK_close=" + KOTAKBANK_close
				+ ", AXISBANK_close=" + AXISBANK_close + ", PNB_close=" + PNB_close + ", BANKBARODA_close="
				+ BANKBARODA_close + ", CANBK_close=" + CANBK_close + ", INDUSINDBK_close=" + INDUSINDBK_close
				+ ", IDFCFIRSTB_close=" + IDFCFIRSTB_close + ", AUBANK_close=" + AUBANK_close + ", FEDERALBNK_close="
				+ FEDERALBNK_close + ", HDFCBANK_dayChange=" + HDFCBANK_dayChange + ", ICICIBANK_dayChange="
				+ ICICIBANK_dayChange + ", SBIN_dayChange=" + SBIN_dayChange + ", KOTAKBANK_dayChange="
				+ KOTAKBANK_dayChange + ", AXISBANK_dayChange=" + AXISBANK_dayChange + ", PNB_dayChange="
				+ PNB_dayChange + ", BANKBARODA_dayChange=" + BANKBARODA_dayChange + ", CANBK_dayChange="
				+ CANBK_dayChange + ", INDUSINDBK_dayChange=" + INDUSINDBK_dayChange + ", IDFCFIRSTB_dayChange="
				+ IDFCFIRSTB_dayChange + ", AUBANK_dayChange=" + AUBANK_dayChange + ", FEDERALBNK_dayChange="
				+ FEDERALBNK_dayChange + ", HDFCBANK_dayChangePerc=" + HDFCBANK_dayChangePerc
				+ ", ICICIBANK_dayChangePerc=" + ICICIBANK_dayChangePerc + ", SBIN_dayChangePerc=" + SBIN_dayChangePerc
				+ ", KOTAKBANK_dayChangePerc=" + KOTAKBANK_dayChangePerc + ", AXISBANK_dayChangePerc="
				+ AXISBANK_dayChangePerc + ", PNB_dayChangePerc=" + PNB_dayChangePerc + ", BANKBARODA_dayChangePerc="
				+ BANKBARODA_dayChangePerc + ", CANBK_dayChangePerc=" + CANBK_dayChangePerc
				+ ", INDUSINDBK_dayChangePerc=" + INDUSINDBK_dayChangePerc + ", IDFCFIRSTB_dayChangePerc="
				+ IDFCFIRSTB_dayChangePerc + ", AUBANK_dayChangePerc=" + AUBANK_dayChangePerc
				+ ", FEDERALBNK_dayChangePerc=" + FEDERALBNK_dayChangePerc + ", HDFCBANK_high=" + HDFCBANK_high
				+ ", ICICIBANK_high=" + ICICIBANK_high + ", SBIN_high=" + SBIN_high + ", KOTAKBANK_high="
				+ KOTAKBANK_high + ", AXISBANK_high=" + AXISBANK_high + ", PNB_high=" + PNB_high + ", BANKBARODA_high="
				+ BANKBARODA_high + ", CANBK_high=" + CANBK_high + ", INDUSINDBK_high=" + INDUSINDBK_high
				+ ", IDFCFIRSTB_high=" + IDFCFIRSTB_high + ", AUBANK_high=" + AUBANK_high + ", FEDERALBNK_high="
				+ FEDERALBNK_high + ", HDFCBANK_highPriceRange=" + HDFCBANK_highPriceRange
				+ ", ICICIBANK_highPriceRange=" + ICICIBANK_highPriceRange + ", SBIN_highPriceRange="
				+ SBIN_highPriceRange + ", KOTAKBANK_highPriceRange=" + KOTAKBANK_highPriceRange
				+ ", AXISBANK_highPriceRange=" + AXISBANK_highPriceRange + ", PNB_highPriceRange=" + PNB_highPriceRange
				+ ", BANKBARODA_highPriceRange=" + BANKBARODA_highPriceRange + ", CANBK_highPriceRange="
				+ CANBK_highPriceRange + ", INDUSINDBK_highPriceRange=" + INDUSINDBK_highPriceRange
				+ ", IDFCFIRSTB_highPriceRange=" + IDFCFIRSTB_highPriceRange + ", AUBANK_highPriceRange="
				+ AUBANK_highPriceRange + ", FEDERALBNK_highPriceRange=" + FEDERALBNK_highPriceRange
				+ ", HDFCBANK_highTradeRange=" + HDFCBANK_highTradeRange + ", ICICIBANK_highTradeRange="
				+ ICICIBANK_highTradeRange + ", SBIN_highTradeRange=" + SBIN_highTradeRange
				+ ", KOTAKBANK_highTradeRange=" + KOTAKBANK_highTradeRange + ", AXISBANK_highTradeRange="
				+ AXISBANK_highTradeRange + ", PNB_highTradeRange=" + PNB_highTradeRange
				+ ", BANKBARODA_highTradeRange=" + BANKBARODA_highTradeRange + ", CANBK_highTradeRange="
				+ CANBK_highTradeRange + ", INDUSINDBK_highTradeRange=" + INDUSINDBK_highTradeRange
				+ ", IDFCFIRSTB_highTradeRange=" + IDFCFIRSTB_highTradeRange + ", AUBANK_highTradeRange="
				+ AUBANK_highTradeRange + ", FEDERALBNK_highTradeRange=" + FEDERALBNK_highTradeRange
				+ ", HDFCBANK_lastTradeQty=" + HDFCBANK_lastTradeQty + ", ICICIBANK_lastTradeQty="
				+ ICICIBANK_lastTradeQty + ", SBIN_lastTradeQty=" + SBIN_lastTradeQty + ", KOTAKBANK_lastTradeQty="
				+ KOTAKBANK_lastTradeQty + ", AXISBANK_lastTradeQty=" + AXISBANK_lastTradeQty + ", PNB_lastTradeQty="
				+ PNB_lastTradeQty + ", BANKBARODA_lastTradeQty=" + BANKBARODA_lastTradeQty + ", CANBK_lastTradeQty="
				+ CANBK_lastTradeQty + ", INDUSINDBK_lastTradeQty=" + INDUSINDBK_lastTradeQty
				+ ", IDFCFIRSTB_lastTradeQty=" + IDFCFIRSTB_lastTradeQty + ", AUBANK_lastTradeQty="
				+ AUBANK_lastTradeQty + ", FEDERALBNK_lastTradeQty=" + FEDERALBNK_lastTradeQty
				+ ", HDFCBANK_lastTradeTime=" + HDFCBANK_lastTradeTime + ", ICICIBANK_lastTradeTime="
				+ ICICIBANK_lastTradeTime + ", SBIN_lastTradeTime=" + SBIN_lastTradeTime + ", KOTAKBANK_lastTradeTime="
				+ KOTAKBANK_lastTradeTime + ", AXISBANK_lastTradeTime=" + AXISBANK_lastTradeTime
				+ ", PNB_lastTradeTime=" + PNB_lastTradeTime + ", BANKBARODA_lastTradeTime=" + BANKBARODA_lastTradeTime
				+ ", CANBK_lastTradeTime=" + CANBK_lastTradeTime + ", INDUSINDBK_lastTradeTime="
				+ INDUSINDBK_lastTradeTime + ", IDFCFIRSTB_lastTradeTime=" + IDFCFIRSTB_lastTradeTime
				+ ", AUBANK_lastTradeTime=" + AUBANK_lastTradeTime + ", FEDERALBNK_lastTradeTime="
				+ FEDERALBNK_lastTradeTime + ", HDFCBANK_low=" + HDFCBANK_low + ", ICICIBANK_low=" + ICICIBANK_low
				+ ", SBIN_low=" + SBIN_low + ", KOTAKBANK_low=" + KOTAKBANK_low + ", AXISBANK_low=" + AXISBANK_low
				+ ", PNB_low=" + PNB_low + ", BANKBARODA_low=" + BANKBARODA_low + ", CANBK_low=" + CANBK_low
				+ ", INDUSINDBK_low=" + INDUSINDBK_low + ", IDFCFIRSTB_low=" + IDFCFIRSTB_low + ", AUBANK_low="
				+ AUBANK_low + ", FEDERALBNK_low=" + FEDERALBNK_low + ", HDFCBANK_lowPriceRange="
				+ HDFCBANK_lowPriceRange + ", ICICIBANK_lowPriceRange=" + ICICIBANK_lowPriceRange
				+ ", SBIN_lowPriceRange=" + SBIN_lowPriceRange + ", KOTAKBANK_lowPriceRange=" + KOTAKBANK_lowPriceRange
				+ ", AXISBANK_lowPriceRange=" + AXISBANK_lowPriceRange + ", PNB_lowPriceRange=" + PNB_lowPriceRange
				+ ", BANKBARODA_lowPriceRange=" + BANKBARODA_lowPriceRange + ", CANBK_lowPriceRange="
				+ CANBK_lowPriceRange + ", INDUSINDBK_lowPriceRange=" + INDUSINDBK_lowPriceRange
				+ ", IDFCFIRSTB_lowPriceRange=" + IDFCFIRSTB_lowPriceRange + ", AUBANK_lowPriceRange="
				+ AUBANK_lowPriceRange + ", FEDERALBNK_lowPriceRange=" + FEDERALBNK_lowPriceRange
				+ ", HDFCBANK_lowTradeRange=" + HDFCBANK_lowTradeRange + ", ICICIBANK_lowTradeRange="
				+ ICICIBANK_lowTradeRange + ", SBIN_lowTradeRange=" + SBIN_lowTradeRange + ", KOTAKBANK_lowTradeRange="
				+ KOTAKBANK_lowTradeRange + ", AXISBANK_lowTradeRange=" + AXISBANK_lowTradeRange
				+ ", PNB_lowTradeRange=" + PNB_lowTradeRange + ", BANKBARODA_lowTradeRange=" + BANKBARODA_lowTradeRange
				+ ", CANBK_lowTradeRange=" + CANBK_lowTradeRange + ", INDUSINDBK_lowTradeRange="
				+ INDUSINDBK_lowTradeRange + ", IDFCFIRSTB_lowTradeRange=" + IDFCFIRSTB_lowTradeRange
				+ ", AUBANK_lowTradeRange=" + AUBANK_lowTradeRange + ", FEDERALBNK_lowTradeRange="
				+ FEDERALBNK_lowTradeRange + ", HDFCBANK_ltp=" + HDFCBANK_ltp + ", ICICIBANK_ltp=" + ICICIBANK_ltp
				+ ", SBIN_ltp=" + SBIN_ltp + ", KOTAKBANK_ltp=" + KOTAKBANK_ltp + ", AXISBANK_ltp=" + AXISBANK_ltp
				+ ", PNB_ltp=" + PNB_ltp + ", BANKBARODA_ltp=" + BANKBARODA_ltp + ", CANBK_ltp=" + CANBK_ltp
				+ ", INDUSINDBK_ltp=" + INDUSINDBK_ltp + ", IDFCFIRSTB_ltp=" + IDFCFIRSTB_ltp + ", AUBANK_ltp="
				+ AUBANK_ltp + ", FEDERALBNK_ltp=" + FEDERALBNK_ltp + ", HDFCBANK_oiDayChange=" + HDFCBANK_oiDayChange
				+ ", ICICIBANK_oiDayChange=" + ICICIBANK_oiDayChange + ", SBIN_oiDayChange=" + SBIN_oiDayChange
				+ ", KOTAKBANK_oiDayChange=" + KOTAKBANK_oiDayChange + ", AXISBANK_oiDayChange=" + AXISBANK_oiDayChange
				+ ", PNB_oiDayChange=" + PNB_oiDayChange + ", BANKBARODA_oiDayChange=" + BANKBARODA_oiDayChange
				+ ", CANBK_oiDayChange=" + CANBK_oiDayChange + ", INDUSINDBK_oiDayChange=" + INDUSINDBK_oiDayChange
				+ ", IDFCFIRSTB_oiDayChange=" + IDFCFIRSTB_oiDayChange + ", AUBANK_oiDayChange=" + AUBANK_oiDayChange
				+ ", FEDERALBNK_oiDayChange=" + FEDERALBNK_oiDayChange + ", HDFCBANK_oiDayChangePerc="
				+ HDFCBANK_oiDayChangePerc + ", ICICIBANK_oiDayChangePerc=" + ICICIBANK_oiDayChangePerc
				+ ", SBIN_oiDayChangePerc=" + SBIN_oiDayChangePerc + ", KOTAKBANK_oiDayChangePerc="
				+ KOTAKBANK_oiDayChangePerc + ", AXISBANK_oiDayChangePerc=" + AXISBANK_oiDayChangePerc
				+ ", PNB_oiDayChangePerc=" + PNB_oiDayChangePerc + ", BANKBARODA_oiDayChangePerc="
				+ BANKBARODA_oiDayChangePerc + ", CANBK_oiDayChangePerc=" + CANBK_oiDayChangePerc
				+ ", INDUSINDBK_oiDayChangePerc=" + INDUSINDBK_oiDayChangePerc + ", IDFCFIRSTB_oiDayChangePerc="
				+ IDFCFIRSTB_oiDayChangePerc + ", AUBANK_oiDayChangePerc=" + AUBANK_oiDayChangePerc
				+ ", FEDERALBNK_oiDayChangePerc=" + FEDERALBNK_oiDayChangePerc + ", HDFCBANK_open=" + HDFCBANK_open
				+ ", ICICIBANK_open=" + ICICIBANK_open + ", SBIN_open=" + SBIN_open + ", KOTAKBANK_open="
				+ KOTAKBANK_open + ", AXISBANK_open=" + AXISBANK_open + ", PNB_open=" + PNB_open + ", BANKBARODA_open="
				+ BANKBARODA_open + ", CANBK_open=" + CANBK_open + ", INDUSINDBK_open=" + INDUSINDBK_open
				+ ", IDFCFIRSTB_open=" + IDFCFIRSTB_open + ", AUBANK_open=" + AUBANK_open + ", FEDERALBNK_open="
				+ FEDERALBNK_open + ", HDFCBANK_openInterest=" + HDFCBANK_openInterest + ", ICICIBANK_openInterest="
				+ ICICIBANK_openInterest + ", SBIN_openInterest=" + SBIN_openInterest + ", KOTAKBANK_openInterest="
				+ KOTAKBANK_openInterest + ", AXISBANK_openInterest=" + AXISBANK_openInterest + ", PNB_openInterest="
				+ PNB_openInterest + ", BANKBARODA_openInterest=" + BANKBARODA_openInterest + ", CANBK_openInterest="
				+ CANBK_openInterest + ", INDUSINDBK_openInterest=" + INDUSINDBK_openInterest
				+ ", IDFCFIRSTB_openInterest=" + IDFCFIRSTB_openInterest + ", AUBANK_openInterest="
				+ AUBANK_openInterest + ", FEDERALBNK_openInterest=" + FEDERALBNK_openInterest
				+ ", HDFCBANK_prevOpenInterest=" + HDFCBANK_prevOpenInterest + ", ICICIBANK_prevOpenInterest="
				+ ICICIBANK_prevOpenInterest + ", SBIN_prevOpenInterest=" + SBIN_prevOpenInterest
				+ ", KOTAKBANK_prevOpenInterest=" + KOTAKBANK_prevOpenInterest + ", AXISBANK_prevOpenInterest="
				+ AXISBANK_prevOpenInterest + ", PNB_prevOpenInterest=" + PNB_prevOpenInterest
				+ ", BANKBARODA_prevOpenInterest=" + BANKBARODA_prevOpenInterest + ", CANBK_prevOpenInterest="
				+ CANBK_prevOpenInterest + ", INDUSINDBK_prevOpenInterest=" + INDUSINDBK_prevOpenInterest
				+ ", IDFCFIRSTB_prevOpenInterest=" + IDFCFIRSTB_prevOpenInterest + ", AUBANK_prevOpenInterest="
				+ AUBANK_prevOpenInterest + ", FEDERALBNK_prevOpenInterest=" + FEDERALBNK_prevOpenInterest
				+ ", HDFCBANK_symbol=" + HDFCBANK_symbol + ", ICICIBANK_symbol=" + ICICIBANK_symbol + ", SBIN_symbol="
				+ SBIN_symbol + ", KOTAKBANK_symbol=" + KOTAKBANK_symbol + ", AXISBANK_symbol=" + AXISBANK_symbol
				+ ", PNB_symbol=" + PNB_symbol + ", BANKBARODA_symbol=" + BANKBARODA_symbol + ", CANBK_symbol="
				+ CANBK_symbol + ", INDUSINDBK_symbol=" + INDUSINDBK_symbol + ", IDFCFIRSTB_symbol=" + IDFCFIRSTB_symbol
				+ ", AUBANK_symbol=" + AUBANK_symbol + ", FEDERALBNK_symbol=" + FEDERALBNK_symbol
				+ ", HDFCBANK_totalBuyQty=" + HDFCBANK_totalBuyQty + ", ICICIBANK_totalBuyQty=" + ICICIBANK_totalBuyQty
				+ ", SBIN_totalBuyQty=" + SBIN_totalBuyQty + ", KOTAKBANK_totalBuyQty=" + KOTAKBANK_totalBuyQty
				+ ", AXISBANK_totalBuyQty=" + AXISBANK_totalBuyQty + ", PNB_totalBuyQty=" + PNB_totalBuyQty
				+ ", BANKBARODA_totalBuyQty=" + BANKBARODA_totalBuyQty + ", CANBK_totalBuyQty=" + CANBK_totalBuyQty
				+ ", INDUSINDBK_totalBuyQty=" + INDUSINDBK_totalBuyQty + ", IDFCFIRSTB_totalBuyQty="
				+ IDFCFIRSTB_totalBuyQty + ", AUBANK_totalBuyQty=" + AUBANK_totalBuyQty + ", FEDERALBNK_totalBuyQty="
				+ FEDERALBNK_totalBuyQty + ", HDFCBANK_totalSellQty=" + HDFCBANK_totalSellQty
				+ ", ICICIBANK_totalSellQty=" + ICICIBANK_totalSellQty + ", SBIN_totalSellQty=" + SBIN_totalSellQty
				+ ", KOTAKBANK_totalSellQty=" + KOTAKBANK_totalSellQty + ", AXISBANK_totalSellQty="
				+ AXISBANK_totalSellQty + ", PNB_totalSellQty=" + PNB_totalSellQty + ", BANKBARODA_totalSellQty="
				+ BANKBARODA_totalSellQty + ", CANBK_totalSellQty=" + CANBK_totalSellQty + ", INDUSINDBK_totalSellQty="
				+ INDUSINDBK_totalSellQty + ", IDFCFIRSTB_totalSellQty=" + IDFCFIRSTB_totalSellQty
				+ ", AUBANK_totalSellQty=" + AUBANK_totalSellQty + ", FEDERALBNK_totalSellQty="
				+ FEDERALBNK_totalSellQty + ", HDFCBANK_tsInMillis=" + HDFCBANK_tsInMillis + ", ICICIBANK_tsInMillis="
				+ ICICIBANK_tsInMillis + ", SBIN_tsInMillis=" + SBIN_tsInMillis + ", KOTAKBANK_tsInMillis="
				+ KOTAKBANK_tsInMillis + ", AXISBANK_tsInMillis=" + AXISBANK_tsInMillis + ", PNB_tsInMillis="
				+ PNB_tsInMillis + ", BANKBARODA_tsInMillis=" + BANKBARODA_tsInMillis + ", CANBK_tsInMillis="
				+ CANBK_tsInMillis + ", INDUSINDBK_tsInMillis=" + INDUSINDBK_tsInMillis + ", IDFCFIRSTB_tsInMillis="
				+ IDFCFIRSTB_tsInMillis + ", AUBANK_tsInMillis=" + AUBANK_tsInMillis + ", FEDERALBNK_tsInMillis="
				+ FEDERALBNK_tsInMillis + ", HDFCBANK_volume=" + HDFCBANK_volume + ", ICICIBANK_volume="
				+ ICICIBANK_volume + ", SBIN_volume=" + SBIN_volume + ", KOTAKBANK_volume=" + KOTAKBANK_volume
				+ ", AXISBANK_volume=" + AXISBANK_volume + ", PNB_volume=" + PNB_volume + ", BANKBARODA_volume="
				+ BANKBARODA_volume + ", CANBK_volume=" + CANBK_volume + ", INDUSINDBK_volume=" + INDUSINDBK_volume
				+ ", IDFCFIRSTB_volume=" + IDFCFIRSTB_volume + ", AUBANK_volume=" + AUBANK_volume
				+ ", FEDERALBNK_volume=" + FEDERALBNK_volume + ", HDFCBANK_yearHighPrice=" + HDFCBANK_yearHighPrice
				+ ", ICICIBANK_yearHighPrice=" + ICICIBANK_yearHighPrice + ", SBIN_yearHighPrice=" + SBIN_yearHighPrice
				+ ", KOTAKBANK_yearHighPrice=" + KOTAKBANK_yearHighPrice + ", AXISBANK_yearHighPrice="
				+ AXISBANK_yearHighPrice + ", PNB_yearHighPrice=" + PNB_yearHighPrice + ", BANKBARODA_yearHighPrice="
				+ BANKBARODA_yearHighPrice + ", CANBK_yearHighPrice=" + CANBK_yearHighPrice
				+ ", INDUSINDBK_yearHighPrice=" + INDUSINDBK_yearHighPrice + ", IDFCFIRSTB_yearHighPrice="
				+ IDFCFIRSTB_yearHighPrice + ", AUBANK_yearHighPrice=" + AUBANK_yearHighPrice
				+ ", FEDERALBNK_yearHighPrice=" + FEDERALBNK_yearHighPrice + ", HDFCBANK_yearLowPrice="
				+ HDFCBANK_yearLowPrice + ", ICICIBANK_yearLowPrice=" + ICICIBANK_yearLowPrice + ", SBIN_yearLowPrice="
				+ SBIN_yearLowPrice + ", KOTAKBANK_yearLowPrice=" + KOTAKBANK_yearLowPrice + ", AXISBANK_yearLowPrice="
				+ AXISBANK_yearLowPrice + ", PNB_yearLowPrice=" + PNB_yearLowPrice + ", BANKBARODA_yearLowPrice="
				+ BANKBARODA_yearLowPrice + ", CANBK_yearLowPrice=" + CANBK_yearLowPrice + ", INDUSINDBK_yearLowPrice="
				+ INDUSINDBK_yearLowPrice + ", IDFCFIRSTB_yearLowPrice=" + IDFCFIRSTB_yearLowPrice
				+ ", AUBANK_yearLowPrice=" + AUBANK_yearLowPrice + ", FEDERALBNK_yearLowPrice="
				+ FEDERALBNK_yearLowPrice + ", HDFCBANK_type=" + HDFCBANK_type + ", ICICIBANK_type=" + ICICIBANK_type
				+ ", SBIN_type=" + SBIN_type + ", KOTAKBANK_type=" + KOTAKBANK_type + ", AXISBANK_type=" + AXISBANK_type
				+ ", PNB_type=" + PNB_type + ", BANKBARODA_type=" + BANKBARODA_type + ", CANBK_type=" + CANBK_type
				+ ", INDUSINDBK_type=" + INDUSINDBK_type + ", IDFCFIRSTB_type=" + IDFCFIRSTB_type + ", AUBANK_type="
				+ AUBANK_type + ", FEDERALBNK_type=" + FEDERALBNK_type + "]";
	}
	
	
	
	
	private BankNiftyCompanies() {
	        // initialize default values if needed
	    }	
	
	 public static synchronized BankNiftyCompanies getInstance() {
	        if (instance == null) {
	            instance = new BankNiftyCompanies();
	        }
	        return instance;
	    }
	
}