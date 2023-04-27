package blaze.selenium.travels.search;

import blaze.selenium.travels.pages.HotelSearchPage;
import blaze.selenium.travels.pages.SignUpPage;
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
        String lastName = "Wojciechowski"
;
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver, wait);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver, wait);
        signUpPage.setFirstName("Błażej");
        signUpPage.setLastName(lastName);
        signUpPage.setPhone("123456789");
        signUpPage.setEmail(email);
        signUpPage.setPassword("Test123!");
        signUpPage.setConfirmPassword("Test123!");
        signUpPage.signUp();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='RTL']")));
        WebElement heading = driver.findElement(By.xpath("//h3[@class='RTL']"));

        Assert.assertTrue(heading.getText().contains(lastName));
    }
}
