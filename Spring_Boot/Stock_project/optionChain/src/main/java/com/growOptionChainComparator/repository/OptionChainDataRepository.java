package com.growOptionChainComparator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.growOptionChainComparator.model.OptionChainData;

@Repository
public interface OptionChainDataRepository extends JpaRepository<OptionChainData, Long> {
}
