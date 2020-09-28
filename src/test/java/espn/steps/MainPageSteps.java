package espn.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import espn.helpers.RunnerHelper;
import espn.pages.MainPage;

public class MainPageSteps {
    MainPage mainPage;
    RunnerHelper runner = new RunnerHelper();

    @Given("^i am in the main page of \"([^\"]*)\"$")
    public void iAmInTheMainPageOf(String arg0) {
        mainPage = new MainPage(runner.setUp(arg0));
    }

    @When("^i create an account with with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iCreateAnAccountWithWith(String firstName, String lastName, String email, String pass) {
        mainPage.hoverOverAvatar();
        mainPage.clickOnSignUpButton();
        mainPage.creatingTheAccount(firstName, lastName, email, pass);
    }

    @Then("^i am able to see the page as a registered user$")
    public void iAmAbleToSeeThePageAsARegisteredUser() {
        mainPage.verifyIfTheUserIsLoggedIn();
    }

    @And("^i click on the Log Out button$")
    public void iClickOnTheLogOutButton() {
        mainPage.hoverOverAvatar();
        mainPage.clickOnLogOutButton();
    }

    @Then("^i am logged out$")
    public void iAmLoggedOut() {
        mainPage.verifyIfTheUserIsLoggedOut();
    }

    @And("^i delete the account$")
    public void iDeleteTheAccount() {
        mainPage.hoverOverAvatar();
        mainPage.clickOnEspnProfile();
        mainPage.deleteAccount();
    }

    @Then("^i am able to log in on the page$")
    public void iAmAbleToLogInOnThePage() {
        mainPage.hoverOverAvatar();
        mainPage.logInAsAUser();
    }
}
