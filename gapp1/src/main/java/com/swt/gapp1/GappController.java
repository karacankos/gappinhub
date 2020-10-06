package com.swt.gapp1;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.swt.gapp1.gappdata.GappDataBasic;


@RestController
public class GappController {

	// Ref.: Building REST services with Spring
	// 
	// https://spring.io/guides/tutorials/bookmarks/
	@Autowired
	public RequestMappingHandlerMapping requestMappingHandlerMapping;
	@RequestMapping("/endpoints")
	public @ResponseBody
	Object showEndpointsAction() throws SQLException
	{
	        return requestMappingHandlerMapping.getHandlerMethods().keySet().stream().map(t ->
	               (t.getMethodsCondition().getMethods().size() == 0 ? "GET" : t.getMethodsCondition().getMethods().toArray()[0]) + " " +                    
	               t.getPatternsCondition().getPatterns().toArray()[0]
	        ).toArray();
	 }
    @Autowired
    private GappService gappService;
    ////
    // QUERIES
    ////
    @GetMapping("/gappdatabasics")
    ResponseEntity<List<GappDataBasic>> getAllToDos() {
        return new ResponseEntity<>(gappService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/gappdatabasicbytext/{text}")
    ResponseEntity<List<GappDataBasic>> getGappDataByText(@PathVariable String text) {
    	System.out.println("Text = "+text);
    	return new ResponseEntity<>(gappService.findByText(text), HttpStatus.OK);
    }
    
    @GetMapping("/gappdatabasicbyid/{id}")
    ResponseEntity<List<GappDataBasic>> getGappDataById(@PathVariable long id) {
    	System.out.println("Id = "+id);
    	return new ResponseEntity<>(gappService.findById(id), HttpStatus.OK);
    }
    
    @GetMapping("/gappdatabasicbyidinjson/{id}")
    ResponseEntity<String> getGappDataByIdInJson(@PathVariable long id) {
    	System.out.println("Id = "+id);
    	return new ResponseEntity<>(gappService.findByIdInJson(id), HttpStatus.OK);
    }
    
    @GetMapping("/gappdatabasicbycompleted/{completed}")
    ResponseEntity<List<GappDataBasic>> getGappDataByCompleted(@PathVariable boolean completed) {
    	System.out.println("completed = "+completed);
    	return new ResponseEntity<>(gappService.findByCompleted(completed), HttpStatus.OK);
    }
    ////
    // MODIFICATION 
    ////
    // save new
    // .. $ curl -X POST localhost:8080/gappdatabasics -H 'Content-type:application/json'
    // 								-d '{"id": "1", "text": "gardener", "completed": "true"}'
    // .. id is not relevant but must exist bec' it is unique
    
    // save new
    @PostMapping("/gappdatabasics")
    GappDataBasic postGappDataBasic(@RequestBody GappDataBasic newGappDataBasic) {
    	System.out.println("newGappDataBasic = "+newGappDataBasic);
    	return gappService.save(newGappDataBasic);
    }
    
    // update vie Id
    // CONT. https://www.concretepage.com/spring-boot/spring-boot-rest-example#PutMapping
    @PutMapping("/gappdatabasics/")
    GappDataBasic replaceGappDataBasic(	@RequestBody GappDataBasic newGappDataBasic, 
    									@PathVariable Long id) {
    	System.out.println("newGappDataBasic = "+newGappDataBasic);
    	return gappService.save(newGappDataBasic);
    }
    // delete via Id
    @DeleteMapping("/gappdatabasicsdeleteby/{id}")
    ResponseEntity<GappDataBasic> deleteEmployee(@PathVariable long id) {
    	System.out.println("id = "+id);
    	gappService.deleteById(id);
    	return ResponseEntity.noContent().build();
    }
}
