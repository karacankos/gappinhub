package com.swt.gapp1.gappdata;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class GappDataAbstract {
    public GappDataAbstract() {
	}
/*	
	public String toJson(GappDataAbstract c) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(c);
	}
*/
	public String toJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(this);
	}

}
