package com.cglia.junit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.cglia.junit.App;
import com.cglia.junit.model.Village;
import com.cglia.junit.model.Zipcode;
import com.cglia.junit.repo.VillageRepo;
import com.cglia.junit.repo.ZipcodeRepo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class VillageServiceTest {

	@MockBean
	private VillageRepo villageRepo;
	@Mock
	private ZipcodeRepo ziprepo;
	@Mock
	Village village;
	@Mock
	Zipcode zipcode;
	private VillageService villageService;
	AutoCloseable autoCloseable;
	
		
	@Before
	public void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
		villageService = new VillageService(villageRepo);
		zipcode = new Zipcode(10001, 56000);
		village = new Village(10003, "abc", 10000, 1, zipcode);
	}

	@After
	public void tearDown() throws Exception {
		autoCloseable.close();
		villageRepo.deleteAll();
	}
	
	
	// save -- Successful test case
	@Test
	public void testAddVillageSuccessful() {
		when(villageRepo.save(village)).thenReturn(village);
		assertThat(villageService.addVillage(village).getVillageId()).isEqualTo(village.getVillageId());
	}
	
	// save -- failure test case
	@Test
	public void testAddVillageFailure() {
		Village smallvillage = new Village();
		when(villageRepo.save(smallvillage)).thenReturn(null);
		assertThat(smallvillage.getVillageName()).isNull();
	}
		
	
	// getById -- Successful test case
	@Test
	public void testGetOneVillage() {
		when(villageRepo.findById(village.getVillageId())).thenReturn(Optional.ofNullable(village));
		assertThat(villageService.getOneVillage(10003)).isEqualTo(village);
	}
	
	
	// getById -- Failure test case
	@Test
	public void testGetOneVillageFailure() {
		when(villageRepo.findById(10000000)).thenThrow(new NoSuchElementException());
		assertThrows(NoSuchElementException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				villageService.getOneVillage(10000000);
			}
		});
	}
	
	
	// getByVillageName -- Successful test case
	@Test
	public void testGetVillageByName() {
		when(villageRepo.findByVillageName(village.getVillageName())).thenReturn(village);
		assertThat(villageService.getVillageByName("abc")).isEqualTo(village);
	}
	
	
	// getByVillageName -- Failure test case
	@Test
	public void testGetVillageByNameFailure() {
		when(villageRepo.findByVillageName("SivaKrishna")).thenThrow(new NoSuchElementException());
		assertThrows(NoSuchElementException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				villageService.getVillageByName("SivaKrishna");
			}
		});
	}
	
	
	// UpdateById -- Successful test case
	@Test
	public void testUpdateById() {
		when(villageRepo.findById(5)).thenReturn(Optional.ofNullable(village));
		when(villageRepo.save(village)).thenReturn(village);
		assertThat(villageService.updateById(village, 5)).isEqualTo("updated");
		
	}
	
}





















