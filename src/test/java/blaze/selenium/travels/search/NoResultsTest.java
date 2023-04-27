package blaze.selenium.travels.search;

import blaze.selenium.travels.pages.HotelSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoResultsTest extends BaseTest {
    @Test
    public void resultTest() {
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver, wait);
        hotelSearchPage.setDates("28/04/2024", "30/04/2024");
        hotelSearchPage.setTravellers(1, 1);
        hotelSearchPage.performSearch();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='text-center']")));
        WebElement heading = driver.findElement(By.xpath("//h2[@class='text-center']"));

        Assert.assertTrue(heading.isDisplayed());
        Assert.assertTrue(true, heading.getText());
    }
}
