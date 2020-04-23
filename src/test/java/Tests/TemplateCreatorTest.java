package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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

public class TemplateCreatorTest extends BaseTest {
	String workSpaceName = ReadDataFile.readDataFile("WorkSpace");

	@Test(description = "Creat new WorkSpace")
	@Description("This test will generate 6 templates from 5 diferent categories using data provider method")
	@Severity(SeverityLevel.NORMAL)
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

	@Test(dataProvider = "getData", description = "Creat new Project")
	@Severity(SeverityLevel.NORMAL)
	public void tc_02_creat_new_project(String projectType, String template, String projectName) {
		HomePage hm = new HomePage(driver);
		hm.sleep(3000);
		String beforeNum = hm.chooseWrkSpc(workSpaceName);
		if (beforeNum.equals("0")) {
			hm.clickStartBtn();
		} else {
			hm.clickNewProject();
		}
		ChooseProjectTypePage cpt = new ChooseProjectTypePage(driver);
		cpt.choosePrjtype(projectType);
		TemplatePage tp = new TemplatePage(driver);
		tp.sleep(2000);
		tp.chooseTemlate(template);
		NewProjectPage npp = new NewProjectPage(driver);
		npp.enterProjectName(projectName);
		npp.clickStartEdit();
		ProjectEditingPage pep = new ProjectEditingPage(driver);
		pep.clickSveExtBtn();
		String afterNum = hm.chooseWrkSpc(workSpaceName);

		Assert.assertEquals(Integer.parseInt(afterNum), Integer.parseInt(beforeNum) + 1);

	}

	@DataProvider
	@Description("This is data provider method for the ceate new project templates tests ")
	public Object[][] getData() {
		Object[][] data = { 
				{ "Form", "Contact Form", "Boaz Contact Form" },
				{"Form","Book A Trip For Two","Boaz Vacation"},
				{ "Quiz", "Technology Quiz", "Boaz Tech Quiz" },
				{ "Quiz", "IQ Test", "Boaz IQ Quiz" },
				{ "Personality Test", "What's Your Love Language?", "Boaz Love Language" },
				{ "Calculator", "Website ROI Calculator", "The Best Calc ever" } };
		return data;
	}
}
