package blaze.selenium.travels.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SignUpTest extends BaseTest {
    @Test
    public void singUp() {
        Random random = new Random();
        int rand = random.nextInt();
        String email = "testowy" + rand + "@gmail.com";
        driver.findElements(By.xpath("//li[@id='li_myaccount']"))
                .stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        driver.findElements(By.xpath("//a[text()='  Sign Up']"))
                .get(1)
                .click();

        driver.findElement(By.name("firstname")).sendKeys("Błażej");
        driver.findElement(By.name("lastname")).sendKeys("Wojciechowski");
        driver.findElement(By.name("phone")).sendKeys("123456789");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("Test123!");
        driver.findElement(By.name("confirmpassword")).sendKeys("Test123!");
        driver.findElement(By.xpath("//button[text()=' Sign Up']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='RTL']")));
        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));

        Assert.assertTrue(heading.getText().contains("Wojciechowski"));
    }
}
