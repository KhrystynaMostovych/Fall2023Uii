package advanceMouseInteraction;

import com.github.javafaker.Faker;
import com.github.javafaker.Hobbit;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.Then;
import cucumber.api.java.tr.Fakat;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utillities.Driver;

import java.nio.file.WatchEvent;
import java.util.concurrent.locks.Condition;

import static utillities.HelperMethods.highlightElement;

public class PracticeActionsClass {
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
    public void test1(){
        // we will practice doubleClick() and right click
     driver.navigate().to("https://demoqa.com/buttons");
     WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
     WebElement rightClickButton =driver.findElement(By.id("rightClickBtn"));

     // in order to use Actions class
     // first step
    Actions actions =new Actions(driver);
    actions.doubleClick(doubleClickButton).contextClick(rightClickButton).perform();
    // if I want actions to be executed I always have to use .perform()
// we can use 2 different actions like "double click" and " right click"
    WebElement doubleClickMassage = driver.findElement(By.id("doubleClickMessage"));
    Assert.assertTrue(doubleClickMassage.isDisplayed());

    //actions.contextClick(rightClickButton).perform();

    WebElement rightClickMassage = driver.findElement(By.id("doubleClickMessage"));
    Assert.assertTrue(rightClickMassage.isDisplayed());

    }

    @Test
    public void test2() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/tool-tips");
        WebElement hoverButton = driver.findElement(By.id("toolTipButton"));
        // in order to cover over the webElement we use moveToElement()

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();
        // //button[@aria-describedby='buttonToolTip'] v
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.attributeContains(hoverButton,"aria-describedby","buttonToolTip"));
         Assert.assertTrue("ToolTip is not displayed", hoverButton.getAttribute("aria-describedby").equals("buttonToolTip"));


    }

    @Test
    public void test3(){

        driver.navigate().to("https://demoqa.com/slider");
        Actions actions = new Actions(driver);
        WebElement slider= driver.findElement(By.xpath("//input[@min='0']"));
        // this will move my slider
        actions.clickAndHold(slider).moveByOffset(30,0).release().perform();
        Integer newSliderValue = Integer.parseInt(slider.getAttribute("value"));
        Assert.assertTrue(newSliderValue>25);


    }

    @Test
    public void test4(){
        driver.navigate().to("https://demoqa.com/droppable");
    //1: we will ise built into selenium drag and drop method
        WebElement source = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement target = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        Actions actions =new Actions(driver);

        actions.dragAndDrop(source,target).perform();

    }

    @Test
    public void tet6(){
        driver.navigate().to("https://demoqa.com/menu#");
        WebElement mainIteam2 = driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a"));
        Actions actions = new Actions(driver);
         actions.moveToElement(mainIteam2).perform();


    }

    @Test
    public void test7 () throws InterruptedException {
        driver.navigate().to("https://demoqa.com/automation-practice-form");

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));

        highlightElement(firstName);

        Faker faker = new Faker();
        firstName.sendKeys(faker.funnyName().name());

        Actions actions = new Actions(driver);
        // if mac use COMMAND
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.TAB).perform();

        actions.keyUp(Keys.CONTROL).keyUp("y").keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);
        highlightElement((lastName));

        Assert.assertEquals(true, lastName.getAttribute(String.valueOf("value".equals(firstName.getAttribute("value")))));
    }



    }


