package com.cglia.junit.repo;

import com.cglia.junit.model.Village;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepo extends JpaRepository<Village, Integer> {
	
	Village findByVillageName(String name);
	
}
