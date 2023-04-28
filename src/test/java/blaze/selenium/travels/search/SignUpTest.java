package blaze.selenium.travels.search;

import blaze.selenium.travels.pages.HotelSearchPage;
import blaze.selenium.travels.pages.LoggedUserPage;
import blaze.selenium.travels.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SignUpTest extends BaseTest {
    @Test
    public void singUp() {
        Random random = new Random();
        int rand = random.nextInt();
        String email = "testowy" + rand + "@gmail.com";
        String lastName = "Wojciechowski";

        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver, wait);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver, wait);
        signUpPage.fillSignUpForm("Błażej", lastName, "123456789", email, "Test123!");

        LoggedUserPage loggedUserPage = new LoggedUserPage(driver, wait);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='RTL']")));
        Assert.assertTrue(loggedUserPage.getHeadingText().contains(lastName));
        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Błażej Wojciechowski");
    }
}
