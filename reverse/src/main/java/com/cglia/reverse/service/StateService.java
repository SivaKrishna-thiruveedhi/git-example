package com.cglia.reverse.service;


import com.cglia.reverse.dao.CapitalRepo;
import com.cglia.reverse.dao.DistrictRepo;
import com.cglia.reverse.dao.LanguageRepo;
import com.cglia.reverse.dao.StateRepo;
import com.cglia.reverse.model.Capital;
import com.cglia.reverse.model.Distict;
import com.cglia.reverse.model.Language;
import com.cglia.reverse.model.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateService {
	
	@Autowired
	StateRepo srepo;
	@Autowired
	CapitalRepo crepo;
	@Autowired
	DistrictRepo drepo;
	@Autowired
	LanguageRepo lrepo;
	
	public void saveState(State state) {				// one to one  &&  one to many save 
		crepo.save(state.getCapital());
		drepo.saveAll(state.getDistict());
		srepo.save(state);
	}

	public void changeCapital(int id, State state) {		// One to one  update
		Optional<State> st = srepo.findById(id);
		State st1 = st.get();
		Capital cap = st1.getCapital();
		if (cap != null) {
			cap.setCapitalName(null);
		}
		st1.setCapital(state.getCapital());
		crepo.save(st1.getCapital());
		srepo.save(st1);
	}

	public void updateStateWithDistricts(int id, State state) {		// one to many update
		Optional<State> st = srepo.findById(id);
		State st1 = st.get();
		st1.getDistict().forEach(district -> district.setState(null));
		st1.getDistict().clear();													// Clear existing districts
		state.getDistict().forEach(district -> district.setState(state));			// Update state reference in updated districts
		st1.setDistict(state.getDistict());	
		srepo.save(st1);
	}

	public void updateStateLanguages(int id, State state) {			// many to many update
		Optional<State> st = srepo.findById(id);
		State st1 = st.get();
//		List<Language> lang = lrepo.findAllById(state.getLanguage().forEach(language -> language.getLangID()));
//		st1.setLanguage(lang);
		srepo.save(st1);
	}

	public void deleteState(int id, State state) {					// 1-1 && 1-M delete
		Optional<State> st = srepo.findById(id);
		State st1 = st.get();
		Capital cap = st1.getCapital();
		if (cap != null) {
			st1.setCapital(null);			
		}
		List<Integer> dist = new ArrayList<>();
//		drepo.deleteAllById(state.getDistict().forEach(distict -> distict.getDistictId()));
		st1.getDistict().forEach(distict -> dist.add(distict.getDistictId()));
		drepo.deleteAllByIdInBatch(dist);
		
		srepo.delete(st1);
	}
}












