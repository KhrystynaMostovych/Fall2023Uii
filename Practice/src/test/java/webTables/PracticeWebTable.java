package webTables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import utillities.Driver;

import java.util.List;

public class PracticeWebTable {
    WebDriver driver;
    @Before
    public void setUp(){
        driver = Driver.getDriver();
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void test1() {

        // we will treat it as a static table
        //and we can hardcode the row where Dan Brown is displayed
        driver.navigate().to("https://chandanachaitanya.github.io/selenium-practice-site/?languages=Java&enterText=");

        // bring the table into the view

        // so if I need to find how many names in the list
        // I have to create the action then I nave to create "List" and
        //

        Actions actions = new Actions(driver);
        WebElement buttonToScrollTo = driver.findElement(By.id("win1"));
        actions.moveToElement(buttonToScrollTo).perform();

        //WebElement table = driver.findElement(By.xpath())
        //        List<WebElement> columns = table.findElements(By.xpath(".//tr/th"));

        // how to get the number of rows

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='BooksAuthorsTable']//tr"));
        int numberOfRows = rows.size();
        System.out.println("The number of rows in the table: " + numberOfRows);


        // find number of columns

        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='BooksAuthorsTable']//tr/th"));
        int numberOfColumn = columns.size();
        System.out.println("Number of columns: " + numberOfColumn);


        // print out all books

        List<WebElement> danBrownRow = driver.findElements(By.xpath("//table[@id='BooksAuthorsTable']//tr[4]/td"));
        // print all books
        // because 1st name will be name of author we fo for loop for printing name afret 1
        for (int i = 1; i < danBrownRow.size(); i++) {
            System.out.println(danBrownRow.get(i).getText());
        }

    }


    @Test
    public void test2(){
        driver.navigate().to("https://chandanachaitanya.github.io/selenium-practice-site/?languages=Java&enterText=");

        Actions actions = new Actions(driver);
        WebElement buttonToScrollTo = driver.findElement(By.id("win1"));
        actions.moveToElement(buttonToScrollTo).perform();
    // we will work dynamic table
        // we need to find witch colon contain authors and witch books
        WebElement table = driver.findElement(By.xpath("//table[@id='BooksAuthorsTable']//tr"));
        List<WebElement> columnNames = table.findElements(By.xpath(".//th")); // book1,book2...
        int indexOfAuthor = 0;

         for(WebElement columnName : columnNames){
             ++indexOfAuthor;
             if(columnName.getText().contains("Author"))break;

               }

         List<WebElement> autors =table.findElements(By.xpath(".//tr/td["+ indexOfAuthor +"]"));

         int indexOfDanBrownRow =0;
         for(WebElement author : autors){
             ++indexOfDanBrownRow;
             if(author.getText().trim().equals("Dan Brown"))break; }


    }


    @Test
    public void test3(){
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        int countryColon = 3;
        Actions action = new Actions(driver);
List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
int mexico=1;
for(int i=2; i<=rows.size(); i++) {  // we will look only for 3rd row
    mexico++;
    WebElement countryCell = driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]/td[3]"));
    if (countryCell.getText().trim().equals("Mexico")) break;

}
int companyColumn =1;

WebElement mexicoCamp = driver.findElement(By.xpath("//table[@id='customers']//tr["+mexico+"/td["+companyColumn+"]"));

    }
}
