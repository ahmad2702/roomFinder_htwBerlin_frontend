package com.sadullaev.webProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.sadullaev.webProject.propertiesLoader.BackendConnection;

@SpringBootApplication
public class WebProjectApplication extends SpringBootServletInitializer {
	
	/**
	 * Configuring of Build Process
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebProjectApplication.class);
	}

	/**
	 * Application Launcher
	 * @param args
	 */
	public static void main(String[] args) {
		new BackendConnection();
		
		SpringApplication.run(WebProjectApplication.class, args);
		
		System.out.println("Started!");
	}

}
