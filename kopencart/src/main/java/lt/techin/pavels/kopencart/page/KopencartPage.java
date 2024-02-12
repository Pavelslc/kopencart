package lt.techin.pavels.kopencart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class KopencartPage {

    private WebDriver driver;

    public KopencartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
