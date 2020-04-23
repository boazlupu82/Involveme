package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.AnalyticsPage;
import pageObjects.BasePage;
import pageObjects.CalcTemplatePage;
import pageObjects.GeneralSettingPage;
import pageObjects.HomePage;
import pageObjects.IQTemplatePage;
import pageObjects.LoginPage;
import pageObjects.PublishProjectPage;
import pageObjects.ShareProjectPage;
import pageObjects.StartPage;
import utilities.ReadDataFile;

public class CalcTemlapteTest extends BaseTest {
	String beforeSubmiss;
	String beforeView;
	String WorkSpace=ReadDataFile.readDataFile("WorkSpace");

	@Test(description = "Quiz IQ Template")
	@Severity(SeverityLevel.NORMAL)
	@Description("This test will validate the IQ template in Quiz category")
	public void tc01_Template_IQ_Test() {
		StartPage sp = new StartPage(driver);
		sp.clicklogn();
		LoginPage lg = new LoginPage(driver);
		sp.sleep(1000);
		lg.fillEMail("boaz.lupu@gmail.com");
		lg.fillpassWrd("Neli5077");
		lg.clickLogn();
		HomePage hm = new HomePage(driver);
		hm.chooseWrkSpc(WorkSpace);
		hm.chooseTabAndClick("All");
		hm.clickProjectAnalytics("The Best Calc ever");
		AnalyticsPage ap = new AnalyticsPage(driver);
		ap.clickViewBtn();
		CalcTemplatePage ctp = new CalcTemplatePage(driver);
		String mainWin = ctp.getWindowMainTab();
		ctp.switchtoLastTab();
		ctp.setAnswer("How many visitors does your website have per month?", 80);
		ctp.setAnswer("How often does a visitor convert into a lead on your website?", 50);
		ctp.setAnswer("What is your lead to customer rate?", 30);

		ctp.setAverageSalesPrice("5600");
		ctp.clickCalculate();
		String finaTxt = ctp.getFinalCalcMsg();
		Assert.assertEquals(finaTxt, "Additional Revenue");

	}

}
