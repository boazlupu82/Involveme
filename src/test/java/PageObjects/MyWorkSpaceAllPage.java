package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWorkSpaceAllPage extends BasePage{
	@FindBy(css=".dropdown.relative .text-xs")
	WebElement loggedUsrName;

	public MyWorkSpaceAllPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getLoggedUsrNm() {
		String lgUser= loggedUsrName.getText();
		return lgUser;
	}
	
}
