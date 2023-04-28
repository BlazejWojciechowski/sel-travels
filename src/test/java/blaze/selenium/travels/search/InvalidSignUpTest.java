package blaze.selenium.travels.search;

import blaze.selenium.travels.pages.HotelSearchPage;
import blaze.selenium.travels.pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class InvalidSignUpTest extends BaseTest {
    @Test
    public void singUp() {
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver, wait);
        hotelSearchPage.openSignUpForm();

        SignUpPage signUpPage = new SignUpPage(driver, wait);
        signUpPage.signUp();

        List<String> errors = signUpPage.getErrors();

        errors.forEach(System.out::println);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errors.contains("The Email field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The Password field is required."));
        softAssert.assertTrue(errors.contains("The First name field is required."));
        softAssert.assertTrue(errors.contains("The Last Name field is required."));
        softAssert.assertAll();
    }
}
