package com.cglia.reverse.dao;



import com.cglia.reverse.model.State;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository<State, Integer> {
	public List<State> findByStateName(String name);
}
