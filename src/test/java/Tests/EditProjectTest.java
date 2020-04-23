package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProjectEditingPage;
import pageObjects.StartPage;
import utilities.ReadDataFile;

public class EditProjectTest extends BaseTest {

	@Test(description = "Adding a slide to existing project")
	@Severity(SeverityLevel.BLOCKER)
	@Description("This test will add a slide to existing template and add a start rating feature to it")
	public void tc01_Add_a_slide_to_existing_project() {
		StartPage sp = new StartPage(driver);
		sp.clicklogn();
		LoginPage lg = new LoginPage(driver);
		sp.sleep(1000);
		lg.fillEMail("boaz.lupu@gmail.com");
		lg.fillpassWrd("Neli5077");
		lg.clickLogn();
		lg.sleep(1000);
		HomePage hp = new HomePage(driver);
		hp.chooseWrkSpc(ReadDataFile.readDataFile("WorkSpace"));
		hp.clickProjectMne("Boaz Vacation");
		hp.clickEditPrjc();
		ProjectEditingPage pep = new ProjectEditingPage(driver);
		int beforeNum = pep.getSlideNum();
		pep.clickAddNwSld();
		int afterNum = pep.getSlideNum();
		Assert.assertEquals(afterNum, beforeNum + 1);
	}

	@Test(description = "Drag and drop Star-rating feature into a slide")
	@Severity(SeverityLevel.BLOCKER)
	public void tc_02_Drag_n_Drop_Start_Rating_to_Slide() {
		ProjectEditingPage pep = new ProjectEditingPage(driver);
		pep.addContElmt("Rating");
		pep.sleep(2000);
		pep.clickLastSlide();
		boolean exist1 = pep.ratingElementVisible();

		Assert.assertEquals(exist1, true);
	}
	@Test(description = "Drag and drop a contact feature into a slide")
	@Severity(SeverityLevel.BLOCKER)
	public void tc_03_Drag_n_Drop_Contact_Feature_to_Slide() {
		ProjectEditingPage pep = new ProjectEditingPage(driver);
		pep.clickAddNwSld();
		pep.sleep(1500);
		pep.addContElmt("Contact Info");
		pep.sleep(2000);
		pep.clickLastSlide();
		boolean exist2 = pep.contactElementVisible();
		Assert.assertEquals(exist2, true);
	}
}
