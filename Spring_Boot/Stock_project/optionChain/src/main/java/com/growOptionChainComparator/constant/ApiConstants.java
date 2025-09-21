package com.growOptionChainComparator.constant;

public final class ApiConstants {
    private static String highestVolumeUrl;

	private ApiConstants() {
        // Private constructor to prevent instantiation
    }

    public static final String BASE_URL = "http://localhost:9012/api/highestStrikePrice";
    public static String HIGHEST_VOLUME_URL = highestVolumeUrl;
    public static int BANKNIFTY_LOT_SIZE = 35;
    public static int PROFIT_AMOUNT = 700;
    public static int lOSS_AMOUNT = 700;
    public static int GROW_CHARGES = 100;
    
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
