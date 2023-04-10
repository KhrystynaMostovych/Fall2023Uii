package windowsIframes;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class MultipleWindows {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @After
    public void tearDown (){
        driver.close();
        driver.quit();
    }



    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com/");
        // I want to get the unique window handle assigned to amazon page;
        // getWindowHandle()  --> retrieves the unique id of currently open window
         String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);

        // my unique id CDwindow-ABD60E3E08B9CB6A13193815717227C3 --- after first run
        // CDwindow-C78558B4D3F4DBB754B3D50561B6187A ----- second run and unique id change
    }

     @Test
    public void testMulpeWidows(){
        driver.get("http://www.practiceselenium.com/");
        driver.findElement(By.xpath("//span[contains(text(),'25 years')]/a")).click();
    // after I clicked on the link - new window opene up
    // in order to interact with webelements on switch to the new window
    // I need to tell my driver to switch to the new window
     //1. get windowHandle of main window
     //2.get window handles of all open window
     //3.using a loop compare and switch to the new window

         //1.
         String mainPage = driver.getWindowHandle();

         //2.
         Set<String> allOpenWindows = driver.getWindowHandles();
         // this set will contain 2 values because we have 2 windows open
         // one of the values will be id of our main window
         //
         for (String windowHandle : allOpenWindows){
             if (!windowHandle.equals(mainPage)){
                 driver.switchTo().window(windowHandle);}}

         // click on the new window
         driver.findElement(By.xpath("//a[text()='Choosing am Automation Solotion"));
          // here I may need to add some wait

         WebElement agendaHeading = driver.findElement(By.xpath("/strong[text()='Agenda:']"));
         Assert.assertTrue("Agenda is not displayed.Switch to the next window",agendaHeading.isDisplayed());

         driver.switchTo().window(mainPage);
         WebElement checkOutLink = driver.findElement(By.xpath("//"));
         Assert.assertTrue("Failed to switch back to home page",checkOutLink.isDisplayed());

    }


    @Test
    public void demoQaTest (){
        // we are going to main page

driver.get("https://demoqa.com/");
// here we should click on the button
driver.findElement(By.xpath("")).click();
// we are create a string of main page
String mainPage = driver.getWindowHandle();
// we are create a set to handle all open windos
Set<String>allOpenWindows = driver.getWindowHandles();

// we are creating a new loop to check if our windowHandle is opened and  to compare with main window
for (String windowHandle : allOpenWindows){
    if ((!windowHandle.equals(mainPage))){

        driver.switchTo().window(windowHandle);}}

    // now we are on the new window and we can interact with its element

       WebElement joinNowLink =  driver.findElement(By.xpath("//a[@href='https://www.toolsqa.com/selenium-training/']"));

    joinNowLink.click();
     // now I have 3 windows open
     //
      String secondPage =driver.getWindowHandle();
     allOpenWindows = driver.getWindowHandles();//now its have 3 values

    for(String windowHandle: allOpenWindows){
        // so we need for and if statement to make shore that our 3rd lind dosnt compare to first link and second link
        // that mean we have 3rd link and we can open it
        if(!windowHandle.equals(mainPage)&& !windowHandle.equals(secondPage)){
            driver.switchTo().window(windowHandle);}}
          Assert.assertTrue(driver.getTitle().contains("Online selenium training"));
          Assert.assertTrue(driver.findElement(By.xpath("//")).isDisplayed());





     }






}
