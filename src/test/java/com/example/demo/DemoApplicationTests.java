package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.wipro.capstone.dao.CustomerDao;
import com.wipro.capstone.service.CustomerService;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@MockBean
	CustomerService cs;
	
	@Autowired
	CustomerDao cd;
	
	
	
}
