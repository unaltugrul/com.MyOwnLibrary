package unal.video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.amazon.com");

        //another version  beside of get method to land on webpage as usual navigate method is used navigates of between pages as well.
        driver.navigate().to("https://www.facebook.com");

        // back to previous page
        driver.navigate().back();

        //next to forward page
        driver.navigate().forward();

        //to refresh
        driver.navigate().refresh();

        //if you have just single window
        driver.close();

        //if you have multiple windows
        //driver.quit();


    }
}
