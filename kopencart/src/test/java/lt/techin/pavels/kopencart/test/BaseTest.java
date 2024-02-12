package lt.techin.pavels.kopencart.test;

import lt.techin.pavels.kopencart.page.HomePage;
import lt.techin.pavels.kopencart.page.QAstuffPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setup() {
        driver= new ChromeDriver();
        driver.get("http://192.168.88.86/");
        driver.manage().window().maximize();
    }
//    @AfterEach
//    void driverQuit() {
//        driver.quit();
//    }
}
