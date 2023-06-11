package com.cglia.reverse.dao;



import com.cglia.reverse.model.Distict;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepo extends JpaRepository<Distict, Integer> {
	public List<Distict> findByDistictName(String name);
}
