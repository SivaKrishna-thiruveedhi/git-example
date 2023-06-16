package com.cglia.junit.repo;

import com.cglia.junit.model.Zipcode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipcodeRepo extends JpaRepository<Zipcode, Integer> {
	Zipcode findByZipcode(int zipcode);
}
