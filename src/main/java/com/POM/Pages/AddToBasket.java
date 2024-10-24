package com.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.Utilities.ObjectRepository;

/**
 *This class contains all the methods used for adding the selected product to Basket 
 *and also validating the product price in the basket
 *
 *@author PraneethReddy
 */

public class AddToBasket extends ObjectRepository {
	WebDriver driver;

	public AddToBasket(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddToBasketButton() throws InterruptedException {
		System.out.println("Price in add to basket class" + priceOfProduct);
		webUtil.elementToBeClickable(30, AddToBasketElement);
		try {
			webUtil.javaScriptToClick(AddToBasketElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Product to added to the basket");
	}

	public void mouseHoverOnMyBasket() {
		webUtil.visibilityOfElement(10, myBasket);
		webUtil.scrollDown(200, 0);
		try {
			webUtil.moveToElement(myBasket);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Mouse hovering on the My basket");
	}

	public void validateMouseHoverOnMyBasket() {
		validations.isDisplayed(myBasketDetailsDisplay, true, "Product added details is not displayed");
		log.info("Product details is successfully displayed");
	}

	public void clickOnViewBasketAndCheckOutButton() {
		webUtil.elementToBeClickable(10, viewBasketAndCheckOut);
		try {
			webUtil.javaScriptToClick(viewBasketAndCheckOut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("successfully clicked on view Basket And CheckOut button");
	}

	public void basketPageValidation() {
		basketPageUrl = webUtil.getCurrentWindowUrl();
		validations.contains(basketPageText, basketPageUrl, true, "Navigated to the basket page");
	}

	public void getTotalProductPrice() {
		price = javaUtil.removeCharacters(priceOfProduct);
		System.out.println("Price after coverted :" + price);
		totalPriceOfProduct = webUtil.getElementText(totalPriceElement);
		System.out.println("total price " + totalPriceOfProduct);
	}

	public void priceValidation() {

		validations.contains(price, totalPriceOfProduct, true, "Product price is not matched");
		log.fatal("Product price is matched");

	}

	public void clearBasket() {
		try {
			webUtil.visibilityOfElement(10, productQuantity);
			String itemQuantity = webUtil.getElementText(productQuantity);
			String quantity = "1";
			if (itemQuantity.equals(quantity)) {
				webUtil.elementToBeClickable(10, decreaseProductQuantity);
				webUtil.javaScriptToClick(decreaseProductQuantity);
			} else {
				webUtil.elementToBeClickable(30, emptyBasket);
				webUtil.javaScriptToClick(emptyBasket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnEmptyPopUpOkButton() {
		try {
			webUtil.elementToBeClickable(30, deletePopUp);
			webUtil.javaScriptToClick(deletePopUp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void emptyBasketValidation() {
		try {
			webUtil.visibilityOfElement(15, message);
			emptyBasketMessage = webUtil.getElementText(message);
			validations.isDisplayed(message, true, emptyBasketMessage + " is not displayed");
			log.error("Empty basket message is displayed successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.fatal("Items are deleted successfully in the basket");
	}

}
