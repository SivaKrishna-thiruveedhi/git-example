package com.cglia.junit.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.cglia.junit.model.Village;
import com.cglia.junit.repo.VillageRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VillageService {

	private static final Logger logger = Logger.getLogger(VillageService.class.getName());
	
	@Autowired
	VillageRepo villageRepo;
	
	public VillageService(VillageRepo villageRepo) {
		this.villageRepo = villageRepo;
	}

	public List<Village> getAllVillages() {
		return villageRepo.findAll();
	}

	public Village addVillage(Village village) {
		return villageRepo.save(village);
	}

	public Optional<Village> getOneVillage(int id) {
		logger.info("Get by id method is called by the controller - started");
		logger.info("Get by id method is called by the controller - ended");
		return villageRepo.findById(id);
	}

	public Village getVillageByName(String name) {
		logger.info("Get by village name method is called by the controller");
		return villageRepo.findByVillageName(name);
	}

	public String updateById(Village village, int id) {
		Village villa = villageRepo.findById(id).get();

		villa.setVillageName(village.getVillageName());
		villa.setPopulation(village.getPopulation());
		villa.setStatus(village.getStatus());
		villa.setZipcode(village.getZipcode());
		villageRepo.save(villa);
		return "updated";

	}

	public Village deleteById(int id) {
		Village villa = villageRepo.findById(id).get();
		villa.setStatus(0);
		return villageRepo.save(villa);
	}
}



















