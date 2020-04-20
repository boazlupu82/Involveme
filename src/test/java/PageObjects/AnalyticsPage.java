package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class AnalyticsPage extends BasePage {
	
	@FindBy(css=".mr-1.text-gray-600")
	WebElement viewBtn;

	public AnalyticsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickViewBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(viewBtn));
		click(viewBtn);
	}

}
