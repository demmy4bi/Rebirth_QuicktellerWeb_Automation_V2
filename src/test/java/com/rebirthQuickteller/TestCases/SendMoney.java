package com.rebirthQuickteller.TestCases;

import java.io.IOException;

import com.rebirthQuickteller.base.TestBase;

import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.LoginPageObjects;
import pages.SendMoneyPageObjects;
import pages.SignUpPageObjects;

public class SendMoney extends TestBase {

	SendMoneyPageObjects SendMoneyObj = new SendMoneyPageObjects(driver);
	LoginPageObjects LoginPageObj = new LoginPageObjects(driver);
	SignUpPageObjects SignUpPageObj = new SignUpPageObjects(driver);

	@Test(priority = 1, description = "This test case will perform transfer with card")
	public void CardTransferWithValidDetails() throws IOException, InterruptedException {
		Reporter.log("Test to perform transfer with card started !!!", true);

		// LoginPageObj.ClickSignInWithPhoneNumberButton();
		// LoginPageObj.EnterPhoneNumber("08098487373");
		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();
		SendMoneyObj.ClickSendMoney();
		SendMoneyObj.ClickNewButton();
		// SendMoneyObj.ClickSendNow();
		SendMoneyObj.EnterAccountNumber("1350008937");
		SendMoneyObj.ClickBankDropdown();
		SendMoneyObj.SelectBank("Quickteller");
		SendMoneyObj.SelectBankSearch();
	//	SendMoneyObj.SaveasBeneficiary();
		SendMoneyObj.ClickSNext();
		SendMoneyObj.EnterAmount("5000");
		SendMoneyObj.InputNarration("Bizza Bizza");
		SendMoneyObj.ClickSend();
		SendMoneyObj.ClickUseNewCard();
		SendMoneyObj.InputCardNumber("5612330000000000099");
		SendMoneyObj.InputCardExpiryDate("03/50");
		SendMoneyObj.InputCardCVV("111");
		SendMoneyObj.InputCardPIN("1234");
		SendMoneyObj.ClickNext();
		SendMoneyObj.SuccessfulTransferAssertion();
		SendMoneyObj.ViewReceipt();
		SendMoneyObj.AssertiontoConfirmReceiptisVisible();
		SendMoneyObj.CloseReceipt();
		Reporter.log("Test to perform transfer with card completed !!!", true);
	}

	@Test(priority = 2, description = "This test case will perform transfer with QtAccount")
	public void QtAccountTransferWithValidDetails() throws IOException, InterruptedException {
		Reporter.log("Test to perform transfer with QTAccount started !!!", true);
		NavigateHomePage();
		// LoginPageObj.ClickSignInWithPhoneNumberButton();
		// LoginPageObj.EnterPhoneNumber("08098487373");
		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();

		SendMoneyObj.ClickSendMoney();
		SendMoneyObj.ClickNewButton();
		// SendMoneyObj.ClickSendNow();
		SendMoneyObj.EnterAccountNumber("1350008463");
		SendMoneyObj.ClickBankDropdown();
		SendMoneyObj.SelectBank("Quickteller");
		SendMoneyObj.SelectBankSearch();
	//	SendMoneyObj.SaveasBeneficiary();
		SendMoneyObj.ClickSNext();
		SendMoneyObj.EnterAmount("1000");
		SendMoneyObj.InputNarration("Bizza Bizza");
		SendMoneyObj.ClickSend();
		SendMoneyObj.PayWithQuicktellerAccount();
		SendMoneyObj.InputTransactionPin("8407");
		SendMoneyObj.SuccessfulTransferAssertion();
		SendMoneyObj.ViewReceipt();
		// SendMoneyObj.AssertiontoConfirmReceiptisVisible();
		// SendMoneyObj.CloseReceipt();

		Reporter.log("Test to perform transfer with QTAccount completed !!!", true);
	}

	@Test(priority = 3, description = "This test case will perform transfer with QtAccount Using Invalid Pin")
	public void QtAccountTransferWithInValidPIN() throws IOException, InterruptedException {
		Reporter.log("Test to perform transfer with QTAccount Using Invalid Pin started !!!", true);
		NavigateHomePage();
		// LoginPageObj.ClickSignInWithPhoneNumberButton();
		// LoginPageObj.EnterPhoneNumber("08098487373");
		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();

		SendMoneyObj.ClickSendMoney();
		SendMoneyObj.ClickNewButton();
		// SendMoneyObj.ClickSendNow();
		SendMoneyObj.EnterAccountNumber("1350008463");
		SendMoneyObj.ClickBankDropdown();
		SendMoneyObj.SelectBank("Quickteller");
		SendMoneyObj.SelectBankSearch();
		//SendMoneyObj.SaveasBeneficiary();
		SendMoneyObj.ClickSNext();
		SendMoneyObj.EnterAmount("1000");
		SendMoneyObj.InputNarration("Bizza Bizza");
		SendMoneyObj.ClickSend();
		SendMoneyObj.PayWithQuicktellerAccount();
		SendMoneyObj.InputTransactionPin("0000");
		SendMoneyObj.InvalidTransactionPINAssertion();

		// SendMoneyObj.AssertiontoConfirmReceiptisVisible();
		// SendMoneyObj.CloseReceipt();

		Reporter.log("Test to perform transfer with QTAccount Using Invalid Pin completed !!!", true);
	}

	@Test(priority = 4, description = "This test case will perform Fund QtAccount with CARD")
	public void FundAccountWithValidDetails() throws IOException, InterruptedException {
		Reporter.log("Test to perform Fund QTAccount started !!!", true);
		NavigateHomePage();
		// LoginPageObj.ClickSignInWithPhoneNumberButton();
		// LoginPageObj.EnterPhoneNumber("09125490124");
		LoginPageObj.EnterEmail("demmy4bi@gmail.com");
		LoginPageObj.EnterPassword("Ademola1@");
		LoginPageObj.ClickSignInButton();

		SendMoneyObj.AddMoneyBtn();
		SendMoneyObj.FundAmount("5000");
		SendMoneyObj.PayBtn();
		SendMoneyObj.ClickUseNewCard();
		SendMoneyObj.InputCardNumber("5612330000000000099");
		SendMoneyObj.InputCardExpiryDate("03/50");
		SendMoneyObj.InputCardCVV("111");
		SendMoneyObj.InputCardPIN("1234");
		SendMoneyObj.ClickNext();
		SendMoneyObj.SuccessfulFundTransferAssertion();
		SendMoneyObj.ViewReceipt();
		// SendMoneyObj.AssertiontoConfirmReceiptisVisible();
		// SendMoneyObj.CloseReceipt();

		Reporter.log("Test to perform Fund QTAccount completed !!!", true);
	}

}
