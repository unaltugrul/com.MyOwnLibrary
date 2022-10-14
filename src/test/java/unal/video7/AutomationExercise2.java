package unal.video7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomationExercise2 {


    @Test
    public void test1() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='logo pull-left']/a/img[1]")).isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[2]/a[1]")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String actualText = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println("actualText = " + actualText);
        Assert.assertEquals(actualText,"ALL PRODUCTS");
        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("tshirt");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        String actualText1 = driver.findElement(By.xpath("//div[@class='features_items']/h2[1]")).getText();
        System.out.println("actualText = " + actualText1);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='features_items']/h2[1]")).isDisplayed());


    }

}
