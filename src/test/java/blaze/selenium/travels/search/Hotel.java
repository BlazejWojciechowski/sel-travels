package blaze.selenium.travels.search;

import blaze.selenium.travels.service.FactoryDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hotel {
    @Test
    public void search() {
        WebDriver driver = FactoryDriver.getDriver("firefox");

        Duration time = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, time);

        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//span[@class='select2-match' and text()='Dubai']")));
        driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']")).click();
    }
}