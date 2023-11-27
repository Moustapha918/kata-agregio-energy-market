package com.agregio.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KataApplicationTests {

	@Autowired
	private KataApplication kataApplication;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(kataApplication);
	}

}
