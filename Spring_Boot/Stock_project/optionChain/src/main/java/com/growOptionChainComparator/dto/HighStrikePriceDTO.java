package com.growOptionChainComparator.dto;

public class HighStrikePriceDTO {
	private String strikePrice;
	private String url;
	private Long volume;

	public HighStrikePriceDTO(String strikePrice, String url, Long volume) {
		this.strikePrice = strikePrice;
		this.url = url;
		this.volume = volume;
	}

	// Getters and setters
	public String getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(String strikePrice) {
		this.strikePrice = strikePrice;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}
}
