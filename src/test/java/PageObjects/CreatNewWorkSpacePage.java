package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CreatNewWorkSpacePage extends BasePage{
	@FindBy(css=".p-6>input")
	WebElement workSpcName;
	@FindBy(css="#confirm-create-button")
	WebElement creatBtn;

	public CreatNewWorkSpacePage(WebDriver driver) {
		super(driver);
		
	}
	@Step("WorkSpace inserted name is:{0}")
	public void insertNwWrkSpc(String wrkSpcNm) {
		fillText(workSpcName, wrkSpcNm);
	}
	@Step("click on the creation new Workspcae buttun")
	public void clickCreatBtn() {
		click(creatBtn);
	}
	

}
