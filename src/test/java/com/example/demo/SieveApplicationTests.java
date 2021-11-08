package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.controller.DemoRestController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class SieveApplicationTests {

	@Autowired
	private DemoRestController demoRestController;

	@Test
	void contextLoads() {
		assertThat(demoRestController).isNotNull();
	}

}
