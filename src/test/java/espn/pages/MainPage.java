package espn.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;


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

    @FindBy(css = ".tools .account-management li:last-child")
    private WebElement _logOutBtn;

    @FindBy(css = ".tools [tref=\"/members/v3_1/modifyAccount\"]")
    private WebElement _espnProfile;

    @FindBy(css = "#cancel-account")
    private WebElement _deleteAccount;

    @FindBy(css = ".btn[type=\"submit\"]")
    private WebElement _confirmBtn;

    @FindBy(css = "[placeholder=\"Username or Email Address\"]")
    private WebElement _userNameTextBox;

    private WebDriver driver;
    private String _password;
    private String _email;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public MainPage hoverOverAvatar() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 13);
        wait.until(ExpectedConditions.visibilityOf(_avatar)).click();
        return new MainPage(driver);
    }

    public MainPage clickOnSignUpButton() {
        WebDriverWait wait = new WebDriverWait(driver, 13);
        _logInButton.click();
        driver.switchTo().frame("disneyid-iframe");
        wait.until(ExpectedConditions.elementToBeClickable(_signUp)).click();
        return new MainPage(driver);
    }

    public MainPage creatingTheAccount(String firstName, String lastName, String email, String pass) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.elementToBeClickable(_firstNameTextBox)).sendKeys(firstName);
        _password = pass;
       // String randomForEmail = null;
        //Random r = new Random();
        //String alphabet = "12345xyabfz";

      //  for (int i = 0; i < 25; i++) {
        //    randomForEmail = randomForEmail + alphabet.charAt(r.nextInt(alphabet.length()));
       // }
        _lastNameTextBox.sendKeys(lastName);
        _emailAddressTextBox.sendKeys(randomEmail(email));
        //_email = randomForEmail + email;
        _passtextBox.sendKeys(pass);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        wait.until(ExpectedConditions.elementToBeClickable(_signUpSubmitbtn)).click();
        Thread.sleep(5000);
        return new MainPage(driver);
    }

    public MainPage verifyIfTheUserIsLoggedIn(String name) {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 13);
        wait.until(ExpectedConditions.visibilityOf(_avatar)).click();
        String actualString = _userLoggedIn.getText();
        Assert.assertTrue(actualString.contains("Welcome" + name + "!"));
        return new MainPage(driver);
    }

    public MainPage clickOnLogOutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 13);
        wait.until(ExpectedConditions.elementToBeClickable(_logOutBtn)).click();
        return new MainPage(driver);
    }

    public MainPage verifyIfTheUserIsLoggedOut() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 13);
        wait.until(ExpectedConditions.visibilityOf(_avatar)).click();
        Assert.assertTrue(_logInButton.isDisplayed());
        return new MainPage(driver);
    }

    public MainPage clickOnEspnProfile() {
        WebDriverWait wait = new WebDriverWait(driver, 13);
        wait.until(ExpectedConditions.elementToBeClickable(_espnProfile)).click();
        return new MainPage(driver);
    }

    public MainPage deleteAccount() {
        driver.switchTo().frame("disneyid-iframe");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)");
        _deleteAccount.click();
        WebDriverWait wait = new WebDriverWait(driver, 13);
        wait.until(ExpectedConditions.elementToBeClickable(_confirmBtn)).click();
        driver.navigate().refresh();
        return new MainPage(driver);
    }

    public MainPage logInAsAUser() {
        WebDriverWait wait = new WebDriverWait(driver, 13);
        _logInButton.click();
        driver.switchTo().frame("disneyid-iframe");
        wait.until(ExpectedConditions.visibilityOf(_userNameTextBox)).sendKeys(_email);
        _passtextBox.sendKeys(_password);
        _confirmBtn.click();
        return new MainPage(driver);
    }

    public String randomEmail(String email) {
        String randomForEmail = null;
        Random r = new Random();
        String alphabet = "12345xyabfz";
        for (int i = 0; i < 25; i++) {
            randomForEmail = randomForEmail + alphabet.charAt(r.nextInt(alphabet.length()));
        }
        return _email = randomForEmail + email;
    }
}
