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
import pageObjects.PersonalityTemplatePage;
import pageObjects.PublishProjectPage;
import pageObjects.ShareProjectPage;
import pageObjects.StartPage;
import utilities.ReadDataFile;

public class PersonaltyTemlapteTest extends BaseTest {

	@Test(description = "Testing personality template")
	@Description("This test will open personality test template in web browser and complete it")
	@Severity(SeverityLevel.TRIVIAL)
	public void tc01_Template_Personality_Test() {
		StartPage sp = new StartPage(driver);
		sp.clicklogn();
		LoginPage lg = new LoginPage(driver);
		sp.sleep(1000);
		lg.fillEMail("boaz.lupu@gmail.com");
		lg.fillpassWrd("Neli5077");
		lg.clickLogn();
		HomePage hm = new HomePage(driver);
		hm.chooseWrkSpc(ReadDataFile.readDataFile("WorkSpace"));
		hm.chooseTabAndClick("All");
		hm.clickProjectAnalytics("Boaz love language");
		AnalyticsPage ap = new AnalyticsPage(driver);
		ap.clickViewBtn();
		PersonalityTemplatePage ptp = new PersonalityTemplatePage(driver);
		String mainWin = ptp.getWindowMainTab();
		ptp.switchtoLastTab();
		ptp.clickTakeTest("What's your love language?", true);
		ptp.setPersonalDetails("Boaz", "Lupu", "Boaz@gmail.com");
		ptp.clickTakeTest("Let's get started", false);
		ptp.chooseAnswer("My partner helps me when i need it", "Question 1/5");
		ptp.chooseAnswer("Getting a kiss on the cheek", "Question 2/5");
		ptp.chooseAnswer("A weekend trip for two", "Question 3/5");
		ptp.chooseAnswer("Walking hand in hand in public", "Question 4/5");
		ptp.chooseAnswer("Going on a fun date", "Question 5/5");

		String finaTxt = ptp.getFinalTxt();
		Assert.assertEquals(finaTxt, "Receiving gifts");
	}
}
