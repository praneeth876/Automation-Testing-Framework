package com.Utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.BaseClass.BaseTest;

/**
 * Object repository class is used to store all the locators of an application as objects
 *
 * @author PraneethReddy
 */

public class ObjectRepository extends BaseTest {

	// Login page locators
	@FindBy(css = "div[class=\"col-md-12 pad-0\"] [class=\"pull-right\"] [class=\"list-unstyled list-inline login-section\"]")
	public WebElement loginSignUpButton;
	@FindBy(css = "input#otpEmail")
	public WebElement enterMobileNumber;
	@FindBy(css = "button[class=\"btn btn-default login-btn\"]")
	public WebElement continueButton;
	@FindBy(css = "button[class=\"btn btn-default btn-lg login-btn fixed-btn\"]")
	public WebElement verifyAndContinueButton;

	// Production selection locators
	@FindBy(css = "a[class=\"dropdown-toggle meganav-shop\"]")
	public WebElement ShopByCategory;
	@FindBy(xpath = "//div[@class=\"tabbable col-md-12 pad-rt-0\"]/following::a[text()='Potato, Onion & Tomato']")
	public WebElement productSubCategory;
	@FindBy(xpath = "//a[text()='Onion (Loose)']")
	public WebElement itemSelection;
	@FindBy(css = "[class=\"_7NzDu\"] [class=\"d8V7B\"]")
	public WebElement viewSelectedProduct;
	@FindBy(css = "[class=\"_16DQ1\"]")
	public WebElement productImageDisplay;
	@FindBy(css = "[data-qa=\"productPrice\"]")
	public WebElement productPrice;

	// Add to basket locators
	@FindBy(css = "[class=\"Cs6YO rippleEffect\"]")
	public WebElement AddToBasketElement;
	@FindBy(css = "div.eubx4")
	public WebElement myBasket;
	@FindBy(css = ".sOXt1")
	public WebElement myBasketDetailsDisplay;
	@FindBy(css = ".OMMEI._3bj9B.rippleEffect")
	public WebElement viewBasketAndCheckOut;
	@FindBy(css = "span#finalTotal")
	public WebElement totalPriceElement;
	@FindBy(css = "input[class=\"text-change-qty-search-popup\"]")
	public WebElement productQuantity;
	@FindBy(css = "button[qa=\"decBaskQty\"]")
	public WebElement decreaseProductQuantity;
	@FindBy(css = "a[qa=\"emptyBasketBSKT\"]")
	public WebElement emptyBasket;
	@FindBy(css = "[class=\"uiv2-popup-alert\"] [id=\"alert_ok\"]")
	public WebElement deletePopUp;
	@FindBy(css = "[id=\"empty_message\"] [class=\"uiv2-title-basketwrap\"]")
	public WebElement message;

}
