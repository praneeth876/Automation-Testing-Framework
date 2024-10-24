package com.POM.PagesTest;

import org.testng.annotations.Test;

/**
 * Calling all the methods which is declared in Add Basket class
 * 
 * @author PraneethReddy
 *
 */
public class TC002_AddToBasketTest extends POMObjects {
	@Test
	public void addProductToBasket() throws InterruptedException {
		
		login.clickOnLoginSignUpButton();
		login.enterUserLoginData(userLoginData);
		login.clickOnContinueButton();
		log.info("Successfully logged in to the Big Basket Application");
		product.hoverOnShopByCategory();
		product.chooseProductsubCategory();
		product.selectProduct();
		product.getProductPrice();
		addToBasket.clickOnAddToBasketButton();
		addToBasket.mouseHoverOnMyBasket();
		addToBasket.clickOnViewBasketAndCheckOutButton();
		addToBasket.getTotalProductPrice();
		addToBasket.priceValidation();
		addToBasket.clearBasket();
		addToBasket.clickOnEmptyPopUpOkButton();
		addToBasket.emptyBasketValidation();
		log.info("Add to basket scenario is successfully executed");

	}

}
