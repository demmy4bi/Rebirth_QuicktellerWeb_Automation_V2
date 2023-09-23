package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.rebirthQuickteller.base.TestBase;

public class RechargePageObjects extends TestBase {

	String actualmessage;
	String Expectedrechargesuccessmessage = "Airtime Purchase Successful!";

	public RechargePageObjects(WebDriver driver) {
		TestBase.driver = driver;
	}

	public void ClickAirtimeDataButton() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("AirtimeDataBtn_CSS"))).click();
		Reporter.log("Airtime button clicked successfully", true);
	}

	public void ClickNewAirtimeButton() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickNew_XPATH"))).click();
		Reporter.log("New Airtime button clicked successfully", true);
	}

	public void SelectCountryCode(String text) throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickCountryCodeDropdown_CSS"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickSearchCountryCode_CSS"))).click();
		chooseElement("ClickSearchCountryCode_CSS").sendKeys(text);

		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("SelectFrmSearch_CSS"))).click();

		Reporter.log("Country code selected successfully", true);

	}

	public void ClickNext() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickNextBtn_XPATH"))).click();
		Reporter.log("Next button clicked successfully", true);
	}

	public void EnterPhoneNumber(String text) throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("phoneNumber_NAME"))).clear();
		chooseElement("phoneNumber_NAME").sendKeys(text);
		Reporter.log("PhoneNumber Entered", true);

	}

	public void EnterAmount(String text) throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("Amount_XPATH"))).clear();
		chooseElement("Amount_XPATH").sendKeys(text);
		Reporter.log("Amount Entered", true);

	}

	public void ClickPay() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//button[contains(.,'Pay')]"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(500);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("PayBtn_XPATH"))).click();

		Reporter.log("Pay button clicked", true);
	}

	public void ClickUseNewCard() throws IOException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("NewCardBtn_CSS"))).click();
		Reporter.log("New card selected", true);

	}

	public void InputCardNumber(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("CardNumber_NAME"))).clear();
		chooseElement("CardNumber_NAME").sendKeys(text);
		Reporter.log("Card number input", true);

	}

	public void InputCardExpiryDate(String text) throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ExpiryDate_NAME"))).clear();
		chooseElement("ExpiryDate_NAME").sendKeys(text);
		Reporter.log("CardExpiryDate input", true);

	}

	public void InputCardCVV(String text) throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("CVV_NAME"))).clear();
		chooseElement("CVV_NAME").sendKeys(text);
		Reporter.log("CardCVV input", true);

	}

	public void InputCardPIN(String text) throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("CardPin_NAME"))).clear();
		chooseElement("CardPin_NAME").sendKeys(text);
		Reporter.log("CardPin input", true);

	}

	public void ClickSaveCard() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("SaveCard_CSS"))).click();
		Reporter.log("save card clicked", true);

	}

	public void SuccessfulRechargeAssertion() throws IOException {

		String actualmessage = new WebDriverWait(driver, 60)
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//p[contains(.,'Airtime Purchase Successful!')]")))
				.getText();
		try {
			Assert.assertEquals(actualmessage, Expectedrechargesuccessmessage);
			System.out.println("Actual success message  =" + actualmessage);
			Reporter.log("Recharge Successful", true);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void ClickReceipt() throws IOException {
		try {
			chooseElement("Receipt_XPATH").click();
			Reporter.log("Receipt clicked", true);
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void ClickDoneBtn() throws IOException {
		try {
			chooseElement("ClickDoneBtn_XPATH").click();
			Reporter.log("Done Clicked successfully", true);
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void CloseReceipt() throws IOException {
		try {
			chooseElement("closeReceipt_CSS").click();
			Reporter.log("Receipt closed successfully", true);
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		} catch (AssertionError e) {
			System.err.println("Assertion failed: " + e.getMessage());
		}
	}

	public void PayWithQuicktellerAccount() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickPayWQuickteller_XPATH"))).click();
		Reporter.log("QuicktellerAccount Selected for Airtime Recharge", true);

	}

	public void PayBtn() throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickTransferbtn_XPATH"))).click();
		Reporter.log("Transfer Button Clicked Successfully", true);

	}

	public void InputTransactionPin(String text) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("ClickPinBtn_XPATH"))).clear();
		chooseElement("ClickPinBtn_XPATH").sendKeys(text);
		Reporter.log("Transfer Button Clicked Successfully", true);

	}
	
	public void SelectGlo() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(chooseElement("SelectGlo_XPATH"))).click();
		Reporter.log("Glo Clicked Successfully", true);
	}

}
