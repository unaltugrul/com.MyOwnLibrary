package unal.video7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise {

    @Test
    public void test01(){
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
        driver.findElement(By.xpath("//i[@class='fa fa-lock']/..")).click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='login-form']/h2[1]")).isDisplayed());
        //6. Enter correct email address and password
        String email = "nabernaber@gmail.com";
        String password= "12345";
        WebElement inputBox = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        inputBox.sendKeys(email);
        WebElement passwordBox = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordBox.sendKeys(password);
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[10]")).isDisplayed());
        //9. Click 'logout' button
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[4]")).click();
        //10. Verify that user is navigated to login page
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='login-form']/h2[1]")).isDisplayed());

        //11. Close driver
        driver.close();


    }




}
