package com.rebirthQuickteller.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.rebirthQuickteller.base.TestBase;
import com.rebirthQuickteller.utility.Utility;

import pages.SignUpPageObjects;

public class SignUp extends TestBase {

	TestBase test = new TestBase();
	SignUpPageObjects SignUpPageObj = new SignUpPageObjects(driver);

	@Test(priority = 1, description = "This test case will verify user can't sign up with already exist phoneNumber")
	public void AlreadyExistPhonenumberSignUp() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can't sign up with already exist phoneNumber started !!!", true);
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Nigeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber("08074258404");
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.ClickSignUp();
		SignUpPageObj.AlreadyExistphonenumberAssertion();
		Reporter.log("Test to verify user can't login with sign up with already exist phoneNumber completed !!!", true);
		 
	}

	@Test(priority = 2, description = "This test case will check user can't signup using invalid phonenumber ")
	public void InvalidPhonenumberSignUp() throws IOException, InterruptedException {
		Reporter.log("Test to verify user can't signup using invalid phonenumber started !!!", true);
		NavigateHomePage();
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Algeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.InvalidphoneNumberInputAssertion();
		SignUpPageObj.AssertSignUpButtonNotActive();
		Reporter.log("Test to verify user can't signup using invalid phonenumber completed !!!", true);
		 
	}

//	@Test(priority = 3, description = "This test case will check user can't use Invalid otp to verify phonenumber")
	public void VerifyPhonenumberWithInvalidOTP() throws IOException, InterruptedException {

		Reporter.log("Test to check user can't use Invalid otp to verify phonenumber started !!!", true);
		NavigateHomePage();
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Nigeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.ClickSignUp();
		SignUpPageObj.EnterOTP("123489");
		SignUpPageObj.InvalidOTPPhoneNumberVerificationAssertion();
		SignUpPageObj.ClickClose();

		Reporter.log("Test to check user can't use Invalid otp to verify phonenumber completed !!!", true);
		 

	}

	@Test(priority = 4, description = "This test case will check user must provide password that Contain 1 Number")
	public void InvalidPasswordCheck1() throws IOException, InterruptedException {

		Reporter.log("Test to confirm user must provide password that Contain 1 Number started !!!", true);
		NavigateHomePage();
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Nigeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.ClickSignUp();
		SignUpPageObj.EnterOTP("123456");
		SignUpPageObj.EnterPassword("Ademola@");
		SignUpPageObj.EnterconfirmPassword("Ademola@");
		SignUpPageObj.PasswordMustContain1NumberAssertion();
		SignUpPageObj.AssertNextButtonNotActive();
		Reporter.log("Test to confirm user must provide password that Contain 1 Number completed !!!", true);
		 
	}

	@Test(priority = 5, description = "This test case will check user must provide password that Contain LowerCaseLetter")
	public void InvalidPasswordCheck2() throws IOException, InterruptedException {

		Reporter.log("Test to confirm user must provide password that Contain LowerCaseLetter started !!!", true);
		SignUpPageObj.EnterPassword("ADEMOLA1@");
		SignUpPageObj.EnterconfirmPassword("ADEMOLA1@");
		SignUpPageObj.PasswordMustContainLowerCaseLetterAssertion();
		SignUpPageObj.AssertNextButtonNotActive();
		Reporter.log("Test to confirm user must provide password that Contain LowerCaseLetter completed !!!", true);
		 
	}

	@Test(priority = 6, description = "This test case will check user must provide password that Contain UpperCaseLetter")
	public void InvalidPasswordCheck3() throws IOException, InterruptedException {

		Reporter.log("Test to confirm user must provide password that Contain UpperCaseLetter started !!!", true);
		SignUpPageObj.EnterPassword("ademola@");
		SignUpPageObj.EnterconfirmPassword("ademola@");
		SignUpPageObj.PasswordMustContainUpperCaseLetterAssertion();
		SignUpPageObj.AssertNextButtonNotActive();
		Reporter.log("Test to confirm user must provide password that Contain UpperCaseLetter completed !!!", true);
		 
	}

	@Test(priority = 7, description = "This test case will check user must provide the same password and confirmPassword")
	public void InvalidPasswordCheck4() throws IOException, InterruptedException {

		Reporter.log("Test to confirm user must provide the same password and confirmPassword started !!!", true);

		SignUpPageObj.EnterPassword("ADEMOLA1@");
		SignUpPageObj.EnterconfirmPassword("ADEMOLA1");
		SignUpPageObj.PasswordMatchAssertion();
		SignUpPageObj.AssertNextButtonNotActive();
		Reporter.log("Test to confirm user must provide the same password and confirmPassword completed !!!", true);
		 
	}

	@Test(priority = 8, description = "This test case will check user must provide password that contains 1 Special Character")
	public void InvalidPasswordCheck5() throws IOException, InterruptedException {
         
		Reporter.log("Test to confirm user must provide password that contains 1 Special Character started !!!",
				true);
		SignUpPageObj.EnterPassword("ADEMOLA1@");
		SignUpPageObj.EnterconfirmPassword("ADEMOLA2@");
		SignUpPageObj.PasswordMatchAssertion();
		SignUpPageObj.AssertNextButtonNotActive();
		Reporter.log("Test to confirm user must provide password that contains 1 Special Character completed !!!",
				true);
		 
	}

	@Test(priority = 9, description = "This test case will check user must provide password that contains 8 Character")
	public void InvalidPasswordCheck6() throws IOException, InterruptedException {

		Reporter.log("Test to confirm user must provide password that contains 8 Character started !!!", true);

		SignUpPageObj.EnterPassword("Adeo@1");
		SignUpPageObj.EnterconfirmPassword("Adeo@1");
		SignUpPageObj.PasswordMustContain8CharacterAssertion();
		SignUpPageObj.AssertNextButtonNotActive();
		Reporter.log("Test to confirm user must provide password that contains 8 Character completed !!!", true);
		 
	}

	@Test(priority = 10, description = "This test case will check user must provide firstName to complete Onboarding Process")
	public void CheckFirstNameIsRequiredToCompleteOnboarding() throws IOException, InterruptedException {

		Reporter.log("Test to confirm user must provide firstName to complete Onboarding Process started !!!", true);
		NavigateHomePage();
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Nigeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.ClickSignUp();
		SignUpPageObj.EnterOTP("123456");
		SignUpPageObj.EnterPassword("Ademola1@");
		SignUpPageObj.EnterconfirmPassword("Ademola1@");
		SignUpPageObj.ClickNext();
		SignUpPageObj.WelcometoQuicktellerAssertion();
		SignUpPageObj.ClickGetStarted();
		SignUpPageObj.EnterLastName(randomLastName());
		SignUpPageObj.SelectGender();
		SignUpPageObj.EnterDateofBirth("0");
		SignUpPageObj.EnterQuickTag(randomFirstName());
		SignUpPageObj.EnterRefferalName(randomEmail());
		SignUpPageObj.AssertNextButtonNotActive();
		Reporter.log("Test to confirm user must provide firstName to complete Onboarding Process completed !!!", true);
		 
	}

	@Test(priority = 11, description = "This test case will check user must provide lastName to complete Onboarding Process")
	public void CheckLastNameIsRequiredToCompleteOnboarding() throws IOException, InterruptedException {
		NavigateHomePage();
		Reporter.log("Test to confirm user must provide lastName to complete Onboarding Process started !!!", true);
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Nigeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.ClickSignUp();
		SignUpPageObj.EnterOTP("123456");
		SignUpPageObj.EnterPassword("Ademola1@");
		SignUpPageObj.EnterconfirmPassword("Ademola1@");
		SignUpPageObj.ClickNext();
		SignUpPageObj.WelcometoQuicktellerAssertion();
		SignUpPageObj.ClickGetStarted();
		SignUpPageObj.EnterFirstName(randomFirstName());
		SignUpPageObj.SelectGender();
		SignUpPageObj.EnterDateofBirth("0");
		SignUpPageObj.EnterQuickTag(randomFirstName());
		SignUpPageObj.EnterRefferalName(randomEmail());
		SignUpPageObj.AssertNextButtonNotActive();
		Reporter.log("Test to confirm user must provide lastName to complete Onboarding Process completed !!!", true);
		 
	}

	@Test(priority = 12, description = "This test case will check user must provide gender to complete Onboarding Process")
	public void CheckGenderIsRequiredToCompleteOnboarding() throws IOException, InterruptedException {
		NavigateHomePage();
		Reporter.log("Test to confirm user must provide gender to complete Onboarding Process started !!!", true);
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Nigeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.ClickSignUp();
		SignUpPageObj.EnterOTP("123456");
		SignUpPageObj.EnterPassword("Ademola1@");
		SignUpPageObj.EnterconfirmPassword("Ademola1@");
		SignUpPageObj.ClickNext();
		SignUpPageObj.WelcometoQuicktellerAssertion();
		SignUpPageObj.ClickGetStarted();
		SignUpPageObj.EnterFirstName(randomFirstName());
		SignUpPageObj.EnterLastName(randomLastName());
		SignUpPageObj.EnterDateofBirth("0");
		SignUpPageObj.EnterQuickTag(randomFirstName());
		SignUpPageObj.EnterRefferalName(randomEmail());
		// SignUpPageObj.ClickNext();
		SignUpPageObj.AssertNextButtonNotActive();
		Reporter.log("Test to confirm user must provide gender to complete Onboarding Process completed !!!", true);
		 
	}

	@Test(priority = 13, description = "This test case will check user must provide dateofbirth to complete Onboarding Process")
	public void CheckDateOfBirthIsRequiredToCompleteOnboarding() throws IOException, InterruptedException {
		Reporter.log("Test to confirm user must provide dateofbirth to complete Onboarding Process started !!!", true);
		NavigateHomePage();
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Nigeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.ClickSignUp();
		SignUpPageObj.EnterOTP("123456");
		SignUpPageObj.EnterPassword("Ademola1@");
		SignUpPageObj.EnterconfirmPassword("Ademola1@");
		SignUpPageObj.ClickNext();
		SignUpPageObj.WelcometoQuicktellerAssertion();
		SignUpPageObj.ClickGetStarted();
		SignUpPageObj.EnterFirstName(randomFirstName());
		SignUpPageObj.EnterLastName(randomLastName());
		SignUpPageObj.SelectGender();
		SignUpPageObj.EnterQuickTag(randomFirstName());
		SignUpPageObj.EnterRefferalName(randomEmail());
		SignUpPageObj.AssertNextButtonNotActive();
		Reporter.log("Test to confirm user must provide dateofbirth to complete Onboarding Process completed !!!",
				true);
		 
	}

	@Test(priority = 14, description = "This test case will check user must provide match pin and confirm pin to complete Onboarding Process")
	public void CheckPinMisMatchisNotPermmittedToCompleteOnboarding() throws IOException, InterruptedException {
		Reporter.log(
				"Test to confirm user must provide match pin and confirm pin to complete Onboarding Process started !!!",
				true);
		NavigateHomePage();
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Nigeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.ClickSignUp();
		SignUpPageObj.EnterOTP("123456");
		SignUpPageObj.EnterPassword("Ademola1@");
		SignUpPageObj.EnterconfirmPassword("Ademola1@");
		SignUpPageObj.ClickNext();
		SignUpPageObj.WelcometoQuicktellerAssertion();
		SignUpPageObj.ClickGetStarted();
		SignUpPageObj.EnterFirstName(randomFirstName());
		SignUpPageObj.EnterLastName(randomLastName());
		SignUpPageObj.SelectGender();
		SignUpPageObj.EnterDateofBirth("0");
		SignUpPageObj.EnterQuickTag(randomFirstName());
		SignUpPageObj.EnterRefferalName(randomEmail());
		SignUpPageObj.ClickNext();
		SignUpPageObj.EnterPin("1990");
		SignUpPageObj.EnterconfirmPin("1995");
		SignUpPageObj.ClickSavePin();
		SignUpPageObj.PinMismatchAssertion();
		Reporter.log(
				"Test to confirm user must provide match pin and confirm pin to complete Onboarding Process completed !!!",
				true);
		 
	}

	@Test(priority = 15, description = "This test case will check user must provide pin and confirm pin that is not repetitive or sequential to complete Onboarding Process")
	public void CheckPinRepetitiveisNotPermmittedToCompleteOnboarding() throws IOException, InterruptedException {

		Reporter.log(
				"Test to confirm user must provide pin and confirm pin that is not repetitive or sequential to complete Onboarding Process started !!!",
				true);
		NavigateHomePage();
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Nigeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.ClickSignUp();
		SignUpPageObj.EnterOTP("123456");
		SignUpPageObj.EnterPassword("Ademola1@");
		SignUpPageObj.EnterconfirmPassword("Ademola1@");
		SignUpPageObj.ClickNext();
		SignUpPageObj.WelcometoQuicktellerAssertion();
		SignUpPageObj.ClickGetStarted();
		SignUpPageObj.EnterFirstName(randomFirstName());
		SignUpPageObj.EnterLastName(randomLastName());
		SignUpPageObj.SelectGender();
		SignUpPageObj.EnterDateofBirth("0");
		//SignUpPageObj.EnterQuickTag(randomFirstName());
		SignUpPageObj.EnterRefferalName(randomEmail());
		SignUpPageObj.ClickNext();
		//SignUpPageObj.ProfileUpdateAssertion();
		SignUpPageObj.EnterPin("1111");
		SignUpPageObj.EnterconfirmPin("1111");
		SignUpPageObj.ClickSavePin();
		SignUpPageObj.PinRepetitiveAssertion();
		Reporter.log(
				"Test to confirm user must provide pin and confirm pin that is not repetitive or sequential to complete Onboarding Process completed !!!",
				true);
		 
	}

	@Test(priority = 16, description = "This test case will verify user can signup with phonenumber using valid credentials")
	public void SignUpwithPhoneNumber() throws IOException, InterruptedException {

		Reporter.log("Test to verify user can signup with phonenumber using valid credentials started !!!", true);
		NavigateHomePage();
		SignUpPageObj.ClickSignUpButton();
		SignUpPageObj.ClickSignuphPhoneNumber();
		SignUpPageObj.ClickCountryCodeDropdown();
		SignUpPageObj.SearchCountryCode("Nigeria");
		SignUpPageObj.SelectSearchedCountryCode();
		SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		SignUpPageObj.ClickTermConditionButton();
		SignUpPageObj.ClickSignUp();
		SignUpPageObj.EnterOTP("123456");
		SignUpPageObj.EnterPassword("Ademola1@");
		SignUpPageObj.EnterconfirmPassword("Ademola1@");
		SignUpPageObj.ClickNext();
		SignUpPageObj.WelcometoQuicktellerAssertion();
		SignUpPageObj.ClickGetStarted();
		SignUpPageObj.EnterFirstName(randomFirstName());
		SignUpPageObj.EnterLastName(randomLastName());
		SignUpPageObj.SelectGender();
		SignUpPageObj.EnterDateofBirth("0");
		//SignUpPageObj.EnterQuickTag(randomFirstName());
		SignUpPageObj.EnterRefferalName(randomEmail());
		SignUpPageObj.ClickNext();
		SignUpPageObj.ProfileUpdateAssertion();
		SignUpPageObj.EnterPin("1990");
		SignUpPageObj.EnterconfirmPin("1990");
		SignUpPageObj.ClickSavePin();
		SignUpPageObj.PinSetSuccessAssertion();
		//SignUpPageObj.EnterEmail(randomEmail());
		//SignUpPageObj.ClickVerifyEmail();
		//SignUpPageObj.EmailSentAssertion();
		//SignUpPageObj.SkipEmailVerification();
		//SignUpPageObj.ClickPersonaliseAccountBtn();
		//SignUpPageObj.SelectInterests();
		//SignUpPageObj.ClickNext();
		//SignUpPageObj.ClickLogoutDropdownBtn();
		//SignUpPageObj.ClickLogoutButton();

		Reporter.log("Test to verify user can signup with phonenumber using valid credentials completed !!!", true);

	}

}

/*
 * @Test public void SignUptwithPhoneNumber() throws IOException,
 * InterruptedException {
 * 
 * SignUpPageObjects SignUpPageObj = new SignUpPageObjects(driver);
 * SignUpPageObj.ClickSignUpButton(); SignUpPageObj.ClickSignuphPhoneNumber();
 * SignUpPageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
 * SignUpPageObj.ClickTermConditionButton(); SignUpPageObj.ClickSignUp();
 * SignUpPageObj.EnterOTP("123456"); SignUpPageObj.EnterPassword("Ademola1@");
 * SignUpPageObj.EnterconfirmPassword("Ademola1@"); SignUpPageObj.ClickNext();
 * SignUpPageObj.WelcometoQuicktellerAssertion(); Thread.sleep(3000);
 * SignUpPageObj.ClickGetStarted();
 * 
 * //SignUpPageObj.EnterFirstName(randomFirstName());
 * SignUpPageObj.EnterInFirstName("hi");
 * SignUpPageObj.EnterLastName(randomLastName());
 * 
 * 
 * 
 * Thread.sleep(6000);
 * 
 * }
 */

/*
 * public void signUpEmail() throws IOException, InterruptedException {
 * 
 * SignUpPageObjects SignUpPageObj = new SignUpPageObjects(driver);
 * SignUpPageObj.ClickSignUpButton();
 * SignUpPageObj.EnterEmail("ahskskhe@gmail.com");
 * SignUpPageObj.ClickTermConditionButton(); SignUpPageObj.ClickSignUp();
 * SignUpPageObj.ClickOpenEmailBtn(); SignUpPageObj.Clickemail(); }
 */