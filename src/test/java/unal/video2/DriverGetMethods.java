package unal.video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethods {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1-land to url
        driver.get("https://www.amazon.com");

        //2-get title
        System.out.println("page title: " + driver.getTitle());

        //3-get url
        System.out.println("page url: " + driver.getCurrentUrl());

        //4-get page source (etc: verify any word in page source)
        System.out.println("========================================================");
        System.out.println("page source: " + driver.getPageSource());
        System.out.println("========================================================");

        //5-get page unique hash code just for one window (changes every refresh)
        System.out.println("========================================================");
        System.out.println("uniqueHandle = " + driver.getWindowHandle());
        System.out.println("========================================================");

        //6-get page unique hash code just for multiple windows
        System.out.println("========================================================");
        System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles());
        System.out.println("========================================================");
    }
}
