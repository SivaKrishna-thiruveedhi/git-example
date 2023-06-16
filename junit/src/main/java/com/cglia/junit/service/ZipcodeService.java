package com.cglia.junit.service;

import java.util.List;

import com.cglia.junit.model.Zipcode;
import com.cglia.junit.repo.ZipcodeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZipcodeService {
	
	@Autowired
	ZipcodeRepo zipcodeRepo;

	public List<Zipcode> getAllZipcodes() {
		return zipcodeRepo.findAll();
	}

	public Zipcode getOneZipcode(int zipcode) {
		return zipcodeRepo.findByZipcode(zipcode);
	}

	public Zipcode getOneZipcodeById(int zipid) {
		return zipcodeRepo.findById(zipid).get();
	}
	
}
