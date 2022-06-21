import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TolaTest {

    WebDriver driver;
    private String url = "https://www.fitnessavenue.ca/";
    @Before
        public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.get(this.url);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
    }

    @Test
    public void clickAllBtn() throws InterruptedException {
            List<WebElement> cadios= driver.findElements(By.xpath("//*[@id='content']/div[3]/div"));
            clickAllBtnAndBack(cadios);
    }

    @After
    public void closeAll(){
        driver.close();
    }

    public void clickAllBtnAndBack(List<WebElement> cadios) {
        WebDriverWait wait = new WebDriverWait(driver,10);
            for(int i=1;i<=cadios.size();i++){
                WebElement cadiosBtn= driver.findElement(By.xpath("//*[@id='content']/div[3]/div["+i+"]"));
                wait.until(ExpectedConditions.elementToBeClickable(cadiosBtn)).click();
                    driver.navigate().back();
            }
    }
}
