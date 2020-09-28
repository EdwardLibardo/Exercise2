package espn.steps;

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
        mainPage.hoverOverAvatarAndClickOnSignUpButton();
        mainPage.creatingTheAccount(firstName, lastName, email, pass);
    }

    @Then("^i am able to see the page as a registered user$")
    public void iAmAbleToSeeThePageAsARegisteredUser() {
        mainPage.verifyIfTheUserIsLoggedIn();
    }

}
