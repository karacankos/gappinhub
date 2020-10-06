package com.swt.gapp1;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.swt.gapp1.gappdata.GappDataBasic;

@Service
public class GappService {
	
	// --- The query creation mechanism for JPA ---
	// Ref.: 2. JPA Repositories
	// Part I. Reference Documentation
	// https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
	// Generic Queries ...
	private GappRepository gappRepository;
	
	public GappService(GappRepository gappRepository) {
		this.gappRepository = gappRepository;
	}
	//
	// QUERY SERVICES
	//
	public List<GappDataBasic> findAll() {	
		return gappRepository.findAll(); 
	}
	// select u from GappDataBasic u where u.text = ?1
	public List<GappDataBasic> findByText(String text) {	
		List<GappDataBasic> t = gappRepository.findByText(text);
		return t ;
	}
	
	public List<GappDataBasic> findById(long id) {	
		List<GappDataBasic> t = gappRepository.findById(id);
		return t ;
	}

	public List<GappDataBasic> findByCompleted(boolean completed) {
		List<GappDataBasic> t = gappRepository.findByCompleted(completed);
		return t ;
	}
	// ... finds by (unique) Id and converts into json
	public String findByIdInJson(long id) {
		List<GappDataBasic> t = gappRepository.findById(id);
		String ret = "";
		try {
			ret = t.get(0).toJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	//
	// MODIFICATION SERVICES
	//
	public GappDataBasic save(GappDataBasic newGappDataBasic) {
		return gappRepository.save(newGappDataBasic);
	}
	public void deleteById(Long id) {
		gappRepository.deleteById(id);
	}
	
	
}
