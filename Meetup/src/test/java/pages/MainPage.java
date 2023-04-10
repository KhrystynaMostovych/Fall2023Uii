package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.stream.Location;

public class MainPage {
// in this class we will store all the elements from the main page meetup

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // before every webElement we need to tell how to find it
    @FindBy(id = "login-link")
    public WebElement loginButton;

    public WebElement signupButton;
    @FindBy(xpath = "//*[@id=\"register-link\"]")
    public WebElement joinMeetupButton;

    @FindBy(id = "search-keyword-input")
public WebElement searchInputField;

    @FindBy(xpath = "//*[@id=\"page\"]/div[2]/main/div[1]/div[4]/div[1]/form/div[2]/input")
    public WebElement searchButton;

@FindBy(xpath = "//*[@id=\"location-typeahead-searchLocation\"]")
public WebElement locatedInputField;

    public void clickJoinMeetup (){
        //we need explicit waits before performing an action
        joinMeetupButton.click();
    }

    public void search(String searchCriteria , String location){
    searchInputField.sendKeys(searchCriteria);
    if(location!=null){
        //locatedInputField.clear();
        locatedInputField.sendKeys(Keys.COMMAND+"a"+Keys.DELETE);
    locatedInputField.sendKeys(location);

    }
    searchButton.click();

 }

}