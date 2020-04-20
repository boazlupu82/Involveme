package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;



public class DeleteWorkSpacePage extends BasePage{
	@FindBy(css=".p-6 input")
	WebElement inputTxtBx;
	@FindBy(css="#confirm-create-button")
	WebElement deleteBtn;
	

	public DeleteWorkSpacePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Step("The chossen WorkSpace to delete is:{0}")
	public void insertWrkSpc(String wrkSpcNm) {
		fillText(inputTxtBx, wrkSpcNm);
	}
	@Step("Click to delete")
	public void clickDelete() {
		wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
		click(deleteBtn);
	}

}
