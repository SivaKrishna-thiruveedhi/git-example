package com.cglia.junit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.cglia.junit.model.Village;
import com.cglia.junit.model.Zipcode;
import com.cglia.junit.repo.VillageRepo;
import com.cglia.junit.service.VillageService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

	@Autowired
	public MockMvc mockMvc;
	@MockBean
	private VillageRepo villageRepo; 
	@MockBean
	private VillageService villageService;
	Village villageOne;
	Village villageTwo;
	Village village;
	Zipcode zipcodeOne;
	Zipcode zipcodeTwo;
	
	List<Village> villageList = new ArrayList<>();
	
	
	@Before
	public void setUp() throws Exception {
		zipcodeOne = new Zipcode(10001, 56000);
		villageOne = new Village(10003, "abc", 10000, 1, zipcodeOne);
		
		zipcodeTwo = new Zipcode(10002, 76000);
		villageTwo = new Village(10004, "xyz", 90000, 1, zipcodeTwo);
		
		villageRepo.save(villageOne);
		villageRepo.save(villageTwo);
		
		villageList.add(villageOne);
		villageList.add(villageTwo);
	}

	@Test
	public void testGetOneVillage() throws Exception {
		
//		when(villageService.getOneVillage(10004)).thenCallRealMethod();
//		when(villageRepo.findById(10004)).thenReturn(Optional.of(villageTwo));
//		mockMvc.perform( MockMvcRequestBuilders
//			      .get("/village/v1/getone/{id}", 10004))
//		      .andDo(print())
//		      .andExpect(status().isOk());
		
		String payload = "{\"villageId\":10003,\"villageName\":\"abc\",\"population\":10000,\"status\":1,\"zipcode\":{\"zipId\":10001,\"zipcode\":56000}}";

		mockMvc.perform(post("/village/v1/save").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(status().isOk()).andReturn();

		mockMvc.perform(get("/village/v1/getone/{id}", 10003)).andExpect(status().isOk()).andReturn();
		
	}

//	@Test
//	public void testGetByName() throws Exception {
//		when(villageService.getVillageByName("abc")).thenReturn(villageOne);
//		mockMvc.perform( MockMvcRequestBuilders
//			      .get("/village/v1/getbyname/{name}", "abc"))
//		      .andDo(print())
//		      .andExpect(content().json("{\"villageId\":10003,\"villageName\":\"abc\",\"population\":10000,\"status\":1,\"zipcode\":{\"zipId\":10001,\"zipcode\":56000}}"));
//		
//	}
//	
//	@Test
//	public void testGetAllVillages() throws Exception {
//		when(villageService.getAllVillages()).thenReturn(villageList);
//		mockMvc.perform(MockMvcRequestBuilders
//				.get("/village/v1"))
//			.andDo(print())
//			.andExpect(status().isOk());
//	}
//	
	
}



























