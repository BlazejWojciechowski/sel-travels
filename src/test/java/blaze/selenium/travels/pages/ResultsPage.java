package blaze.selenium.travels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultsPage {
    @FindBy(xpath = "//h4[contains(@class, 'list_title')]//b")
    private List<WebElement> hotelList;
    private WebDriver driver;
    private WebDriverWait wait;

    public ResultsPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    public List<String> getHotelNames() {
        return hotelList
                .stream()
                .map(element -> element.getAttribute("textContent"))
                .toList();
    }
}
