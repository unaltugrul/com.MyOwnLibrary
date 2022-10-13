package unal.video3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class Locators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //base sample
        //we have 8 locator way, our purpose is creating unique way via values of attributes
        //id, name, link text, partial link text, class name, tag name, css, xpath
        //WebElement webElement = driver.findElement(By.xpath("//tagname[@attributename='attributeValue']"));

        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//input[@data-action-type='DISMISS']")).sendKeys(Keys.ENTER);
        String logoText = driver.findElement(By.xpath("//div[@id='nav-logo']/a[1]")).getAttribute("aria-label");
        System.out.println("Logo Text = " + logoText);

    }
}
