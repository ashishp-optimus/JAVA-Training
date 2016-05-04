package com.BCAA.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	private static final String CONFIG_FILE_PATH = "\\src\\com\\BCAA\\config\\config.properties";
	private static final String CONFIG_PATH = System.getProperty("user.dir") + CONFIG_FILE_PATH;

	public static String readProperty(String propertyKey) {

		String value = null;
		Properties config = new Properties();
		try (FileInputStream inputFile = new FileInputStream(CONFIG_PATH);) {
			config.load(inputFile);
			value = config.getProperty(propertyKey);
		} catch (IOException exception) {
			// TODO: 
			exception.printStackTrace();
		}
		return value;

	}

}
