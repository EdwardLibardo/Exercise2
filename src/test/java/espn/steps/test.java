package espn.steps;

import espn.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
    WebDriver driver;
    MainPage _page;
    String _firstName = "Neymar";
    String _lastName = "Silva Santos";
    String _password = "Password2020124*";

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void createAnAccount() throws InterruptedException {
        driver.get("https://www.espn.com/src=com&_adblock=true");
        _page = PageFactory.initElements(driver, MainPage.class);
        _page.hoverOverAvatar()
                .clickOnSignUpButton()
                .creatingTheAccount(_firstName, _lastName, "@gmail.com", _password);
        // writingTheDataToCreateTheAccount();
        _page.verifyIfTheUserIsLoggedIn(_firstName);
    }

    @Test
    public void logOutThePage() throws InterruptedException {
        createAnAccount();
        _page.hoverOverAvatar()
                .clickOnLogOutButton()
                .verifyIfTheUserIsLoggedOut();
    }

    @Test
    public void userLogin() throws InterruptedException {
        logOutThePage();
        _page.logInAsAUser()
                .verifyIfTheUserIsLoggedIn(_firstName);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    public void writingTheDataToCreateTheAccount() throws InterruptedException {
        _page.creatingTheAccount(_firstName, _lastName, "@gmail.com", _password);
    }
}
