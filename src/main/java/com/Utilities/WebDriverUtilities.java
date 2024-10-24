package com.Utilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The functions that performs different actions across the automation execution
 * these utilities are getting from the webdriver interface
 * 
 * @author PraneethReddy
 */

public class WebDriverUtilities {
	WebDriver driver;
	Select select;
	Actions action;
	JavascriptExecutor jS;
	WebDriverWait wait;

	public WebDriverUtilities(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Implicit Wait- Time given to load all the elements and execute when loaded
	 * 
	 * @param time
	 */
	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	/**
	 * Maximize() is used to maximize the window
	 */
	public void maximize() {
		driver.manage().window().maximize();
	}

	/**
	 * Explicit Wait- wait until element to be clickable
	 * 
	 * @param time
	 * @param element
	 */
	public void elementToBeClickable(int time, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Explicit Wait- wait until visibility Of Element
	 * 
	 * @param time
	 * @param element
	 */
	public void visibilityOfElement(int time, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Explicit Wait- wait until in visibility Of Element
	 * 
	 * @param time
	 * @param locator
	 */
	public void invisibilityOfElementLocated(int time, By locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	/**
	 * Thread sleep (Holding the execution for specific time)
	 * 
	 * @param time
	 */
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Drop Down - select by Value (Select Class)
	 * 
	 * @param element
	 * @param Value
	 */
	public void selectByValue(WebElement element, String Value) {
		select = new Select(element);
		select.selectByValue(Value);
	}

	/**
	 * Drop Down - select by Visual Text (Select Class)
	 * 
	 * @param element
	 * @param Value
	 */
	public void selectByVisibleText(WebElement element, String Value) {
		select = new Select(element);
		select.selectByVisibleText(Value);
	}

	/**
	 * Drop Down - select by Index (Select Class)
	 * 
	 * @param element
	 * @param Value
	 */
	public void selectByIndex(WebElement element, int Value) {
		select = new Select(element);
		select.selectByIndex(Value);
	}

	/**
	 * moveToElement() is used for moving cursor from one element to other element
	 * 
	 * @param element
	 */
	public void moveToElement(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	/**
	 * dragAndDrop() is used to drag element from one place and drop it in other
	 * place
	 * 
	 * @param dragElement
	 * @param dropElement
	 */
	public void dragAndDrop(WebElement dragElement, WebElement dropElement) {
		action = new Actions(driver);
		action.dragAndDrop(dragElement, dropElement).build().perform();

	}

	/**
	 * Keyboard Operations by using Actions class
	 * 
	 * @param button
	 */
	public void keyBoardOperations(String button) {
		action = new Actions(driver);
		action.sendKeys(Keys.valueOf(button)).build().perform();
	}

	/**
	 * Driver is switching to other frame
	 * 
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * Driver is switching back to default page
	 */
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}

	/**
	 * javascript method used to click web element
	 * 
	 * @param element
	 */
	public void javaScriptToClick(WebElement element) {

		jS = (JavascriptExecutor) driver;
		jS.executeScript("arguments[0].click();", element);
		element.click();
	}

	/**
	 * javascript method used to write the value and attribute in the html
	 * properties by passing certain arguments as parameters
	 * 
	 * @param arguments
	 * @param element
	 */
	public void elementNotInteractable(String arguments, WebElement element) {
		jS = (JavascriptExecutor) driver;
		jS.executeScript(arguments, element);
	}

	/**
	 * Javascript method used to scroll the page using co-ordinates
	 * 
	 * @param minRange
	 * @param maxRange
	 */
	public void scrollDown(int minRange, int maxRange) {
		jS = (JavascriptExecutor) driver;
		jS.executeScript("window.scrollTo(" + minRange + "," + maxRange + ")");
	}

	/**
	 * getText() method is used to get the text of an element
	 * 
	 * @param element
	 * @return
	 */
	public String getElementText(WebElement element) {
		return element.getText();
	}

	/**
	 * click() method is used to perform click operation on given element
	 * 
	 * @param element
	 */
	public void clickElement(WebElement element) {
		element.click();
	}

	/**
	 * sendkeys() method is used to give the input data to elements
	 * 
	 * @param element
	 * @param text
	 */
	public void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * getTitle method is used to get the title of the current window
	 */
	public String getCurrentWindowTitle() {
		return driver.getTitle();
	}

	/**
	 * getCurrentUrl is used to get the Url of the current window
	 */
	public String getCurrentWindowUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * getWindowHandles method is used to store all the window address
	 */
	public Set<String> getAllWindows() {
		return driver.getWindowHandles();

	}

	/**
	 * This method is used to handle the windows and to switch to different windows
	 * when ever required
	 * 
	 * @param windowTitle
	 */
	public void windowHandles(String windowTitle) {

		for (String win : getAllWindows()) {
			for (int i = 0; i < getAllWindows().size(); i++) {

				String currentWindowTitle = driver.switchTo().window(win).getTitle();

				if (currentWindowTitle.equals(windowTitle)) {

					break;
				}
			}
		}

	}

}
