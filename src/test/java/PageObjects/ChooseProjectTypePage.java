package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

import java.util.List;

public class ChooseProjectTypePage extends BasePage{
	@FindBy(css=".col-md-12.content-chooser .title")
	List<WebElement> projectType;

	public ChooseProjectTypePage(WebDriver driver) {
		super(driver);

	}
	@Step("Chossen project type:{0}")
	public void choosePrjtype(String prjcType) {
		List<WebElement> typeList = projectType;
		for(int i=0;i<typeList.size();i++) {
			if(getText(typeList.get(i)).equalsIgnoreCase(prjcType)) {

				click(typeList.get(i));
				break;
			}
		}
	}

}
