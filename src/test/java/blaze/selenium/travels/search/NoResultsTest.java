package blaze.selenium.travels.search;

import blaze.selenium.travels.service.FactoryDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NoResultsTest {
    @Test
    public void resultTest() {
        WebDriver driver = FactoryDriver.getDriver("firefox");

        Duration time = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, time);

        driver.manage().window().maximize();
        driver.get("http://www.kurs-selenium.pl/demo/");

        driver.findElement(By.name("checkin")).sendKeys("28/04/2024");
        driver.findElement(By.name("checkout")).sendKeys("30/04/2024");
        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        driver.findElement(By.xpath("//button[(text()=' Search')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='text-center']")));
        WebElement heading = driver.findElement(By.xpath("//h2[@class='text-center']"));

        Assert.assertTrue(heading.isDisplayed());
        Assert.assertTrue(true, heading.getText());
    }
}
