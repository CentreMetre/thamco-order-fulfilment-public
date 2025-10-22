package com.thamco.shop.order.fulfilment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FulfilmentApplicationTests {

	@Test
	void contextLoads() {
	}

	/**
	 * An always true test to make sure testing is working properly.
	 */
	@Test
	void successfulTest()
	{
		System.out.println("successfulTest");
		assertTrue(true);
	}

}
