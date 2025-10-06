package com.data.constants;

public final class ApiConstants {
    private ApiConstants() {
        // Private constructor to prevent instantiation
    }

    public static final String HIGH_STRIKE_PRICE_URL = "http://localhost:9012/api/highestStrikePrice";
    public static final String BANKNIFTY_COMPANIES_DATA_URL = "http://localhost:9012/api/bankNiftyAllCompaniesData";
    public static final String BASE_URL = "http://localhost:8085/api/highestStrikePrice";
   
    public static String storedUrl;
    public static String storedStrikePrice;
    public static String url;
    public static String strikePrice;
    public static int predictionInputParamaters = 325;
    public static int predictionOutputParamaters = 1;
    public static double combinedDayChangedPercentage = 0;

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
