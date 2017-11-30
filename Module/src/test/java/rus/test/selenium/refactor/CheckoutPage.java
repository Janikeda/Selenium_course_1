package rus.test.selenium.refactor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class CheckoutPage extends PageBase {

    public CheckoutPage(WebDriver driver)
    {
        super(driver);
    }

    public CheckoutPage deletingProduct()
    {
        List<WebElement> row = driver.findElements(By.cssSelector("#order_confirmation-wrapper tr td.item"));
        for (int i = 1; i <= row.size(); i++)
        {
            List<WebElement> shortcuts = driver.findElements(By.cssSelector("#box-checkout-cart .shortcuts li"));
            if (shortcuts.size() > 0)
            {
                WebElement shortcut = driver.findElement(By.cssSelector("#box-checkout-cart .shortcuts li:nth-child(1)"));
                shortcut.click();
                WebElement btn = wait.until(elementToBeClickable(By.cssSelector("[name='remove_cart_item']")));
                btn.click();
                wait.until(stalenessOf(row.get(0)));
            }
            else
            {
                WebElement btn = wait.until(elementToBeClickable(By.cssSelector("[name='remove_cart_item']")));
                btn.click();
                wait.until(stalenessOf(row.get(0)));
            }
        }
        wait.until(numberOfElementsToBe(By.cssSelector("#checkout-cart-wrapper p"), 2));

        return this;

    }

    public boolean finalStep()
    {
        return driver.findElement(By.cssSelector("#checkout-cart-wrapper p")).getText().equals("There are no items in your cart.");
    }

}
