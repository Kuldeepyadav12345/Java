package com.growOptionChainComparator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * A Java model class for the LivePrice JSON data, configured as a JPA Entity.
 *
 * This class serves as the single model for all price data, regardless of the
 * underlying database table. The @Entity annotation is used by JPA to recognize
 * this class as a persistent object, even though we will be using native
 * queries for saving, bypassing the standard repository-based save methods.
 */
@Entity
@Table(name = "LivePrice")
public class LivePrice {

	@Id
	@JsonIgnoreProperties(ignoreUnknown = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // A primary key is required for a JPA entity

	private double close;
	private double dayChange;
	private double dayChangePerc;
	private double high;
	private double highPriceRange;
	private String highTradeRange; // Using String for nullable field
	private int lastTradeQty;
	private long lastTradeTime;
	private double low;
	private double lowPriceRange;
	private String lowTradeRange; // Using String for nullable field
	private double ltp;
	private double oiDayChange;
	private double oiDayChangePerc;
	private double open;
	private String openInterest; // Using String for nullable field
	private String prevOpenInterest; // Using String for nullable field
	private String symbol;
	private int totalBuyQty;
	private int totalSellQty;
	private long tsInMillis;
	private int volume;
	private double yearHighPrice;
	private double yearLowPrice;
	private String type;

	// Getters for all fields
	public double getClose() {
		return close;
	}

	public double getDayChange() {
		return dayChange;
	}

	public double getDayChangePerc() {
		return dayChangePerc;
	}

	public double getHigh() {
		return high;
	}

	public double getHighPriceRange() {
		return highPriceRange;
	}

	public String getHighTradeRange() {
		return highTradeRange;
	}

	public int getLastTradeQty() {
		return lastTradeQty;
	}

	public long getLastTradeTime() {
		return lastTradeTime;
	}

	public double getLow() {
		return low;
	}

	public double getLowPriceRange() {
		return lowPriceRange;
	}

	public String getLowTradeRange() {
		return lowTradeRange;
	}

	public double getLtp() {
		return ltp;
	}

	public double getOiDayChange() {
		return oiDayChange;
	}

	public double getOiDayChangePerc() {
		return oiDayChangePerc;
	}

	public double getOpen() {
		return open;
	}

	public String getOpenInterest() {
		return openInterest;
	}

	public String getPrevOpenInterest() {
		return prevOpenInterest;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getTotalBuyQty() {
		return totalBuyQty;
	}

	public int getTotalSellQty() {
		return totalSellQty;
	}

	public long getTsInMillis() {
		return tsInMillis;
	}

	public int getVolume() {
		return volume;
	}

	public double getYearHighPrice() {
		return yearHighPrice;
	}

	public double getYearLowPrice() {
		return yearLowPrice;
	}

	public String getType() {
		return type;
	}

	// Setters (required for JPA and data binding)
	public void setClose(double close) {
		this.close = close;
	}

	public void setDayChange(double dayChange) {
		this.dayChange = dayChange;
	}

	public void setDayChangePerc(double dayChangePerc) {
		this.dayChangePerc = dayChangePerc;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public void setHighPriceRange(double highPriceRange) {
		this.highPriceRange = highPriceRange;
	}

	public void setHighTradeRange(String highTradeRange) {
		this.highTradeRange = highTradeRange;
	}

	public void setLastTradeQty(int lastTradeQty) {
		this.lastTradeQty = lastTradeQty;
	}

	public void setLastTradeTime(long lastTradeTime) {
		this.lastTradeTime = lastTradeTime;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public void setLowPriceRange(double lowPriceRange) {
		this.lowPriceRange = lowPriceRange;
	}

	public void setLowTradeRange(String lowTradeRange) {
		this.lowTradeRange = lowTradeRange;
	}

	public void setLtp(double ltp) {
		this.ltp = ltp;
	}

	public void setOiDayChange(double oiDayChange) {
		this.oiDayChange = oiDayChange;
	}

	public void setOiDayChangePerc(double oiDayChangePerc) {
		this.oiDayChangePerc = oiDayChangePerc;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public void setOpenInterest(String openInterest) {
		this.openInterest = openInterest;
	}

	public void setPrevOpenInterest(String prevOpenInterest) {
		this.prevOpenInterest = prevOpenInterest;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setTotalBuyQty(int totalBuyQty) {
		this.totalBuyQty = totalBuyQty;
	}

	public void setTotalSellQty(int totalSellQty) {
		this.totalSellQty = totalSellQty;
	}

	public void setTsInMillis(long tsInMillis) {
		this.tsInMillis = tsInMillis;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setYearHighPrice(double yearHighPrice) {
		this.yearHighPrice = yearHighPrice;
	}

	public void setYearLowPrice(double yearLowPrice) {
		this.yearLowPrice = yearLowPrice;
	}

	public void setType(String type) {
		this.type = type;
	}
}
