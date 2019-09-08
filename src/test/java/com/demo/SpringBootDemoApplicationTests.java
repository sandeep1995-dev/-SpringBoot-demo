package com.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.controller.Example;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest()
public class SpringBootDemoApplicationTests {
	@Autowired
	private MockMvc mvc;
	
	@InjectMocks
	private Example ex;

	@Before
	public void setUp() throws Exception{
		mvc=MockMvcBuilders.standaloneSetup(ex).build();
 	}
	
	@Test
	public void getWelcome() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/welcome")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(MockMvcResultMatchers.status().isOk());
	      //.andExpect(MockMvcResultMatchers.jsonPath("$.welcome").exists());
	      //.andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
	}
}
