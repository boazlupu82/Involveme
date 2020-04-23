package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Quiz1ndPage extends BasePage {
	@FindBy(css = ".c-button.btn")
	WebElement startBtn;

	public Quiz1ndPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickStartBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(startBtn));
		click(startBtn);
	}

	public String getWindowMainTab() {
		String mainWindow = driver.getWindowHandle();
		return mainWindow;

	}

	public void switchtoLastTab() {
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);
		}
	}
}
