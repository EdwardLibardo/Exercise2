package espn.helpers;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RunnerHelper {
    public static WebDriver driver;


    @Before
    public WebDriver setUp(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        String _url = url;
        return driver;
    }
}
