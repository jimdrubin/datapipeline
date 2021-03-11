package com.jdr.statedata;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class StatedataApplicationTests {

	@Test
	void correct_number_of_districts() {
		ReadExcel reade = new ReadExcel();
		District[] dists = reade.getDistrictData();
		assertEquals(436,dists.length);
	}

}
