package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Quiz5ndPage extends BasePage{
	private static final String JavascriptExecutor = null;
	@FindBy(css=".wrapper.align-left>button")
	List<WebElement> answerList;
	@FindBy(css=".wrapper.align-left>.c-button")
	WebElement nextBtn;
	@FindBy(css=".e-html-container>span")
	WebElement textQuestion;
	@FindBy(css=".wrapper.align-left>button")
	List<WebElement> listButton;

	public Quiz5ndPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void chooseAnswer(String name) {

		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion.getText().contains("What does the Internet");
		wait.until(elementTextContainsString);
		List<WebElement> ansLst=answerList;
		for(int i=0;i<ansLst.size();i++) {
			System.out.println(ansLst.get(i));
			if(getText(ansLst.get(i)).equalsIgnoreCase(name)) {
				click(ansLst.get(i));

				break;
			}
		}
	}
	public void clickNext(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		List<WebElement> btn=listButton;
		for(int i=0;i<btn.size();i++) {
			System.out.println(btn.get(i));
			if(getText(btn.get(i)).equalsIgnoreCase(name)) {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("scrollBy(0,2500)");
				Actions actions = new Actions(driver);
				actions.moveToElement(btn.get(i)).build().perform();
				click(btn.get(i));
				break;
			}

			//sleep(2000);
			//click(nextBtn);

		}
	}
}
