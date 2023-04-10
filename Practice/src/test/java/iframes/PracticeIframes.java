package iframes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utillities.Driver;

import javax.xml.transform.sax.SAXResult;

public class PracticeIframes {

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
    public void test1(){

        driver.navigate().to("https://demoqa.com/frames");
        // before checking if text1 is displayed we need switch to that contains it

        //option 1 .  switch by webelement
        WebElement iframe1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframe1);

        WebElement text1 = driver.findElement(By.id("sampleHeading"));


        Assert.assertTrue(text1.isDisplayed());

        // option 2. by name or id
        driver.switchTo().defaultContent();// switch to main paige
        driver.switchTo().frame("frame2");


        // 3rd option be index

      //  driver.switchTo().frame(2);
// couse we switch to new frame id of text could be the same
        WebElement text2 = driver.findElement(By.id("sampleHeading"));
         Assert.assertTrue(text2.isDisplayed());
    }
    @Test
    public  void test2 () {
        driver.navigate().to("https://leetcode.com/");
        // to move the frame in to the ...
        Actions actions = new Actions(driver);
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"developer\"]/div/div/div/div/div[2]/div[2]/div/div[2]/iframe"));
        actions.moveToElement(iframe).perform();

        driver.switchTo().frame(iframe);

        WebElement runButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/button[2]"));
        runButton.click();
        WebElement runResult = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/button[2]")));
        String text = runResult.getText();
        for (String word : text.split("")) {
            if (Character.isDigit(word.charAt(0))) {
                int ms = Integer.parseInt(word);
                Assert.assertTrue(ms < 5);
            }
        }
    }}