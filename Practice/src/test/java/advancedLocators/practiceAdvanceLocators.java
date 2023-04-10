package advancedLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class practiceAdvanceLocators {


    WebDriver driver;
    @Before
    public void setUp(){
        // this is a set up method for every single test annotation
        // webDriver manager
         WebDriverManager.chromedriver().setup();

         // we initialize the driver
        driver = new ChromeDriver();
        // maximize the window
        driver.manage().window().maximize();
        //set timeout
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

    }

     @After
    public void tearDown(){
        driver.close();
     }
    @Test
    public void test1() {
        //try out findElements()
        driver.get("https://devxschool.com/");


        // print out the href of the first link on the page
        WebElement firstLink = driver.findElement(By.tagName("a"));
        System.out.println("First link is: " + firstLink.getAttribute("href"));
        // we want to print out text of every single link on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));


        }

    }


}
