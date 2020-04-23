package pageObjects;

import java.util.List;

import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Quiz4ndPage extends BasePage {
	@FindBy(css = ".c-question-container button")
	List<WebElement> answerList;
	@FindBy(css = ".c-button.btn")
	WebElement nextBtn;
	@FindBy(css = ".e-html-container>span")
	WebElement textQuestion;

	public Quiz4ndPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void chooseAnswer(String name) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion.getText()
				.contains("How many computer");
		wait.until(elementTextContainsString);
		List<WebElement> ansLst = answerList;
		for (int i = 0; i < ansLst.size(); i++) {
			if (getText(ansLst.get(i)).equalsIgnoreCase(name)) {
				click(ansLst.get(i));
				break;
			}
		}
	}

	public void clickNext() {
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		click(nextBtn);
		click(nextBtn);
	}
}
