package com.cglia.reverse.dao;



import com.cglia.reverse.model.Village;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepo extends JpaRepository<Village, Integer> {

}
