package unal.video4;

import com.github.javafaker.Faker;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2 {
    public static void main(String[] args) {
        //1 - go to https://www.facebook.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebook.com");
        //2- Enter mail adress to email box randomly
        Faker faker = new Faker();
        String emailAddress = faker.internet().emailAddress();
        driver.findElement(By.name("email")).sendKeys(emailAddress);
        //3- Enter password randomly
        String password = faker.internet().password();
        driver.findElement(By.name("pass")).sendKeys(password);
        //4- Click ""log in"" button
        driver.findElement(By.name("login")).click();
        //5- ıf account suggestion pop-up appears then click close button

        try {
            WebElement popupElement = driver.findElement(By.xpath("//div[@role='dialog']"));
            WebElement closeButton = driver.findElement(By.xpath("//div[@role='dialog']//div/i[1]"));
            if (popupElement.isDisplayed()){
                closeButton.click();
            }
        }catch (Exception e){
            System.out.println("pop-up was not appeared");
        }

        //5- Verify that user should be able to see "The email or mobile number you entered isn't connected to an account. Find your account and log in."

        try {
            String actualErrorMessage = driver.findElement(By.xpath("//div[@id='email_container']/div[2]")).getText();
            System.out.println("actualErrorMessage = " + actualErrorMessage);
            String expectedErrorMessage = "The email address you entered isn't connected to an account. ";
            //----->Without assertion
            if (expectedErrorMessage.equals(actualErrorMessage)){
                System.out.println("PASSED");
            }else {
                System.out.println("FAILED");
            }

        }catch (Exception e){
            System.out.println("you should try this scenario again");
        }

        //6- Close the page
        driver.close();
    }
}
