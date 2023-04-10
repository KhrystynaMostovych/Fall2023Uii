package javascript;

import com.github.javafaker.Faker;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utillities.Driver;

import static utillities.HelperMethods.highlightElement;

public class PracticeJavascript {

    WebDriver driver;

    @Before
    public void setUp(){

        driver= Driver.getDriver();
    }
    @After
    public void tearDown(){
        Driver.closeDriver();

    }

    @Test
    public void test1() throws InterruptedException {
        // to navigate to the page we have to first create JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.location='https://www.eatsy.com/'");
        WebElement signInButton = driver.findElement(By.cssSelector(".select-signin"));
        highlightElement(signInButton);
         js.executeScript("arguments[0].srtAttribute('style',arguments[1];",signInButton,"border:2px solid green");
           Thread.sleep(2000);

            js.executeScript("arguments[0].click();",signInButton);
            js.executeScript("document.getElementById('join_neu_email_field'),arguments[1]);",signInButton,"border: 2px solid green");

    Faker faker = new Faker();
   String fakeMail =  faker.internet().emailAddress();
   String fakePassword = faker.internet().password();

   js.executeScript("document.getElementById('join_neu_mail_field').value=arguments[0];",fakeMail);
        js.executeScript("document.getElementById('join_neu_email_field'),arguments[1]);",signInButton,"border: 2px solid green");
        Thread.sleep(2000);


     }

}
