package com.automation.training.pages;

import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class SearchResultsSpecialPage extends BasePage {

    @FindBy(id = "firstHeading")
    private WebElement pageTitle;

    public SearchResultsSpecialPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public SearchResultsSpecialPage isThePageSearchingTheRighText(String text) {
        Assert.assertTrue(getDriver().getTitle().contains("Hola Mundo"));
        return new SearchResultsSpecialPage(getDriver());
    }
}
