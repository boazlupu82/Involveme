package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AnalyticsPage;
import PageObjects.BasePage;
import PageObjects.CalcTemplatePage;
import PageObjects.GeneralSettingPage;
import PageObjects.HomePage;
import PageObjects.IQTemplatePage;
import PageObjects.LoginPage;
import PageObjects.PublishProjectPage;
import PageObjects.ShareProjectPage;
import PageObjects.StartPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CalcTemlapteTest extends BaseTest{
	String beforeSubmiss;
	String beforeView;
	@Test(description="Quiz IQ Template")
	@Severity(SeverityLevel.NORMAL)
	@Description("This test will validate the IQ template in Quiz category")
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
		hm.clickProjectAnalytics("The Best Calc ever");
		AnalyticsPage ap=new AnalyticsPage(driver);
		ap.clickViewBtn();
		CalcTemplatePage ctp=new CalcTemplatePage(driver);
		String mainWin =ctp.getWindowMainTab();
		ctp.switchtoLastTab();
		ctp.setAnswer("How many visitors does your website have per month?",80);
		ctp.setAnswer("How often does a visitor convert into a lead on your website?",50);
		ctp.setAnswer("What is your lead to customer rate?",30);
				
		ctp.setAverageSalesPrice("5600");
		ctp.clickCalculate();
		String finaTxt=ctp.getFinalCalcMsg();
		Assert.assertEquals(finaTxt,"Additional Revenue");
		
	}

}
