package rus.test.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Test {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        //driver = new ChromeDriver();
        //driver = new InternetExplorerDriver();

        // System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {
        driver.navigate().to("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
