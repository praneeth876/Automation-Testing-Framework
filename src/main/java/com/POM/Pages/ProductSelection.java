package com.POM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseTest;
import com.Utilities.ObjectRepository;

/**
 *This class contains all the methods used for selecting a product and also validating the selected product
 *
 *@author PraneethReddy
 */

public class ProductSelection extends ObjectRepository {
	WebDriver driver;

	public ProductSelection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void hoverOnShopByCategory() throws InterruptedException {
		Thread.sleep(30000);
		webUtil.visibilityOfElement(20, ShopByCategory);
		webUtil.moveToElement(ShopByCategory);
		log.info("Successufully mouse hovered on Shop By Category DropDown");
	}

	public void chooseProductsubCategory() {
		webUtil.elementToBeClickable(10, productSubCategory);
		try {
			webUtil.javaScriptToClick(productSubCategory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Product sub category is successfully choosed and clicked");
	}

	public void selectProduct() {
		webUtil.elementToBeClickable(20, itemSelection);
		try {
			webUtil.javaScriptToClick(itemSelection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Product is successfully selected");
	}

	public void mouseHoverOnSelectedProduct() {
		webUtil.visibilityOfElement(10, viewSelectedProduct);
		try {
			webUtil.moveToElement(viewSelectedProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Mouse hover on selected element is done successfully");
	}

	public void productImageValidation() {
		webUtil.visibilityOfElement(20, productImageDisplay);
		validations.isDisplayed(productImageDisplay, true, "Product Image is not displayed");
		log.warn("Product image is displayed successfully");
	}

	public void getProductPrice() throws InterruptedException {
	
		webUtil.visibilityOfElement(5, productPrice);
		webUtil.scrollDown(0, 100);
		try {
			webUtil.moveToElement(productPrice);
			priceOfProduct = webUtil.getElementText(productPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
