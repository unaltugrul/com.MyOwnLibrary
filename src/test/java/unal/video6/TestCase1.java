package unal.video6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase1 {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1(){
        //1 - go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        //2- enter "Nutella" to searchbox and press enter
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        //3- verify "Nutella" word at the result info bar
        String allInfo = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[3]")).getText();
        System.out.println("allInfo = " + allInfo);
        Assert.assertTrue(allInfo.contains("Nutella"));


    }

    @After
    public void teardown(){
        driver.close();
    }

}
