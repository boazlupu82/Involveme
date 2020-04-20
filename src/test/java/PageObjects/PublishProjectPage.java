package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;

public class PublishProjectPage extends BasePage{
	@FindBy(css="#confirm-publish-button>span")
	WebElement publishNowBtn;
	@FindBy(css="#confirm-publish-button>span")
	WebElement wrnPulishBtn;
	public PublishProjectPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Step("Click publish button")
	public void clickPublishBtn() {
		click(publishNowBtn);
	}
	@Step("Click on worning button")
	public void clickWorningPublishBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(wrnPulishBtn));
		click(wrnPulishBtn);
	}

}
