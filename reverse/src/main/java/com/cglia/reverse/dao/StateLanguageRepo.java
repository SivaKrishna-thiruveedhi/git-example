package com.cglia.reverse.dao;



import com.cglia.reverse.model.State_language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateLanguageRepo extends JpaRepository<State_language, Integer> {

}
