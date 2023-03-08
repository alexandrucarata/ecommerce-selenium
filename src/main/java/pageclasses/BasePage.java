package pageclasses;

import driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = WebDriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void hover(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }
}