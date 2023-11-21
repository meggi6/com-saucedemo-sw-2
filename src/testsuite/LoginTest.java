package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Write down the following test into ‘LoginTest’ class
 *  1. userSholdLoginSuccessfullyWithValidCredentials
 *  * Enter “standard_user” username * Enter “secret_sauce” password
 *  * Click on ‘LOGIN’ button * Verify the text “PRODUCTS”
 *  2. verifyThatSixProductsAreDisplayedOnPage * Enter “standard_user” username
 *  * Enter “secret_sauce” password * Click on ‘LOGIN’ button
 *  * Verify that six products are displayed on page
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    //Before annotation run in the beginning of all tests
    @Before
    //Browser set-up method
    public void setUp(){
        openBrowser(baseUrl);
    }

    //After annotation method run at the end of all tests
    @After
    //Browser closing method
    public void tearDown(){
        closeBrowser();
    }

    //Test annotation for executing the method
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //Find username field element and enter username
        driver.findElement(By.xpath("//input[@id = 'user-name' and @placeholder = 'Username']")).sendKeys("standard_user");
        //Find password field element and enter password
        driver.findElement(By.xpath("//input[@type='password' or @placeholder = 'Password']")).sendKeys("secret_sauce");
        //Find login button element and click on it
        driver.findElement(By.xpath("//input[contains(@id , 'logi')]")).click();
        //Expected text according to requirement
        String expectedSecureText = "PRODUCTS";
        //Find Products text element and get it's text
        String actualSecureText = driver.findElement(By.xpath("//span[@class= 'title']")).getText();
        //Verify expected and actual text
        Assert.assertEquals("Text is not matching", expectedSecureText, actualSecureText);
    }

    //Test annotation for executing the method
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Find username field element and enter username
        driver.findElement(By.xpath("//input[@id = 'user-name' and @placeholder = 'Username']")).sendKeys("standard_user");
        //Find password field element and enter password
        driver.findElement(By.xpath("//input[@type='password' or @placeholder = 'Password']")).sendKeys("secret_sauce");
        //Find login button element and click on it
        driver.findElement(By.xpath("//input[contains(@id , 'logi')]")).click();
        //Expected number of products in page according to requirement
        int expectedNumberOfProducts = 6;
        //Find number of products elements and get it's size
        List <WebElement> numberOfProductsElements = driver.findElements(By.xpath("//div[@class= 'inventory_list']//div[@class= 'inventory_item']"));
        int actualNumberOfProducts = numberOfProductsElements.size();
        //Verify expected and actual number
        Assert.assertEquals("Text is not matching", expectedNumberOfProducts, actualNumberOfProducts);
    }
}
