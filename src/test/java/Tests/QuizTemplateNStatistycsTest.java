package tests;

import java.util.ArrayList;
import java.util.Set;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.ChooseProjectTypePage;
import pageObjects.CreatNewWorkSpacePage;
import pageObjects.GeneralSettingPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.NewProjectPage;
import pageObjects.ProjectEditingPage;
import pageObjects.PublishProjectPage;
import pageObjects.Quiz1ndPage;
import pageObjects.Quiz2ndPage;
import pageObjects.Quiz3ndPage;
import pageObjects.Quiz4ndPage;
import pageObjects.Quiz5ndPage;
import pageObjects.Quiz6ndPage;
import pageObjects.QuizFinalPage;
import pageObjects.ShareProjectPage;
import pageObjects.StartPage;
import pageObjects.TemplatePage;
import utilities.ReadDataFile;

public class QuizTemplateNStatistycsTest extends BaseTest {
	String beforeSubmiss;
	String beforeView;
	String workSpaceName = ReadDataFile.readDataFile("WorkSpace");
	String projectName = "Boaz Tech Quiz";

	@Test(description = "Publish a project")
	@Description("This test will Creat and publish new project from quiz template and check views and submission")
	@Severity(SeverityLevel.CRITICAL)
	public void tc01_Publish_A_Project() {
		StartPage sp = new StartPage(driver);
		sp.clicklogn();
		LoginPage lg = new LoginPage(driver);
		sp.sleep(1000);
		lg.fillEMail("boaz.lupu@gmail.com");
		lg.fillpassWrd("Neli5077");
		lg.clickLogn();
		HomePage hm = new HomePage(driver);
		sp.sleep(4000);
		hm.clickNewWorkSpc();
		CreatNewWorkSpacePage nws = new CreatNewWorkSpacePage(driver);
		nws.insertNwWrkSpc(workSpaceName);
		nws.clickCreatBtn();
		hm.sleep(2000);
		String beforeNum = hm.chooseWrkSpc(workSpaceName);
		if (beforeNum.equals("0")) {
			hm.clickStartBtn();
		} else {
			hm.clickNewProject();
		}
		ChooseProjectTypePage cpt = new ChooseProjectTypePage(driver);
		cpt.choosePrjtype("Quiz");
		TemplatePage tp = new TemplatePage(driver);
		tp.sleep(2000);
		tp.chooseTemlate("Technology Quiz");
		NewProjectPage npp = new NewProjectPage(driver);
		npp.enterProjectName(projectName);
		npp.clickStartEdit();
		ProjectEditingPage pep = new ProjectEditingPage(driver);
		pep.clickSveExtBtn();
		String beforeTxt = hm.getTabNum("Published");
		hm.clickPublish(projectName);
		GeneralSettingPage gsp = new GeneralSettingPage(driver);
		gsp.clickPublishBtn();
		PublishProjectPage ppp = new PublishProjectPage(driver);
		ppp.clickPublishBtn();
		ShareProjectPage spp = new ShareProjectPage(driver);
		spp.choosePageDirection("Projects");
		hm.chooseWrkSpc(workSpaceName);
		hm.chooseTabAndClick("Published");
		String afterTxt = hm.getTabNum("Published");
		Assert.assertEquals(Integer.parseInt(afterTxt), Integer.parseInt(beforeTxt) + 1);
	}

	@Test(description = "template test")
	@Severity(SeverityLevel.NORMAL)
	public void tc_02_template_tets() {
		HomePage hm = new HomePage(driver);
		hm.chooseWrkSpc(workSpaceName);
		hm.chooseTabAndClick("Published ");
		hm.sleep(2000);
		beforeSubmiss = hm.getProjectSubmssn(projectName);
		System.out.println(beforeSubmiss);
		beforeView = hm.getProjectViews(projectName);
		System.out.println(beforeView);
		hm.clickView(projectName);

		Quiz1ndPage q1p = new Quiz1ndPage(driver);
		String mainWindow = q1p.getWindowMainTab();
		q1p.switchtoLastTab();
		q1p.clickStartBtn();
		Quiz2ndPage q2p = new Quiz2ndPage(driver);
		q2p.chooseAnswer("Steve Jobs");
		q2p.clickNext();
		Quiz3ndPage q3p = new Quiz3ndPage(driver);
		q3p.chooseAnswer("Operating System");
		q3p.clickNext();
		Quiz4ndPage q4p = new Quiz4ndPage(driver);
		q4p.chooseAnswer("4500");
		q4p.clickNext();
		Quiz5ndPage q5p = new Quiz5ndPage(driver);
		q5p.chooseAnswer("Western World Words");
		q5p.clickNext("Next");
		Quiz6ndPage q6p = new Quiz6ndPage(driver);
		q6p.chooseAnswer("Animation/video file");
		q6p.clickNext("Next");
		QuizFinalPage qfp = new QuizFinalPage(driver);
		qfp.sleep(5000);
		String acturlResult = qfp.getNumOfCorrctAsn();
		qfp.switchToMainTab(mainWindow);
		System.out.println("The actual results are: " + acturlResult);
		Assert.assertEquals(Integer.parseInt(acturlResult), 3);
	}

	@Test(description = "Get Views and submission statystics")
	@Severity(SeverityLevel.CRITICAL)
	public void tc_03_views_and_submission_test(ITestContext context) {
		HomePage hm = new HomePage(driver);
		hm.chooseTabAndClick("Published ");
		String AfterSubmiss = hm.getProjectSubmssn(projectName);
		System.out.println(AfterSubmiss);
		String AfterView = hm.getProjectViews(projectName);
		System.out.println(AfterView);
		int AftSubm = Integer.parseInt(AfterSubmiss);
		int AftVw = Integer.parseInt(AfterView);
		int[] after = new int[] { AftSubm, AftVw };
		int BfrSub = Integer.parseInt(beforeSubmiss);
		int BfrVw = Integer.parseInt(beforeView);
		int[] expected = new int[] { BfrSub + 1, BfrVw + 1 };

		Assert.assertEquals(after, expected);
	}
}
