package rus.test.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Test_13 {
        private WebDriver driver;
        private WebDriverWait wait;



        @Before
        public void start() {
            driver = new ChromeDriver();
            //driver = new InternetExplorerDriver();
            //driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            wait = new WebDriverWait(driver, 10);
        }
        boolean isElementPresent(WebDriver driver, By locator) {
            return driver.findElements(locator).size() > 0;
        }


        @Test
        public void myFirstTest() {
            driver.get("http://localhost/litecart/en/");
            adding_Product();
            adding_Product();
            adding_Product();
            driver.findElement(By.cssSelector("#cart a.link")).click();
            deleting_Product ();
            deleting_Product ();
            deleting_Product ();
            String finalString = driver.findElement(By.cssSelector("#checkout-cart-wrapper em")).getText();
            assertTrue(finalString.contains("There are no items in your cart."));
        }

        public void adding_Product () {
            driver.findElement(By.cssSelector("div.content li.product")).click();
            String cart_Number = driver.findElement(By.cssSelector("#cart span.quantity")).getAttribute("innerText");

            if (isElementPresent(driver, By.cssSelector("#box-product div.buy_now tr:nth-child(1) select"))); {
                Select select = new Select(driver.findElement(By.cssSelector("#box-product div.buy_now tr:nth-child(1) select")));
                select.selectByValue("Large");
            }

//            if (isElementPresent(driver, By.cssSelector("#box-product div.buy_now tr:nth-child(1) select"))) {
//                Select select = new Select(driver.findElement(By.cssSelector("#box-product div.buy_now tr:nth-child(1) select")));
//                select.selectByValue("Large");
//            }

            driver.findElement(By.cssSelector("#box-product div.buy_now button")).click();
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("#cart span.quantity"), cart_Number));
            driver.findElement(By.cssSelector("#logotype-wrapper a")).click();

        }

        private void deleting_Product () {
            String total_Amount = driver.findElement(By.cssSelector("#order_confirmation-wrapper tr.footer td:nth-child(2)")).getAttribute("innerText");

            isElementPresent(driver, By.cssSelector("#box-checkout-cart p:nth-child(5) button")); {
                try {
                    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                    WebElement element = driver.findElement(By.cssSelector("#box-checkout-cart p:nth-child(5) button"));
                    wait.until(ExpectedConditions.elementToBeClickable(element));
                    element.click();
                } finally {
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
            }
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.cssSelector("#order_confirmation-wrapper td:nth-child(2)"), total_Amount));

        }


        @After
        public void stop() {
            driver.quit();
            driver = null;
        }


    }
















