package com.sapient.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;


import com.sapient.rest.controller.CreditCardController;

@SpringBootTest
@AutoConfigureMockMvc
class RestApplicationTests {
	
	@Autowired
	private CreditCardController ccController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void contextLoads() {
		assertThat(ccController).isNotNull();
	}
	
	@Test
	public void getAllCardTest() throws Exception {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", "Basic dXNlcjpwYXNzd29yZA==");
		ResultActions rs =this.mockMvc.perform(get("/credit-cards").headers(httpHeaders))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());
		/*.andDo(MockMvcResultMatchers.content().toString());
				
		rs.andReturn().getResponse().*/
	}

}
