package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.junit.Assert;

public class AccountPage extends TestBase {
	static WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElements
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a/span[1]")
	WebElement BANK_AND_CASH;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")
	WebElement NEW_ACCOUNT_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement ACCOUNT_TITLE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")
	WebElement ACCOUNT_DESCRIPTION_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"balance\"]")
	WebElement INITIAL_BALANCE_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account_number\"]")
	WebElement ACCOUNT_NUMBER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_person\"]")
	WebElement CONTACT_PERSON_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_phone\"]")
	WebElement PHONE_NUMBER_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"ib_url\"]")
	WebElement INTERNET_BANKING_URL_FIELD;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")
	WebElement SUBMIT_BUTTON;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]")
	WebElement ACCOUNT_VALIDATION_TEXT;

	// Intractable Methods
	public void clickOnBankAndCashButton() {
		BANK_AND_CASH.click();
	}

	public void clickOnNewAccountButton() {
		NEW_ACCOUNT_BUTTON.click();
	}

	public void insertAccountTitle(String AccountTitle) {
		String accountTitle = AccountTitle + RandomGenerator();
		ACCOUNT_TITLE_FIELD.sendKeys(accountTitle);
	}

	public void insertDescription(String Description) {
		ACCOUNT_DESCRIPTION_FIELD.sendKeys(Description);
	}

	public void insertInitialBalance(String initialBalane) {
		INITIAL_BALANCE_FIELD.sendKeys(initialBalane);
	}

	public void insertAccountNumber(String AccountNumber) {
		ACCOUNT_NUMBER_FIELD.sendKeys(AccountNumber);
	}

	public void insertContactPerson(String ContactPerson) {
		CONTACT_PERSON_FIELD.sendKeys(ContactPerson);
	}

	public void inserPhoneNumber(String PhoneNumber) {
		PHONE_NUMBER_FIELD.sendKeys(PhoneNumber);
	}

	public void insertInternetBankinglink(String URL) {
		INTERNET_BANKING_URL_FIELD.sendKeys(URL);
	}

	public void clickOnSubmitButton() {
		SUBMIT_BUTTON.click();
	}

	public void accountCreationValidation() {
		// Xpath: //table//tr[164]//td
		String before_xpath = "//table//tr[";
		String after_Xpath = "]//td";
		for (int i = 164; i >= 60; i--) {
			String enteredNmae = driver.findElement(By.xpath(before_xpath + i + after_Xpath)).getText();
			if (enteredNmae.contains(enteredNmae)) {
				System.out.println("Account is created");
				break;
			} else {
				System.out.println("Account Creation unsuccesful please Try again!!");
			}

		}
	}
}