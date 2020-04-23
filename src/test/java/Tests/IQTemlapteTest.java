package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageObjects.AnalyticsPage;
import pageObjects.BasePage;
import pageObjects.GeneralSettingPage;
import pageObjects.HomePage;
import pageObjects.IQTemplatePage;
import pageObjects.LoginPage;
import pageObjects.PublishProjectPage;
import pageObjects.ShareProjectPage;
import pageObjects.StartPage;
import utilities.ReadDataFile;

public class IQTemlapteTest extends BaseTest {
	String beforeSubmiss;
	String beforeView;

	@Test(description = "")

	public void tc01_Template_IQ_Test() {
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
		hm.clickProjectAnalytics("Boaz IQ Quiz");
		AnalyticsPage ap = new AnalyticsPage(driver);
		ap.clickViewBtn();
		IQTemplatePage itp = new IQTemplatePage(driver);
		String mainWin = itp.getWindowMainTab();
		itp.switchtoLastTab();
		itp.clickStartFirstPage();
		itp.chooseFirstAns();
		itp.chooseScndAns("brilliant");
		itp.chooseThirdAns("Ellbow");
		itp.chooseForthAns("T");
		itp.chooseFifthAns("Dandelion");
		itp.chooseSixAns();
		itp.chooseSevenAns("Harp");
		itp.chooseEightAns("14");
		itp.chooseNineAns("Carpenter");
		itp.chooseTenAns("26");
		String finalScore = itp.getFinalScore();

		Assert.assertEquals(finalScore, "90");
	}
}
