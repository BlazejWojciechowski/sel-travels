package blaze.selenium.travels.service;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FactoryDriver {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    String chromePath = "C:\\Users\\User\\chromedriver_win32\\chromedriver.exe";
                    System.setProperty("webdriver.chrome.driver", chromePath);
                    return new ChromeDriver();
                case "firefox":
                    String firefoxPath = "C:\\Users\\User\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe";
                    System.setProperty("webdriver.gecko.driver", firefoxPath);
                    return new FirefoxDriver();
                default:
                    throw new InvalidArgumentException("Invalid browser name");
            }
        }
        return driver;
    }
}
