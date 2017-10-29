package rus.test.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Launch_Firefox {

    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {

//        FirefoxOptions options = new FirefoxOptions().setLegacy(true); // Запуск браузера FireFox ver 45
//        driver = new FirefoxDriver(options);

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")));
        driver = new FirefoxDriver(options);

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







