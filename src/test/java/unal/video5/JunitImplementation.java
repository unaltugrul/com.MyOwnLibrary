package unal.video5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JunitImplementation {

    @Test
    public void test1(){
        //We use @Test annotation from Junit framework
        //1 - go to https://www.amazon.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        //2- enter "Nutella" to searchbox
        //3- press enter
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        //4- print product number
        System.out.println(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")).getText());
    }
}
