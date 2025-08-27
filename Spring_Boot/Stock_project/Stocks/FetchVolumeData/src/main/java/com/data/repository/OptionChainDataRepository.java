package com.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.model.OptionChainData;

@Repository
public interface OptionChainDataRepository extends JpaRepository<OptionChainData, Long> {
}
