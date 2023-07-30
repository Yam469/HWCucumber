package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import pages.AccountPage;
import pages.LoginPage;
import pages.TestBase;

public class StepDefinition extends TestBase {
	LoginPage loginpage;
	AccountPage accountpage;
	@Before
	public void beforeRun() {
		initDriver();
		 loginpage =PageFactory.initElements(driver, LoginPage.class);
		
	}
	@Given ("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		
		driver.get("https://techfios.com/billing/?ng=login/after/dashboard");
	}
	@When ("User enters username as {string}")
	public void  User_enters_username_as(String username) throws InterruptedException {
		//loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(username);
	}
	@When ("User clicks on Sign in button")
	public void user_clicks_on_Sign_in_button() {
		loginpage.clickOnSigninButton();
	}
	@Then ("User should land on dashboard page")
	public void User_should_land_on_dashboard_page() {
		String expectedTitle="Dashboard- iBilling";
		String actualTitle=loginpage.getTitlePage();
		Assert.assertEquals("Dashboard page not found!!", expectedTitle, actualTitle);
		
	}
	@When("User enters password as {string}")
	public void user_enters_password_as(String password) {
		loginpage.insertPassword(password);
	}
	@When("User enters wrongpassword as {string}")
	public void user_enters_wrongpassword_as(String password) {
		loginpage.insertPassword(password);
	}
	@Then("User should not land on dashboard page")
	public void user_should_not_land_on_dashboard_page() {
	    
	}

	@When("User enters the {string} in the {string} field")
	public void user_enters_the_in_the_field(String logininfo, String field) {
	  /*  if(field.equalsIgnoreCase("username")) {
	    	loginpage.insertUserName(logininfo);	
	    }
	    else if(field.equalsIgnoreCase("password")) {
	    	loginpage.insertPassword(logininfo);
	    	
	    }else {
	    	System.out.println("Login info:"+logininfo+" and field:"+field+" is not valid!");
	    }
	}*/
	switch(field) {
	case "username":
	
	loginpage.insertUserName(logininfo);
	break;
	case "password":
		loginpage.insertPassword(logininfo);
		break;
		default: 
			System.out.println("Login info:\"+logininfo+\" and field:\"+field+\" is not valid!");
		
	}
	}
	@When("User clicks on {string}")
	public void user_clicks_on(String buttontype) {
	switch(buttontype) {
	case "login":
		loginpage.clickOnSigninButton();
		break;
	case "bankCash":
		accountpage=PageFactory.initElements(driver, AccountPage.class);
		accountpage.clickOnBankAndCashButton();
		break;
	case "newAccount":
		accountpage.clickOnNewAccountButton();
		break; 
	case "submit":
		accountpage.clickOnSubmitButton();
		default:
			System.out.println("Unable to click:"+buttontype);
	}
	   
	}

	@Then("User enters {string} in the {string} field in accounts page")
	public void user_enters_in_the_field_in_accounts_page(String accountinfo, String field) {
	   switch (field) {
	   case "accountTitle":
		   accountpage.insertAccountTitle(accountinfo);
		   break;
	   case "description":
		   accountpage.insertDescription(accountinfo);
		   break;
	   case "initialBalance":
		   accountpage.insertInitialBalance(accountinfo);
		   break;
	   case "accountNumber":
		   accountpage.insertAccountNumber(accountinfo);
		   break;
	   case"contactPerson":
		   accountpage.insertContactPerson(accountinfo);
		   break;
	   case "Phone":
		   accountpage.inserPhoneNumber(accountinfo);
		   break;
	   case "internetBankingURL":
		   accountpage.insertInternetBankinglink(accountinfo);
		   default:
			   System.out.println("Account information: "+accountinfo+" is not correct in"+field);
	   
	   
	   }
	}

	@Then("User should be able to validate account created successfully")
	public void user_should_be_able_to_validate_account_created_successfully() {
	    accountpage.accountCreationValidation();
	}

	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
