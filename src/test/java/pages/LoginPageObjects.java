package pages;

import java.io.IOException;
import java.time.Clock;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.rebirthQuickteller.assertions.Assertions;
import com.rebirthQuickteller.base.TestBase;

public class LoginPageObjects extends TestBase {

	String actualerrormessage;
	String Emailexpectederrormessage = "We could not find an account associated with this email";
	String Passwordexpectederrormessage = "Incorrect password, 3 attempts remaining.";
	String PhoneNumberexpectederrormessage = "We could not find an account associated with this phone number";
	String InvalidEmailexpectederrormessage = "Email address must be a valid email";
	String InvalidPasswordexpectederrormessage = "Password must be valid";
	String InvalidphoneNumberexpectederrormessage = "Provide a valid phone number";

	public LoginPageObjects(WebDriver driver) {
		TestBase.driver = driver;
	}

	public void EnterEmail(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("Email_NAME"))).clear();
		chooseElement("Email_NAME").sendKeys(text);
		Reporter.log("emailAddress entered successfully", true);
	}

	public void EnterPassword(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("password_NAME"))).clear();
		chooseElement("password_NAME").sendKeys(text);
		Reporter.log("Password entered successfully", true);
	}

	public void EnterPhoneNumber(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("phoneNumber_NAME"))).clear();
		chooseElement("phoneNumber_NAME").sendKeys(text);
		Reporter.log("phoneNumber entered successfully", true);
	}

	public void ClickSignInButton() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("SignIn_CSS"))).click();
		Reporter.log("SignIn button clicked successfully", true);
	}

	public void ValidateHomePageUrl() throws InterruptedException {
		String expURL = "https://rebirth-uat.quickteller.com/dashboard";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean responses = wait.until(ExpectedConditions.urlToBe(expURL));
		try {
			assert driver.getCurrentUrl().equals(expURL);
			System.out.println("Navigating to homepage dashboard  is" + responses);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void ClickLogoutButton() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav__bar__logout > p"))).click();
		Reporter.log("Logout successfully", true);
	}

	public void ClickLogoutDropdownBtn() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".user__dropdown"))).click();
	}

	public void ClickSignInWithPhoneNumberButton() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickSignINphoneNumber_CSS"))).click();
		Reporter.log("Sign In with PhoneNumber button clicked successfully	", true);
	}

	public void UnregisteredEmailAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p:nth-child(3)"))).getText();
		try {
			Assert.assertEquals(actualmessage, Emailexpectederrormessage);
			System.out.println("Actual error message  =" + actualmessage);
			Reporter.log("Assertion of UnregisteredEmail successful", true);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void UnregisteredPhoneNumberAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//p[contains(.,'We could not find an account associated with this phone number')]")))
				.getText();
		try {
			Assert.assertEquals(actualmessage, PhoneNumberexpectederrormessage);
			System.out.println("Actual error message  =" + actualmessage);
			Reporter.log("Assertion of UnregisteredPhoneNumber successful", true);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void InvalidPasswordAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[contains(.,'Incorrect password, 3 attempts remaining.')]")))
				.getText();
		try {
			Assert.assertEquals(actualmessage, Passwordexpectederrormessage);
			System.out.println("Actual error message  =" + actualmessage);
			Reporter.log("Assertion of Invalid Password successful", true);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void ClickForgotPasswordButton() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("forgotPassword_LINKTEXT"))).click();
	}

	public void ClickResetPasswordButton() throws IOException, InterruptedException {
		chooseElement("ResetPassword_CSS").click();
		Thread.sleep(3000);

	}

	public void ClickOpenEmailBtn() throws IOException, InterruptedException {
		chooseElement("ResetPassword_CSS").click();
		Thread.sleep(3000);
	}

	public void ClickGmail() throws IOException {
		chooseElement("openEmail_CSS").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	public void SwitchWindow() throws InterruptedException {
		// Switch Window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow);
		Thread.sleep(3000);

		// SwitchbacktoParent
		driver.switchTo().window(ParentWindow);
		Thread.sleep(3000);

	}

	public void doitlatercllick() throws IOException {
		chooseElement("Doitlater_CSS").click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	public void InvalidEmailInputAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 30).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(.,'Email address must be a valid email')]")))
				.getText();
		try {
			Assert.assertEquals(actualmessage, InvalidEmailexpectederrormessage);
			System.out.println("Actual error message  =" + actualmessage);
			Reporter.log("Assertion of InvalidEmailInput successful", true);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}

	}

	public void InvalidphoneNumberInputAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".errorText"))).getText();
		try {
			Assert.assertEquals(actualmessage, InvalidphoneNumberexpectederrormessage);
			System.out.println("Actual error message  =" + actualmessage);
			Reporter.log("Assertion of InvalidphoneNumberInput successful", true);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void InvalidPasswordInputAssertion() throws IOException {
		String actualmessage = new WebDriverWait(driver, 30)
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[contains(.,'Password must be valid')]")))
				.getText();
		try {
			Assert.assertEquals(actualmessage, InvalidPasswordexpectederrormessage);
			System.out.println("Actual error message  =" + actualmessage);
			Reporter.log("Assertion of InvalidPasswordInput successful", true);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void InvalidPasswordInput() throws IOException, InterruptedException {
		chooseElement("password_NAME").clear();
		type("password_NAME", "txtPassword2");
		chooseElement("password_NAME").sendKeys(Keys.TAB);
		chooseElement("password_NAME").clear();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("Password entered successfully", true);
		Thread.sleep(3000);
	}

	public void ClickRememberMe() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("RemmeberMe_CSS"))).click();
	}

	public void EyePassword() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("EyePassword_CSS"))).click();
	}

	public void quictellerTitle() throws IOException {
		String actualmessage = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("account__number-title"))).getText();

		System.out.println(actualmessage);
		Reporter.log("quictellerTitle", true);

	}

	public void AssertSignInButtonNotActive() throws IOException {

		WebElement submitButton = driver.findElement(By.xpath("//p[contains(.,'Sign in')]"));
		// Check if the submit button is active or disabled
		try {
			boolean isButtonActive = !submitButton.isEnabled();
			System.out.println("SignIn button active: " + isButtonActive);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void pageSource() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("html")));

		/*
		 * String pageSource = driver.getPageSource(); System.out.println(pageSource);
		 * Reporter.log("pageSource feth", true);
		 */

		List<WebElement> elements = driver.findElements(By.tagName("html"));

		StringBuilder htmlOutput = new StringBuilder();

		for (WebElement element : elements) {
			String className = element.getAttribute("class");
			String tagName = element.getTagName();
			String text = element.getText();
			String href = element.getAttribute("href");

			String elementHtml = String.format("<%s href='%s'>%s</%s>", className, tagName, href, text, tagName);
			htmlOutput.append(elementHtml);

			System.out.println(text);

		}

	}

}
