package com.automation.training.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage {

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstHeading")
    private WebElement pageTitle;

    @FindBy(linkText = "Privacy policy")
    private WebElement privacyLink;

    @FindBy(id = "searchInput")
    private WebElement searchTextBox;

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public SearchResultsSpecialPage search(String text) {
        searchTextBox.sendKeys(text);
        searchTextBox.sendKeys(Keys.ENTER);
        return new SearchResultsSpecialPage(getDriver());
    }

}
