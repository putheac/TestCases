import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase12 {
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
    public void test1() throws InterruptedException {
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
        //10) Click on the Add To Basket button which adds that book to your basket
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //11) User can view that Book in the Menu item with price.
        WebElement showPrice = driver.findElement(By.xpath("//a[@class='wpmenucart-contents']"));
        System.out.println(showPrice.getText());
        //12) Now click on Item link which navigates to proceed to check out page.
        showPrice.click();
        //13) Click on textbox value under quantity in Check out page to add or subtract books.
                 driver.findElement(By.xpath("//input[@type='number']")).sendKeys(Keys.chord(Keys.CONTROL, "1", Keys.DELETE), "2");
        // 14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
        // 15) Now click on Update Basket to reflect those changes
         driver.findElement(By.xpath("//input[@value='Update Basket']")).click();
        //16) User has the feasibility to Update Basket at the time of check out.
        //????

    }
}
