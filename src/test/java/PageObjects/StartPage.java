package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class StartPage extends BasePage {

	@FindBy(css = ".other-link.login")
	WebElement loginLnk;
	@FindBy(css = ".other-link.register")
	WebElement rgisterLnk;

	public StartPage(WebDriver driver) {
		super(driver);
	}

	@Step("Click login")
	public void clicklogn() {
		click(loginLnk);
	}
}
