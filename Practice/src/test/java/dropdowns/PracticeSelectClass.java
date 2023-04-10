package dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLSelectElement;
import utillities.ConfigReader;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeSelectClass {

    WebDriver driver;

    @Before
    public void setUp() {
        if(ConfigReader.getProperty("browser").equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();} else if (ConfigReader.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
       // driver.close();
       // driver.quit();
    }

    @Test
    public void practiceEnrollForm() {
        driver.get("https://devxschool.com/enrollment/");
        // i want to see all the options available
        // i want to see the option selected by default
        // STEP 1
        // Locate your select webelement and store it in webelement object
        WebElement selectElement = driver.findElement(By.cssSelector("#form-field-field_e77277b"));

        // STEP 2
        Select dropdown = new Select(selectElement);

        // to see all the available options
        List<WebElement> availableOptions = dropdown.getOptions();

        Assert.assertEquals(8, availableOptions.size());
        for (WebElement option : availableOptions) {
            System.out.println(option.getText());
        }

        // make sure From a friend is selected by default
        //1. Get all selected options

        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
        Assert.assertTrue(selectedOptions.size() == 1 && selectedOptions.get(0).getText().equals("Friends"));

        // lets select Google by visible text
        dropdown.deselectByVisibleText("Google");
        // to select by index
        dropdown.selectByIndex(1);
        // select by value
        dropdown.selectByValue("Google");
        selectedOptions = dropdown.getAllSelectedOptions();
        Assert.assertTrue(selectedOptions.size() == 1 && selectedOptions.get(0).equals("Google"));

    }


    @Test
    public void practiceMultiSelect(){
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

        WebElement selectElement = driver.findElement(By.id("option-droup-demo"));
        Select dropdown = new Select(selectElement);// - lets verify it is a multi select
        Assert.assertTrue(dropdown.isMultiple());
        //what options are selected?

        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
        System.out.println("Currently options that are selected: ");
        for (WebElement selected: selectedOptions){
            System.out.println(selected.getText());}

       // I want to select Java and Python. c#

        // first I deselect HTML and CSS
        dropdown.deselectAll();
// if I want to deselect html I would do this - dropdown.deselectByVisibleText("HTML");
        // select Java by index
        dropdown.selectByIndex(5);
        //select C# be value
        dropdown.selectByValue("csharp");
        //select Python by text
        dropdown.selectByVisibleText("Python");

        // we want to make sure that 3 options are selected
        selectedOptions = dropdown.getAllSelectedOptions();
        Assert.assertEquals(3,selectedOptions.size());

        System.out.println("******\nNew options selected");
        for (WebElement selected: selectedOptions){
            System.out.println(selected.getText());} // we do this to know witch elements are selected
    }

    @Test
    public void selectExpedia (){
        driver.get("https://www.expedia.com/");
        try {
            driver.findElement(By.xpath("//*[@id=\"wizardMainRegionV2\"]/div/div/div/div/ul/li[6]/a")).click();
        }catch (ElementClickInterceptedException e){
            WebDriverWait wait =new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app-layer-base\"]/div[1]/div[1]/header/div/section/div/div/div[2]/div/div/div/div/div[2]/h2")));
            driver.findElement(By.xpath("//*[@id=\"wizardMainRegionV2\"]/div/div/div/div/ul/li[6]/a")).click();
            driver.findElement(By.id("cruise-destination"));
        }
        WebElement selectElement = driver.findElement(By.id("cruise-destination"));

        Select dropdown = new Select(selectElement);

        dropdown.selectByValue("alaska");

        //verify that we choose Alaska - we select all elements because its only 1 we put .get(0)
        // then we want to get a text and we want to make sure that text equals to that what we are looking for

        Assert.assertTrue(dropdown.
                getAllSelectedOptions()
                .get(0)
                .getText()
                .equals("Alaska"));

        dropdown.selectByVisibleText("Africa");
        Assert.assertTrue(dropdown.
                getFirstSelectedOption()
                .getText()
                .equals("Alaska"));

        //dropdown.getOptions -  will return my a list of webElement inst at of creating a list
        for(WebElement option: dropdown.getOptions()) {
            System.out.println(option.getText());
        }


}




}
