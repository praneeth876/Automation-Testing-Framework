package com.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * ScreenShotUtility class is used to capture the screen shot when ever a test is failed 
 * and these are store in a seperate folder. so this is used as a proof of defect
 * 
 * @author PraneethReddy
 */

public class ScreenShotUtility {
	
	/**
	 * @param driver
	 * @param imageName
	 * @throws IOException
	 */
	public void captureScreenshot(WebDriver driver, String imageName) {

		TakesScreenshot sh = (TakesScreenshot) driver;
		try {
			File srcFile = sh.getScreenshotAs(OutputType.FILE);

			File destFile = new File("./defectScreenShots/" + imageName + ".png");

			FileUtils.copyFile(srcFile, destFile);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
