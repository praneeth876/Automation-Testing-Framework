package com.POM.PagesTest;

import org.testng.annotations.Test;
import com.BaseClass.BaseTest;
import com.POM.Pages.LoginSignUpPage;

/**
 * Calling all the methods which is declared in Product selection class
 * @author PraneethReddy
 *
 */
public class TC001_ProductSelectionTest extends POMObjects {

	@Test
	public void seclectingProduct() throws InterruptedException {
		login.clickOnLoginSignUpButton();
		login.enterUserLoginData(userLoginData);
		login.clickOnContinueButton();
		log.info("Successfully logged in to the Big Basket Application");
		product.hoverOnShopByCategory();
		product.chooseProductsubCategory();
		product.selectProduct();
		product.mouseHoverOnSelectedProduct();
		product.productImageValidation();
		product.getProductPrice();
		log.info("Product selection scenario is successfully executed");

	}
}
