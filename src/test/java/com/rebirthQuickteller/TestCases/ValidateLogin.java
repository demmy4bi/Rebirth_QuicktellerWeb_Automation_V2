package com.rebirthQuickteller.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.rebirthQuickteller.base.TestBase;

import pages.LoginPageObjects;
import pages.SignUpPageObjects;

public class ValidateLogin extends TestBase {

	// Email Login

	@Test(priority = 1, description = "This test case will verify user can't login with invalid email and a valid password fields")
	public void LoginWithInvalidEmailInput() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can't login with invalid email and a valid password fields started !!!",
				true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.EnterEmail("demmy4bigmail.com");
		LoginPageObj.InvalidEmailInputAssertion();
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.AssertSignInButtonNotActive();
		Reporter.log("Test to verify user can't login with invalid email and a valid password fields completed !!!",
				true);
	}

	@Test(priority = 2, description = "This test case will verify user can't login with UnregisteredEmail and a valid password fields")
	public void LoginWithUnregisteredEmail() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can't login with  UnregisteredEmail and a valid password fields started !!!",
				true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.EnterEmail("demmy4biiii@gmail.com");
		LoginPageObj.EnterPassword("Ademola4@");
		LoginPageObj.ClickSignInButton();
		LoginPageObj.UnregisteredEmailAssertion();

		Reporter.log(
				"Test to verify user can't login with  UnregisteredEmail and a valid password fields completed !!!",
				true);
	}

	@Test(priority = 3, description = "This test case will verify user can't login with empty email fields and valid password")
	public void EmailLoginWithEmptyEmailAddressField() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can't login with empty email fields and valid password started !!!", true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.EnterEmail(" ");
		LoginPageObj.EnterPassword("Ademola4@");
		LoginPageObj.AssertSignInButtonNotActive();
		Reporter.log("Test to verify user can't login with empty email fields and valid password completed !!!", true);
	}

	@Test(priority = 4, description = "This test case will verify user can't login with empty pasword fields and valid email address")
	public void EmailLoginWithEmptyPasswordField() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can't login with empty pasword fields and valid email address started !!!",
				true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword(" ");
		LoginPageObj.AssertSignInButtonNotActive();
		Reporter.log("Test to verify user can't login with empty pasword fields and valid email address completed !!!",
				true);
	}

	@Test(priority = 5, description = "This test case will verify user can't login with valid email and a wrong password fields")
	public void EmailLoginwithInvalidPassword() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can't login with  valid email and a wrong password fields started !!!", true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola");
		LoginPageObj.ClickSignInButton();
		LoginPageObj.InvalidPasswordAssertion();
		Reporter.log("Test to verify user can't login with  valid email and a wrong password fields completed !!!",
				true);

	}

	@Test(priority = 6, description = "This TestCase will perform email login with valid credentials")
	//6
	public void EmailLoginwithValidcredentials() throws IOException, InterruptedException {

		Reporter.log("Test to perform login with valid email and password started !!!", true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);

		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();
		LoginPageObj.ValidateHomePageUrl();
		LoginPageObj.ClickLogoutDropdownBtn();
		LoginPageObj.ClickLogoutButton();

		Reporter.log("Test to perform login with valid email and password completed !!!", true);
	}

	@Test(priority = 7, description = "This TestCase will perform valid login with rememberMe")
	public void ValidateEmailLoginWithRememberMe() throws IOException, InterruptedException {
		Reporter.log("Test to perform valid login with rememberMe started !!!", true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);

		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.EyePassword();
		LoginPageObj.EyePassword();
		LoginPageObj.ClickRememberMe();
		LoginPageObj.ClickSignInButton();
		LoginPageObj.ValidateHomePageUrl();
		LoginPageObj.ClickLogoutDropdownBtn();
		LoginPageObj.ClickLogoutButton();
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.EyePassword();
		LoginPageObj.ClickSignInButton();
		LoginPageObj.ValidateHomePageUrl();
		LoginPageObj.ClickLogoutDropdownBtn();
		LoginPageObj.ClickLogoutButton();

		Reporter.log("Test to perform valid email login with rememberMe completed !!!", true);
	}

	// PhoneNumber Login
	@Test(priority = 8, description = "This test case will verify user can't login with invalid phoneNumber fields")
	public void LoginWithInvalidPhoneNumberInput() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can't login with invalid phoneNumber fields started !!!", true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.ClickSignInWithPhoneNumberButton();
		LoginPageObj.EnterPhoneNumber("0809845");
		LoginPageObj.InvalidphoneNumberInputAssertion();

		Reporter.log("Test to verify user can't login with invalid phoneNumber fields fields completed !!!", true);
	}

	@Test(priority = 9, description = "This test case will verify user can't login with  UnregisteredPhoneNumber and a valid password fields")
	public void LoginWithUnRegisteredPhonenumber() throws IOException, InterruptedException {

		Reporter.log(
				"Test to verify user can't login with  UnregisteredPhoneNumber and a valid password fields started !!!",
				true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.EnterPhoneNumber("08052511399");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();
		LoginPageObj.UnregisteredPhoneNumberAssertion();
		Reporter.log(
				"Test to verify user can't login with  UnregisteredPhoneNumber and a valid password fields completed !!!",
				true);
	}

	@Test(priority = 10, description = "This test case will verify user can't login with empty phoneNumber fields and valid password")
	public void LoginWithEmptyPhonenumberField() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can't login with empty phoneNumber fields and valid password started !!!",
				true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.EnterPhoneNumber(" ");
		LoginPageObj.EnterPassword("Ademola4@");
		LoginPageObj.AssertSignInButtonNotActive();
		Reporter.log("Test to verify user can't login with empty phoneNumber fields and valid password completed !!!",
				true);
	}

	@Test(priority = 11, description = "This test case will verify user can't login with empty pasword fields and valid phoneNumber")
	public void phoneNumberLoginWithEmptyPasswordField() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can't login with empty pasword fields and valid phoneNumber started !!!",
				true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.EnterPhoneNumber("08098487373");
		LoginPageObj.EnterPassword(" ");
		LoginPageObj.AssertSignInButtonNotActive();
		Reporter.log("Test to verify user can't login with empty pasword fields and valid phoneNumber completed !!!",
				true);
	}

	@Test(priority = 12, description = "This test case will verify user can't login with valid phoneNumber and a wrong password fields")
	public void PhoneNumberLoginWithInvalidPassword() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can't login with valid phoneNumber and a wrong password fields started !!!",
				true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.EnterPhoneNumber("09125490124");//08098487373
		LoginPageObj.EnterPassword("Ademola");
		LoginPageObj.ClickSignInButton();
		LoginPageObj.InvalidPasswordAssertion();

		Reporter.log("Test to verify user can't login with valid phoneNumber and a wrong password fields completed !!!",
				true);
	}

	@Test(priority = 13, description = "This TestCase will perform phoneNumber login with valid credentials")
	public void PhoneNumberLoginWithValidCredentials() throws IOException, InterruptedException {

		Reporter.log("Test to perform phoneNumber login with valid credentials started !!!", true);
		SignUpPageObjects SignUpPageObj = new SignUpPageObjects(driver);
		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.EnterPhoneNumber("09125490124");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();
		LoginPageObj.ValidateHomePageUrl();
		LoginPageObj.ClickLogoutDropdownBtn();
		LoginPageObj.ClickLogoutButton();
		Reporter.log("Test to perform phoneNumber login with valid credentials completed !!!", true);
	}

	@Test(priority = 14, description = "This TestCase will perform valid phoneNumber login with rememberMe")
	public void ValidatePhonenumberLoginWithRememberMe() throws IOException, InterruptedException {
		Reporter.log("Test to perform valid phoneNumber login with rememberMe started !!!", true);

		LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
		LoginPageObj.ClickSignInWithPhoneNumberButton();
		LoginPageObj.EnterPhoneNumber("09125490124");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.EyePassword();	 
		LoginPageObj.EyePassword();
		LoginPageObj.ClickRememberMe();
		LoginPageObj.ClickSignInButton();
		LoginPageObj.ValidateHomePageUrl();
		LoginPageObj.ClickLogoutDropdownBtn();
		LoginPageObj.ClickLogoutButton();
		LoginPageObj.ClickSignInWithPhoneNumberButton();
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.EyePassword();
		LoginPageObj.ClickSignInButton();
	    LoginPageObj.ValidateHomePageUrl();
		LoginPageObj.ClickLogoutDropdownBtn();
		LoginPageObj.ClickLogoutButton();

		Reporter.log("Test to perform valid PhoneNumberlogin with rememberMe completed !!!", true);
	}

}

/*
 * @Test(priority = 1, description =
 * "This test case will verify user can't login with  UnregisteredEmail and a valid password fields"
 * ) public void InvalidPasswordInput() throws IOException, InterruptedException
 * { Reporter.
 * log("Test to verify user can't login with  UnregisteredEmail and a valid password fields started !!!"
 * , true); LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
 * LoginPageObj.EnterEmail("demmy4bi@gmail.com");
 * LoginPageObj.InvalidPasswordInput(); LoginPageObj.InvalidPasswordAssertion();
 * Thread.sleep(3000); Reporter.
 * log("Test to verify user can't login with  UnregisteredEmail and a valid password fields completed !!!"
 * , true); }
 */
