package com.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.model.OptionData;

@Repository
public interface HighestVolumeDataRepo extends JpaRepository<OptionData, Long> {

}
