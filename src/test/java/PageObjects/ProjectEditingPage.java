package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;

public class ProjectEditingPage extends BasePage {
	@FindBy(css = ".e-close")
	WebElement saveNExitBtn;
	@FindBy(css = ".e-pages-container .e-page-management")
	List<WebElement> slideList;
	@FindBy(css = "div.e-page-item.current > div.add-page-container >button")
	WebElement addNewSlide;
	@FindBy(css = "#tab1contentitems .svg-wrapper+p")
	List<WebElement> contentElemenyNameList;
	@FindBy(css = ".tab-content .svg-wrapper")
	List<WebElement> contentElemenyBoxList;
	@FindBy(css = ".content-item-wrapper.shadow.empty_canvas")
	WebElement dropLocation;
	@FindBy(css = ".content-item.has-rating.target-component")
	WebElement ratingElement;
	@FindBy(css = "#input_vk21ds2")
	WebElement questionTxt;
	@FindBy(css = ".c-menu-data-collection .settings-back")
	WebElement backToElList;

	public ProjectEditingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Step("Click on Save and Exist")
	public void clickSveExtBtn() {
		wait.until(ExpectedConditions.visibilityOf(saveNExitBtn));
		click(saveNExitBtn);
	}

	@Step("Get number of slides")
	public int getSlideNum() {
		int num = slideList.size();
		return num;
	}

	@Step("The question is: {0}")
	public void insertQstionTxt(String txt) {
		fillText(questionTxt, txt);
	}

	@Step("Click back to list")
	public void clickBackToList() {
		click(backToElList);
	}

	@Step("Checking whether Rating element was added to slide")
	public boolean ratingElementVisible() {
		try {
			driver.findElement(By.cssSelector(".rating-items-container"));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}
	@Step("Checking whether contact element was added to slide")
	public boolean contactElementVisible() {
		try {
			driver.findElement(By.cssSelector(".c-data-collection-container"));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}
	@Step("Add the content: {0}")
	public void addContElmt(String contentName) {
		Actions actions = new Actions(driver);
		List<WebElement> contElmtlstName = contentElemenyNameList;
		for (int i = 0; i < contElmtlstName.size(); i++) {
			if (getText(contElmtlstName.get(i)).equalsIgnoreCase(contentName)) {
				sleep(1000);
				actions.dragAndDrop(contentElemenyBoxList.get(i),driver.findElement(By.cssSelector(".empty-canvas-info.center-center"))).build().perform();
				sleep(1000);
				actions.moveByOffset(725, 268).contextClick().perform();
				sleep(1000);
				actions.click();
				sleep(1000);
				windowRefresh();
				break;
			}
		}
	}
	public void clickLastSlide() {
		sleep(1000);
		List<WebElement> list = slideList;
		int slideNum=list.size();
		click(list.get(slideNum-2));
	}
	@Step("Add new slide")
	public void clickAddNwSld() {
		List<WebElement> sldLst = slideList;
		int i = sldLst.size();
		click(sldLst.get(i - 2));
		click(addNewSlide);
	}
}
