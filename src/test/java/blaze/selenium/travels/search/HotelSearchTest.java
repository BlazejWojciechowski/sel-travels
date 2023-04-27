package blaze.selenium.travels.search;

import blaze.selenium.travels.pages.HotelSearchPage;
import blaze.selenium.travels.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HotelSearchTest extends BaseTest {
    @Test
    public void search() {
        HotelSearchPage hotelSearchPage = new HotelSearchPage(driver, wait);
        hotelSearchPage.setCity("London");
        hotelSearchPage.setDates("12/12/2024", "13/12/2024");
        hotelSearchPage.setTravellers(2, 3);
        hotelSearchPage.performSearch();

        ResultsPage resultsPage = new ResultsPage(driver, wait);
        List<String> hotelNames = resultsPage.getHotelNames();

        Assert.assertEquals("Grand Plaza Apartments", hotelNames.get(0));

        /*
        Assert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
        Assert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
        Assert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));

         */
    }
}