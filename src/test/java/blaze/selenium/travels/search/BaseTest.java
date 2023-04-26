package blaze.selenium.travels.search;

import blaze.selenium.travels.service.FactoryDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeMethod
    public void setup() {
        this.driver = FactoryDriver.getDriver("firefox");

        Duration time = Duration.ofSeconds(10);
        this.wait = new WebDriverWait(driver, time);

        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
