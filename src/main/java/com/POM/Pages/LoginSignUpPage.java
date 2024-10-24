package com.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseTest;
import com.Utilities.ObjectRepository;

/**
 *This class contains all the methods used for login to Big Basket Application
 *
 *@author PraneethReddy
 */


public class LoginSignUpPage extends ObjectRepository {
	WebDriver driver;

	public LoginSignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLoginSignUpButton()  {
		webUtil.maximize();
		try {
			webUtil.implicitWait(10);
			webUtil.elementToBeClickable(20, loginSignUpButton);
			webUtil.javaScriptToClick(loginSignUpButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Login/SignIn Buton is successfully clicked");
	}
	public void enterUserLoginData(String userLoginData) {
		webUtil.keyBoardOperations("TAB");
		webUtil.keyBoardOperations("TAB");
		webUtil.elementToBeClickable(10, enterMobileNumber);
		try {
			webUtil.sendText(enterMobileNumber, userLoginData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("User data is entered");
	}

	public void clickOnContinueButton() {
		webUtil.elementToBeClickable(20, continueButton);
		try {
			webUtil.javaScriptToClick(continueButton);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void clickOnVerifyAndCountButton()  {
		webUtil.elementToBeClickable(10, verifyAndContinueButton);
		try {
			webUtil.javaScriptToClick(verifyAndContinueButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("OTP is entered successfully and successfully navigated to Home page");
	}
	
}
