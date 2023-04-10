package step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.EnvironmentManager;

import java.util.concurrent.TimeUnit;


public class BasicValidation1 {
    WebDriver driver = Driver.getDriver();

    @Given("^user on meetup homepage$")
    public void user_on_meetup_homepage() throws Throwable{
      driver.get(EnvironmentManager.baseUrl);
     }

    @Then("^usen should see titile page contains \"([^\"]*)\"$")
    public void usen_should_see_titile_page_contains(String expectedUrl) throws Throwable {
String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

     }

    @Then("^User should verify the url contains \"([^\"]*)\"$")
    public void user_should_verify_the_url_contains(String expectedTitle) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
