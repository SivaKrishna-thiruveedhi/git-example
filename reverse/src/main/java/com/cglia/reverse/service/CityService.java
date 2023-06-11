package com.cglia.reverse.service;

import com.cglia.reverse.dao.*;
import com.cglia.reverse.model.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
	
	@Autowired
	CityRepo cityrepo;
	@Autowired
	DistrictRepo drepo;

	
	public void addCity(City city) {							// many to one save
		Distict dist = city.getDistict();
		
		List<Distict> check = drepo.findByDistictName(dist.getDistictName());
		
		if (check == null) {
			drepo.save(dist);
			cityrepo.save(city);
		} else {
			cityrepo.save(city);	
		}
	}
	
	public void updateCityDistrict(int id, City city) {				// many to one update
		Optional<City> st = cityrepo.findById(id);
		City c1 = st.get();
		
		Optional<Distict> di = drepo.findById(c1.getDistict().getDistictId());
		Distict dist = di.get();
		
		c1.setDistict(dist);
		cityrepo.save(c1);
	}
}


