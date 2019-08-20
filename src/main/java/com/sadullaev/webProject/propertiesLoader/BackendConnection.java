package com.sadullaev.webProject.propertiesLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BackendConnection {
	
	/*
	 * Instance variables
	 */
	
	static Properties property = new Properties();
	private static String host;
	private static String port;

	/**
	 * Constructor
	 */
	public BackendConnection() {
		load();
	}
	
	/**
	 * Function for load properties
	 */
	public static void load() {
		try {
            InputStream input = BackendConnection.class.getClassLoader().getResourceAsStream("backend_connect_config.properties");
            property.load(input);
            
            host = property.getProperty("host");
            port = property.getProperty("port");
            
		} catch (IOException e) {
            System.err.println("Properties fuer LSF nicht gefunden!");
        }
	}

	/**
	 * Getter function for host
	 * @return host
	 */
	public static String getHost() {
		return host;
	}

	/**
	 * Getter function for port
	 * @return port
	 */
	public static String getPort() {
		return port;
	}

}

