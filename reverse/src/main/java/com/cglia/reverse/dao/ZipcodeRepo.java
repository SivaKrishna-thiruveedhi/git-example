package com.cglia.reverse.dao;



import com.cglia.reverse.model.Zipcode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodeRepo extends JpaRepository<Zipcode, Integer> {

}
