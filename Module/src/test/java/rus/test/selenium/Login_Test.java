package rus.test.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Login_Test {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        //driver = new InternetExplorerDriver();
        // System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
        //driver = new FirefoxDriver();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
         }
    public boolean areElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
    @Test
    public void myFirstTest() {
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> list = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-"));
        //List<WebElement> listSpan = driver.findElements(By.cssSelector("ul#box-apps-menu li#app- span.name"));

        for(int i = 0; i < list.size(); ++i) {
            list = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-"));
            list.get(i).click();

            List<WebElement> listSpan = driver.findElements(By.cssSelector("ul#box-apps-menu li#app- span.name"));
            for(int m = 0; m < listSpan.size(); ++m)
            listSpan = driver.findElements(By.cssSelector("ul#box-apps-menu li#app- span.name"));
            listSpan.get(m).click();
        };
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
