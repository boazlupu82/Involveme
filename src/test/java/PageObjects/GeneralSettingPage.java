package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class GeneralSettingPage extends BasePage{
	
	@FindBy(css=".sticky.py-4 button>span")
	WebElement publishBtn;

	public GeneralSettingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Step("Click publish button")
	public void clickPublishBtn() {
		click(publishBtn);
	}
}
