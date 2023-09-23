package com.rebirthQuickteller.base;

import static com.rebirthQuickteller.base.TestBase.faker;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
 
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.rebirthQuickteller.utility.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {
	public static WebDriver driver;
	public String projectPath = System.getProperty("user.dir");
	static Faker faker = new Faker();
 

	@BeforeClass
	public void setUp() throws IOException {

		if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("chrome")) {
			// set property and create instance of chrome browser
			
			
			
			  System.setProperty("webdriver.chrome.driver", projectPath +
			  "\\Drivers\\chromedriver.exe");
			  
			  //driver = new ChromeDriver();
			 
			 

			
			
			//webdrivermanager setup     // driver = new ChromeDriver();
			
			 //  WebDriverManager.chromedriver().setup();              
			 
			
			
				
				/*
				 * ChromeOptions options = new ChromeOptions();
				 * options.addArguments("--disable-gpu"); driver = new ChromeDriver(options);
				 */
			 
			 
			 
			 
			 
			 
			 
			// Run in headless mode

			
			
			
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("--headless"); options.addArguments("disable-gpu");
			  options.addArguments("window-size=1200,1100");
			  
			  driver = new ChromeDriver(options);
			 
			 
			 
			 
			Reporter.log("=====Chrome Browser Session Started=====", true);

		} else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			// headless
			/*
			 * FirefoxOptions options = new FirefoxOptions();
			 * options.addArguments("--headless"); driver = new FirefoxDriver(options);
			 */

			Reporter.log("=====Firefox  Browser Session Started=====", true);
		} else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			Reporter.log("=====Edge Browser Session Started=====", true);
		} else if (Utility.fetchProperty("browserName").toString().equalsIgnoreCase("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			Reporter.log("=====Internet Explorer Browser Session Started=====", true);
		} else {

			driver = new ChromeDriver();
		}
		/*
		 * driver.get(Utility.fetchProperty("applicationUrl").toString());
		 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		 * driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 * Reporter.log("=====Application Started=====", true);
		 */

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		//driver.get(Utility.fetchProperty("applicationUrl").toString());
		String applicationUrl = Utility.fetchProperty("applicationUrl").toString();
        driver.get(applicationUrl);
		 
	}

	// To choose Webelement
	public static WebElement chooseElement(String Locator) throws IOException {
		WebElement weblement = null;
		if (Locator.endsWith("_XPATH"))
			weblement = driver.findElement(By.xpath(Utility.fetchLocator(Locator)));
		else if (Locator.endsWith("_ID")) {
			weblement = driver.findElement(By.id(Utility.fetchLocator(Locator)));
		} else if (Locator.endsWith("_CSS")) {
			weblement = driver.findElement(By.cssSelector(Utility.fetchLocator(Locator)));
		} else if (Locator.endsWith("_NAME")) {
			weblement = driver.findElement(By.name(Utility.fetchLocator(Locator)));
		} else if (Locator.endsWith("_LINKTEXT")) {
			weblement = driver.findElement(By.linkText(Utility.fetchLocator(Locator)));
		} else if (Locator.endsWith("_CLASSNAME")) {
			weblement = driver.findElement(By.className(Utility.fetchLocator(Locator)));
		} else if (Locator.endsWith("_TAGNAME")) {
			weblement = driver.findElement(By.tagName(Utility.fetchLocator(Locator)));
		}
		return weblement;
	}

	// Perform Mouse Hovering
	public static void MouseOver(String Locator) throws IOException {
		Actions act = new Actions(driver);
		act.moveToElement(chooseElement(Locator)).build().perform();
	}

	public static void doubleClick(String Locator) throws IOException {
		Actions clickFrequencyBtn = new Actions(driver);
		// WebElement frequencyRadioBt =
		// driver.findElement(By.id(Utility.fetchLocator("frequency_ID")));
		clickFrequencyBtn.doubleClick(chooseElement(Locator)).perform();
	}

	public static void selectDropdowntByVisibleText(String visibleText, String Locator) throws IOException {
		Select select = new Select(chooseElement(Locator));
		select.selectByVisibleText(visibleText);
	}

	public static void selectDropdownByIndex(int index, String Locator) throws IOException {
		Select select2 = new Select(chooseElement(Locator));
		select2.selectByIndex(index);
	}

	// To carry out click action for all locators
	public void click(String Locator) throws IOException {
		chooseElement(Locator).click();
	}

	// To carry out sendkeys function
	public void type(String Locator, String Value) throws IOException {
		chooseElement(Locator).sendKeys(Utility.fetchLocator(Value));
	}

	public static String RandomNigeriaPhoneGenerator() {

		// return faker.phoneNumber().cellPhone();
		Faker faker = new Faker();
		String phoneNumber = "0805" + faker.number().digits(7);
		return phoneNumber;

	}

	public static String randomEmail() {

		return faker.internet().emailAddress();
	}

	public static String randomFirstName() {

		return faker.name().firstName();
	}

	public static String randomLastName() {

		return faker.name().lastName();
	}

	public static String randomName() {

		return faker.name().name();
	}

	public void NavigateHomePage() throws IOException {
		//setUp();
		
		 // driver.manage().window().maximize(); 
		
			
			
			/*
			 * driver.manage().deleteAllCookies();
			 * driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			 * driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 * 
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("--disable-gpu"); driver = new ChromeDriver(options);
			 */
			 
			  driver.get(Utility.fetchProperty("applicationUrl").toString());
			 
		 
		
		 
		String actualmessage = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='qickteller']"))).getText();
		System.out.println("Navigated to HomePage!!!  ");

	}

	@AfterClass
	public void terminateSession() {

		driver.close();

	}
}
