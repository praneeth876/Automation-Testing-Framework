package com.Utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

/*
 * Asserts is used as Validations and checkpoints which compares the actual with expected conditions
 */

public class Validations {

	/**
	 * Used to validate whether the element is displayed or not
	 * 
	 * @param element
	 * @param trueOrfalse
	 * @param message
	 */
	public void isDisplayed(WebElement element, boolean trueOrfalse, String message) {
		Assert.assertEquals(element.isDisplayed(), trueOrfalse, message);
	}
	/**
	 * Used to validate whether the element is selected or not
	 * 
	 * @param element
	 * @param trueOrfalse
	 * @param message
	 */
	public void isSelected(WebElement element, boolean trueOrfalse, String message) {
		Assert.assertEquals(element.isSelected(), trueOrfalse, message);
	}

	/**
	 * Used to validate whether the element is Enabled or not
	 * 
	 * @param element
	 * @param trueOrfalse
	 * @param message
	 */
	public void isEnabled(WebElement element, boolean trueOrfalse, String message) {
		Assert.assertEquals(element.isEnabled(), trueOrfalse, message);
	}

	/**
	 * Used to validate whether the two elements text is equal or not
	 *  
	 * @param expected
	 * @param actual
	 * @param trueOrfalse
	 * @param message
	 */
	public void equals(String expected, String actual, boolean trueOrfalse, String message) {

		Assert.assertEquals(actual.equals(expected), trueOrfalse, message);
	}


	/**
	 * Used to validate whether the one element text contains on other element
	 * 
	 * @param expected
	 * @param actual
	 * @param trueOrfalse
	 * @param message
	 */
	public void contains(String expected, String actual, boolean trueOrfalse, String message) {

		Assert.assertEquals(actual.contains(expected), trueOrfalse, message);
	}

}
