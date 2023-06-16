package com.cglia.junit.controller;

import java.util.List;

import com.cglia.junit.model.Zipcode;
import com.cglia.junit.service.ZipcodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zipcode")
public class ZipcodeController {
	
	@Autowired
	ZipcodeService zipcodeService;
	
	@GetMapping("/v1")
	public List<Zipcode> getall(){
		return zipcodeService.getAllZipcodes();
	}
	
	@GetMapping("/v1/{zipid}")
	public Zipcode getOneById(@PathVariable int zipid){
		return zipcodeService.getOneZipcodeById(zipid);
	}
	
	@GetMapping("/v1/{zipcode}")
	public Zipcode getOne(@PathVariable int zipcode){
		return zipcodeService.getOneZipcode(zipcode);
	}
}
