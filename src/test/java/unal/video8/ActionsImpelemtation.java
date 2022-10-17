package unal.video8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsImpelemtation {

    //clickandHold
    //contextClick ----> right click
    //Actions actions = new Actions();

    @Test
    public void test1(){

        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='logo pull-left']/a/img[1]")).isDisplayed());
        //4. Click on 'Signup / Login' button
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("//i[@class='fa fa-lock']/.."))).perform();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='signup-form']")).isDisplayed());
        //6. Enter name and email address
        actions.click(driver.findElement(By.xpath("//input[@data-qa='signup-name']")))
                .sendKeys("Mex")
                .sendKeys(Keys.TAB)
                .sendKeys("deneme@den.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //7. Click 'Signup' button
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        WebElement radioButton = driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        actions.click(radioButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("3")
                .sendKeys(Keys.TAB)
                .sendKeys("April")
                .sendKeys(Keys.TAB)
                .sendKeys("1910")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys("Mex")
                .sendKeys(Keys.TAB)
                .sendKeys("Mock")
                .sendKeys(Keys.TAB)
                .sendKeys("Myself")
                .sendKeys(Keys.TAB)
                .sendKeys("street mocking mocking")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("USA")
                .sendKeys(Keys.TAB)
                .sendKeys("Teksas")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("06200")
                .sendKeys(Keys.TAB)
                .sendKeys("1010101010")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        String expectedMessage = "ACCOUNT CREATED!";
        String actualMessage = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        driver.close();

        //If you want to run this test scenario you should change name and email because of that this message may appear "Email Address already exist!"

    }


}
