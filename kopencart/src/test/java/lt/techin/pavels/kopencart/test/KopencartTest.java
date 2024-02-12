package lt.techin.pavels.kopencart.test;

import lt.techin.pavels.kopencart.page.KopencartPage;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KopencartTest {
    private WebDriver driver;
    private KopencartPage kopencartPage;

    @BeforeEach
    void setup() {
        driver= new ChromeDriver();
        driver.get("http://192.168.88.86/");
        driver.manage().window().maximize();
    }
}
