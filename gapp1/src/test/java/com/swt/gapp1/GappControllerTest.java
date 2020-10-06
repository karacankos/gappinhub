package com.swt.gapp1;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.swt.gapp1.gappdata.GappDataBasic;


// TO DO:
// ... tests for PUT POST DELETE, see
// ... Ref.:
// ... ... https://howtodoinjava.com/spring-boot2/testing/spring-boot-mockmvc-example/
//

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class GappControllerTest {

	    @Autowired
	    MockMvc mockMvc;

	    @MockBean
	    private GappService gappService;
		@MockBean
	    private GappRepository gappRepository;
	    
	    // TEST CASE: fetch all entities via GappService call 
	    //"GET /gappdatas, where GappService is behavior mocked!
	    @Test
	    void getAlls() throws Exception {
	    		    
	        // (1) prep Mock Data
	        List<GappDataBasic> gappDataList = new ArrayList<GappDataBasic>();
	        gappDataList.add(new GappDataBasic(1L,"GappData_Entity_1",true));
	        gappDataList.add(new GappDataBasic(2L,"GappData_Entity_2",true));
	        //
	        // (2) define mocked behavior "gappService.findAll()" : service call "get a list of entities"
            when(gappService.findAll()).thenReturn(gappDataList);

            // (3) call the Controller's endpoint "GET /gappdatabasics"
            mockMvc.perform(MockMvcRequestBuilders.get("/gappdatabasics")
                    .contentType(MediaType.APPLICATION_JSON)
            ).andExpect(jsonPath("$", hasSize(2))).andDo(print());

	    }

}
