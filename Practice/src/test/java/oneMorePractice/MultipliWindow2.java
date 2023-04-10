package oneMorePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipliWindow2 {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

        @After
        public void dearDown (){
         driver.close();
         driver.quit();
    }

    @Test
    public void amazom () {
        driver.get("https://www.amazon.com/");

        //window handle is String
        // this String doesn't need any parameters

        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);
    }
    @Test
            public void multipleWindows() {
        driver.get("https://www.amazon.com/");

        // window ID will change every time when we are open this window
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"learn-more-link-1\"]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"learn-more-link-1\"]/div/a")).click();
        String mainPage = driver.getWindowHandle();
        Set<String> allOpenWindows = driver.getWindowHandles();
        for (String windowHandle : allOpenWindows) {
            if (!windowHandle.equals(mainPage)) {
                driver.switchTo().window(windowHandle);
            }
            driver.findElement(By.xpath("/html/body/article/div[1]/div/div/h2"));


            // after this new window open up
            //my driver pointer to the first page still
            // now I should tell to my driver switch to the new window
/*
        String mainPage = driver.getWindowHandle(); //here I will have the ID of my main page
        // I should get window handle of all open window
         Set<String> allOpenWindows = driver.getWindowHandles();
        // now here I have 2 values because we have 2 windows open
        for(String windowHandle : allOpenWindows){ // now we compare our window with main window
            // and if main window is open we use switch to another window
            if (!windowHandle.equals(mainPage)){
                driver.switchTo().window(windowHandle);}}
        // click on the new window

        driver.findElement(By.xpath("//*[@id=\"learn-more-link-1\"]/div/a")).click();

// here I may need to add some wait

        WebElement trueHAding = driver.findElement(By.xpath("/html/body/article/div[1]/div/div/h2"));
        Assert.assertTrue("is not displayed",trueHAding.isDisplayed());

*/
        }


    }}
