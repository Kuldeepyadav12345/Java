package com.data.model;

public class OptionVolumeData implements Comparable<OptionVolumeData> {
    private String url;
    private Long volume;
    private String strikePrice;

    public OptionVolumeData(String url, Long volume, String strikePrice) {
        this.url = url;
        this.volume = volume;
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

    public String getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(String strikePrice) {
        this.strikePrice = strikePrice;
    }

    @Override
    public int compareTo(OptionVolumeData other) {
        // Sort by volume in descending order (highest volume first)
        return other.volume.compareTo(this.volume);
    }

    @Override
    public String toString() {
        return "OptionVolumeData{" +
                "url='" + url + '\'' +
                ", volume=" + volume +
                ", strikePrice='" + strikePrice + '\'' +
                '}';
    }
}
