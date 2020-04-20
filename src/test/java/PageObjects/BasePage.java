package PageObjects;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 15);
	}

	void click(WebElement el) {
		highlightElement(el, "yellow");
		el.click();
	}

	void fillText(WebElement el, String text) {
		highlightElement(el, "blue");
		el.clear();
		el.sendKeys(text);
	}

	String getText(WebElement el) {
		highlightElement(el, "pink");
		return el.getText();
	}
	void clearTextBox (WebElement el) {
		highlightElement(el, "gray");
		el.clear();
	}

	public void sleep(int miliSecs) {
		try {
			Thread.sleep(miliSecs);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	private void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background: yellow " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}

}
