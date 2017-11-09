package rus.test.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class Test_11 {
        private WebDriver driver;
        private WebDriverWait wait;

        @Before
        public void start() {
            driver = new ChromeDriver();
            //driver = new InternetExplorerDriver();
            //driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, 10);
        }

        @Test
        public void myFirstTest() {
            driver.get("http://localhost/litecart/en/");
            driver.findElement(By.cssSelector("#box-account-login a")).click();
            driver.findElement(By.cssSelector("#create-account tr:nth-child(2) td:nth-child(1) input")).sendKeys("Ivan");
            driver.findElement(By.cssSelector("#create-account tr:nth-child(2) td:nth-child(2) input")).sendKeys("Ivanov");
            driver.findElement(By.cssSelector("#create-account tr:nth-child(3) input")).sendKeys("Chicago, Broadway");
            driver.findElement(By.cssSelector("#create-account tr:nth-child(4) input")).sendKeys("60601");
            driver.findElement(By.cssSelector("#create-account tr:nth-child(4) td:nth-child(2) input")).sendKeys("Albukerka");
            Select select = new Select(driver.findElement(By.cssSelector("#create-account tr:nth-child(5) td:nth-child(1) select")));
            select.selectByValue("US");
            select = new Select(driver.findElement(By.cssSelector("#create-account td:nth-child(2) select")));
            select.selectByValue("IL");
            driver.findElement(By.cssSelector("#create-account tr:nth-child(6) td:nth-child(1) input")).sendKeys("1234@a.com");
            driver.findElement(By.cssSelector("#create-account tr:nth-child(6) td:nth-child(2) input")).sendKeys("7874578");
            driver.findElement(By.cssSelector("#create-account tr:nth-child(8) td:nth-child(1) input")).sendKeys("1234");
            driver.findElement(By.cssSelector("#create-account tr:nth-child(8) td:nth-child(2) input")).sendKeys("1234");
            driver.findElement(By.cssSelector("#create-account tr:nth-child(9) button")).click();
            driver.findElement(By.cssSelector("#box-account li:nth-child(4) a")).click();
            driver.findElement(By.cssSelector("#box-account-login tr:nth-child(1) input")).sendKeys("1234@a.com");
            driver.findElement(By.cssSelector("#box-account-login tr:nth-child(2) input")).sendKeys("1234");
            driver.findElement(By.cssSelector("#box-account-login tr:nth-child(4) button:nth-child(1)")).click();
            driver.findElement(By.cssSelector("#box-account li:nth-child(4) a")).click();
           }

        @After
        public void stop() {
            driver.quit();
            driver = null;
        }
    }
