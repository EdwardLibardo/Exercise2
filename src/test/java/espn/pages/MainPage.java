package espn.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePage {

    @FindBy(id = "global-user-trigger")
    private WebElement _avatar;

    @FindBy(css = ".tools .account-management li:last-child")
    private WebElement _logInButton;

    @FindBy(css = ".section .btn-group:last-child")
    private WebElement _signUp;

    @FindBy(css = "[placeholder=\"First Name\"]")
    private WebElement _firstNameTextBox;

    @FindBy(css = "[placeholder=\"Last Name\"]")
    private WebElement _lastNameTextBox;

    @FindBy(css = "[aria-label=\"Email Address\"]")
    private WebElement _emailAddressTextBox;

    @FindBy(css = "[placeholder=\"Password (case sensitive)\"]")
    private WebElement _passtextBox;

    @FindBy(css = ".section-submit .btn-group")
    private WebElement _signUpSubmitbtn;

    @FindBy(css = ".tools .display-user")
    private WebElement _userLoggedIn;

    private WebDriver driver;
    private String _userName;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public MainPage hoverOverAvatarAndClickOnSignUpButton() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 13);
        wait.until(ExpectedConditions.visibilityOf(_avatar)).click();
        _logInButton.click();
        driver.switchTo().frame("disneyid-iframe");
        wait.until(ExpectedConditions.elementToBeClickable(_signUp)).click();
        return new MainPage(driver);
    }

    public MainPage creatingTheAccount(String firstName, String lastName, String email, String pass) {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.elementToBeClickable(_firstNameTextBox)).sendKeys(firstName);
        _userName = firstName;
        _lastNameTextBox.sendKeys(lastName);
        _emailAddressTextBox.sendKeys(email);
        _passtextBox.sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(_signUpSubmitbtn)).click();
        return new MainPage(driver);
    }

    public MainPage verifyIfTheUserIsLoggedIn() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 13);
        wait.until(ExpectedConditions.visibilityOf(_avatar)).click();
        String actualString = _userLoggedIn.getText();
        Assert.assertTrue(actualString.contains("Welcome" + _userName + "!"));
        return new MainPage(driver);
    }
}
