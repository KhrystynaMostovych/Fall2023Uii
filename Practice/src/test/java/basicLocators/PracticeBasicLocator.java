package basicLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeBasicLocator {
    WebDriver driver;


    @Test
    public void testClassLocator(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

        WebElement link = driver.findElement(By.className("NKcBbd"));

        String text = link.getText();
        System.out.println(text);

        Assert.assertTrue("link text did not contain", text.contains("future leaders"));

        driver.close();

    }


    // create test which will be negative to hht://www.practiceselenium.com/
    // use tag name locator and find the main heading on the page


@Test
    public void testFindText(){


    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();


    driver.get("https://www.practiceselenium.com/");

    WebElement name = driver.findElement(By.id("copyright"));
    String text = name.getText();
    System.out.println(text);
    Assert.assertTrue("name dosent match",text.contains("GoDaddy"));
    driver.close();
    }

    @Test
    public void testLinkLocator() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver drive = new ChromeDriver();
        drive.manage().window().maximize();

        driver.get("https://www.google.com/");
        WebElement gmaillink = drive.findElement(By.linkText("Gmail"));
        gmaillink.click();

        Thread.sleep(300);// stop for 30 sec
        Assert.assertTrue(drive.getCurrentUrl().contains("mail"));

    }
    @After // cleans up after test
    public void tearDown(){
        driver.close();

    }

    @Test
    public void testPartialLink() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement link = driver.findElement(By.partialLinkText("How Search works"));
        link.click();
        Thread.sleep(2000);

        String expected = "Read the latest news about Google Search";
        Assert.assertTrue(driver.getTitle().contains(expected));

    }


}
