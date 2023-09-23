package com.rebirthQuickteller.TestCases;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.SendMoneyPageObjects;
import com.rebirthQuickteller.base.TestBase;
import pages.LoginPageObjects;
import pages.RechargePageObjects;
import pages.SignUpPageObjects;

public class Recharge extends TestBase {
	LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
	RechargePageObjects RechargePageObj = new RechargePageObjects(driver);
	SignUpPageObjects SignUpPageObj = new SignUpPageObjects(driver);
	SendMoneyPageObjects SendMoneyObj = new SendMoneyPageObjects(driver);

	@Test(priority = 1, description = "This test case will check user should not be able to recharge with invalid phoneNumber")
	public void InvalidphoneNumberAirtimeRecharge() throws IOException, InterruptedException {
		Reporter.log("Test to check user should not be able to recharge with invalid phoneNumber started !!!", true);
		// LoginPageObj.ClickSignInWithPhoneNumberButton();
		// LoginPageObj.EnterPhoneNumber("08098487373");
		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();

		// LoginPageObj.doitlatercllick();
		RechargePageObj.ClickAirtimeDataButton();
		RechargePageObj.ClickNewAirtimeButton();
		// RechargePageObj.SelectCountryCode("Nigeria");
		RechargePageObj.EnterPhoneNumber("08074");
		//RechargePageObj.ClickNext();
		LoginPageObj.InvalidphoneNumberInputAssertion();
		Reporter.log("Test to check user should not be able to recharge with invalid phoneNumber completed !!!", true);
	}

	@Test(priority = 2, description = "This test case will perform recharge with QTAccount ")
	public void QTAccountAirtimeRecharge() throws IOException, InterruptedException {

		Reporter.log("Test to perform recharge with QTAccount started !!!", true);
		NavigateHomePage();
		// LoginPageObj.ClickSignInWithPhoneNumberButton();
		// LoginPageObj.EnterPhoneNumber("08098487373");
		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();

		// LoginPageObj.doitlatercllick();
		RechargePageObj.ClickAirtimeDataButton();
		RechargePageObj.ClickNewAirtimeButton();
		RechargePageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		RechargePageObj.SelectGlo();
		RechargePageObj.ClickNext();
		RechargePageObj.EnterAmount("1000");
		RechargePageObj.ClickPay();
		RechargePageObj.PayWithQuicktellerAccount();
		RechargePageObj.InputTransactionPin("8407");
		// RechargePageObj.PayBtn();
		RechargePageObj.SuccessfulRechargeAssertion();
		// Thread.sleep(2000);

		RechargePageObj.ClickReceipt();
		RechargePageObj.CloseReceipt();
		RechargePageObj.ClickDoneBtn();

		// Thread.sleep(4000);
		// RechargePageObj.CloseReceipt();

		// LoginPageObj.ClickLogoutDropdownBtn();
		// LoginPageObj.ClickLogoutButton();
		Reporter.log("Test to perform recharge with QTAccount completed !!!", true);
	}

	@Test(priority = 3, description = "This test case will perform recharge with QTAccount using Invalid Transacton Pin ")
	public void QTAccountAirtimeRechargeWithInvalidTransactionPin() throws IOException, InterruptedException {

		Reporter.log("Test to perform recharge with QTAccount using Invalid Transacton Pin started !!!", true);
		NavigateHomePage();
		// LoginPageObj.ClickSignInWithPhoneNumberButton();
		// LoginPageObj.EnterPhoneNumber("08098487373");
		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();

		// LoginPageObj.doitlatercllick();
		RechargePageObj.ClickAirtimeDataButton();
		RechargePageObj.ClickNewAirtimeButton();
		RechargePageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		RechargePageObj.SelectGlo();
		RechargePageObj.ClickNext();
		RechargePageObj.EnterAmount("1000");
		RechargePageObj.ClickPay();
		RechargePageObj.PayWithQuicktellerAccount();
		RechargePageObj.InputTransactionPin("0000");
		// RechargePageObj.PayBtn();
		SendMoneyObj.InvalidTransactionPINAssertion();

		Reporter.log("Test to perform recharge with QTAccount using Invalid Transacton Pin completed !!!", true);
	}

	@Test(priority = 4, description = "This test case will perform recharge with Card ")
	//4
	public void CardAirtimeRecharge() throws IOException, InterruptedException {

		Reporter.log("Test to perform recharge with card started !!!", true);
		NavigateHomePage();
		// RechargePageObj.SelectCountryCode("Nigeria");
		// LoginPageObj.ClickSignInWithPhoneNumberButton();
		// LoginPageObj.EnterPhoneNumber("08098487373");
		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();

		// LoginPageObj.doitlatercllick();
		RechargePageObj.ClickAirtimeDataButton();
		RechargePageObj.ClickNewAirtimeButton();
		RechargePageObj.EnterPhoneNumber(RandomNigeriaPhoneGenerator());
		RechargePageObj.SelectGlo();
		RechargePageObj.ClickNext();
		RechargePageObj.EnterAmount("1000");
		RechargePageObj.ClickPay();
		RechargePageObj.ClickUseNewCard();
		RechargePageObj.InputCardNumber("5612330000000000099");
		RechargePageObj.InputCardExpiryDate("03/50");
		RechargePageObj.InputCardCVV("111");
		RechargePageObj.InputCardPIN("1234");
	//	RechargePageObj.ClickSaveCard();
		RechargePageObj.ClickNext();

		RechargePageObj.SuccessfulRechargeAssertion();

		RechargePageObj.ClickReceipt();
		RechargePageObj.CloseReceipt();
		RechargePageObj.ClickDoneBtn();

		// LoginPageObj.ClickLogoutDropdownBtn();
		// LoginPageObj.ClickLogoutButton();
		Reporter.log("Test to perform recharge with card completed !!!", true);
	}

}
