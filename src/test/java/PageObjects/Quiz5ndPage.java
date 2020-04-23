package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Quiz5ndPage extends BasePage {

	@FindBy(css = ".c-question-container.content-item.is-snappable button")
	List<WebElement> answerList;
	@FindBy(css = ".wrapper.align-left>.c-button")
	WebElement nextBtn;
	@FindBy(css = ".e-html-container>span")
	WebElement textQuestion;
	@FindBy(css = ".wrapper.align-left>button")
	List<WebElement> listButton;

	public Quiz5ndPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void chooseAnswer(String name) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion.getText()
				.contains("What does the Internet prefix WWW stand for?");
		wait.until(elementTextContainsString);
		sleep(1500);
		List<WebElement> ansLst = answerList;
		for (int i = 0; i < ansLst.size(); i++) {
			System.out.println(ansLst.get(i));
			if (getText(ansLst.get(i)).equalsIgnoreCase(name)) {
				click(ansLst.get(i));
				break;
			}
		}
	}

	public void clickNext(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		List<WebElement> btn = listButton;
		for (int i = 0; i < btn.size(); i++) {
			System.out.println(btn.get(i));
			if (getText(btn.get(i)).equalsIgnoreCase(name)) {
				scrollDownTo(2500);
				moveToElement(btn.get(i));
				click(btn.get(i));
				break;
			}
		}
	}
}
