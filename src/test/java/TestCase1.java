import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestCase1 {
    WebDriver chrome;

    @Before
    public void beforeMethod() {
        //Open the browser
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        //Enter the URL “http://practice.automationtesting.in/”
        chrome.get("http://practice.automationtesting.in/");
    }

    @Test
    public void test1() {
        //Click on shop Menu
        chrome.findElement(By.xpath("//li[@id=\"menu-item-40\"]")).click();
        //Click on Home Menu
        chrome.findElement(By.xpath("//div[@id=\"content\"]/nav/a")).click();
        //Test whether the Home page has Three Sliders only
        List<WebElement> sliders = chrome.findElements(By.xpath("//*[@id='n2-ss-6']/div"));
        int numberOfSliders = sliders.size();
        if (numberOfSliders == 3) {
            System.out.println("Sliders count is 3");
        } else {
            System.out.println("Failed");
            //System.out.println(sliders.size());
        }

    }
}
