package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

//WebElements
	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")
	WebElement SIGNIN_BUTTON_ELEMENT;

// Intractable Methods
// Individual methods
	public void insertUserName(String userName) {
		USER_NAME_ELEMENT.sendKeys(userName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public void clickOnSigninButton() {
		SIGNIN_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public String getTitlePage() {
		return driver.getTitle();
		

	}
}
