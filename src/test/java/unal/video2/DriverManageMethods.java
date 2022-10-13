package unal.video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManageMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //gives to me pixel of page size
        System.out.println(driver.manage().window().getSize()); //----> (1052, 698)
        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getSize()); //----> (1361, 730)



    }
}
