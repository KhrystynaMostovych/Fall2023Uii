package utillities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class FireFoxWebDriver {
    public static WebDriver loadFireFoxDriver (){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
      //  if(ConfigReader.getProperty("headless").equalsIgnoreCase("true"));
        options.setHeadless(true);

WebDriver driver = new FirefoxDriver(options);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().window().maximize();


return driver;

    }

}
