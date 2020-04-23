package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class NewProjectPage extends BasePage {
	@FindBy(css = ".form-group>input")
	WebElement projectName;
	@FindBy(css = ".swal-button-container>button")
	WebElement startEditing;

	public NewProjectPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Step("Entered project name:{0}")
	public void enterProjectName(String name) {
		fillText(projectName, name);
	}

	@Step("Click start edit")
	public void clickStartEdit() {
		click(startEditing);
	}
}
