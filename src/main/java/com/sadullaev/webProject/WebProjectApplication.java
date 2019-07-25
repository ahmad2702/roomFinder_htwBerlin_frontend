package com.sadullaev.webProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.sadullaev.webProject.propertiesLoader.BackendConnection;

@SpringBootApplication
public class WebProjectApplication extends SpringBootServletInitializer {
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebProjectApplication.class);
	}

	
	public static void main(String[] args) {
		new BackendConnection();
		
		SpringApplication.run(WebProjectApplication.class, args);
		
		System.out.println("Started!");
	}

}
