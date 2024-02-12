package lt.techin.pavels.kopencart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
