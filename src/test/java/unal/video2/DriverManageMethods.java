package unal.video2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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

        //gives position the window(starting points(origin point) start from left bottom of the page)
        System.out.println("Page location: " + driver.manage().window().getPosition());

        //setting origin point
        driver.manage().window().setPosition(new Point(50,50));
        System.out.println(driver.manage().window().getPosition()); //-->(49, 49)

        //arrange window size as left bottom side constant
        driver.manage().window().setSize(new Dimension(900,600));
        System.out.println("new window sizes: " + driver.manage().window().getSize()); //new window sizes: (902, 602)
        System.out.println("new page location: " + driver.manage().window().getPosition()); //new page location: (48, 48)

        //to see differences some practices
        driver.manage().window().maximize();
        System.out.println("new window sizes: " + driver.manage().window().getSize());//new window sizes: (1361, 730)
        System.out.println("new page location: " + driver.manage().window().getPosition());//new page location: (-7, -7)

        driver.manage().window().fullscreen();
        System.out.println("new window sizes: " + driver.manage().window().getSize());//new window sizes: (1348, 758)
        System.out.println("new page location: " + driver.manage().window().getPosition());//new page location: (0, 0)




    }
}
