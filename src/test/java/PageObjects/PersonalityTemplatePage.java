package pageObjects;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import io.qameta.allure.Step;

public class PersonalityTemplatePage extends BasePage {
	@FindBy(css = ".c-question-container button")
	List<WebElement> answerList;
	@FindBy(css = ".c-button.btn")
	WebElement takeATestBtn;
	@FindBy(css = ".e-headline.is-shrinkable span")
	WebElement firstPageHeader;
	@FindBy(css = ".title.boldfont >span")
	WebElement secondPageHeader;
	@FindBy(css = ".input-label.firstName-label>input")
	WebElement firstNameTxtBx;
	@FindBy(css = ".input-label.lastName-label>input")
	WebElement lastNameTxtBx;
	@FindBy(css = ".input-label.email-label>input")
	WebElement emailTxtBx;
	@FindBy(css = ".c-checkbox-container:nth-child(3) .el-checkbox>span:nth-child(1)")
	WebElement iAgreeChBox;
	@FindBy(css = ".e-html-container-sub>span")
	WebElement questionProgress;
	@FindBy(css = ".wrapper.align-center>.e-headline span")
	WebElement endTestTxt;

	public PersonalityTemplatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Step("Click to start the test")
	public void clickTakeTest(String headerTxt, boolean enable) {
		if (enable) {
			ExpectedCondition<Boolean> elementTextContainsString = arg0 -> firstPageHeader.getText()
					.contains(headerTxt);
			wait.until(elementTextContainsString);
			click(takeATestBtn);
		} else {
			click(takeATestBtn);
		}
	}

	@Step("First name: {0}, Last name: {1}, E-mail: {2}")
	public void setPersonalDetails(String firstName, String lastName, String email) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> secondPageHeader.getText()
				.contains("Let's get started");
		wait.until(elementTextContainsString);
		fillText(firstNameTxtBx, firstName);
		fillText(lastNameTxtBx, lastName);
		fillText(emailTxtBx, email);
		click(iAgreeChBox);
	}

	@Step("Asnwer: {0}, Header name: {1}")
	public void chooseAnswer(String name, String headerName) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> questionProgress.getText().contains(headerName);
		wait.until(elementTextContainsString);
		List<WebElement> ansLst = answerList;
		for (int i = 0; i < ansLst.size(); i++) {
			if (getText(ansLst.get(i)).equalsIgnoreCase(name)) {
				click(ansLst.get(i));
				break;
			}
		}
	}

	@Step("Get final result")
	public String getFinalTxt() {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> endTestTxt.getText().contains("Receiving gifts");
		wait.until(elementTextContainsString);
		String txt = endTestTxt.getText();
		return txt;
	}

	@Step("Get main window handle")
	public String getWindowMainTab() {
		String mainWindow = driver.getWindowHandle();
		return mainWindow;
	}

	@Step("Switch to last open tab")
	public void switchtoLastTab() {
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
		}
	}

	@Step("Switch back to main window: {0}")
	public void switchToMainTab(String mainTab) {
		driver.switchTo().window(mainTab);
	}

}
