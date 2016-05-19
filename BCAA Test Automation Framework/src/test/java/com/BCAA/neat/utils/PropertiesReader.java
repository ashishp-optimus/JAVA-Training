package com.BCAA.neat.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class is used to Read the property from the config property
 * 
 * @author Optimus
 */
public class PropertiesReader {
	static Logger logger = Logger.getLogger(PropertiesReader.class);

	private static final String CONFIG_FILE_PATH = "\\src\\test\\java\\com\\BCAA\\neat\\config\\config.properties";
	private static final String CONFIG_PATH = System.getProperty("user.dir") + CONFIG_FILE_PATH;

	/**
	 * 
	 * @param propertyKey
	 *            it store the variable whoes value needs to be fetch
	 * @return
	 */
	public static String readProperty(String propertyKey) {
		logger.info("Inside readProperty method in PropertiesReader Class");
		String value = null;
		Properties config = new Properties();
		try (FileInputStream inputFile = new FileInputStream(CONFIG_PATH);) {
			config.load(inputFile);
			value = config.getProperty(propertyKey);
		} catch (IOException exception) {
			logger.warn(exception);

		}
		return value;

	}

}
