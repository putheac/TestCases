import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase7 {
    WebDriver driver;
    private String url = "http://practice.automationtesting.in/";

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//li[@id=\"menu-item-40\"]")).click();
        driver.findElement(By.xpath("//div[@id=\"content\"]/nav/a")).click();
        List<WebElement> arrivals = driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div"));
        int numberOfArrivals = arrivals.size();
        if (numberOfArrivals == 3) {
            System.out.println("Home page Arrivals count is 3");
        } else {
            System.out.println("Failed");
        }
        //Click on Image with Add to Cart Available
        driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]")).click();
        //Click on add to cart
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Get Only number are in stock
        WebElement basket = driver.findElement(By.xpath("//p[@class='stock in-stock']"));
        String str =basket.getText();
        str=str.replaceAll("[^0-9]", "");
        System.out.println(str);
        //add one more 1 order to current available stock
        //convert String to Integer
        int addOder = Integer.parseInt(str);
        addOder=addOder+1;
        //convert int to String
        String newStr=String.valueOf(addOder);
        //System.out.println(newStr);
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys(Keys.chord(Keys.CONTROL, "1", Keys.DELETE), newStr);
        //driver.findElement(By.xpath("//input[@type='number']")).sendKeys(newStr);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
}
