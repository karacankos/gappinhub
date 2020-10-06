package com.swt.gapp1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swt.gapp1.gappdata.GappDataBasic;

@Repository("gappRepository")
public interface  GappRepository extends JpaRepository<GappDataBasic, Long> {

	// -- FIND
	List<GappDataBasic> findById(long id);

	List<GappDataBasic> findByText(String text);

	List<GappDataBasic> findByCompleted(boolean completed);
	// -- SAVE 
	
	
}
