package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	@FindBy(css=".form-group>[for='email']>input")
	WebElement email;
	@FindBy(css=".form-group.m-b-20 input")
	WebElement passWord;
	@FindBy(css=".btn.btn-primary.btn-lg")
	WebElement loginBtn;
	@FindBy(css="p .darken")
	WebElement creatAccount;
	@FindBy(css=".alert.alert-danger")
	WebElement alertMsg;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Step("E-Mail is:{0}")
	public void fillEMail(String userNm) {
		sleep(1500);
		fillText(email, userNm);
	}
	@Step("Passwrod is:{0}")
	public void fillpassWrd(String pssWrd) {
		fillText(passWord, pssWrd);
	}
	@Step("Click on login")
	public void clickLogn(){
		click(loginBtn);
	}
	@Step("Click on creat account")
	public void creatAccnt() {
		click(creatAccount);
	}
	@Step("Getting alert messege")
	public String getAlertMsg() {
		String msg=alertMsg.getText();
		return msg;
	}
	
}
