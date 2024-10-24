package com.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Property file Utility class is used to read the data from the external file called property file 
 * which represents ".properties" file. This file stores the browser, Url, path locations etc.,
 * 
 * @author PraneethReddy
 * 
 */

public class PropertyFileUtiltity {

	FileInputStream file;
	public Properties prop;

	// Created constructor for initializing the file and load the Properties
	public PropertyFileUtiltity() {
		try {
			file = new FileInputStream("./src/main/resources/BigBasket.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Reading the browser data from properties file
	public String getBrowser() {
		return prop.getProperty("browser");
	}

	//Reading the Url data from properties file
	public String getAppUrl() {
		return prop.getProperty("url");
	}

	//Reading the excelPath data from properties file
	public String getExcelPath() {
		return prop.getProperty("excelPath");
	}

	//Reading the excelSheetName from properties file
	public String getSheetName() {
		return prop.getProperty("excelSheetName");
	}

	//Reading the reportPath from properties file
	public String getExtentReportPath() {

		return prop.getProperty("reportPath");
	}

}
