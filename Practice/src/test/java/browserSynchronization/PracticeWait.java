package browserSynchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Transient;
import java.util.concurrent.TimeUnit;

public class PracticeWait {


    WebDriver driver;
// hooks
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //____implicit wait___

        WebDriverWait wait = new WebDriverWait(driver,3);
       // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//")));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void anazonLoad (){
        driver.get("https://www.amazon.com/");


    }

    @Test
    public void testEtsy(){
        driver.get("https://www.etsy.com/"); // --> the only case when you don't need to wait to continue;
        //click sing in button
        WebElement sininButton = driver.findElement(By.xpath("//button[contain(@class,'select-signin')]"));
        sininButton.click();

   // WebElement registrationFrom = driver.findElement(By.xpath("//"));
     //   Assert.assertTrue("The registration from is not display",registrationFrom.isDisplayed());
        }


    @Test // wait until button show up
    public void testButtons (){
        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement showButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
    Assert.assertTrue(showButton.isDisplayed());
     }

@Test// color of button change
    public void test2(){

        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.attributeContains(By.cssSelector("#colorChange"),"class","text-danger"));
        WebElement colorChangeButton = driver.findElement(By.id("colorChange"));

        Assert.assertTrue(colorChangeButton.getAttribute("class").contains("text-danger"));

}

@Test
    public void testFailUpLoad(){
        driver.get("https://demoqa.com/upload-download");
        // I need to locate the input element that represent fail upload
       //then I need to sendKeys() with the path to my file to input file

     // verify that my file path is displayed under the choose file button

    WebElement chooseFileInput = driver.findElement(By.xpath("//input[@id='uploadFile']"));
   chooseFileInput.sendKeys("C:\\Users\\Arsen\\Desktop\\DEVX\\image-106.png");
    // WHAT WE NORMALLY DO
    // WebElement result = driver.findElement(By.xpath("//input[@id='uploadFile']/../../following-sibling::p"));
     WebElement result = chooseFileInput.findElement(By.xpath("./../../following-sibling::p"));
     Assert.assertTrue(result.getText().contains("image-106"));
}

@Test
    public void test3(){
        driver.get("https://images.google.com/");
        driver.findElement(By.xpath("//div[@aria-label='Search by image']")).click();

}
}
