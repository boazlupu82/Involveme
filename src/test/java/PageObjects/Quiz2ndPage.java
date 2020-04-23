package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Quiz2ndPage extends BasePage {
	@FindBy(css = ".c-question-container button")
	List<WebElement> answerList;
	@FindBy(css = ".c-button.btn")
	WebElement nextBtn;

	public Quiz2ndPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void chooseAnswer(String name) {
		List<WebElement> ansLst = answerList;
		for (int i = 0; i < ansLst.size(); i++) {
			if (getText(ansLst.get(i)).equalsIgnoreCase(name)) {
				click(ansLst.get(i));
				sleep(1000);

				break;
			}
		}
	}

	public void clickNext() {
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		click(nextBtn);
	}
}
