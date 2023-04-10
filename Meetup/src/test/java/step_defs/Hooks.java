package step_defs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.EnvironmentManager;


public class Hooks {

@Before
    public void setUp() throws Exception {
//   here we set up our environment variables
// we will have inv. manager that will store all inv. variables
// and our before hook will call the inv manager to set up all verbiables corectly
    EnvironmentManager.setUpEnvironment();


}

/*@After
    public void tearDown(Scenario scenario){
    try{if (scenario.isFailed()){
        final byte[] screenshot = ((TakesScreenshot)(Driver.getDriver()).getScreenshot(OutputType.BYTES);
     scenario.embed(screenshot,"image/png");
   } }catch (Exception e){
      System.out.println("The error happened while taking screenshot");
       e.getMessage();
Driver.getDriver();*/



}


