package com.cglia.reverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.reverse.dao.DistrictRepo;
import com.cglia.reverse.dao.StateRepo;
import com.cglia.reverse.model.*;

@Service
public class DistictService {

	@Autowired
	DistrictRepo drepo;
	@Autowired
	StateRepo srepo;

	public void addDistict(Distict distict) {

		State state = distict.getState();

		List<State> check = srepo.findByStateName(state.getStateName());

		if (check == null) {

			srepo.save(state);
			drepo.save(distict);
			
		} else {
			drepo.save(distict);
		}
	}
}
