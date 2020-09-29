package com.automation.training.tests;


import com.automation.training.pages.EspnMainPage;
import org.testng.annotations.Test;

public class EspnTests extends BaseTests {

    private EspnMainPage _espnMainPage;
    private String _firstName = "Neymar";
    private String _lastName = "Silva Santos";
    private String _password = "Password2020124*";


    @Test
    public void createAnAccount() throws InterruptedException {
        _espnMainPage = getMainPage();
        _espnMainPage.hoverOverAvatar()
                .clickOnSignUpButton()
                .creatingTheAccount(_firstName, _lastName, "@gmail.com", _password);
        _espnMainPage.verifyIfTheUserIsLoggedIn(_firstName);
    }

    @Test
    public void logOutThePage() throws InterruptedException {
        _espnMainPage = getMainPage();
        _espnMainPage.hoverOverAvatar()
                .clickOnSignUpButton()
                .creatingTheAccount(_firstName, _lastName, "@gmail.com", _password)
                .hoverOverAvatar()
                .clickOnLogOutButton()
                .verifyIfTheUserIsLoggedOut();
    }

    @Test
    public void userLogin() throws InterruptedException {
        _espnMainPage = getMainPage();
        _espnMainPage.hoverOverAvatar()
                .clickOnSignUpButton()
                .creatingTheAccount(_firstName, _lastName, "@gmail.com", _password)
                .hoverOverAvatar()
                .clickOnLogOutButton();
        _espnMainPage.hoverOverAvatar()
                .logInAsAUser()
                .verifyIfTheUserIsLoggedIn(_firstName);
    }

    @Test
    public void deleteAccount() throws InterruptedException {
        _espnMainPage = getMainPage();
        _espnMainPage.hoverOverAvatar()
                .clickOnSignUpButton()
                .creatingTheAccount(_firstName, _lastName, "@gmail.com", _password)
                .hoverOverAvatar();
        _espnMainPage.clickOnEspnProfile()
                .deleteAccount()
                .verifyIfTheUserIsLoggedOut();
    }
}
