package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Quiz3ndPage extends BasePage {

	@FindBy(css = ".c-question-container button")
	List<WebElement> answerList;
	@FindBy(css = ".c-button.btn")
	WebElement nextBtn;
	@FindBy(css = ".e-html-container>span")
	WebElement textQuestion;

	public Quiz3ndPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void chooseAnswer(String name) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion.getText().contains("What does the");
		wait.until(elementTextContainsString);
		List<WebElement> ansrList = answerList;
		for (int i = 0; i < ansrList.size(); i++) {
			if (getText(ansrList.get(i)).equalsIgnoreCase(name)) {
				click(ansrList.get(i));
				sleep(2000);
				break;
			}
		}
	}

	public void clickNext() {
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		click(nextBtn);
	}
}
