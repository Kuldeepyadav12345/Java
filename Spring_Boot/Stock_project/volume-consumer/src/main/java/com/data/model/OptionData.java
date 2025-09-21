package com.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "HIGHEST_VOLUME_DATA")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "opt_data_seq")
    @SequenceGenerator(name = "opt_data_seq", sequenceName = "OPT_DATA_SEQ", allocationSize = 1)
    private Long id;

    private String type;
    private String symbol;
    private Long tsInMillis;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double ltp;
    private Double dayChange;
    private Double dayChangePerc;
    private Double lowPriceRange;
    private Double highPriceRange;
    private Long volume;
    private Double lowTradeRange;
    private Double highTradeRange;
    private Long totalBuyQty;
    private Long totalSellQty;
    private Double openInterest;
    private Double prevOpenInterest;
    private Double oiDayChange;
    private Double oiDayChangePerc;
    private Long lastTradeQty;
    private Long lastTradeTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Long getTsInMillis() {
		return tsInMillis;
	}
	public void setTsInMillis(Long tsInMillis) {
		this.tsInMillis = tsInMillis;
	}
	public Double getOpen() {
		return open;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	public Double getLow() {
		return low;
	}
	public void setLow(Double low) {
		this.low = low;
	}
	public Double getClose() {
		return close;
	}
	public void setClose(Double close) {
		this.close = close;
	}
	public Double getLtp() {
		return ltp;
	}
	public void setLtp(Double ltp) {
		this.ltp = ltp;
	}
	public Double getDayChange() {
		return dayChange;
	}
	public void setDayChange(Double dayChange) {
		this.dayChange = dayChange;
	}
	public Double getDayChangePerc() {
		return dayChangePerc;
	}
	public void setDayChangePerc(Double dayChangePerc) {
		this.dayChangePerc = dayChangePerc;
	}
	public Double getLowPriceRange() {
		return lowPriceRange;
	}
	public void setLowPriceRange(Double lowPriceRange) {
		this.lowPriceRange = lowPriceRange;
	}
	public Double getHighPriceRange() {
		return highPriceRange;
	}
	public void setHighPriceRange(Double highPriceRange) {
		this.highPriceRange = highPriceRange;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public Double getLowTradeRange() {
		return lowTradeRange;
	}
	public void setLowTradeRange(Double lowTradeRange) {
		this.lowTradeRange = lowTradeRange;
	}
	public Double getHighTradeRange() {
		return highTradeRange;
	}
	public void setHighTradeRange(Double highTradeRange) {
		this.highTradeRange = highTradeRange;
	}
	public Long getTotalBuyQty() {
		return totalBuyQty;
	}
	public void setTotalBuyQty(Long totalBuyQty) {
		this.totalBuyQty = totalBuyQty;
	}
	public Long getTotalSellQty() {
		return totalSellQty;
	}
	public void setTotalSellQty(Long totalSellQty) {
		this.totalSellQty = totalSellQty;
	}
	public Double getOpenInterest() {
		return openInterest;
	}
	public void setOpenInterest(Double openInterest) {
		this.openInterest = openInterest;
	}
	public Double getPrevOpenInterest() {
		return prevOpenInterest;
	}
	public void setPrevOpenInterest(Double prevOpenInterest) {
		this.prevOpenInterest = prevOpenInterest;
	}
	public Double getOiDayChange() {
		return oiDayChange;
	}
	public void setOiDayChange(Double oiDayChange) {
		this.oiDayChange = oiDayChange;
	}
	public Double getOiDayChangePerc() {
		return oiDayChangePerc;
	}
	public void setOiDayChangePerc(Double oiDayChangePerc) {
		this.oiDayChangePerc = oiDayChangePerc;
	}
	public Long getLastTradeQty() {
		return lastTradeQty;
	}
	public void setLastTradeQty(Long lastTradeQty) {
		this.lastTradeQty = lastTradeQty;
	}
	public Long getLastTradeTime() {
		return lastTradeTime;
	}
	public void setLastTradeTime(Long lastTradeTime) {
		this.lastTradeTime = lastTradeTime;
	}
	@Override
	public String toString() {
		return "OptionData [id=" + id + ", type=" + type + ", symbol=" + symbol + ", tsInMillis=" + tsInMillis
				+ ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close + ", ltp=" + ltp
				+ ", dayChange=" + dayChange + ", dayChangePerc=" + dayChangePerc + ", lowPriceRange=" + lowPriceRange
				+ ", highPriceRange=" + highPriceRange + ", volume=" + volume + ", lowTradeRange=" + lowTradeRange
				+ ", highTradeRange=" + highTradeRange + ", totalBuyQty=" + totalBuyQty + ", totalSellQty="
				+ totalSellQty + ", openInterest=" + openInterest + ", prevOpenInterest=" + prevOpenInterest
				+ ", oiDayChange=" + oiDayChange + ", oiDayChangePerc=" + oiDayChangePerc + ", lastTradeQty="
				+ lastTradeQty + ", lastTradeTime=" + lastTradeTime + "]";
	}

  
    
}
