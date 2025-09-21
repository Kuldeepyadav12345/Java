package com.growOptionChainComparator.repository;

import org.springframework.stereotype.Repository;

import com.growOptionChainComparator.model.LivePrice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

/**
 * The implementation of the DynamicPriceRepository interface.
 *
 * This class uses a native SQL query with JPA's EntityManager to dynamically
 * insert data into a specified table. This approach is necessary when the
 * table name is not known at compile time.
 */
@Repository
public class DynamicPriceRepositoryImpl implements DynamicPriceRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveToDynamicTable(String tableName, LivePrice livePrice) {
        // Build the dynamic SQL query. Note the table name is concatenated directly.
        // The parameters are handled safely via setParameter to prevent SQL injection.
        String sql = "INSERT INTO " + tableName +
                " (close, day_change, day_change_perc, high, high_price_range, " +
                " last_trade_qty, last_trade_time, low, low_price_range, ltp, " +
                " oi_day_change, oi_day_change_perc, open, symbol, total_buy_qty, " +
                " total_sell_qty, ts_in_mill_is, volume, year_high_price, year_low_price, type) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Create the native query and bind the parameters
        Query query = entityManager.createNativeQuery(sql);

        int paramIndex = 1;
        query.setParameter(paramIndex++, livePrice.getClose());
        query.setParameter(paramIndex++, livePrice.getDayChange());
        query.setParameter(paramIndex++, livePrice.getDayChangePerc());
        query.setParameter(paramIndex++, livePrice.getHigh());
        query.setParameter(paramIndex++, livePrice.getHighPriceRange());
        // Handle nullable fields
        query.setParameter(paramIndex++, livePrice.getLastTradeQty());
        query.setParameter(paramIndex++, livePrice.getLastTradeTime());
        query.setParameter(paramIndex++, livePrice.getLow());
        query.setParameter(paramIndex++, livePrice.getLowPriceRange());
        query.setParameter(paramIndex++, livePrice.getLtp());
        query.setParameter(paramIndex++, livePrice.getOiDayChange());
        query.setParameter(paramIndex++, livePrice.getOiDayChangePerc());
        query.setParameter(paramIndex++, livePrice.getOpen());
        query.setParameter(paramIndex++, livePrice.getSymbol());
        query.setParameter(paramIndex++, livePrice.getTotalBuyQty());
        query.setParameter(paramIndex++, livePrice.getTotalSellQty());
        query.setParameter(paramIndex++, livePrice.getTsInMillis());
        query.setParameter(paramIndex++, livePrice.getVolume());
        query.setParameter(paramIndex++, livePrice.getYearHighPrice());
        query.setParameter(paramIndex++, livePrice.getYearLowPrice());
        query.setParameter(paramIndex++, livePrice.getType());

        // Execute the insert query
        query.executeUpdate();
    }
}