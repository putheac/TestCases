import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase2 {

    WebDriver driver;
    private String url = "http://practice.automationtesting.in/";

    @Before
    public void beforeMethod() {
        //Open the browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Enter the URL “http://practice.automationtesting.in/”
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        //Click on shop Menu
        driver.findElement(By.xpath("//li[@id=\"menu-item-40\"]")).click();
        //Click on Home Menu
        driver.findElement(By.xpath("//div[@id=\"content\"]/nav/a")).click();
        //Test whether the Home page has Three Arrivals only
        List<WebElement> arrivals = driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div"));
        int numberOfArrivals = arrivals.size();
        if (numberOfArrivals == 3) {
            System.out.println("Home page Arrivals count is 3");
        } else {
            System.out.println("Failed");
            //System.out.println(sliders.size());
        }

    }
}
