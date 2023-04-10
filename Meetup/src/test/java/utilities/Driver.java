package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){}


    // --- 1.
    private static WebDriver driver;

    public static WebDriver getDriver() {
        // before creating a driver we need to make sure there is no driver running
        //first of all, we have to check that our driver is null

        if (driver == null) {
            // here we will create new fresh driver;
            switch(ConfigReader.getProperty("browser").toLowerCase()){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = (WebDriver) new FirefoxDriverManager();
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
                driver.close();
                driver.quit();
                driver = null;
            }
        }catch (Exception e){
            e.printStackTrace(); // we do this to know where is coming from and what is a reson

        }}}


