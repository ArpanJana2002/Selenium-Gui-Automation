package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;

	static {
		try {
			loadProperties();
		} catch (IOException e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	private static void loadProperties() throws IOException {
		properties = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
		properties.load(fis);
		fis.close();
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
