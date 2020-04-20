package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProjectEditingPage;
import PageObjects.StartPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class EditProjectTest extends BaseTest{
	
	@Test(description="Adding a slide to existing project")
	@Severity(SeverityLevel.BLOCKER)
	@Description("This test will add a slide to existing template and add a start rating feature to it")
	public void tc01_Add_a_slide_to_existing_project() {
		StartPage sp= new StartPage(driver);
		sp.clicklogn();
		LoginPage lg = new LoginPage(driver);
		sp.sleep(1000);
		lg.fillEMail("boaz.lupu@gmail.com");
		lg.fillpassWrd("Neli5077");
		lg.clickLogn();
		lg.sleep(1000);
		HomePage hp= new HomePage(driver);
		hp.chooseWrkSpc("My Workspace");
		hp.clickProjectMne("just A test");
		hp.clickEditPrjc();
		ProjectEditingPage pep= new ProjectEditingPage(driver);
		int beforeNum =pep.getSlideNum();
		pep.clickAddNwSld();
		int afterNum= pep.getSlideNum();
		Assert.assertEquals(afterNum, beforeNum+1);
	}
	@Test(description = "Drag and drop into slide")
	@Severity(SeverityLevel.BLOCKER)
	public void tc_02_Drag_n_Drop_to_Slide() {
		ProjectEditingPage pep=new ProjectEditingPage(driver);
		pep.addContElmt("Rating");
		boolean exist=pep.ratingElementVisible();
		
		Assert.assertEquals(exist, true);
	}
	@Test(description = "Delete from slide")
	public void tc_03_delete_from_slide() {
		ProjectEditingPage pep=new ProjectEditingPage(driver);
		pep.clickBackToList();
		pep.addContElmt("Button");
		
		
		
	}
}
