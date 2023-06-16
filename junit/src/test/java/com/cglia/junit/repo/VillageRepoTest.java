package com.cglia.junit.repo;

import static org.assertj.core.api.Assertions.assertThat;


import com.cglia.junit.App;
import com.cglia.junit.model.Village;
import com.cglia.junit.model.Zipcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class VillageRepoTest {
	
	@MockBean
	VillageRepo villageRepo;
	@Mock
	Village village;
	@Mock
	Zipcode zipcode;
	
	@Before
	public void setup() {
		zipcode = new Zipcode(10005, 500200);
		village = new Village(200, "Nand", 1000, 1, zipcode);
		villageRepo.save(village);
	}
	
	@After
	public void tearDown() {
		villageRepo.deleteAll();
	}
	
	@Test
	public void isVillageExistById() {
		Boolean actualResult = villageRepo.existsById(200);
		assertThat(actualResult).isTrue();
	}
	
	@Test
	public void isVillageExistByName() {
		Village checkVillage = villageRepo.findByVillageName("Nand");
		if (checkVillage != null) {
			assertThat(true).isTrue();
		} else {
			assertThat(false).isTrue();
		}
	}
	
}












