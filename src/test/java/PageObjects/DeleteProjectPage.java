package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class DeleteProjectPage extends BasePage {
	@FindBy(css = "#confirm-delete-button")
	WebElement confrmDltbtn;

	public DeleteProjectPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Step("Click tp delete a project")
	public void clickDltPrj() {
		click(confrmDltbtn);
	}
}
