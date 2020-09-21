package steps;

import com.automation.training.MyDriver;
import com.automation.training.pages.ArticlePage;
import com.automation.training.pages.WikiHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class MyStepdefs {

    MyDriver driver = new MyDriver("chrome");
    WikiHomePage home;
    ArticlePage articlePage;

    @Given("I am an user using {string}")
    public void iAmAnUserUsing(String url) {
        home = new WikiHomePage(driver.getDriver(), url);
    }

    @And("I search for {string}")
    public void iSearchFor(String word) {
        articlePage = home.buscar(word);
        Assert.assertEquals(articlePage.getPageTitle(), "Java");
    }

    @When("I use the article page to search by {string}")
    public void iUseTheArticlePageToSearchBy(String text) {
        articlePage.search(text);
    }

    @Then("I can see the expected results")
    public void iCanSeeTheExpectedResults() throws IOException {
        Assert.assertTrue(driver.getDriver().getTitle().contains("Hola Mundo"));
        File scrFile = ((TakesScreenshot) driver.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/ecorregidor/work/Exercise2/trainingAcamica/FinalVerification.png"));
        driver.getDriver().quit();
    }
}
