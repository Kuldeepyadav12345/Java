package com.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.model.BankNiftyCompaniesData;

@Repository
public interface BankNiftyCompaniesDataRepo extends JpaRepository<BankNiftyCompaniesData, Long> {

}
