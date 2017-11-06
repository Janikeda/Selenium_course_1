package rus.test.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Test_10 {
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
            driver.navigate().to("http://localhost/litecart/en/");
            List<String> list_Main = new ArrayList<>();
            WebElement element = driver.findElement(By.cssSelector("#box-campaigns li:nth-child(1)"));
            list_Main.add(element.findElement(By.cssSelector("div.name")).getAttribute("innerText"));
            list_Main.add(element.findElement(By.cssSelector("div.price-wrapper")).getAttribute("innerText"));

            colorTest(element);
            sizeTest(element);

            element.findElement(By.tagName("a")).click();
            List<String> list_Product = new ArrayList<>();
            element = driver.findElement(By.cssSelector("#box-product"));
                    list_Product.add(element.findElement(By.cssSelector("h1.title")).getAttribute("innerText"));
                    list_Product.add(element.findElement(By.cssSelector("div.price-wrapper")).getAttribute("innerText"));
            colorTest(element);
            sizeTest(element);

            boolean inEqual = list_Main.equals(list_Product);

                    if (inEqual) {
                System.out.println("Характеристики совпадают");
            }
                    else {
                System.out.println("Характеристики не совпадают");
            }

        }

        public void colorTest(WebElement el) {
            String color_Grey = el.findElement(By.cssSelector("div.price-wrapper s")).getCssValue("color");
            String color_Red = el.findElement(By.cssSelector("div.price-wrapper strong")).getCssValue("color");

            String[] color_Array = color_Grey.replace("rgba(", "").replace(")", "").replace(" ", "").split(",");

            if (color_Array[0].equals(color_Array[1]) && color_Array[1].equals(color_Array[2])) {
                System.out.println("Цвет серый");
            }
            else {System.out.println("Цвет не серый");}
            color_Array = color_Red.replace("rgba(", "").replace(")", "").replace(" ", "").split(",");
            if (Objects.equals(color_Array[1], "0") && Objects.equals(color_Array[2], "0")) {
                System.out.println("Цвет красный");
            }
            else {System.out.println("Цвет не красный");}
        }

        public void sizeTest(WebElement el) {
            Dimension size_Grey = el.findElement(By.cssSelector("div.price-wrapper s")).getSize();
            int size_Grey_Width = size_Grey.getWidth();
            int size_Grey_Height = size_Grey.getHeight();
            Dimension size_Red = el.findElement(By.cssSelector("div.price-wrapper strong")).getSize();
            int size_Red_Width = size_Red.getWidth();
            int size_Red_Height = size_Red.getHeight();
            if ((size_Grey_Width+size_Grey_Height) > (size_Red_Width+size_Red_Height)) {
                System.out.println("Размер основной цены больше цены аукциона");
            }
            if ((size_Grey_Width+size_Grey_Height) == (size_Red_Width+size_Red_Height)){
                System.out.println("Размер цен одинаковый");
            }
            else{System.out.println("Размер аукционной цены больше основной");}
        }

        @After
        public void stop() {
            driver.quit();
            driver = null;
        }

    }

