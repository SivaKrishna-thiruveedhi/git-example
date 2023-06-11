package com.cglia.reverse.controller;

import com.cglia.reverse.model.City;
import com.cglia.reverse.model.Distict;
import com.cglia.reverse.model.State;
import com.cglia.reverse.service.CityService;
import com.cglia.reverse.service.DistictService;
import com.cglia.reverse.service.StateService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	StateService stateService;
	@Autowired
	CityService cityService;
	@Autowired
	DistictService distictService;
	
	@RequestMapping("/")
	public String home() {
		return "Hello";
	}
	
	@PostMapping("/state")
	public String home(@RequestBody State state) {
		stateService.saveState(state);
		return "State saved Successfully";
	}
	
	@PostMapping("/city")
	public String saveCity(@RequestBody City city) {
		cityService.addCity(city);
		return "City added Successfully";
	}
	
	@PostMapping("/distict")
	public String saveDistict(@RequestBody Distict distict) {
		distictService.addDistict(distict);
		return "Distict added successfully";
	}
	
	@PutMapping("/capital/{id}")
	public String updateCapital(@RequestBody State state, @PathVariable int id) {
		stateService.changeCapital(id, state);
		return "State Capital Updated Successfully";
	}
	
	@PutMapping("/disticts/{id}")
	public String updateDisticts(@RequestBody State state, @PathVariable int id) {
		stateService.updateStateWithDistricts(id, state);		
		return "Districts Updated Successfully";
	}
	
	@PutMapping("/distict/{id}")
	public String updateDistict(@RequestBody City city, @PathVariable int id) {
		cityService.updateCityDistrict(id, city);		
		return "District Updated Successfully";
	}
	
	@PutMapping("/languages/state/{id}")
	public String updateStateLanguages(@RequestBody State state, @PathVariable int id) {
		stateService.updateStateLanguages(id, state);		
		return "District Updated Successfully";
	}
	
	@DeleteMapping("/state/{id}")
	public String deleteState(@RequestBody State state, @PathVariable int id) {
		stateService.deleteState(id, state);
		return "State Deleted Successfully";
	}
} 
















