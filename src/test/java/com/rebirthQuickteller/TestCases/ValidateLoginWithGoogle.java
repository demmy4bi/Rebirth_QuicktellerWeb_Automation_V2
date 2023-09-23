package com.rebirthQuickteller.TestCases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.rebirthQuickteller.base.TestBase;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;

public class ValidateLoginWithGoogle extends TestBase {
	
	@Test(description = "")
	public void SignInGoogle() throws IOException, InterruptedException {
		
		//Click Sign In with Google Button
		chooseElement("ClickSignINGoogle_XPATH").click();
		
		//Switch Window
		Set <String> windows = driver.getWindowHandles();
		Iterator <String> it = windows.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);
		Thread.sleep(3000);
		
		//Enter Email
		chooseElement("GoogleEmail_XPATH").clear();
		type("GoogleEmail_XPATH","txtGoogleEmail");
		chooseElement("GoogleEmail_XPATH").sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 
		Thread.sleep(1000);
		

		//Click Next
		chooseElement("GoogleNext_XPATH").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		 
		 
		
		
		//Enter Password
		chooseElement("GooglePassword_XPATH").clear();
		type("GooglePassword_XPATH","txtGooglePass");
		chooseElement("GooglePassword_XPATH").sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 
		Thread.sleep(3000);

		
		//Click Next
		chooseElement("GoogleNext_XPATH").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 
		Thread.sleep(1000);
		
		
		
		
	}

}
