package com.swt.gapp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.swt.gapp1.gappdata.GappDataBasic;


@SpringBootTest
public class GappServiceTest {
	
	@MockBean
    private GappRepository gappRepository;
	
	@Test
	void getAllGappDatas(){
	    GappDataBasic aGappData = new GappDataBasic("GappData # 1",true);

    	// (1) define mocked behavior "gappRepository.findAll()" : service call "get a list of entities"
	    // 		https://www.infoworld.com/article/3543268/junit-5-tutorial-part-2-unit-testing-spring-mvc-with-junit-5.html
	    doReturn(Arrays.asList(aGappData)).when(gappRepository).findAll();
	    
	    //
	    GappService gappService = new GappService(gappRepository);
	    
	    List<GappDataBasic> gappDataList = gappService.findAll();
	    GappDataBasic lastGappData = gappDataList.get(gappDataList.size()-1);

	    assertEquals(aGappData.getText(), lastGappData.getText());
	    assertEquals(aGappData.isCompleted(), lastGappData.isCompleted());
	    assertEquals(aGappData.getId(), lastGappData.getId());
	}
	
	@Test
	void getGappDataByText(){
		String string = "GappData # 1";
	    GappDataBasic aGappData = new GappDataBasic(string,true);

    	// (1) define mocked behavior "gappRepository.findByText()" : service call "get a list of entities"
	    // 		https://www.infoworld.com/article/3543268/junit-5-tutorial-part-2-unit-testing-spring-mvc-with-junit-5.html
	    doReturn(Arrays.asList(aGappData)).when(gappRepository).findByText(string);
	    //
	    GappService gappService = new GappService(gappRepository);
	    
	    List<GappDataBasic> gappDataList = gappService.findByText(string);
	    GappDataBasic lastGappData = gappDataList.get(gappDataList.size()-1);

	    assertEquals(string, lastGappData.getText());

	}

}