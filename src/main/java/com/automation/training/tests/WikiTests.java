package com.automation.training.tests;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.training.pages.ArticlePage;
import com.automation.training.pages.WikiHomePage;

import java.io.File;
import java.io.IOException;

public class WikiTests extends BaseTests{
	

	
	@Test
	public void testWikiSearch() throws IOException {
		WikiHomePage home = getWikiHomePage();
		ArticlePage articlePage = home.buscar("Java");
		Assert.assertEquals(articlePage.getPageTitle(), "Java");
		articlePage.search("Hola Mundo ");
		Assert.assertTrue(myDriver.getDriver().getTitle().contains("Hola Mundo"));
		File scrFile = ((TakesScreenshot)myDriver.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("/Users/ecorregidor/work/Exercise2/trainingAcamica/FinalVerification.png"));
	}

}
