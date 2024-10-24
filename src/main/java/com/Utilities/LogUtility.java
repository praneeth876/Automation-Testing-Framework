package com.Utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Log is used as reports to know the information about the test execution flow
 * 
 * @author PraneethReddy
 * 
 */

public class LogUtility {
	String LogFilepath = "C:\\Users\\PraneethReddyKatamre\\Desktop\\Automation Testing\\FlipKartApplication\\src\\main\\resources\\log4j.properties";
	Logger logger = Logger.getLogger(LogUtility.class);

	/**
	 * logger-info()
	 * 
	 * @param value
	 */
	public void info(String value) {
		PropertyConfigurator.configure(LogFilepath);
		logger.info(value);
	}

	/**
	 * logger-warn()
	 * 
	 * @param value
	 */
	public void warn(String value) {
		PropertyConfigurator.configure(LogFilepath);
		logger.warn(value);
	}

	/**
	 * logger-error()
	 * 
	 * @param value
	 */
	public void error(String value) {
		PropertyConfigurator.configure(LogFilepath);
		logger.error(value);
	}

	/**
	 * logger-fatal()
	 * 
	 * @param value
	 */
	public void fatal(String value) {
		PropertyConfigurator.configure(LogFilepath);
		logger.fatal(value);
	}
}
