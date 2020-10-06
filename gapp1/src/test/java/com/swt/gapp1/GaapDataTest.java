package com.swt.gapp1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.swt.gapp1.gappdata.GappDataBasic;

class GaapDataTest {

	@Test
	void test_GappDataBasicToJson() {
		String js = null;
		GappDataBasic db = new GappDataBasic(2L,"28.06.2020", false);
		try {
			js = db.toJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			js = "failed";
		}
		// expected output: {"id":2,"text":"28.06.2020","completed":false}
		String exOutput = "{\"id\":2,\"text\":\"28.06.2020\",\"completed\":false}";
		//System.out.println(js);
		assertEquals(exOutput, js);
	}

}
