package com.Utilities;

import com.BaseClass.BaseTest;

/**
 * This class is used to create all the reusable methods which
 * is accepted by the java programming standards and can be created 
 * predefined and also user defined methods
 * 
 *@author PraneethReddy
 */

public class JavaUtility {	
	
	/**
	 * Program to remove alphabets and accepts only the below condition of characters
	 * 
	 * @param ProductPrice
	 * @return
	 */
	public String removeCharacters(String ProductPrice) {

		String temp = ProductPrice;
		char[] ch = temp.toCharArray();
		String tempString = " ";
		char a;
		for (int i = 0; i < ch.length; i++) {
			a = temp.charAt(i);

			if ((a >= '0' && a <= '9') || (a == '.')) {
				tempString = tempString + a;
			}
		}
		return tempString;
	}
}
