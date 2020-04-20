package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AnalyticsPage;
import PageObjects.BasePage;
import PageObjects.GeneralSettingPage;
import PageObjects.HomePage;
import PageObjects.IQTemplatePage;
import PageObjects.LoginPage;
import PageObjects.PublishProjectPage;
import PageObjects.ShareProjectPage;
import PageObjects.StartPage;
import io.qameta.allure.Description;

public class IQTemlapteTest extends BaseTest{
	String beforeSubmiss;
	String beforeView;
	@Test(description="")

	public void tc01_Template_IQ_Test() {
		StartPage sp= new StartPage(driver);
		sp.clicklogn();
		LoginPage lg = new LoginPage(driver);
		sp.sleep(1000);
		lg.fillEMail("boaz.lupu@gmail.com");
		lg.fillpassWrd("Neli5077");
		lg.clickLogn();
		HomePage hm = new HomePage(driver);
		hm.chooseWrkSpc("Boaz Multi project");
		hm.chooseTabAndClick("All");
		hm.clickProjectAnalytics("Boaz IQ Quiz");
		AnalyticsPage ap=new AnalyticsPage(driver);
		ap.clickViewBtn();
		IQTemplatePage itp= new IQTemplatePage(driver);
		String mainWin=itp.getWindowMainTab();
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
		String finalScore=itp.getFinalScore();
		
		Assert.assertEquals(finalScore,"90");
		
	}

}
