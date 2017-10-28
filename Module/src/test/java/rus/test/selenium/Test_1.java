package rus.test.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Test_1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
     @Test
     public void myFirstTest() {
        driver.navigate().to("http://www.google.com");
         driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
        driver.findElement(By.name("btnG")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
