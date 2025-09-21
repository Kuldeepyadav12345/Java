package com.growOptionChainComparator.repository;

import org.springframework.stereotype.Repository;

import com.growOptionChainComparator.model.LivePrice;

/**
 * Custom repository interface for saving LivePrice data to dynamic tables.
 *
 * This interface defines a single method, `saveToDynamicTable`, which will be
 * implemented to handle the dynamic insertion logic. We do not extend a
 * standard JPA repository (e.g., JpaRepository) because our save logic is
 * custom.
 */
@Repository
public interface DynamicPriceRepository {

	/**
	 * Saves the provided LivePrice object to a dynamically determined table.
	 *
	 * @param tableName The name of the table to save the data to.
	 * @param livePrice The LivePrice object containing the data to be saved.
	 */
	void saveToDynamicTable(String tableName, LivePrice livePrice);
}
