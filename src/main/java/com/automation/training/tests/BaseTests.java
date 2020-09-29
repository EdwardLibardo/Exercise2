package com.automation.training.tests;

import com.automation.training.pages.EspnMainPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.training.MyDriver;
import com.automation.training.pages.WikiHomePage;

public class BaseTests {

	MyDriver myDriver;

	private WikiHomePage wikiHome;
	private EspnMainPage _espnMainPage;

	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		//wikiHome = new WikiHomePage(myDriver.getDriver());
		_espnMainPage = new EspnMainPage(myDriver.getDriver());
	}

	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		_espnMainPage.dispose();
	}

	public WikiHomePage getWikiHomePage() {
		return wikiHome;
	}

	public EspnMainPage getMainPage(){
		return _espnMainPage;
	}
}
