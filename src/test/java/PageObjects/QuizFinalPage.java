package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class QuizFinalPage extends BasePage {
	@FindBy(css = ".wrapper.align-left.is-shrinkable>span:nth-child(2)")
	WebElement actualScore;
	@FindBy(css = ".wrapper.align-left.is-shrinkable>span:nth-child(4)")
	WebElement numOfQuestion;

	public QuizFinalPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Step("Get number of correct answers")
	public String getNumOfCorrctAsn() {
		String num = getText(actualScore);
		return num;
	}

	@Step("Get number of question")
	public String getNumOfQustions() {
		String num = getText(numOfQuestion);
		return num;
	}

	@Step("Switch to main tab")
	public void switchToMainTab(String mainTab) {
		driver.close();
		driver.switchTo().window(mainTab);
	}
}
