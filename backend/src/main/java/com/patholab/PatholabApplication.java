package com.patholab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.patholab.service.AdminService;

@SpringBootApplication
//@ComponentScan("com.patholab")
@EnableJpaAuditing
public class PatholabApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatholabApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AdminService srv) {
	    return (args) -> {
	    	if(srv.count()==0) {
	    		srv.createAdmin();
	    	}
	    };
	}

}
