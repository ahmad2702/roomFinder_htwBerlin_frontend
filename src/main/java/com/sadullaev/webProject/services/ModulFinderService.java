package com.sadullaev.webProject.services;

import com.sadullaev.webProject.propertiesLoader.BackendConnection;

public class ModulFinderService {

	private static String getUrl() {
		String url = "http://"
				+ BackendConnection.getHost()
				+ ":"
				+ BackendConnection.getPort();
		
		return url;
	}
	
	
	
}
