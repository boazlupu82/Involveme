package PageObjects;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

import io.qameta.allure.Step;

public class CalcTemplatePage extends BasePage{
	@FindBy(css=".title.boldfont")
	List<WebElement> questionList;
	@FindBy(css=".slider-item>input")
	List<WebElement> slideBarList;
	@FindBy(css=".e-subheadline>.e-html-container")
	WebElement header;
	@FindBy(css=".c-input-container>input")
	WebElement inputAvgSalePrice;
	@FindBy(css=".c-button.btn")
	WebElement calcBtn;
	@FindBy(css=".e-headline.is-shrinkable>.e-html-container>span")
	WebElement finalMsgTxt;


	public CalcTemplatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Step("The qustion is:{0}, The answer is:{1}")
	public void setAnswer(String question,int value){
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> header.getText().contains("Find out how much additional revenue you could make.");
		wait.until(elementTextContainsString);
		List<WebElement> qstList=questionList;
		List<WebElement> sldBrLst=slideBarList;
		for(int i=0;i<qstList.size();i++) {
			String name=getText(qstList.get(i));
			if(getText(qstList.get(i)).equalsIgnoreCase(question)) {
				Actions move = new Actions(driver);
				move.moveToElement(sldBrLst.get(i)).click().dragAndDropBy(sldBrLst.get(i), value, 0).build().perform();
				break;
			}
		}
	}
	@Step("The average sales price set:{0}")
	public void setAverageSalesPrice(String price) {
		inputAvgSalePrice.click();
		inputAvgSalePrice.sendKeys(""+price);
	}
	@Step("Clik on calculate in template final page")
	public void clickCalculate() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,2500)");
		click(calcBtn);
	}
	@Step("Getting main window handle")
	public String getWindowMainTab() {
		String mainWindow = driver.getWindowHandle();
		return mainWindow;	
	}
	@Step("Switching to opened new tab")
	public void switchtoLastTab() {
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			driver.switchTo().window(win);			
		}
	}
	@Step("Switchig back to main tab:{0}")
	public void switchToMainTab(String mainTab) {
		driver.switchTo().window(mainTab);
	}
	@Step("Getting last slide final outcome result")
	public String getFinalCalcMsg() {
		ExpectedCondition<Boolean> elementTextContainsString = arg0 -> finalMsgTxt.getText().contains("Additional Revenue");
		wait.until(elementTextContainsString);
		String txt=finalMsgTxt.getText();
		return txt;
	}
}

