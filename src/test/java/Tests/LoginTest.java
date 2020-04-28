package tests;

import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.LoginPage;
import pageObjects.MyWorkSpaceAllPage;
import pageObjects.StartPage;
import utilities.ReadDataFile;

public class LoginTest extends BaseTest {
	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Login with non registered user")
	@Description("This tes will go over common use-cases in login page")
	public void tc_01_Non_registered_user() {
		StartPage sp = new StartPage(driver);
		sp.clicklogn();
		LoginPage lp = new LoginPage(driver);
		lp.fillEMail("boaz123@gmail.com");
		lp.fillpassWrd("12345678");
		lp.clickLogn();
		String actualMsg = lp.getAlertMsg();
		Assert.assertEquals(actualMsg, "These credentials do not match our records.");
	}

	@Test(description = "Login with wrong password")
	@Severity(SeverityLevel.NORMAL)
	public void tc_02_wrong_password() {
		LoginPage lp = new LoginPage(driver);
		lp.fillEMail("boaz.lupu@gmail.com");
		lp.fillpassWrd("12345678");
		lp.clickLogn();
		String actualMsg = lp.getAlertMsg();
		Assert.assertEquals(actualMsg, "These credentials do not match our records.////");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(description = "Login with wrong case sensitive password")
	public void tc_03_wrong_case_sensitive_password() {
		LoginPage lp = new LoginPage(driver);
		lp.fillEMail("boaz.lupu@gmail.com");
		lp.fillpassWrd("neli5077");
		lp.clickLogn();
		String actualMsg = lp.getAlertMsg();
		Assert.assertEquals(actualMsg, "These credentials do not match our records.");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(description = "Login with right password")
	public void tc_04_Right_password() {
		LoginPage lp = new LoginPage(driver);
		lp.fillEMail(ReadDataFile.readDataFile("email"));
		lp.fillpassWrd(ReadDataFile.readDataFile("password"));
		lp.clickLogn();
		MyWorkSpaceAllPage mwsap = new MyWorkSpaceAllPage(driver);
		String lggedUsr = mwsap.getLoggedUsrNm();
		Assert.assertEquals(lggedUsr, "boaz lupu");

	}
}
