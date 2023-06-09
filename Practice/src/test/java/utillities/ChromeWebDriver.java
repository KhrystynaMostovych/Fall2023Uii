package utillities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeWebDriver {
 public static WebDriver loadChromeDriver() {
     WebDriverManager.chromedriver().setup();
     // new ChromeDriver() - it creates default Chrome browser
     // new ChromeDriver (options)

     ChromeOptions options = new ChromeOptions();
     options.addArguments("--start-maximized");
     options.addArguments("--disable-extension");
     options.addArguments("--window-size=1920,1080");
    //  if(ConfigReader.getProrerty("headless").equalsIgnoreCase("true"));
     options.addArguments("--headless");
      // these are extra options
     options.addArguments("--no-sanbox");
     options.addArguments("--disable-gpu");


     WebDriver driver = new ChromeDriver(options);
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     return driver;
 }}

