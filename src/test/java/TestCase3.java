import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase3 {
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
    public void test1() throws InterruptedException {
        Actions action = new Actions(driver);
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

        for (int i = 1; i <= arrivals.size(); i++) {
            WebElement inStockCheck=driver.findElement(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div["+i+"]"));
            String check=inStockCheck.getText();
            System.out.println(check);
            if (check.contains("ADD TO BASKET")) {
                inStockCheck.click();
                WebElement bookItem = driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[2]/form/button"));
                action.moveToElement(bookItem).build().perform();
                bookItem.click();
                System.out.println("book add to his basket successful");

            } else {
                System.out.println("Out of Stock");
            }

        }

        String actualPage = driver.getTitle();
        System.out.println("Current Page >>"+actualPage);
        String expectedPage = "Mastering JavaScript – Automation Practice Site";
        System.out.println("Expect Page >>"+expectedPage);
        if (actualPage.equalsIgnoreCase(expectedPage)) {
            System.out.println("You are in the right page");
        } else {
            System.out.println("Page navigate to is Failed");
        }
        //Click on arrival

    }
}
