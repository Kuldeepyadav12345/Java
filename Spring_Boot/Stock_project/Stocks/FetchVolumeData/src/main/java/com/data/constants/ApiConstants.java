package com.data.constants;

public final class ApiConstants {
    private ApiConstants() {
        // Private constructor to prevent instantiation
    }

    public static final String BASE_URL = "http://localhost:8085/api/highestStrikePrice";
    
    public static String url;
    private static String strikePrice;

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ApiConstants.url = url;
    }

    public static String getStrikePrice() {
        return strikePrice;
    }

    public static void setStrikePrice(String strikePrice) {
        ApiConstants.strikePrice = strikePrice;
    }
}
