package iframes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utillities.Driver;



public class PracticeAlerts {

    // initialize a logger for every class
    private static final Logger LOGGER = LogManager.getLogger(PracticeAlerts.class);


    WebDriver driver;


    @Before
    public void setUp(){
        driver = Driver.getDriver();

    }

    @After
    public void tearDown(){
driver.close();

    }
@Test
public void testAlert(){

        driver.navigate().to("https://demoqa.com/alerts");
// trigger first alert
    driver.findElement(By.id("alertButton")).click();
// now alert is present on the skrin
    Alert alert = driver.switchTo().alert();
    String alertText = alert.getText();

    Assert.assertEquals("You clicked a button",alertText);
// with simple alert - we van only click okay
    alert.accept();

    //
driver.findElement(By.id("timerAlertButton")).click();
// alert is not present on the screen right away
    // we should put a wait

    WebDriverWait wait = new WebDriverWait(driver,5);
    wait.until(ExpectedConditions.alertIsPresent());

    driver.switchTo().alert();
    alert.accept();

}

 @Test
    public void testPromptAlert (){
     driver.navigate().to("https://demoqa.com/alerts");
driver.findElement(By.id("promtButton")).click();

Alert alert = driver.switchTo().alert();
// since it is a prompt - I have to type some inf in it
     String name = "Sofia";
     alert.sendKeys(name);
     alert.accept();
     WebElement result  = driver.findElement(By.id("promptResult"));

     Assert.assertTrue(result.getText().contains(name));

    }

}

