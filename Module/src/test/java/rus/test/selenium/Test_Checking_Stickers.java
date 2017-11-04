package rus.test.selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class Test_Checking_Stickers {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
    public boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }
     @Test
     public void myFirstTest() {
         driver.navigate().to("http://localhost/litecart/en/");

         List<WebElement> listProducts = driver.findElements(By.cssSelector(".product"));

         for (int i = 0; i < listProducts.size(); i++) {
             WebElement product = listProducts.get(i);
             try {
                 Assert.assertTrue(product.findElements(By.cssSelector(".sticker")).size() != 0);
                 System.out.println("Товар №"+(i+1)+": Количество стикеров: "+ product.findElements(By.cssSelector(".sticker")).size());

             } catch (NoSuchElementException e) {
                 System.out.println("Товар №"+(i+1)+"i Количество стикеров: 0");
             }
         }
     }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
