package com.POM.PagesTest;

import org.testng.annotations.BeforeMethod;

import com.BaseClass.BaseTest;
import com.POM.Pages.AddToBasket;
import com.POM.Pages.LoginSignUpPage;
import com.POM.Pages.ProductSelection;

public class POMObjects extends BaseTest{

	@BeforeMethod
	public void pomPageObjectsInitialization() {
		login = new LoginSignUpPage(driver);		
		product = new ProductSelection(driver);
		addToBasket = new AddToBasket(driver);
	}
	
}
