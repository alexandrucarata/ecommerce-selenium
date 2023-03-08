package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Objects;

import static helpers.Constants.BROWSER;
import static helpers.Constants.REMOTE;

public class WebDriverSingleton {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(setupDriver());
        }
        return driver.get();
    }

    @SneakyThrows
    private static WebDriver setupDriver() {
        Capabilities capabilities = BrowserCapabilities.getBrowserCapabilities(BROWSER);
        if (StringUtils.isEmpty(REMOTE)) {
            return getLocalInstance(BROWSER);
        }
        return new RemoteWebDriver(new URL(REMOTE), Objects.requireNonNull(capabilities));
    }

    public static WebDriver getLocalInstance(String browser) {
        Capabilities capabilities = BrowserCapabilities.getBrowserCapabilities(browser);
        switch (browser) {
            case "chrome":
                WebDriverManager.getInstance(ChromeDriver.class).setup();
                return new ChromeDriver((ChromeOptions) Objects.requireNonNull(capabilities));
            case "firefox":
                WebDriverManager.getInstance(FirefoxDriver.class).setup();
                return new FirefoxDriver((FirefoxOptions) Objects.requireNonNull(capabilities));
        }
        return null;
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}