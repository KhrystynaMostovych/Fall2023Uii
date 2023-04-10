package utillities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static final Logger LOGGER = LogManager.getLogger(Driver.class);
    // class that will totally control our browser and driver
    // it will make sure that there is only ine driver instance running at a time

    // in order to prevent anyone from creating a driver instance from anywhere
    //we create private constructor


                  //this class will contain 2 methods
                 //1 - for create a driver
                 //2- for closing your driver



     //this line will not allow you driver = new Driver();
    private Driver(){}


                       // --- 1.
    private static WebDriver driver;

    public static WebDriver getDriver() {

        LOGGER.debug("Initializing a webdriver for selenium version 3.141.59");
        LOGGER.info("Initializing a webdriver for selenium version 3.141.59");

        // before creating a driver we need to make sure there is no driver running
        //first of all, we have to check that our driver is null

        if (driver == null) {
            // here we will create new fresh driver;
    switch(ConfigReader.getProperty("browser").toLowerCase()){
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            // here will be code to set up firefox browser
            break;
        case "ie":
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            break;
        default:
            driver = ChromeWebDriver.loadChromeDriver();
            break;

        }}
        // if it is not null we simply return existing driver;
        return driver;

    }
                     // -2

    public static void closeDriver(){
        // we have to make sure that our driver is not null
        try{
        if(driver!=null) {
            LOGGER.info("Closing driver");
            driver.close();
            driver.quit();
            driver = null;
        }
        }catch (Exception e){
             e.printStackTrace(); // we do this to know where is coming from and what is a reson

        }}}


