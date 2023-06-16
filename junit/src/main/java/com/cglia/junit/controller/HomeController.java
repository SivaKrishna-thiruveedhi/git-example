package com.cglia.junit.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.cglia.junit.model.Village;
import com.cglia.junit.service.VillageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/village")
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class.getName());
	Optional<Village> village;
	
	@Autowired
	VillageService villageService;
		
	@GetMapping("/v1")
	public List<Village> getall() {
		logger.info("Get all villages is invoked");
		List<Village> villa = villageService.getAllVillages();
		if (villa != null) {
			return villa;
		} else {
			return null;
		}
	}
	
	@PostMapping("/v1/save")
	public String save(@RequestBody Village village) {
		Village villa = villageService.addVillage(village);
		if (villa != null ) {
			return "Village Added";
		} else {
			return "Village not added";
		}
	}
	
	@GetMapping("/v1/getone/{id}")
	public Village getOneVillage(@PathVariable int id) {
		logger.info("Get by villageId is mapped");
		village = villageService.getOneVillage(id);
		logger.info("Get by villageId is Done");
		if (village != null) {
			return village.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/v1/getbyname/{name}")
	public Village getByName(@PathVariable String name) {
		logger.info("Get by village name is mapped");
		Village villa = villageService.getVillageByName(name);
		if (villa != null) {
			return villa;
		} else {
			return null;
		}
	}
	
	@PutMapping("/v1/{id}")
	public String updateById(@RequestBody Village village, @PathVariable int id) {
		String msg = villageService.updateById(village, id);
		if (msg.equals("updated")) {
			return "Update Successfull";
		} else {
			return "Not updated";
		}
	}
	
	@DeleteMapping("/v1/{id}")
	public String delete(@PathVariable int id) {
		Village villa = villageService.deleteById(id);
		if (villa != null) {
			return "Deleted Successfully";
		} else {
			return "Not deleted";
		}
	}
}





















