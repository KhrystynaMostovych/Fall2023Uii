package step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import utilities.Driver;
import utilities.EnvironmentManager;

public class LoginFlowStep {

    WebDriver driver = Driver.getDriver();
    MainPage mainPage = new MainPage();


    @Then("^user should be able to see \"([^\"]*)\" button$")
    public void user_should_be_able_to_see_button(String button) throws Throwable {
       // WebElement buttonToVerify = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/main/div[2]/div/a"));

        if(button.equalsIgnoreCase("Log in")) {
            Assert.assertTrue("Button s not displayed",mainPage.loginButton.isDisplayed());
        }else if(button.equalsIgnoreCase("sing in")) {
            Assert.assertTrue("Button s not displayed",mainPage.signupButton.isDisplayed());
        } else if (button.equalsIgnoreCase("join meetup")) {
            Assert.assertTrue("Button s not displayed",mainPage.joinMeetupButton.isDisplayed());
        }

    }

}
