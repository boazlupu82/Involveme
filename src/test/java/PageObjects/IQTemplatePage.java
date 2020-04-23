package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import io.qameta.allure.Step;

public class IQTemplatePage extends BasePage {
	@FindBy(css = ".wrapper.align-center>button")
	List<WebElement> secondAnsList;
	@FindBy(css = ".e-headline>.e-html-container")
	WebElement textQuestion1;
	@FindBy(css = ".c-button.btn")
	WebElement FirstPgStartBtn;
	@FindBy(css = ".e-html-container>span")
	WebElement textQuestion2;
	@FindBy(css = ".c-answer-container.v-horizontal>div:nth-child(3)")
	WebElement firstAns;
	@FindBy(css = ".e-html-container>span")
	WebElement textQuestion3;
	@FindBy(css = ".e-html-container>span")
	WebElement textQuestion4;
	@FindBy(css = ".c-answer-container.v-horizontal>div:nth-child(3)")
	WebElement sixAns;
	@FindBy(css = ".wrapper.align-center.is-shrinkable>span:nth-child(2)")
	WebElement finalScore;
	@FindBy(css = ".wrapper.align-center.is-shrinkable>span:nth-child(1)")
	WebElement iqText;

	public IQTemplatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Step("Click on first page start button")
	public void clickStartFirstPage() {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion1.getText().contains("TEST YOUR IQ");
		wait.until(elementTextContainsString);
		click(FirstPgStartBtn);

	}

	@Step("1Th answer is:{0}")
	public void chooseFirstAns() {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion2.getText()
				.contains("Complete the sequence");
		wait.until(elementTextContainsString);
		click(firstAns);
	}

	@Step("2Th answer is:{0}")
	public void chooseScndAns(String answer) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion2.getText()
				.contains("What has similar meaning");
		wait.until(elementTextContainsString);
		List<WebElement> sal = secondAnsList;
		for (int i = 0; i < sal.size(); i++) {
			if (getText(sal.get(i)).equalsIgnoreCase(answer))
				click(sal.get(i));
		}
	}

	@Step("3Th answer is:{0}")
	public void chooseThirdAns(String answer) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion2.getText()
				.contains("Find the analogy");
		wait.until(elementTextContainsString);
		List<WebElement> sal = secondAnsList;
		for (int i = 0; i < sal.size(); i++) {
			if (getText(sal.get(i)).equalsIgnoreCase(answer))
				click(sal.get(i));
		}
	}

	@Step("4Th answer is:{0}")
	public void chooseForthAns(String answer) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion2.getText()
				.contains("Continue the sequence");
		wait.until(elementTextContainsString);
		List<WebElement> sal = secondAnsList;
		for (int i = 0; i < sal.size(); i++) {
			if (getText(sal.get(i)).equalsIgnoreCase(answer))
				click(sal.get(i));
		}
	}

	@Step("5Th answer is:{0}")
	public void chooseFifthAns(String answer) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion2.getText()
				.contains("Find the odd one");
		wait.until(elementTextContainsString);
		List<WebElement> sal = secondAnsList;
		for (int i = 0; i < sal.size(); i++) {
			if (getText(sal.get(i)).equalsIgnoreCase(answer))
				click(sal.get(i));
		}
	}

	@Step("6TH answer is:{0}")
	public void chooseSixAns() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,3000)");
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion2.getText()
				.contains("Complete the sequence");
		wait.until(elementTextContainsString);
		click(sixAns);
	}

	@Step("7Th answer is:{0}")
	public void chooseSevenAns(String answer) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion2.getText()
				.contains("Find the odd one");
		wait.until(elementTextContainsString);
		List<WebElement> sal = secondAnsList;
		for (int i = 0; i < sal.size(); i++) {
			if (getText(sal.get(i)).equalsIgnoreCase(answer))
				click(sal.get(i));
		}

	}

	@Step("8TH answer is:{0}")
	public void chooseEightAns(String answer) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion2.getText()
				.contains("Continue the sequence");
		wait.until(elementTextContainsString);
		List<WebElement> sal = secondAnsList;
		for (int i = 0; i < sal.size(); i++) {
			if (getText(sal.get(i)).equalsIgnoreCase(answer))
				click(sal.get(i));
		}
	}

	@Step("9Th answer is:{0}")
	public void chooseNineAns(String answer) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion2.getText()
				.contains("Find the analogy");
		wait.until(elementTextContainsString);
		List<WebElement> sal = secondAnsList;
		for (int i = 0; i < sal.size(); i++) {
			if (getText(sal.get(i)).equalsIgnoreCase(answer))
				click(sal.get(i));
		}
	}

	@Step("10Th answer is:{0}")
	public void chooseTenAns(String answer) {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> textQuestion2.getText()
				.contains("Continue the sequence");
		wait.until(elementTextContainsString);
		List<WebElement> sal = secondAnsList;
		for (int i = 0; i < sal.size(); i++) {
			if (getText(sal.get(i)).equalsIgnoreCase(answer))
				click(sal.get(i));
		}
	}

	@Step("Get final score")
	public String getFinalScore() {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> iqText.getText().contains("IQ");
		wait.until(elementTextContainsString);
		String score = getText(finalScore);
		return score;
	}

	@Step("Get main tb handle")
	public String getWindowMainTab() {
		String mainWindow = driver.getWindowHandle();
		return mainWindow;
	}

	@Step("Switch to last opened tab")
	public void switchtoLastTab() {
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
		}
	}

	@Step("Switch back to main tab")
	public void switchToMainTab(String mainTab) {
		driver.switchTo().window(mainTab);
	}
}
