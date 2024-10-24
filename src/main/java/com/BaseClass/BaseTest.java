package com.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.POM.Pages.AddToBasket;
import com.POM.Pages.LoginSignUpPage;
import com.POM.Pages.ProductSelection;
import com.Utilities.ExcelUtility;
import com.Utilities.JavaUtility;
import com.Utilities.LogUtility;
import com.Utilities.PropertyFileUtiltity;
import com.Utilities.ScreenShotUtility;
import com.Utilities.Validations;
import com.Utilities.WebDriverUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Base class is used create and initialize all the different objects and also used to implements 
 * the common methods used for the application
 * 
 * @author PraneethReddy
 */
public class BaseTest {
	public static WebDriver driver;
	public PropertyFileUtiltity propUtil = new PropertyFileUtiltity();
	public WebDriverUtilities webUtil = new WebDriverUtilities(driver);
	String browser = propUtil.getBrowser();
	String url = propUtil.getAppUrl();
	public LogUtility log = new LogUtility();
	public ExcelUtility excel = new ExcelUtility();
	public ExtentSparkReporter sparkReports;
	public ExtentReports reports;
	public ExtentTest test;
	public ScreenShotUtility srcUtil = new ScreenShotUtility();
	public String reportPath = propUtil.getExtentReportPath();
	public Validations validations = new Validations();
	public JavaUtility javaUtil = new JavaUtility();
	public LoginSignUpPage login;
	public ProductSelection product;
	public AddToBasket addToBasket;
	public String excelPath = propUtil.getExcelPath();
	public String excelSheetName = propUtil.getSheetName();
	public String userLoginData = excel.getData(excelSheetName, 7, 2);
	public static String priceOfProduct;
	public String price;
	public String totalPriceOfProduct;
	public String basketPageText = excel.getData(excelSheetName, 1, 4);
	public String basketPageUrl;
	public String emptyBasketMessage;

	@BeforeClass
	public void setUp() {
		switch (browser) {
		case "chrome":
			chromeDriver();
			break;
		case "edge":
			edgeDriver();
			break;
		case "fireFox":
			fireFoxDriver();
			break;
		case "safari":
			safariDriver();
			break;
		default:
			System.out.println("Choose existing browser");
		}
		log.info(browser + " browser is launched successfully");

		getUrl(url);
		log.info("Successfully navigated to " + url + " url");
	}


	@AfterClass
	public void tearDown() {
		Quit();
		log.fatal("browser is closed successfully");
	}

	
	//Initializing chrome driver
	public void chromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	//Initializing firefox driver
	public void fireFoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	//Initializing edge driver
	public void edgeDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	//Initializing safari driver
	public void safariDriver() {
		WebDriverManager.safaridriver().setup();
		driver = new SafariDriver();
	}

	//Used to get the required application
	public void getUrl(String Url) {
		driver.get(Url);
	}

	//Used to close the browser
	public void Quit() {
		driver.quit();
	}

}
