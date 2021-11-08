package com.example.demo;

import com.example.demo.model.DemoResult;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private DemoService service;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {

		assertThat(
			this.restTemplate.getForObject(
				"http://localhost:" + port + "/test",
				String.class
			)
		).contains("Hexagon find Prime Demo");

		DemoResult sr1 = this.service.getSieveResult(10);

		DemoResult sr2 = this.restTemplate.getForObject(
			"http://localhost:" + port + "/sieve/10",
			DemoResult.class
		);

		assertThat(sr1.primes)
		.isEqualTo(sr2.primes);

		assertThat(sr2.primes)
		.isEqualTo(
			new ArrayList<Integer>(
				Arrays.asList(new Integer[]{2,3,5,7})
			)
		);

		assertThat(sr1.multiplesLists)
		.isEqualTo(sr2.multiplesLists);
	}
}