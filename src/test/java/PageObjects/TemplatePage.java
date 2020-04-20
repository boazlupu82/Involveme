package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;

import java.util.List;

public class TemplatePage extends BasePage {
	@FindBy(css=".details-container")
	List<WebElement> templateList;
	
	@FindBy(css=".btn.btn-primary")
	List<WebElement> chooseBtn;
		
	public TemplatePage(WebDriver driver) {
		super(driver);
		
	}
	@Step("Chossen template:{0}")
	public void chooseTemlate(String tmp) {
		List<WebElement> tmpLst = templateList;
		for(int i=0;i<tmpLst.size();i++) {
			if(getText(tmpLst.get(i)).equalsIgnoreCase(tmp)) {
				Actions actions = new Actions(driver);
				actions.moveToElement(tmpLst.get(i)).build().perform();
				wait.until(ExpectedConditions.visibilityOfAllElements(chooseBtn.get(i)));
				click(chooseBtn.get(i));
				
			}
		}
	}

}
