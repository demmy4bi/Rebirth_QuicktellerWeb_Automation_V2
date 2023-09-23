package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.rebirthQuickteller.base.TestBase;
import com.rebirthQuickteller.utility.Utility;

public class SignUpPageObjects extends TestBase {

	String actualmessage;
	String WelcometoQuicktellersuccessmessage = "Welcome to Quickteller!";
	String ProfileUpdatesuccessmessage = "Profile updated!";
	String PinSetsuccessmessage = "Your Quickteller PIN has been set successfully.";
	String Emailsentmessage = "You’ve got mail !!";
	String AlreadyexistPhonenumbererrmessage = "Account already exists";
	String InvalidOTPPhoneNumberVerification = "Incorrect code, Please try again.";
	String InvalidphoneNumberexpectederrormessage = "Provide a valid phone number";
	String PinMisMatcherrormessage = "Please make sure both PINs are the same and try again";
	String PinRepetitiveerrormessage = "Oops! Pin should not be sequential or repetitive.";

	public SignUpPageObjects(WebDriver driver) {
		TestBase.driver = driver;
	}

	public void EnterEmail(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("Email_NAME"))).clear();
		chooseElement("Email_NAME").sendKeys(text);
		Reporter.log("emailAddress entered successfully", true);
	}

	public void ClickSignUpButton() throws IOException, InterruptedException {
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.cssSelector(".second__text > span"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		/*
		 * Thread.sleep(500); chooseElement("ClickSignUPPBtn_CSS").click();
		 * driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		 */
		Reporter.log("SignUp button clicked successfully", true);
		Thread.sleep(1000);
	}

	public void ClickTermConditionButton() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("TickTermsConditionBtn_NAME"))).click();
		Reporter.log("ClickTermConditionButton clicked successfully", true);
	}

	public void ClickSignUp() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("SignUp_CSS"))).click();
		Reporter.log("SignUp button clicked successfully", true);
	}

	public void Clickemail() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("Selectemail_CSS"))).click();
		Reporter.log("SignUp button clicked successfully", true);
	}

	public void ClickOpenEmailBtn() throws IOException, InterruptedException {

		chooseElement("openEmailBtn_CSS").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("SignIn button clicked successfully", true);
		Thread.sleep(3000);

	}

	public void ClickSignuphPhoneNumber() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("SignUpWithPhoneNumber_XPATH"))).click();
		Reporter.log("Sign up with phonenumber button clicked successfully", true);
	}

	public void EnterPhoneNumber(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("phoneNumber_NAME"))).clear();
		chooseElement("phoneNumber_NAME").sendKeys(text);
		Reporter.log("phoneNumber entered successfully", true);
	}

	public void EnterPassword(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("password_NAME"))).clear();
		chooseElement("password_NAME").sendKeys(text);
		Reporter.log("password entered successfully", true);
	}

	public void EnterconfirmPassword(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ConfirmPassword_NAME"))).clear();
		chooseElement("ConfirmPassword_NAME").sendKeys(text);
		Reporter.log("confirmPassword entered successfully", true);
	}

	public void EnterOTP(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("InputOtp_XPATH"))).clear();
		chooseElement("InputOtp_XPATH").sendKeys(text);
		Reporter.log("OTP entered successfully", true);
	}

	public void ClickNext() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickNextBtn_XPATH"))).click();
		Reporter.log("Next button clicked successfully", true);
	}

	public void ClickGetStarted() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("GetStarted_XPATH"))).click();
		Reporter.log("Get Started button clicked successfully", true);
	}

	public void EnterFirstName(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("FirstName_NAME"))).clear();
		chooseElement("FirstName_NAME").sendKeys(text);
		Reporter.log("FirstName_NAME entered successfully", true);
	}

	public void EnterInFirstName(String text) throws IOException, InterruptedException {

		chooseElement("FirstName_NAME").clear();
		chooseElement("FirstName_NAME").sendKeys(text);

		chooseElement("FirstName_NAME").clear();
		chooseElement("FirstName_NAME").click();
		chooseElement("FirstName_NAME").clear();

		Reporter.log("FirstName_NAME entered successfully", true);
		Thread.sleep(3000);
	}

	public void EnterLastName(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("LastName_NAME"))).clear();
		chooseElement("LastName_NAME").sendKeys(text);
		Reporter.log("LastName NAME entered successfully", true);
	}

	public void EnterDateofBirth(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("DateofBirth_CSS"))).clear();
		chooseElement("DateofBirth_CSS").sendKeys(text);
		Reporter.log("DateofBirth entered successfully", true);
	}

	public void EnterPin(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("Pin_CSS"))).clear();
		chooseElement("Pin_CSS").sendKeys(text);
		Reporter.log("Pin entered successfully", true);
	}

	public void EnterconfirmPin(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ConfirmPin_CSS"))).clear();
		chooseElement("ConfirmPin_CSS").sendKeys(text);
		Reporter.log("ConfirmPin entered successfully", true);
	}

	public void ClickSavePin() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("SavePin_XPATH"))).click();
		Reporter.log("SavePin button clicked successfully", true);
	}

	public void SelectGender() {

		WebElement dropdownElement = driver.findElement(By.name("gender"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("Male");
		Reporter.log("Gender selected successfully", true);
	}

	public void EnterQuickTag(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("quickTag_NAME"))).clear();
		chooseElement("quickTag_NAME").sendKeys(text);
		Reporter.log("quickTag NAME entered successfully", true);
	}

	public void EnterRefferalName(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("refferedBy_NAME"))).clear();
		chooseElement("refferedBy_NAME").sendKeys(text);
		Reporter.log("RefferalName entered successfully", true);
	}

	public void WelcometoQuicktellerAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 30).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(.,'Welcome to Quickteller!')]")))
				.getText();
		Assert.assertEquals(actualmessage, WelcometoQuicktellersuccessmessage);
		System.out.println("Actual message  =" + actualmessage);
		Reporter.log("WelcometoQuickteller message asserted", true);
	}

	public void ProfileUpdateAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(.,'Profile updated!')]")))
				.getText();
		Assert.assertEquals(actualmessage, ProfileUpdatesuccessmessage);
		System.out.println("Actual message  =" + actualmessage);
		Reporter.log("Profile Update success message Asserted", true);
	}

	public void PinSetSuccessAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[contains(.,'Your Quickteller PIN has been set successfully.')]"))).getText();
		Assert.assertEquals(actualmessage, PinSetsuccessmessage);
		System.out.println("Actual message  =" + actualmessage);
		Reporter.log("Pin set success message Asserted", true);
	}

	public void EmailSentAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 60).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(.,'You’ve got mail !!')]")))
				.getText();
		Assert.assertEquals(actualmessage, Emailsentmessage);
		System.out.println("Actual message  =" + actualmessage);
		Reporter.log("EmailSent success message Asserted", true);
	}

	public void AlreadyExistphonenumberAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 60).until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(.,'Account already exists')]")))
				.getText();
		Assert.assertEquals(actualmessage, AlreadyexistPhonenumbererrmessage);
		System.out.println("Actual error message  =" + actualmessage);
		Reporter.log("AlreadyexistPhonenumber error message Asserted", true);
	}

	public void InvalidOTPPhoneNumberVerificationAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 60)
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//p[contains(.,'Incorrect code, Please try again.')]")))
				.getText();
		Assert.assertEquals(actualmessage, InvalidOTPPhoneNumberVerification);
		System.out.println("Actual error message  =" + actualmessage);
		Reporter.log("Invalid OTP PhoneNumber Verification error message Asserted", true);
	}

	public void InvalidphoneNumberInputAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 60)
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[contains(.,'Provide a valid phone number')] ")))
				.getText();
		Assert.assertEquals(actualmessage, InvalidphoneNumberexpectederrormessage);
		System.out.println("Actual error message  =" + actualmessage);
		Reporter.log("Invalid PhoneNumber Asserted", true);
	}

	public void PinMismatchAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 60)
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(.,'Please make sure both PINs are the same and try again')]")))
				.getText();
		Assert.assertEquals(actualmessage, PinMisMatcherrormessage);
		System.out.println("Actual error message  =" + actualmessage);
		Reporter.log("Pin MisMatch error message Asserted", true);
	}

	public void PasswordMatchAssertion() throws IOException {
		WebElement passwordMatchElement = driver.findElement(By.xpath("//li[contains(.,'Password match')]"));

		String colorValue = passwordMatchElement.getCssValue("color");

		Assert.assertEquals("rgba(220, 68, 55, 1)", colorValue);

		Reporter.log("Password must match Assertion successful", true);

	}

	public void PinRepetitiveAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//p[contains(.,'Oops! Pin should not be sequential or repetitive.')]"))).getText();
		Assert.assertEquals(actualmessage, PinRepetitiveerrormessage);
		System.out.println("Actual error message  =" + actualmessage);
		Reporter.log("Pin Repetitive/Sequential error message Asserted", true);
	}

	public void PasswordMustContain1NumberAssertion() throws IOException {
		WebElement passwordMatchElement = driver.findElement(By.xpath("//li[contains(.,'1 number')]"));

		String colorValue = passwordMatchElement.getCssValue("color");

		Assert.assertEquals("rgba(220, 68, 55, 1)", colorValue);

		Reporter.log("Password Must Contain 1 Number Assertion successful", true);

	}

	public void PasswordMustContainLowerCaseLetterAssertion() throws IOException {
		WebElement passwordMatchElement = driver.findElement(By.xpath("//li[contains(.,'1 lowercase letter')]"));

		String colorValue = passwordMatchElement.getCssValue("color");

		Assert.assertEquals("rgba(220, 68, 55, 1)", colorValue);

		Reporter.log("Password Must Contain LowerCase Letter Assertion successful", true);

	}

	public void PasswordMustContainUpperCaseLetterAssertion() throws IOException {
		WebElement passwordMatchElement = driver.findElement(By.xpath("//li[contains(.,'1 uppercase letter')]"));

		String colorValue = passwordMatchElement.getCssValue("color");

		Assert.assertEquals("rgba(220, 68, 55, 1)", colorValue);

		Reporter.log("Password Must Contain UpperCase Letter Assertion successful", true);

	}

	public void PasswordMustContain1SpecialCharacterAssertion() throws IOException {
		WebElement passwordMatchElement = driver.findElement(By.xpath("//li[contains(.,'1 special character')]"));

		String colorValue = passwordMatchElement.getCssValue("color");

		Assert.assertEquals("rgba(220, 68, 55, 1)", colorValue);

		Reporter.log("Password Must Contain 1 Special Character Assertion successful", true);

	}

	public void PasswordMustContain8CharacterAssertion() throws IOException {
		WebElement passwordMatchElement = driver.findElement(By.xpath("//li[contains(.,'8 characters')]"));

		String colorValue = passwordMatchElement.getCssValue("color");

		Assert.assertEquals("rgba(220, 68, 55, 1)", colorValue);

		Reporter.log("Password Must Contain 8 Character Assertion successful", true);

	}

	public void AssertNextButtonNotActive() throws IOException {
		WebElement nextButton = driver.findElement(By.xpath("//button[contains(.,'Next')]"));
		Assert.assertFalse(nextButton.isEnabled(), "Next button is clickable");
		if (!nextButton.isEnabled()) {
			System.out.println("Next Btn is not active");
		}

	}

	public void AssertSignUpButtonNotActive() throws IOException {
		WebElement SignUpButton = driver.findElement(By.xpath("//button[@type='submit']"));
		Assert.assertFalse(SignUpButton.isEnabled(), "SignUp button is clickable");
		if (!SignUpButton.isEnabled()) {
			System.out.println("SignUp Btn is not active");
		}

	}

	public void ClickPersonaliseAccountBtn() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("PersonaliseAccountBtn_CSS"))).click();
		Reporter.log("Personalise Account  button clicked successfully", true);

	}

	public void SelectInterests() throws IOException, InterruptedException {

		chooseElement("EntertainmentInterest_XPATH").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chooseElement("InvestmentInterest_XPATH").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chooseElement("MoneyInterest_XPATH").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chooseElement("TransportationInterest_XPATH").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chooseElement("PaymentInterest_XPATH").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		chooseElement("LoanInterest_XPATH").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Interest selected successfully", true);
		Thread.sleep(1000);

	}

	public void ClickVerifyEmail() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("VerifyEmail_CSS"))).click();
		Reporter.log("Verify email clicked successfully", true);
	}

	public void ClickCountryCodeDropdown() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickSignUpCountryCodeDropdown_CSS")))
				.click();

	}

	public void SearchCountryCode(String text) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickSignUpSearchCountryCode_CSS"))).click();
		chooseElement("ClickSignUpSearchCountryCode_CSS").clear();
		chooseElement("ClickSignUpSearchCountryCode_CSS").sendKeys(text);
		chooseElement("ClickSignUpSearchCountryCode_CSS").click();
		Reporter.log("Search entered successfully", true);

	}

	public void SelectSearchedCountryCode() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("SelectFrmSignUpSearch_CSS"))).click();

		Reporter.log("Country code selected successfully", true);

	}

	public void SelectCountryCode() throws IOException, InterruptedException {

		chooseElement("ClickSignUpCountryCodeDropdown_CSS").click();
		// chooseElement("ClickSearchCountryCode_CSS").click();
		// chooseElement("ClickSearchCountryCode_CSS").sendKeys(text);
		// Thread.sleep(3000);
		chooseElement("SelectfrmDropdown_CSS").click();

		Reporter.log("Country code selected successfully", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);

	}

	public void ClickClose() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("close_CSS"))).click();
		Reporter.log("Close clicked successfully", true);
	}

	public void ClickLogoutButton() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("Logout_CSS"))).click();
		Reporter.log("Logout successfully", true);
	}

	/*
	 * public void ClickLogoutDropdownBtn() throws IOException { WebDriverWait wait
	 * = new WebDriverWait(driver, 60);
	 * wait.until(ExpectedConditions.elementToBeClickable(chooseElement(
	 * "LogoutDropdownBtn_CSS"))).click(); Reporter.log("Logout successfully",
	 * true); }
	 */
	
	public void ClickLogoutDropdownBtn() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".user__dropdown > img"))).click();
	}
	
	public void SkipEmailVerification() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("skipemailverification_CSS"))).click();
	}

	public void Passwordpage() throws IOException {
		String actualmessage = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("onboarding__title"))).getText();

		System.out.println(actualmessage);
		Reporter.log("Passwordpage checked", true);

	}



}
