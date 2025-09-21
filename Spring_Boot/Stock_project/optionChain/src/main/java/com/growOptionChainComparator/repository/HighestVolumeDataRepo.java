package com.growOptionChainComparator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growOptionChainComparator.model.OptionChainData;
import com.growOptionChainComparator.model.highestVolumeData;

@Repository
public interface HighestVolumeDataRepo extends JpaRepository<OptionChainData, Long> {

	void save(highestVolumeData highestVolumeData);
}
