package com.cglia.junit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
	
	
	@Test
	public void contextLoads() {
	}

	@Autowired
	public WebApplicationContext webApplicationContext;

	public MockMvc mockMVC;

	@Before
	public void setup() throws Exception {
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void testGetOneVillage() throws Exception {
		String payload = "{\"villageId\":10003,\"villageName\":\"abc\",\"population\":10000,\"status\":1,\"zipcode\":{\"zipId\":10001,\"zipcode\":56000}}";

		mockMVC.perform(post("/village/v1/save").contentType(MediaType.APPLICATION_JSON).content(payload))
				.andExpect(status().isOk()).andReturn();

		mockMVC.perform(get("/village/v1/getone/{id}", 10003)).andExpect(status().isOk()).andReturn();
	}
	
}








//@Test
//public void fetchUserTest() throws Exception {
//	String payload = "{ \"empId\": 22, \"name\": \"maya\", \"email\": \"maya@gmail.com\", \"salary\": 200.00 }";
//
//	mockMVC.perform(post("/save").contentType(MediaType.APPLICATION_JSON).content(payload))
//			.andExpect(status().isOk()).andReturn();
//
//	mockMVC.perform(get("/getone/{id}", 22)).andExpect(status().isOk()).andReturn();
//}









