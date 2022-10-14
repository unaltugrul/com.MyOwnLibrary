package unal.video4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestCase3 {
    public static void main(String[] args) {
        //1- go to https://www.bestbuy.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
        //2-print all button text
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        System.out.println(buttonList.size());
        for (WebElement each : buttonList) {
            System.out.println("each text: " + each.getText());
        }
    }
}
