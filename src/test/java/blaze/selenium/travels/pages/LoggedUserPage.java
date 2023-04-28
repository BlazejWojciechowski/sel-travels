package blaze.selenium.travels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedUserPage {
    @FindBy(xpath = "//h3[@class='RTL']")
    private WebElement heading;
    private WebDriver driver;
    private WebDriverWait wait;

    public LoggedUserPage(WebDriver driver, WebDriverWait wait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    public String getHeadingText() {
        return heading.getText();
    }
}
