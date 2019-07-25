package com.sadullaev.webProject.propertiesLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BackendConnection {
	
	static Properties property = new Properties();
	private static String host;
	private static String port;

	public BackendConnection() {
		load();
	}
	
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

	public static String getHost() {
		return host;
	}

	public static String getPort() {
		return port;
	}
	
	
	
	
	
}

