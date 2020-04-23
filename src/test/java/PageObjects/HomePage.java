package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

import java.util.List;

public class HomePage extends BasePage {

	@FindBy(css = ".px-4>a")
	WebElement creatProjectBtn;
	@FindBy(css = ".mt-6 .mr-3.truncate")
	List<WebElement> workSpcList;
	@FindBy(css = ".mb-3>.leading-tight.text-lg.font-medium")
	List<WebElement> projectMenuList;
	@FindBy(css = ".relative.flex .dropdown.relative>button")
	List<WebElement> prjDropDwn;
	@FindBy(css = ".mr-3.truncate+span")
	List<WebElement> wspcNumProjects;
	@FindBy(css = ".leading-tight.text-lg>a")
	List<WebElement> projectNameList;
	@FindBy(css = "div.flex.justify-right.items-center  li:nth-child(5)>a")
	List<WebElement> publishBtnList;
	@FindBy(css = ".flex-no-wrap>a")
	List<WebElement> tabList;
	@FindBy(css = ".mr-6.text-teal-600")
	List<WebElement> viewProjectIconList;
	@FindBy(css = ".absolute.bottom-0.mb-1 > a > div:nth-child(4)")
	List<WebElement> submssnProjectIconList;
	@FindBy(css = ".relative.flex .dropdown-menu.w-auto >li:nth-child(4)")
	List<WebElement> viewBtnList;
	@FindBy(css = ".flex.justify-right.items-center > div > ul > li:nth-child(4) >a")
	List<WebElement> analyticsBtn;
	@FindBy(css = ".flex-no-wrap>:nth-child(1)")
	WebElement tabAll;
	@FindBy(css = ".flex-no-wrap>:nth-child(2)")
	WebElement tabDraft;
	@FindBy(css = ".flex-no-wrap>:nth-child(3)")
	WebElement tabPublished;
	@FindBy(css = ".flex-no-wrap>:nth-child(4)")
	WebElement tabCompleted;
	@FindBy(css = ".flex-no-wrap>:nth-child(5)")
	WebElement tabArchived;
	@FindBy(css = ".text-gray-700>[data-icon='search'])")
	WebElement searchBtn;
	@FindBy(css = ".hidden>.rounded")
	WebElement searchTxtBox;
	@FindBy(css = ".pb-6 button")
	WebElement newWrkSpcBtn;
	@FindBy(css = ".block.max-w-xl+a ")
	WebElement startBtn;
	@FindBy(css = " div:nth-child(1) >  div.absolute.right-0.left-0.mt-8.mx-3.z-100.flex-1  div.flex.justify-right.items-center >div >ul > li:nth-child(9) > button")
	WebElement deleteProjectBtn;
	@FindBy(css = ".dropdown.relative.mr-3>button")
	WebElement wrkSpcDrpDwn;
	@FindBy(css = ".dropdown.relative.mr-3  .pl-4.pr-4.w-full.block.leading-loose.text-left.text-sm.text-red-600")
	WebElement dltWrkSpcBtn;
	@FindBy(css = " div.relative.flex.flex-col.pt-2.px-3.pb-2.rounded.shadow-md.w-full.md\\:w-64.h-40.border-t-4.bg-white.md\\:ml-6.lg\\:ml-10.mb-4.md\\:mb-8.border-blue-600  li:nth-child(1) > a")
	WebElement editProjectbtn;
	@FindBy(css = ".text-sm.flex.items-start>a:nth-child(2)")
	WebElement templateLink;

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Step("Click to create a new project")
	public void clickNewProject() {
		click(creatProjectBtn);
	}

	@Step("Click to create a new WorkSpace")
	public void clickNewWorkSpc() {
		click(newWrkSpcBtn);
	}

	@Step("Getting total of WorkSpace number")
	public int getNumOfWrkSpc() {
		int num = workSpcList.size();
		return num;
	}

	@Step("Click start button")
	public void clickStartBtn() {
		click(startBtn);
	}

	@Step("Click to delete a project")
	public void clickDltPrjc() {
		click(deleteProjectBtn);
	}

	@Step("Click to edit a project")
	public void clickEditPrjc() {
		click(editProjectbtn);
	}

	@Step("Click on WorkSapce dropdown")
	public void clickDrpDwnWrkSpc() {
		click(wrkSpcDrpDwn);
	}

	@Step("Click delete WorkSpace")
	public void clickDltWrkSpc() {
		click(dltWrkSpcBtn);
	}

	@Step("Click on template Link")
	public void clickTemplateLink() {
		click(templateLink);
	}

	@Step("Click analitycs of project:{0}")
	public void clickProjectAnalytics(String projectName) {
		List<WebElement> nl = projectNameList;
		List<WebElement> dd = prjDropDwn;
		List<WebElement> ab = analyticsBtn;
		for (int i = 0; i < nl.size(); i++) {
			if (getText(nl.get(i)).equalsIgnoreCase(projectName)) {
				click(dd.get(i));
				click(ab.get(i));
				break;
			}
		}
	}

	@Step("Click on tab:{0}")
	public String getTabNum(String tabName) {
		List<WebElement> tablst = tabList;
		String num = "";
		for (int i = 0; i < tablst.size(); i++) {
			String tab = getText(tablst.get(i)).substring(0, getText(tablst.get(i)).length() - 4);
			if (tab.equalsIgnoreCase(tabName)) {
				num = getText(tablst.get(i)).substring(getText(tablst.get(i)).length() - 2,
						getText(tablst.get(i)).length() - 1);
				break;
			}
		}
		return num;
	}

	@Step("Clicking on tab: {0}")
	public void chooseTabAndClick(String tabName) {
		List<WebElement> tablst = tabList;
		for (int i = 0; i < tablst.size(); i++) {
			String tab = getText(tablst.get(i)).substring(0, getText(tablst.get(i)).length() - 4);
			if (tab.equalsIgnoreCase(tabName)) {
				click(tablst.get(i));
				break;
			}
		}
	}

	@Step("Click on WorkSpace: {0}")
	public String chooseWrkSpc(String wrkSpcNm) {
		List<WebElement> wspcNumOfPrjcs = wspcNumProjects;
		List<WebElement> wrkSpcList = workSpcList;
		String num = "";
		for (int i = 0; i < wrkSpcList.size(); i++) {
			if (getText(wrkSpcList.get(i)).equalsIgnoreCase(wrkSpcNm)) {
				num = getText(wspcNumOfPrjcs.get(i));
				click(wrkSpcList.get(i));
				break;
			}
		}
		return num;
	}

	@Step("Click on menu of project: {0}")
	public void clickProjectMne(String prjcName) {
		List<WebElement> nl = projectNameList;
		List<WebElement> dd = prjDropDwn;
		for (int i = 0; i < nl.size(); i++) {
			if (getText(nl.get(i)).equalsIgnoreCase(prjcName)) {
				click(dd.get(i));
				break;
			}
		}
	}

	@Step("Click view on project: {0}")
	public void clickView(String prjcName) {
		List<WebElement> nl = projectNameList;
		List<WebElement> dd = prjDropDwn;
		List<WebElement> vb = viewBtnList;
		for (int i = 0; i < nl.size(); i++) {
			if (getText(nl.get(i)).equalsIgnoreCase(prjcName)) {
				click(dd.get(i));
				click(vb.get(i));
				break;
			}
		}
	}

	@Step("Click publish project: {0}")
	public void clickPublish(String prjcName) {
		List<WebElement> nl = projectNameList;
		List<WebElement> dd = prjDropDwn;
		List<WebElement> pb = publishBtnList;
		for (int i = 0; i < nl.size(); i++) {
			if (getText(nl.get(i)).equalsIgnoreCase(prjcName)) {
				click(dd.get(i));
				click(pb.get(i));
				break;
			}
		}
	}

	@Step("Get view of project: {0}")
	public String getProjectViews(String projName) {
		List<WebElement> nl = projectNameList;
		List<WebElement> il = viewProjectIconList;
		String view = "";
		for (int i = 0; i < nl.size(); i++) {
			if (getText(nl.get(i)).equalsIgnoreCase(projName)) {
				view = getText(il.get(i));
				break;
			}
		}
		return view;
	}

	@Step("Get submission of project: {0}")
	public String getProjectSubmssn(String projName) {
		List<WebElement> nl = projectNameList;
		List<WebElement> il = submssnProjectIconList;
		String submission = "";
		for (int i = 0; i < nl.size(); i++) {
			if (getText(nl.get(i)).equalsIgnoreCase(projName)) {
				submission = getText(il.get(i));
				break;
			}
		}
		return submission;
	}
}
