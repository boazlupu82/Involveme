package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.ChooseProjectTypePage;
import pageObjects.CreatNewWorkSpacePage;
import pageObjects.DeleteProjectPage;
import pageObjects.DeleteWorkSpacePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewProjectPage;
import pageObjects.ProjectEditingPage;
import pageObjects.StartPage;
import pageObjects.TemplatePage;
import utilities.ReadDataFile;

public class FormContactsCreatProjectTest extends BaseTest {
	String workSpaceName = "WorkSpaceTest";

	@Test(description = "Creat new WorkSpace")
	public void tc_01_creat_new_WorkSpace() {
		StartPage sp = new StartPage(driver);
		sp.clicklogn();
		LoginPage lg = new LoginPage(driver);
		sp.sleep(1000);
		lg.fillEMail("boaz.lupu@gmail.com");
		lg.fillpassWrd("Neli5077");
		lg.clickLogn();
		HomePage hm = new HomePage(driver);
		sp.sleep(4000);
		int beforeNum = hm.getNumOfWrkSpc();
		hm.clickNewWorkSpc();
		CreatNewWorkSpacePage nws = new CreatNewWorkSpacePage(driver);
		nws.insertNwWrkSpc(workSpaceName);
		nws.clickCreatBtn();
		int AfterNum = hm.getNumOfWrkSpc();
		Assert.assertEquals(AfterNum, beforeNum);
	}

	@Test(description = "Creat new Project")
	public void tc_02_creat_new_project() {
		HomePage hm = new HomePage(driver);
		hm.sleep(3000);
		String beforeNum = hm.chooseWrkSpc(workSpaceName);
		if (beforeNum.equals("0")) {
			hm.clickStartBtn();
		} else {
			hm.clickNewProject();
		}
		ChooseProjectTypePage cpt = new ChooseProjectTypePage(driver);
		cpt.choosePrjtype("Survey");
		TemplatePage tp = new TemplatePage(driver);
		tp.sleep(2000);
		tp.chooseTemlate("360° Employee Evaluation");
		NewProjectPage npp = new NewProjectPage(driver);
		npp.enterProjectName("Boaz employee survey");
		npp.clickStartEdit();
		ProjectEditingPage pep = new ProjectEditingPage(driver);
		pep.clickSveExtBtn();
		String afterNum = hm.chooseWrkSpc(workSpaceName);

		Assert.assertEquals(Integer.parseInt(afterNum), Integer.parseInt(beforeNum) + 1);

	}

	@Test(description = "Delete created project")
	public void tc_03_Delete_Created_Project() {
		HomePage hp = new HomePage(driver);
		String numBefore = hp.chooseWrkSpc(workSpaceName);
		hp.sleep(1000);
		hp.clickProjectMne("Boaz employee survey");
		hp.clickDltPrjc();
		DeleteProjectPage dpp = new DeleteProjectPage(driver);
		dpp.clickDltPrj();
		dpp.sleep(1000);
		String numAfter = hp.chooseWrkSpc(workSpaceName);

		Assert.assertEquals(Integer.parseInt(numAfter), Integer.parseInt(numBefore) - 1);
	}

	@Test(description = "Delete WorkSpace")
	public void tc_04_Delete_WorkSpace() {
		HomePage hp = new HomePage(driver);
		int beforeNum = hp.getNumOfWrkSpc();
		hp.chooseWrkSpc(workSpaceName);
		hp.clickDrpDwnWrkSpc();
		hp.clickDltWrkSpc();
		DeleteWorkSpacePage dwp = new DeleteWorkSpacePage(driver);
		dwp.insertWrkSpc(workSpaceName);
		dwp.clickDelete();
		hp.sleep(1000);
		int AfterNum = hp.getNumOfWrkSpc();
		Assert.assertEquals(AfterNum, beforeNum - 1);
	}
}
