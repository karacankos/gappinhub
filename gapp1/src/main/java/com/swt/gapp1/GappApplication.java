package com.swt.gapp1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.swt.gapp1.gappdata.GappDataBasic;

@SpringBootApplication
public class GappApplication {

	public static void main(String[] args) {
		
		/*
		 * call http://localhost:8080/endpoints to see all endpoints
		 */
		System.out.println("---------------------------------------------------------");
		System.out.println("call http://localhost:8080/endpoints to see all endpoints");
		System.out.println("---------------------------------------------------------");
		
		SpringApplication.run(GappApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(GappRepository gappRepository) {
		return (args) -> {
			gappRepository.save(new GappDataBasic(0L,"--- GAPP DATA ---", true));
			gappRepository.save(new GappDataBasic(1L,"INITIAL DRAFT", true));
			gappRepository.save(new GappDataBasic(2L,"28.06.2020", false));
			gappRepository.save(new GappDataBasic(3L,"KARACAN", true));
		};
	}

}
