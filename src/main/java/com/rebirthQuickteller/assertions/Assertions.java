package com.rebirthQuickteller.assertions;

import org.openqa.selenium.WebDriver;

public class Assertions {

	
	public static boolean ValidateUrl(WebDriver driver, String expURL) {
		 boolean url = false;
	        if (driver.getCurrentUrl().equalsIgnoreCase(expURL)) {
	            url = true;
	        }
	        return url;
		
	}
	
	public static boolean validatePageTitle(WebDriver driver, String expTitle) {
		 boolean title = false;
	        if (driver.getTitle().equalsIgnoreCase(expTitle)) {
	        	title = true;
	        }
	        return title;
		
	}
	
	public static boolean validateErrorMsg(WebDriver driver, String expErrorMsg) {
		 boolean errorMsg = false;
	        if (driver.getPageSource().equalsIgnoreCase(expErrorMsg)) {
	        	errorMsg = true;
	        }
	        return errorMsg;
		
	}
	
	
	
	
}
