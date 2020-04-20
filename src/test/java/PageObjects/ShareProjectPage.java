package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ShareProjectPage extends BasePage{
	@FindBy(css=".navbar-nav.mr-auto>.nav-item>a")
	List<WebElement> topBarList;
	

	public ShareProjectPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Step("The link name is:{0}")
	public void choosePageDirection(String linkName) {
		List<WebElement> barList=topBarList;
		for(int i=0;i<barList.size();i++) {
			if(getText(barList.get(i)).equalsIgnoreCase(linkName)) {
				click(barList.get(i));
				break;
			}
		}
	}

}
